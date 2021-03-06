package firstProject.core.member;

import firstProject.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    //인터페이스는 선언만!
    MemberService memberService;

    //테스트 코드 실행 전에 appconfig로 먼저 멤버서비스 가져오도록 설계!
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    //Junit test이용
    //given-when-then 방식 이용
    @Test
    void join(){
        //given - ~ 가 주어졌다.
        //멤버 객체를 생성한다 - 가입시키려고!
        Member member = new Member(1L, "A", Grade.VIP);

        //when - ~일
        //멤버 서비스에 멤버를 가입시킨다
        memberService.join(member);
        //가입시킨 멤버를 아이디로 찾아와본다 - 가입, 찾기 기능 둘 다 테스트
        Member findMember = memberService.findMember(1L);

        //then - 이 값이 나와야해!
        //member와 findmember해서 나온 값이 같은지 Assertions로 확인한다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
