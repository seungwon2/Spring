package firstProject.core.member;

public class MemberServiceImpl implements MemberService{

    //앞에는 인터페이스, new한 후에는 구현체로 객체 생성!
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    //memberRepository 안에 있는 save 메소드를 이렇게 이용
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //회원 검색
    //memberRepository 내부 findById 메소드를 이렇게 이용
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
