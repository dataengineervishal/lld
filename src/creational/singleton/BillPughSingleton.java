package creational.singleton;

/*
 * BILL PUGH SINGLETON (Static Inner Class)
 *
 * When to use: almost always — this is the recommended approach.
 *              Best balance of lazy loading, thread safety, and simplicity.
 *
 * Key concepts:
 *   - Holder class is not loaded when BillPughSingleton class is loaded
 *   - Holder is only loaded when getInstance() is called for the first time
 *   - JVM guarantees static fields are initialized safely during class loading
 *     so no volatile or synchronized needed
 *
 * Why it's better than double-checked locking:
 *   - No volatile keyword needed
 *   - No synchronized block needed
 *   - Still lazy (created on first use)
 *   - Cleaner and easier to read
 *
 * Interview tip: if asked "what's the best singleton implementation?" — say this.
 *               Explain that it leverages JVM class loading guarantees instead of
 *               explicit synchronization.
 */
public class BillPughSingleton {

    private BillPughSingleton() {}

    private static class Holder {
        // loaded only when getInstance() is called
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
