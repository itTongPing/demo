package dataType.array;

import java.util.Arrays;

public class OrdArray {

    private long[] arr;

    private int nElements;


    public OrdArray(int size){
        arr = new long[size];
        nElements = 0;
    }

    /**
     * 插入方法
     */
    public void insert(long value){

        //1.找到插入的位置
        int i= 0;

       /* for(;i<nElements;i++){
            if(arr[i]>value){
                break;
            }
        }*/
        //使用二分查找的方式找到插入的位置
        int start = 0;
        int end = nElements - 1;
        int currIndex = 0;

        while (start<=end) {
            currIndex = (start+end)/2;

            if(arr[currIndex]>value){
                end = currIndex-1;
            }else if(arr[currIndex]<value){
                start = currIndex+1;
            }else{
                //当arr[currIndx] == value;时
                i = currIndex;
            }
        }
        //查找完毕,value的值应该插入在currIndex的两边
        if(arr[currIndex]>value){
            i=currIndex;
        }else{
            i=currIndex+1;
        }





        //2.将大于插入值的数据全部后移
        for(int j = nElements;j>i;j--){
            arr[j] = arr[j-1];
        }
        //如果开始没有数据则arr[0] = value;
        arr[i] = value;
        nElements++;

    }

    /**
     * 根据值查找下标值,二分查找
     * @param value
     * @return
     */
    public int find(long value){
        //1.先中部查询
        int lowerInd = 0;
        int highInd = nElements-1;
        int curInd ;


        while(true){
            curInd = (lowerInd+highInd)/2;

            if(arr[curInd]==value){
                return curInd;  //找到
            //
            }else if(lowerInd>highInd){

                return nElements;
            }else{
                if(arr[curInd]>value){

                    highInd = curInd-1;
                }else{
                    lowerInd = curInd+1;
                }
            }
        }


    }


    /**
     * 删除数据
     * @param value
     * @return
     */
   public boolean delete(long value){

       int i = find(value);
       //没有找到数据
       if(i == nElements){
           return false;
       }
       //删除数据,将下标为i后面部分的数据向前移动一位
       for(int j = i;j<nElements-1;j++){
           arr[j]=arr[j+1];
       }
       nElements--;
    return true;
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
        OrdArray ordArray = new OrdArray(20);

        ordArray.insert(10);
        ordArray.insert(9);
        ordArray.insert(7);
        ordArray.insert(6);
        ordArray.insert(5);
        ordArray.insert(24);

        //ordArray.delete(2);


        int i = ordArray.find(6);
        System.out.println(i);

        ordArray.display();
    }
}
