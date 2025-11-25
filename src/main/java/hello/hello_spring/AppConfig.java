package hello.hello_spring;

import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.discount.FixDiscountPolicy;
import hello.hello_spring.discount.RateDiscountPolicy;
import hello.hello_spring.member.MemberRepository;
import hello.hello_spring.member.MemberService;
import hello.hello_spring.member.MemberServiceImpl;
import hello.hello_spring.member.MemoryMemberRepository;
import hello.hello_spring.order.OrderService;
import hello.hello_spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // 예상(자바 코드)
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // 실제(스프링 동작)
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        //return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
