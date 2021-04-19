package firstProject.core.member;

public interface MemberService {
    //memberRepository는 백엔드 내부에서 멤버를 저장하는 기능을 모았고
    //여기 MemberService는 클라이언트가 건드리는 서비스 부분을 모았다.

    //회원 가입
    void join(Member member);

    //회원 조회
    Member findMember(Long memberId);
}
