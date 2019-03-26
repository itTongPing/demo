package dataType.array;

import java.util.Arrays;

public class HighArray {
    private Long[] arr;

    private int nElements;


    public HighArray(int max){
        arr = new Long[max];
        nElements=0;
    }

    public void insert(long value){
        arr[nElements++] = value;
    }

    public int find(long value){

        int j;
        for(j= 0;j<nElements;j++){
            if(arr[j] == value){
                break;
            }
        }

        if(j==nElements){
            return nElements;
        }else{
            return j;
        }


    }

        public boolean delete(long value){
            int i = find(value);

            if(i == nElements){
                return false;
            }

            //执行删除操作
            for(;i<nElements;i++){
                arr[i] = arr[i+1];
            }
            nElements--;

            return true;

        }

        public long getMax(){

        if (nElements== 0 )return -1;
        if(nElements==1)return arr[nElements-1];
        long max = arr[0];

        for(int i = 1 ; i<nElements;i++){
                if(arr[i]>max){
                    max = arr[i];
                }
        }
        return max;
        }



        public long removeMax(){
                if(nElements==0){
                    return -1;
                }
                if(nElements == 1){
                    nElements--;
                }
            //找到最大值的位置
            int maxIndex = 0 ;
            for(int i = 1 ; i<nElements;i++){
                if(arr[i]>arr[maxIndex]){
                    maxIndex = i;
                }
            }
            //删除最大值
            long maxValue = arr[maxIndex];
            for(int i = maxIndex;i<nElements;i++){
                arr[i] = arr[i+1];

            }

            nElements--;
            return maxValue;






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
        HighArray highArray = new HighArray(20);

        highArray.insert(22);
        highArray.insert(45);
        highArray.insert(65);
        highArray.insert(24);
        highArray.insert(6);
        highArray.insert(12);

        System.out.println(highArray.find(6));
        System.out.println(highArray.delete(6));

        System.out.println("最大的值:"+highArray.getMax());
        System.out.println("删除最大的值"+highArray.removeMax());

        highArray.display();



    }
}
