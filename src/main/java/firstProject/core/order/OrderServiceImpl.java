package firstProject.core.order;

import firstProject.core.discount.DiscountPolicy;
import firstProject.core.member.Member;
import firstProject.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //인터페이스 선언만
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자 만들 때 의존 관계를 주입!
    //Autowired 를 써서 자동으로 스프링빈이 의존관계 주입하도록 설정
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //멤버 아이디로 멤버를 조회해서 꺼내옴
        Member member = memberRepository.findById(memberId);
        //discountPolicy에서 알아서 member로 grade를 정의함
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //할인된 가격을 적용해서 retrun
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
