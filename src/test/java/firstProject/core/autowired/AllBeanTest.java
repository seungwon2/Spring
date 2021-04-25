package firstProject.core.autowired;

import firstProject.core.AutoAppConfig;
import firstProject.core.discount.DiscountPolicy;
import firstProject.core.member.Grade;
import firstProject.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }
    @RequiredArgsConstructor
    static class DiscountService {
        //map으로 discount policy를 모두 저장(이름이 키)
        private final Map<String, DiscountPolicy> policyMap;
        //할인 정책 목록
        private final List<DiscountPolicy> policyList;

        //밖에서 discount code 주입해서 rate 와 fixed 자유롭게 사용
        //다형성을 이용해서 유연하게 프로그램을 설계할 수 있음 - 예를 들어 고객이 rate와 fixed 중 할인 정책을 하나 선택하는 경우
        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);

            return discountPolicy.discount(member, price);
        }
    }
}
