package firstProject.core.order;

import firstProject.core.discount.DiscountPolicy;
import firstProject.core.member.Member;
import firstProject.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //인터페이스 선언만
    //롬복 사용시 자동으로 생성자를 만들어줌
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

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
