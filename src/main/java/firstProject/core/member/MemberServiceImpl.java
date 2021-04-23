package firstProject.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MemberServiceImpl implements MemberService{

    //인터페이스를 선언만
    private final MemberRepository memberRepository;

    //생성자 만들면서 구현체를 생성 - app config에서 나중에 주입하도록 만듦
    @Autowired//ac.getBean(MemberRepository.class) 역할을 함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    //memberRepository 안에 있는 save 메소드를 이렇게 이용
    public void join(Member member) {
        memberRepository.save(member);
    }

    //회원 검색
    //memberRepository 내부 findById 메소드를 이렇게 이용
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
