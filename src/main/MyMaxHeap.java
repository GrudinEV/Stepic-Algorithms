package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyMaxHeap {
	private static List<Integer> heap = new ArrayList<>();
	private static List<Integer> result = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (str.equals("Insert")) {
				insert(sc.nextInt());
			} else {
				extractMax();
			}
		}
		result.forEach(x -> System.out.println(x));
	}

	private static void extractMax() {
		result.add(heap.get(0));
		if (heap.size() < 2) {
			heap.remove(0);
		} else {
			heap.set(0, heap.remove(heap.size() - 1));
			int index = 1;
			while ((heap.size() >= index * 2 && heap.get(index * 2 - 1) > heap.get(index - 1)) ||
					(heap.size() >= index * 2 + 1 && Math.max(heap.get(index * 2 - 1), heap.get(index * 2)) > heap.get(index - 1))) {
				if (heap.size() >= index * 2 + 1) {
					if (heap.get(index * 2 - 1) > heap.get(index * 2)) {
						int temp = heap.get(index * 2 - 1);
						heap.set(index * 2 - 1, heap.get(index - 1));
						heap.set(index - 1, temp);
						index = index * 2;
					} else {
						int temp = heap.get(index * 2);
						heap.set(index * 2, heap.get(index - 1));
						heap.set(index - 1, temp);
						index = index * 2 + 1;
					}
				} else {
					int temp = heap.get(index * 2 - 1);
					heap.set(index * 2 - 1, heap.get(index - 1));
					heap.set(index - 1, temp);
					index = index * 2;
				}
			}
		}
	}

	private static void insert(int newEl) {
		heap.add(newEl);
		int index = heap.size();
		while (index > 1 && heap.get((index / 2) - 1) < heap.get(index - 1)) {
			int temp = heap.get((index / 2) - 1);
			heap.set((index / 2) - 1, heap.get(index - 1));
			heap.set(index - 1, temp);
			index /= 2;
		}		
	}

}
