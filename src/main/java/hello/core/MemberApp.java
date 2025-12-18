package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // Spring의 모든 시작은 ApplicationContext로 부터 시작함
        // 파라미터를 AppConfig.class로 하면 Spring이 AppConfig의 @Bean이 붙은
        // 것들을 다 컨테이너에 짚어 넣어서 관리해줌.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // memberService를 꺼낼꺼야. "," 뒤에는 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);



        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
