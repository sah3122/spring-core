package me.study.core;

import me.study.core.member.MemberRepository;
import me.study.core.member.MemberService;
import me.study.core.member.MemberServiceImpl;
import me.study.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);


    @Test
    @DisplayName("같은 타입의 빈이 둘 이상인 경우 에러가 발생")
    void name() {
        assertThatExceptionOfType(NoUniqueBeanDefinitionException.class)
                .isThrownBy(() -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("같은 타입의 빈이 둘 이상인 경우 빈 이름으로 조회")
    void name2() {
        MemberService memberService = ac.getBean("memberService1", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("같은 타입 모두 조회")
    void type() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println(key );
        }
    }


    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
