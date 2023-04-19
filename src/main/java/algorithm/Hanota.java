package algorithm;

import java.util.List;

public class Hanota {

	// 汉诺塔
	public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
		int n = A.size();
		move(n, A, B, C);
	}
	void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
		if (n == 1) {
			C.add(A.remove(A.size() - 1));
			return;
		}
		move(n - 1, A, C, B);    // 将A上面n-1个通过C移到B
		// 将A最后一个移到C
		C.add(A.remove(A.size() - 1));         // 这时，A空了
		move(n - 1, B, A, C);     // 将B上面n-1个通过空的A移到C
	}
}
