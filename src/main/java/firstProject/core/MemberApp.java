package firstProject.core;

import firstProject.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //Appconfig를 실행
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //Application context로 appconfig 내 클래스를 끌어옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //멤버서비스를 app에 있는 bean을 가져와서 불러옴
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "A", Grade.VIP);
        //회원가입을 시킨다
        memberService.join(member);

        //가입된 멤버를 한번 찾아본다 - 저장되었는지, 찾기 기능이 정상 작동하는지 확인
        Member findMember = memberService.findMember(1L);

        //이름을 출력해서 두 이름이 같은지 직접 확인해본다
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
