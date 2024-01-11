package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/***https://leetcode.com/problems/subsets/solutions/2145410/java-solution-using-recursion-common-mistake-case/*/
public class NumberOfSubSetsWithRecursion {
	 static List<List<Integer>> listOfLists=new ArrayList<>();
	public static void main(String[] args) {
	
		Integer arr[]= {1,2,3};
		List<Integer> nums=Arrays.asList(arr);
		 
		createSubsets(0,new ArrayList<Integer>(),nums);
		System.out.println(listOfLists);

	}
	static void  createSubsets(int index,List<Integer> res,List<Integer> nums){
		if(index==nums.size()) {
			//instead of adding the same list ref, create a new list through the ref, and add it to ListOfLists
			listOfLists.add(new ArrayList<Integer>(res));
			return;
		}
		
		res.add(nums.get(index));
		createSubsets(index+1,res,nums);
		res.remove(res.size()-1);
		createSubsets(index+1,res,nums);
	}

}
