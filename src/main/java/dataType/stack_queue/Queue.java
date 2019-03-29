package dataType.stack_queue;

public class Queue {


    private int elements;
    private int maxSize;
    private long[] arr;
    private int front;
    private int rear;


    public Queue(int maxSize){
        this.maxSize = maxSize;
        arr = new long[maxSize];
        elements=0;
        front = 0;
        rear = -1;
    }

    public void insert(long value){

        if(rear ==  maxSize-1){
            rear = -1;
        }

        arr[++rear] = value;
        elements++;
    }


    public long remove(){

        if(front == maxSize){
            front = 0;
        }
        elements--;
        return arr[front++];
    }

    public long peekFront(){
        return arr[front];
    }




    public boolean isEmpty(){return elements==0;}



    public static void main(String[] args) {
        Queue queue = new Queue(3);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);



        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }

    }

}
