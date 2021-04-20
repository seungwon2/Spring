package firstProject.core;

import firstProject.core.member.Grade;
import firstProject.core.member.Member;
import firstProject.core.member.MemberService;
import firstProject.core.member.MemberServiceImpl;
import firstProject.core.order.Order;
import firstProject.core.order.OrderService;
import firstProject.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        //멤버를 저장해야 주문이 가능하니까 우선 멤버부터
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

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
