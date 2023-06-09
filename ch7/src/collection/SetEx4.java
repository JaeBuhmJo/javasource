package collection;

/* TreeSet
 * 이진탐색트리의 *개념*으로 데이터를 저장 - 그보다 개선된 형태
 * 정렬, 검색, 범위검색에 높은 성능을 보이는 자료구조
 * 
 * TreeSet : 이진탐색트리 + 성능향상
 */

import java.util.Set;
import java.util.TreeSet;

public class SetEx4 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();

		for (int i = 0; set.size() < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(num);
		}
		System.out.println(set);

		TreeSet<Integer> set2 = new TreeSet<>();
		int score[] = { 84, 26, 45, 50, 72, 35, 100 };
		//처음 주어지는 데이터가 root

		for (int i = 0; i < score.length; i++) {
			set2.add(score[i]);
		}
		System.out.println("50보다 작은 값 : " + set2.headSet(50));
		System.out.println("50보다 큰 값 : " + set2.tailSet(50));

	}

}
