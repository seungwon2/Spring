package firstProject.core.singleton;

public class SingletonService {
    //내부에 스태틱 프라이빗 객체 생성
    //이렇게 안에서 스스로의 인스턴스를 만들어서 이걸 계속 사용하는 형태
    private static final SingletonService instance = new SingletonService();

    //오직 이 메소드를 통해서만 조회할 수 있고, 이 메소드를 호출하면 항상 같은 인스턴스를 반환한다.
    //싱글톤의 인스턴스를 밖에서 빼는 메소드 설정
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 프라이빗으로 만들어서 밖에서 new로 객체 생성을 못하도록 설정
    private SingletonService() {
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
