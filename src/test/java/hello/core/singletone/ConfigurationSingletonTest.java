package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository = " +
                memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository  = " +
                orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertSame(memberService.getMemberRepository(),memberRepository);
        Assertions.assertSame(orderService.getMemberRepository(),memberRepository);


    }
}
