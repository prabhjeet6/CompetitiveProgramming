package miscellaneous;

public class NumberOfSubSetsWithRecursion {

	public static void main(String[] args) {
		String arr[]= {"1","2","3"};
		createSubsets(0," ",arr);

	}
	static void  createSubsets(int index,String subset,String arr[]){
		if(index==arr.length) {
			System.out.println(subset);
			return;
		}
		createSubsets(index+1,subset,arr);
		createSubsets(index+1,subset+arr[index],arr);
	}

}
