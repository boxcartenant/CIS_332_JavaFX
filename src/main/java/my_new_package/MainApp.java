package my_new_package;

public class MainApp {

    public static void main(String[] args) {
        SingletonDemo singleton = SingletonDemo.getInstance();

        singleton.showMessage();

        SingletonDemo anotherSingleton = SingletonDemo.getInstance();

        System.out.println("Same instance? " + (singleton == anotherSingleton));
    }
}
