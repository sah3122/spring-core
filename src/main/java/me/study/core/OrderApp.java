package me.study.core;

import me.study.core.member.Grade;
import me.study.core.member.Member;
import me.study.core.member.MemberService;
import me.study.core.member.MemberServiceImpl;
import me.study.core.order.Order;
import me.study.core.order.OrderService;
import me.study.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
