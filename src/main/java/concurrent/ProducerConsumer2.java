package concurrent;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {

    private static int count = 0;
    private final  int FULL = 10;

    final Lock lock = new ReentrantLock();
    final Condition p = lock.newCondition();
    final Condition c = lock.newCondition();

    Runnable producer = () -> {
        for (int i =  0; i < 10; i++) {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            lock.lock();
            try {
                while (count == FULL) {
                    try {
                        p.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName()
                        + "生产者生产，目前总共有" + count);
                c.signal();
            } finally {
                lock.unlock();
            }
        }
    };

    Runnable consumer = () -> {
        for (int i =  0; i < 10; i++) {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            lock.lock();
            try {
                while (count == 0) {
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + count);
                p.signal();
            } finally {
                lock.unlock();
            }
        }
    };

    public static void main(String[] args) {
        ProducerConsumer2 producerConsumer2 = new ProducerConsumer2();

        new Thread(producerConsumer2.producer).start();
        new Thread(producerConsumer2.consumer).start();
    }
}
