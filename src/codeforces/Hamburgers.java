package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codeforces.com/problemset/problem/371/C?mobile=true
//Search over monotonic space(count of Hamburgers)
public class Hamburgers {
    public static void main(String[] a) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String recipe = bufferedReader.readLine();
        String[] inventory = bufferedReader.readLine().split(" ");
        int breads = Integer.parseInt(inventory[0]);
        int sausages = Integer.parseInt(inventory[1]);
        int cheese = Integer.parseInt(inventory[2]);

        String[] prices = bufferedReader.readLine().split(" ");
        int breadPrice = Integer.parseInt(inventory[0]);
        int sausagePrice = Integer.parseInt(inventory[1]);
        int cheesePrice = Integer.parseInt(inventory[2]);

        long totalRubles = Long.parseLong(bufferedReader.readLine());

        int breads4Ham = 0, sausages4Ham = 0, cheese4Ham = 0;
        for (int i = 0; i < recipe.length(); i++) {
            if (recipe.charAt(i) == 'B') {
                breads4Ham++;
            } else if (recipe.charAt(i) == 'S') {
                sausages4Ham++;
            } else {
                cheese4Ham++;
            }
        }
        //maximum burgers which can be made are 100+totalRubles (as we can have each ingredient
        // max Quantity of 100 and cheapest price of an ingredient be one rubel )
        long low = 0, high = totalRubles + 100, mid = 0;
        while (low <= high) {
            //prevents overflow
            mid = low + (high - low) / 2;
            //now calculate cost of 'mid' hamburgers
            long countOfBread = Math.max(breads4Ham * mid - breads, 0L);
            long countSausage = Math.max(sausages4Ham * mid - sausages, 0L);
            long countOfCheese = Math.max(cheesePrice * mid - cheese, 0L);

            long totalCost = breadPrice * countOfBread + sausagePrice * countSausage + cheesePrice * countOfCheese;

            if (totalCost <= totalRubles) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
