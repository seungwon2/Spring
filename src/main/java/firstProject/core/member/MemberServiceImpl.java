package firstProject.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    //인터페이스를 선언만
    //롬복으로 생성자 자동 생성되고 의존 관계 자동 주입됨
    private final MemberRepository memberRepository;

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
