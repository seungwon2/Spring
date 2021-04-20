package firstProject.core.discount;

import firstProject.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
