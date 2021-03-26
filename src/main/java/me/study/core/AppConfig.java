package me.study.core;

import me.study.core.discount.FixDiscountPolicy;
import me.study.core.member.MemberService;
import me.study.core.member.MemberServiceImpl;
import me.study.core.member.MemoryMemberRepository;
import me.study.core.order.OrderService;
import me.study.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
