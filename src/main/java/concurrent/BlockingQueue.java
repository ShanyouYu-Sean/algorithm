package concurrent;

public class BlockingQueue {
	private int[] array = new int[1000];
	private volatile int head = 0;
	private volatile int tail = 0;
	// head 和 tail 构成的是一个前闭后开区间.
	// 当两者重合的时候, 可能是表示队列空, 也可能是表示队列满.
	// 为了区分空还是满, 就需要额外引入一个 size 来表示.
	private volatile int size = 0;

	private final static String LOCK = "LOCK";

	public void put(int value) throws InterruptedException {
		synchronized (LOCK) {
			if(size == array.length) {
				wait();
			}

			// 把 value 放到队尾即可
			array[tail] = value;
			tail++;
			if (tail == array.length) {
				tail = 0;
			}
			size++;

			notify();
		}
	}

	public int take() throws InterruptedException {
		int ret = -1;
		synchronized (LOCK) {
			if (size == 0) {
				this.wait();
			}

			ret = array[head];
			head++;
			if (head == array.length) {
				head = 0;
			}
			size--;

			notify();
		}
		return ret;
	}
}
