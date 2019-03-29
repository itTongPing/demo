package dataType.array;

import java.util.Arrays;

public class ArraySort {


    private long[] arr;
    private int nElements;


    public ArraySort(int max){

        arr = new long[max];
        nElements=0;
    }

    public void insert(long value){
        arr[nElements++] = value;
    }


    public void bubbleSort(){


//效率低O(n平方)
     /*   for(int i = 0 ;i<nElements-1;i++){
            for(int j = 0;j<nElements-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(j, j+1);
                }
            }
        }*/

        for(int i = 0 ;i<nElements-1;i++){   //比较的轮数
            for(int j = 0;j<nElements-1-i;j++){      //每次比较轮都将最大的放在最后面,比较次数相应的减少一次
                if(arr[j]>arr[j+1]){
                    swap(j, j+1);
                }
            }
        }


    }

    public void selSort(){

        int max = 0;
        for(int i = nElements-1 ;i>0;i--){   //比较的轮数
            max=i;
            for(int j = 0;j<i;j++){      //每次比较轮都将最大的放在最后面,比较次数相应的减少一次
                if(arr[j]>arr[max]){
                    max = j;
                }
            }
               swap(max, i);
        }

    }


    public void insertSort(){
        for(int out = 1;out<nElements-1;out++){  //取第一个位置是有序的

            int in = out;
            long temp = arr[in];
            while(in>0 && arr[in-1]>=temp){
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] =temp;

        }



    }






    public void swap(int one,int two){
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two]  = temp;
    }

    public void display(){
        System.out.print("[");
        for(int i=0;i<nElements;i++){

            System.out.print(arr[i]+",");
        }
        System.out.println("]");

        System.out.println(Arrays.toString(arr));

    }


    public static void main(String[] args) {
        ArraySort arraySort = new ArraySort(20);

        arraySort.insert(5);
        arraySort.insert(4);
        arraySort.insert(3);
        arraySort.insert(2);
        arraySort.insert(1);
        arraySort.insert(0);


        //arraySort.bubbleSort();
        //arraySort.selSort();
        arraySort.insertSort();
        arraySort.display();



    }

}
