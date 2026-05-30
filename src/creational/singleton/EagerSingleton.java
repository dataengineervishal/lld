package creational.singleton;

/*
 * EAGER INITIALIZATION SINGLETON
 *
 * When to use: when the object is lightweight and will always be needed.
 *              Simplest singleton — good starting point in interviews.
 *
 * Key concepts:
 *   - static final: instance is created when the class is loaded by JVM
 *   - thread-safe : JVM guarantees class loading happens only once,
 *                   so no synchronization needed
 *
 * Downside: instance is created even if getInstance() is never called.
 *           Wasteful if the object is heavy and may not be used.
 *
 * Interview tip: mention the tradeoff — simplicity vs potential waste of resources.
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton(); // created at class load

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}
