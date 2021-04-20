package firstProject.core;

import firstProject.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        //멤버 서비스 내부에서 알아서 메모리로 저장하게 만들어서 여기서 멤버 서비스만 불러와도 됨!
        //현 코드 문제점 : 클라이언트인 impl에도 의존적인 설계!
        MemberService memberService = new MemberServiceImpl();
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
