package hello.core.singletone;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //private를 통해 객체 생성 외부에서 되는거 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }
}
