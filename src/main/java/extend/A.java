package extend;

import java.util.ArrayList;

public class A extends B {

    static int i = 0;
    static {
        System.out.println("ClassA --> static block B1 + " + i);
    }

    int j = 0;

    static {
        i++;
        System.out.println("ClassA -->static block2 +" + i);
    }

    public A(){
        i++;
        j++;
        System.out.println("ClassA  contruct i:" + i + ";j:" + j);
    }

    {
        System.out.println("ClassA common block + " + i);
    }

    public void getValue() {
        i++;
        System.out.println("ClassA getvalueA:" + i);
    }

    public static void getValues() {
        i++;
        System.out.println("ClassA static getvaluesA:" + i);
    }


//    public static int value1;
//    public static int value2 = 0;
//    private static A singleton2 = new A();
//
//
//    private A(){
//        value1++;
//        value2++;
//    }
//
//    public static A getInstance2(){
//        return singleton2;
//    }


    public static void main(String[] args) {
  //      A.getValues();
    //    A.i = 2;
        A a = new A();
//        a.getValue();
//        A instance = A.getInstance2();
//        System.out.println("Instance 1 = " + instance.value1);
//        System.out.println("Instance 2 = " + instance.value2);

       // ArrayList<String> arrayList = new ArrayList<>();

        //System.out.println("ssss");
    }




}
