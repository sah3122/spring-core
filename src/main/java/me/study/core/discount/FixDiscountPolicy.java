package me.study.core.discount;

import me.study.core.member.Grade;
import me.study.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private static final int DISCOUNT_FIX_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return DISCOUNT_FIX_AMOUNT;
        }
        return 0;
    }
}
