package algorithms;

import java.util.Random;

public class Quickselect {

    private int[] numbers;
    public Quickselect(int[] numbers){
        this.numbers=numbers;
    }

    public int select(int k){
        return select(0,numbers.length-1,k-1);
    }
    private int select(int firstIndex,int lastIndex,int k){
        int pivot=partition(firstIndex,lastIndex);
        if(pivot>k){
            return select(firstIndex,pivot-1,k);
        }else if(pivot<k){
            return select(pivot+1,lastIndex,k);
        }
        return numbers[k];


    }

    private int partition(int firstIndex, int lastIndex) {

        int pivot = new Random().nextInt(lastIndex-firstIndex+1)+firstIndex;
        swap(lastIndex,pivot);

        for(int i=firstIndex;i<lastIndex;++i){
            if(numbers[i]>numbers[lastIndex]){
                swap(i,firstIndex);
                firstIndex++;
            }
        }
        swap(firstIndex, lastIndex);
        return firstIndex;
    }


    private void swap(int firstPosition, int secondPosition){
        int temp=numbers[firstPosition];
        numbers[firstPosition]=numbers[secondPosition];
        numbers[secondPosition]=temp;
    }
}
