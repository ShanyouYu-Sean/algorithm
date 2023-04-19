package concurrent;

import java.util.Random;

/**
 * 用什么加锁就用什么notify和wait，实例中使用的是LOCK
 */
public class ProducerConsumer1 {

    private static int count = 0;
    private final int FULL = 10;
    private final static String LOCK = "LOCK";

    Runnable producer = () -> {
        for (int i =  0; i < 10; i++) {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            synchronized (LOCK) {
                while (count ==  FULL){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                count ++;
                System.out.println(Thread.currentThread().getName()
                        + "生产者生产，目前总共有" + count);
                LOCK.notifyAll();
            }
        }
    };

    Runnable consumer = () -> {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (LOCK) {
                while (count == 0){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + count);
                LOCK.notifyAll();
            }
        }
    };

    public static void main(String[] args) {
        ProducerConsumer1 producerConsumer1 = new ProducerConsumer1();

        new Thread(producerConsumer1.producer).start();
        new Thread(producerConsumer1.consumer).start();
    }
}
