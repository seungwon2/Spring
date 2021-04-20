package firstProject.core;

import firstProject.core.discount.FixDiscountPolicy;
import firstProject.core.member.MemberService;
import firstProject.core.member.MemberServiceImpl;
import firstProject.core.member.MemoryMemberRepository;
import firstProject.core.order.OrderService;
import firstProject.core.order.OrderServiceImpl;

public class AppConfig {
    //appconfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.(온갖 impl들)
    //appconfig는 생성한 객체 인스턴스의 레퍼런스를 생성자를 통해서 주입해준다.
    public MemberService memberService(){
        return new MemberServiceImpl() (new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
