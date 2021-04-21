package firstProject.core;

import firstProject.core.discount.DiscountPolicy;
import firstProject.core.discount.RateDiscountPolicy;
import firstProject.core.member.MemberRepository;
import firstProject.core.member.MemberService;
import firstProject.core.member.MemberServiceImpl;
import firstProject.core.member.MemoryMemberRepository;
import firstProject.core.order.OrderService;
import firstProject.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Appconfig에 설정을 구성한다는 뜻
@Configuration
public class AppConfig {
    //appconfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.(온갖 impl들)
    //appconfig는 생성한 객체 인스턴스의 레퍼런스를 생성자를 통해서 주입해준다.

    //스프링 컨테이너에 빈으로 등록됨
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    //새로 만들어서 중복 제거 완료
    //레포 바꿀 때 이제 retrun 문만 수정하면 된다.
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    //할인 정책 변경할 때 이제 retrun 문만 수정하면 된다.
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
