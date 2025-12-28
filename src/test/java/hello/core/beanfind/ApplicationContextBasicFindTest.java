package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    // “AppConfig 설정 정보를 읽어서, 스프링 컨테이너를 만들고, 그 안에 객체들을 다 생성·관리해라”
    // AnnotationConfigApplicationContext: 스프링 컨테이너의 한 종류

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        //Assertions: 검증하기
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        //Assertions: 검증하기
        System.out.println("memberService = " + memberService);
    }
    @Test
    @DisplayName("구체 타입으로 조회 ")
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        //Assertions: 검증하기
    }
}

