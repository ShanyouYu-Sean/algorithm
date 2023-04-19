package concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    // 初始尾节点是一个虚节点
    private AtomicReference<Node> tail = new AtomicReference<>(new Node());
    public FIFOMutex(){
    }
    static class Node {
        Thread t;
        Node prev;
        Node next;
        public Node(Thread t){
            this.t = t;
        }
        public Node(){
        }
    }

    public void lock(){
        // 初始化节点
        Node node = new Node(Thread.currentThread());
        for (;;){
            // 拿锁
            // 当前驱节点是虚节点时，就永远要自选抢占锁
            if (!locked.compareAndSet(false, true)){
                // 设置尾节点
                // 新入队
                if (node.prev == null){
                    for(;;){
                        Node oldTail = tail.get();
                        if (tail.compareAndSet(oldTail, node)){
                            node.prev = oldTail;
                            oldTail.next = node;
                            break;
                        }
                    }
                }
                // 如果前驱节点有线程，park
                if (node.prev.t != null){
                    System.out.println("park " + Thread.currentThread().getName());
                    LockSupport.park(Thread.currentThread());
                }
            }else {
                // 拿到锁后，释放节点，使前驱节点有效自旋
                node.t = null;
                // 如果后驱节点不为空，unpark
                if (node.next != null){
                    System.out.println(Thread.currentThread().getName() + " get lock, unpark " + node.next.t.getName());
                    LockSupport.unpark(node.next.t);
                }
                // help gc
                node.prev = null;
                node.next = null;
                break;
            }
        }
    }

    public void unlock(){
        locked.set(false);
    }

}
