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

// Configuration을 선언하지 않으면 싱글톤을 보장하지 않는다.
// memberService -> memberRepository 호출, orderService -> memberRepository 호출
// member, orderService에 주입되는 memberRepository는 스프링에서 관리하는 Bean이 아니게 된다.
// Configuration을 선언시 CGRIB를 통해 바이트 코드 조작을 하여 스프링 빈을 관리하게 된다.
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
