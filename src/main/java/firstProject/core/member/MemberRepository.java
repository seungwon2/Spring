package firstProject.core.member;

public interface MemberRepository {
    //회원 저장 기능, void를 retrun 하고 멤버를 받는다.
    void save(Member member);

    //Id를 받아서 Member를 return한다.
    Member findById(Long memberId);
}
