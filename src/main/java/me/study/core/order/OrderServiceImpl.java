package me.study.core.order;

import me.study.core.discount.DiscountPolicy;
import me.study.core.discount.FixDiscountPolicy;
import me.study.core.discount.RateDiscountPolicy;
import me.study.core.member.Member;
import me.study.core.member.MemberRepository;
import me.study.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
