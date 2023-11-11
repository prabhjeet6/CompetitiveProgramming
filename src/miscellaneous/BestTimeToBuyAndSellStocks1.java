package miscellaneous;

import java.util.Scanner;
import java.util.stream.Stream;

/***
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStocks1 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int numberOfDays = Integer.parseInt(s.nextLine());

		int stockPrices[] = Stream.of(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int profitMax[] = new int[numberOfDays];
		// we need optimal price in future(Suffix Max)
		profitMax[numberOfDays - 1] = stockPrices[numberOfDays - 1];
		for (int i = numberOfDays - 2; i >= 0; i--) {
			profitMax[i] = stockPrices[i] > profitMax[i + 1] ? stockPrices[i] : profitMax[i + 1];
		}
		int maxProfit=0;
		for (int i = 0; i < numberOfDays; i++) {
			int priceDiff=profitMax[i]-stockPrices[i];
			if(priceDiff>0&&maxProfit<priceDiff)
            maxProfit=priceDiff;
		}
		System.out.println(maxProfit);
	}

}
