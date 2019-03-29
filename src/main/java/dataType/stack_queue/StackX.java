package dataType.stack_queue;


public class StackX<T> {

    private int maxSize;
    private T[] arr;

    private int top;

    public StackX(int max){

        arr = (T[])new Object[max];
        top=-1;
        maxSize = max;

    }


    public void push(T value){
        arr[++top] = value;
    }

    public T  pop(){
        return arr[top--];
    }

    public T peek(){
        return arr[top];
    }

    public boolean isEmpty(){
        return top ==-1;
    }

    public boolean  isFull(){
        return top ==(maxSize-1);
    }









    public static void main(String[] args) {



        StackX stack = new StackX<Long>(20);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        while(!stack.isEmpty()){

            System.out.print(stack.pop()+",");
        }
    }
}
