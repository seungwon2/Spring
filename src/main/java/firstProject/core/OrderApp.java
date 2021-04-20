package firstProject.core;

import firstProject.core.member.Grade;
import firstProject.core.member.Member;
import firstProject.core.member.MemberService;
import firstProject.core.order.Order;
import firstProject.core.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        //Appconfig 이용해서 구현체 생성
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        //멤버 일단 생성해서 가입시킴
        long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        //orderService로 주문을 넣어봄
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //주문 확인
        System.out.println("order = " + order);
    }
}
