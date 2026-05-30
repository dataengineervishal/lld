package creational.singleton;

/*
 * DOUBLE-CHECKED LOCKING SINGLETON
 *
 * When to use: when you want lazy initialization (created only when first needed)
 *              and need it to be thread-safe with good performance.
 *
 * Key concepts:
 *   - volatile   : prevents CPU instruction reordering. Without this, a thread could
 *                  see a partially constructed object.
 *   - 1st if     : skips the lock once instance is created (performance optimization)
 *   - synchronized: only one thread can create the instance at a time
 *   - 2nd if     : re-checks because two threads could both pass the 1st if
 *                  before either acquires the lock
 *
 * Interview tip: always mention WHY volatile is needed — that's what separates
 *                a good answer from a great one.
 */
public class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {                         // 1st check — no lock needed after creation
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {                 // 2nd check — inside lock
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
