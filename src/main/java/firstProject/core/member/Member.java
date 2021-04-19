package firstProject.core.member;

public class Member {

    //멤버는 id, name, grade의 요소를 가지고 있음
    private Long id;
    private String name;
    private Grade grade;

    //멤버 생성자 만들기(command+N)
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter and setter를 멤버 요소별로 만들기
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
