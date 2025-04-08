package my_new_package;

public class SingletonDemo {
    //create a single static instance of the class
    private static final SingletonDemo instance = new SingletonDemo();

    //private constructor -- prevents instantiation from outside
    private SingletonDemo() {
        //prevent instantiation by reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    //public method to get the instance
    public static SingletonDemo getInstance() { return instance;}

    //example method to demo functionality
    public void showMessage() { System.out.println("Hello from the Singleton!");}
}
