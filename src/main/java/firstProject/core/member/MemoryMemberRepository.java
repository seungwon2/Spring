package firstProject.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    //해시맵으로 아이디와 멤버를 저장한다. key가 아이디 값이 member
    //그냥 HashMap은 동시성 이슈가 발생해서 실무에서는 ConcurrentHashMap을 사용한다.
    private static Map<Long, Member> store = new HashMap<>();

    //인터페이스 구현 시 인터페이스 내부 메소드 전부 오버라이드가 필요
    @Override
    public void save(Member member) {
        //멤버를 넣어주면 멤버의 아이디와 멤버를 맵핑해서 저장한다.
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        //다른 처리 할 필요 없이 해시맵 자체 메소드 get을 이용해서 멤버를 리턴해준다.
        return store.get(memberId);
    }

}
