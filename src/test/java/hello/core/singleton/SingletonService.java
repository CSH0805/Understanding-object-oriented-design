package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    //객체 instance가 필요하면 오직 getInstance를 이용해서만 조회할 수 있음.

    // 객체는 계속 재생성 되기 때문에 위에 코드를 이용해
    // 객체를 하나만 생성하고 그것을 계속 재사용함

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }
}
