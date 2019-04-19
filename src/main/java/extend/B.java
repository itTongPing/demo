package extend;

public class B {


    static int i = 0;
    static {
        System.out.println("ClassB --> static block B1 + " + i);
    }

    int j = 0;

    static {
        i++;
        System.out.println("ClassB -->static block2 +" + i);
    }

    public B(){
        i++;
        j++;
        System.out.println("ClassB  contruct i:" + i + ";j:" + j);
    }

    {
        System.out.println("ClassB common block + " + i);
    }

    public void getValue() {
        i++;
        System.out.println("ClassB getvalueB:" + i);
    }

    public static void getValues() {
        i++;
        System.out.println("ClassB static getvaluesB:" + i);
    }

}
