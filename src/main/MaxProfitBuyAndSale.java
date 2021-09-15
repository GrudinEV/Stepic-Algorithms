package main;

public class MaxProfitBuyAndSale {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[100000];
		for (int i = 0; i < prices.length; i++) {
//			prices[i] = (int) (Math.random() * 100000);
			prices[i] = i;
		}		
		
		System.out.println(maxProfit(prices));
		
		prices = new int[] {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
		
		prices = new int[] {1,2,3,4,5};
		System.out.println(maxProfit(prices));
		
		prices = new int[] {7,6,4,3,1};
		System.out.println(maxProfit(prices));
		
		prices = new int[] {1};
		System.out.println(maxProfit(prices));
		
	}
	
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int length = prices.length;
		int minI = Integer.MAX_VALUE;		
		for (int i = 0; i < length - 1; i++) {
			if (prices[i] < minI) {
				minI = prices[i];
				int numberJ = prices[i];			
				for (int j = i + 1; j < length; j++) {
					if (prices[j] > numberJ) {
						numberJ = prices[j];
						int firstProfit = numberJ - prices[i];
						if (j < length - 2) {
							if (prices[j + 1] < numberJ) {
								int minM = Integer.MAX_VALUE;							
								for (int m = j + 1; m < length - 1; m++) {
									if (prices[m] < minM) {
										minM = prices[m]; 
										int numberN = prices[m];						
										for (int n = m + 1; n < length; n++) {
											numberN = Math.max(prices[n], numberN);
										}
										maxProfit = Math.max(maxProfit, firstProfit + numberN - prices[m]);
									}								
								}
							}							
						} else {
							maxProfit = Math.max(maxProfit, firstProfit);
						}
					}				
				}
			}
			
		}
        return maxProfit;
    }

}
