package firstProject.core.discount;

import firstProject.core.member.Grade;
import firstProject.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    //나중에 할인률이 바뀔 수도 있으니 따로 변수로 뺴놓음!
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
