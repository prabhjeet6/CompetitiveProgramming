package miscellaneous.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortByFrequency {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bufferedReader.readLine().trim());
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(bufferedReader.readLine().trim());
            int arr[]=Stream.of(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int frequency[]=new int[1000];
            for(int j=0;j<N;j++){
                frequency[arr[j]]++;
            }
            sortByFrequency(arr,frequency);

        }

    }

    private static void sortByFrequency(int[] arr,int[] frequency) {
        List<ValueAndFreqModel> valueAndFreqModels=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ValueAndFreqModel valueAndFreqModel=new ValueAndFreqModel();
            valueAndFreqModel.setValue(arr[i]);
            valueAndFreqModel.setFreq(frequency[arr[i]]);
            valueAndFreqModels.add(valueAndFreqModel);
        }
        Collections.sort(valueAndFreqModels,new ValueAndFreqComparator());
        for(int i=0;i<valueAndFreqModels.size();i++){
            System.out.print(valueAndFreqModels.get(i).getValue()+ " ");
        }
        System.out.println();

    }
    static class ValueAndFreqComparator implements Comparator<ValueAndFreqModel>{

        @Override
        public int compare(ValueAndFreqModel o1, ValueAndFreqModel o2) {
            if(o1.freq==o2.freq)
                return o1.value-o2.value;//sort in ascending order of value
            else return o2.freq-o1.freq;//sort in descending order of freq
        }
    }

    static class ValueAndFreqModel{
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        int freq;
    }
}


