package com.spring.data;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push1("aaa");
        stack.push1("bbb");

        stack.push2("zzz");
        stack.push2("nnn");

        stack.pop2();
        stack.show();
    }

}


class Stack{


    private int capacity = 10;
    Object [] arr = new Object[capacity];
    private int top1 = 0;
    private int top2 = capacity-1;






    public void push1(Object object){
        if(top1>=top2){
            throw new IndexOutOfBoundsException();
        }

        arr[top1++] = object;


    }

    public void push2(Object object){
        if(top2<=top1){
            throw new IndexOutOfBoundsException();
        }

        arr[top2--] = object;


    }


    public Object pop1(){


        return arr[top1--];

    }
    public Object pop2(){
        return arr[top2++];
    }



    public void show(){
        //第一个栈的信息
            System.out.println("stack1:");
        for (int i = 0;i<top1;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
        System.out.println("stack2:");
        for (int i = capacity-1;i>top2;i--){
            System.out.println(arr[i]+",");
        }
    }
}