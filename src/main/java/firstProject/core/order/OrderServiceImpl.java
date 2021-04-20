package firstProject.core.order;

import firstProject.core.discount.DiscountPolicy;
import firstProject.core.discount.FixDiscountPolicy;
import firstProject.core.member.Member;
import firstProject.core.member.MemberRepository;
import firstProject.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //이 서비스에서는 멤버 조회와 할인 정책 적용이 필요
    //레포지토리와 할인 정책을 가져옴
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //현 코드 문제점 : 클라이언트인 impl에도 의존적인 설계!
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
