package leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*** https://leetcode.com/problems/subsets/ */
public class SubSetsOfASetUsingBitMasking {
	public static void main(String args[]) {
		 System.out.println(new SubSetsOfASetUsingBitMasking().subsets(new Integer[]
		 {1,2,3}));
	}
	List<List<Integer>> subsets(Integer[] nums) {
		/***
		 * Binary representation of digits from 0 to 2^(N-1) accounts for all possible
		 * values of S with N elements. Therefore, we can iterate over numbers to find
		 * their binary representation and extract 1s to print elements of subsets
		 */
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		} else {
			int totalSubSets = (int) Math.pow(2, nums.length) - 1;
			for (int i = 0; i <= totalSubSets; i++) {
				List<Integer> bitMask = decimalToBinary(i, nums.length);
				//System.out.println(bitMask);
				 res.add(createSubSets(nums,bitMask));
			}
		}
		return res;
	}
	private List<Integer> createSubSets(Integer[] nums, List<Integer> bitMask) {
		List<Integer> subSet=new ArrayList<Integer>();
		if(bitMask.isEmpty())
			return subSet;
		System.out.println(bitMask);
		 for(int i=0;i<nums.length;i++) {

			if(bitMask.get(i)==1) {
				System.out.println(nums[i]);
				subSet.add(nums[i]);
			}
		}
		 return subSet;
	}
	static List<Integer> decimalToBinary(int num, int numsLength) {
		Stack<Integer> remainders = new Stack<Integer>();
		while (num != 0) {
			remainders.add(num % 2);
			num = num / 2;
		}
		List<Integer> binaryRep = new LinkedList<Integer>();
		if (remainders.empty()) {
			return binaryRep;
		} else {
			while (!remainders.empty()) {
				binaryRep.add(remainders.pop());
			}
            if(binaryRep.size()<numsLength) {
            	int padSize=numsLength-binaryRep.size();
            	for(int i=0;i<padSize;i++) {
            	binaryRep.add(i, 0);
            	}
            }
		}
		return binaryRep;
	}

}
