import creational.singleton.BillPughSingleton;
import creational.singleton.DoubleCheckedSingleton;
import creational.singleton.EagerSingleton;

public class main {
    public static void main(String[] args) {

        Runnable task = () -> {
            String thread = Thread.currentThread().getName();

            System.out.println(thread + " DoubleChecked  id: " + System.identityHashCode(DoubleCheckedSingleton.getInstance()));
            System.out.println(thread + " Eager          id: " + System.identityHashCode(EagerSingleton.getInstance()));
            System.out.println(thread + " BillPugh       id: " + System.identityHashCode(BillPughSingleton.getInstance()));
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
