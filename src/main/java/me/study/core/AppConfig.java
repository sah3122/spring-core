package me.study.core;

import me.study.core.discount.DiscountPolicy;
import me.study.core.discount.FixDiscountPolicy;
import me.study.core.discount.RateDiscountPolicy;
import me.study.core.member.MemberRepository;
import me.study.core.member.MemberService;
import me.study.core.member.MemberServiceImpl;
import me.study.core.member.MemoryMemberRepository;
import me.study.core.order.OrderService;
import me.study.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
