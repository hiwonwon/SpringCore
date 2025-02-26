package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인 적용")
    void vip_o(){
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.dicount(member, 10000);

        Assertions.assertEquals(discount,1000);
    }

    @Test
    @DisplayName("VIP아니면 할인적용 X")
    void vip_x(){
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        int discount = discountPolicy.dicount(member, 10000);

        Assertions.assertEquals(discount,0);
    }

}