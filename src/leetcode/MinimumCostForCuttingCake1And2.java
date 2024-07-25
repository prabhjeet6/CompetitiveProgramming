package  leetcode;
import java.util.Arrays;

//https://www.youtube.com/watch?v=9-JzjZygBLM
class MinimumCostForCuttingCake1And2 {
    public static void main(String[] asd) {
        int[] horizontalCut = {1, 3}, verticalCut = {5};
        MinimumCostForCuttingCake1And2 ob = new MinimumCostForCuttingCake1And2();
        System.out.println(ob.minimumCost(3, 2, horizontalCut, verticalCut));
    }

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        //Using Greedy Approach, to get min cost of cutting cake in 1x1, whether we make a vertical cut or Horizontal cut
        // we take the biggest possible cut, hence, both arrays are sorted in descending order
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        reverse(horizontalCut);
        reverse(verticalCut);

        //Initially, we have a  have a single block cake, hence, both number of vertical blocks and horizontal blocks are 1
        int i = 0, j = 0, minCost = 0, numberOfVerticleBlocks = 1, numberOfHorizontalBlocks = 1;

        //Original length of both arrays is one less than m and n respectively because, it needs 2 cuts to make three pieces
        while (i < m - 1 && j < n - 1) {
               //if horizontal[i] has more cost, we cut horizontally
            if (horizontalCut[i] > verticalCut[j]) {
                //when we make a horizontal cut, it is made for all vertical blocks
                minCost += horizontalCut[i] * numberOfVerticleBlocks;
                //since, we made a horizontal cut, number of horizontal blocks double.
                numberOfHorizontalBlocks++;
                //since, we used horizontal[i], we increment i
                i++;
            } else {
                //if vertical[j] has more cost, we cut vertically
                //when we make a vertical cut, it is made for all horizontal blocks
                minCost += verticalCut[j] * numberOfHorizontalBlocks;
                //since, we made a vertical cut, number of vertical blocks double.
                numberOfVerticleBlocks++;
                //since, we used vertical[i], we increment j
                j++;
            }
        }

        int leftCost = 0;
        if (i < m - 1) {
            //if horizontal cuts are still  left and vertical cuts are over, total horizontal cuts and multiply
            //with number of vertical blocks as these horizontal cuts are made all vertical blocks
            while (i < m - 1) {
                leftCost += horizontalCut[i++];
            }
            minCost += leftCost * numberOfVerticleBlocks;
        } else {
            //if vertical cuts are still  left and horizontal cuts are over, total vertical cuts and multiply
            //with number of horizontal blocks as these vertical cuts are made all horizontal blocks
            while (j < n - 1) {
                leftCost += verticalCut[j++];
            }
            minCost += leftCost * numberOfHorizontalBlocks;
        }

        return minCost;
    }

    void reverse(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            swap(start, end, a);
            start++;
            end--;
        }

    }

    void swap(int start, int end, int[] a) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}