public class Singleton {
    private static Singleton instance;
    public Integer testField;

    Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
