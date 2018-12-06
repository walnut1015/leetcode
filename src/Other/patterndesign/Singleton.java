package Other.patterndesign;

/**
 * @author tanya
 * @date 2018/10/8 22:33
 */
public class Singleton {
    private Singleton(){}
    public static Singleton getInstance(){
        return Nested.singleton;
    }
    static class  Nested{
        public static Singleton singleton = new Singleton();
    }

    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
    }
}
