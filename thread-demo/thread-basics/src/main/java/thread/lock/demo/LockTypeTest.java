package thread.lock.demo;

/**
 * @author kris
 * @since 2020-09-14
 */
public class LockTypeTest {

    public static void main(String[] args) {
        LockType l1 = new LockType();
        LockType l2 = new LockType();
        LockType l3 = new LockType();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    l1.testLockType();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    l1.testLockType();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    l1.testLockType();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

/*        while (true){

        }*/

    }
}
