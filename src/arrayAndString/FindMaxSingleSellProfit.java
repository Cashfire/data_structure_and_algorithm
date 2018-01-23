/*
 * Given a list of stock prices for n days, find the maximum profit with a single sell activity.
 * For example, {9,15,19, 1, 12}, when buy_price=1 and sell_price=12, the profit is max.
 * Hint: Kadane's algorithm.
 */
package arrayAndString;

import java.util.Arrays;

public class FindMaxSingleSellProfit {
	//assume the stock prices are integers for simplicity
	static int[] find_buy_sell_price(int[] arr){
		if(arr==null || arr.length<2){
			return null;
		}
		
		int buy_price = arr[0];
		int sell_price = arr[1];
		int profit = sell_price - buy_price;
		int max_profit = profit;
		
		for(int i = 1; i < arr.length; i++){
			profit = arr[i] - buy_price;
			//if profit is larger, update the max_profit and sell_price.
			if(profit > max_profit){
				max_profit = profit;
				sell_price = arr[i];
			}
			// if arr[i] is smaller than buy_temp price, update the buy price.
			if(arr[i] < buy_price){
				buy_price = arr[i];
			}
		}
		int real_buy = sell_price - max_profit;
		int[] buy_sell_prices = {real_buy, sell_price};
		return buy_sell_prices;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {9,15,19, 1, 12};
		int[] arr2 = {8,5,12,9,19,1};
		int[] arr3 = {21,12,11,9,6,3};
		
		System.out.println(Arrays.toString(find_buy_sell_price(arr3)));
	}

}
