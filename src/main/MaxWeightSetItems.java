package main;

import java.util.Arrays;
import java.util.Scanner;

public class MaxWeightSetItems {
	private static Item[] items;
	private static int countItems;
	private static int bagCapacity;
	private static double priceItems = 0.0d;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		countItems = sc.nextInt();
		bagCapacity = sc.nextInt();
		items = new Item[countItems];
		
		for (int i = 0; i < countItems; i++) {
			int price = sc.nextInt();
			int volume = sc.nextInt();
			items[i] = new Item(price, volume);
		}
		
		items = mergeSort(items);
		
		maxPrice();
		
		System.out.println(String.format("%.3f",priceItems).replace(",", "."));
	}
	
	private static void maxPrice() {
		int i = 0;
		while(bagCapacity > 0 && i < countItems) {
			if (bagCapacity >= items[i].volume) {
				bagCapacity -= items[i].volume;
				priceItems += items[i].price;
			} else {
				priceItems += items[i].price * bagCapacity * 1.0 / items[i].volume;
				bagCapacity = 0;
			}
			i++;
		}
	}
	
	private static Item[] mergeSort(Item[] array) {
		int n = array.length;
		if (n == 1) {
			return array;
		}
		int m = n / 2;
		Item[] firstArray = Arrays.copyOfRange(array, 0, m);
		Item[] secondArray = Arrays.copyOfRange(array, m, n);
		return merge(mergeSort(firstArray), mergeSort(secondArray));
	}
	
	private static Item[] merge(Item[] arrA, Item[] arrB) {
		if (arrA.length == 0) {
			return arrB;
		}
		if (arrB.length == 0) {
			return arrA;
		}
		Item[] resArr = new Item[arrA.length + arrB.length];
		if (arrA[0].compareTo(arrB[0]) > 0) {
			resArr[0] = arrA[0];
			System.arraycopy(merge(Arrays.copyOfRange(arrA, 1, arrA.length), arrB), 0, resArr, 1, arrA.length + arrB.length - 1);
		} else {
			resArr[0] = arrB[0];
			System.arraycopy(merge(Arrays.copyOfRange(arrB, 1, arrB.length), arrA), 0, resArr, 1, arrA.length + arrB.length - 1);
		}
		return resArr;
	}
	
	private static class Item implements Comparable<Item> {
		private int price, volume;
		
		Item(int price, int volume) {
			this.price = price;
			this.volume = volume;
		}

		@Override
		public int compareTo(Item item) {
			// TODO Auto-generated method stub
			double priceThis = this.price * 1.0 / this.volume;
			double priceO = ((Item) item).price * 1.0 / ((Item) item).volume;
			return priceThis - priceO > 0 ? 1 : priceThis - priceO < 0 ? -1 : 0;
		}
	}
	
}
