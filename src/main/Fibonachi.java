package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Fibonachi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int m = sc.nextInt();
		int a = 0, b = 1, f = 1;
		ArrayList<Integer> listFibModM = new ArrayList<>();
		listFibModM.add(a);
		listFibModM.add(b);
		
		for (int i = 2; i <= m * 6; i++) {
			f = (a + b) % m;
			a = b;
			b = f;			
			listFibModM.add(f);
			if (a == 0 && b == 1) {
				break;
			}
		}
		int period = listFibModM.size() - 2;
		int index = (int) (n % period);
		System.out.println(listFibModM.get(index));
		
//		BigInteger[] matrix = new BigInteger[] {new BigInteger("0"), new BigInteger("1"), new BigInteger("1"), new BigInteger("1")};
//		
//		BigInteger[] result = binpow(matrix, n - 1);
//		
//		BigInteger fib = result[3];
//		
//		String fibModM = String.valueOf(fib.mod(new BigInteger(String.valueOf(m))));
//		
//		System.out.println(fibModM);
	}
	
	static BigInteger[] binpow(BigInteger[] matrix, long n) {
		if (n == 1) {
			return new BigInteger[] {new BigInteger("0"), new BigInteger("1"), new BigInteger("1"), new BigInteger("1")};
		}
		if (n % 2 == 1) {
			return multiplicationMatrix(binpow(matrix, n - 1), matrix);
		} else {
			BigInteger[] matrixNew = binpow(matrix, n / 2);
			return multiplicationMatrix(matrixNew, matrixNew);
		}
	}
	
	static BigInteger[] multiplicationMatrix(BigInteger[] matrix1, BigInteger[] matrix2) {
		
		return new BigInteger[] {(matrix1[0].multiply(matrix2[0])).add(matrix1[1].multiply(matrix2[2])),
								(matrix1[0].multiply(matrix2[1])).add(matrix1[1].multiply(matrix2[3])),
								(matrix1[2].multiply(matrix2[0])).add(matrix1[3].multiply(matrix2[2])),
								(matrix1[2].multiply(matrix2[1])).add(matrix1[3].multiply(matrix2[3]))};
	}	
}
