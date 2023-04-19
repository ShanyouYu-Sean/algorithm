package concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer3 {

    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    Runnable producer = () -> {
        for (int i =  0; i < 10; i++) {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                blockingQueue.put(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()
                    + "生产者生产，目前总共有" + blockingQueue.size());
        }
    };

    Runnable consumer = () -> {
        for (int i =  0; i < 10; i++) {
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()
                    + "消费者消费，目前总共有" + blockingQueue.size());
        }
    };

    public static void main(String[] args) {
        ProducerConsumer3 producerConsumer3 = new ProducerConsumer3();

        new Thread(producerConsumer3.producer).start();
        new Thread(producerConsumer3.producer).start();
        new Thread(producerConsumer3.consumer).start();
    }
}
