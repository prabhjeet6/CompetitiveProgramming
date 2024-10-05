package leetcode;

class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }else{
                digits[i]=0;
                carry=1;
            }
        }
        if(carry==0){
            return digits;
        }else{
            int[] digitsCopy=new int[digits.length+1];
            for(int i=0;i<digits.length;i++){
                digitsCopy[i+1]=digits[i];
            }
            digitsCopy[0]=1;
            return digitsCopy;
        }
    }
}