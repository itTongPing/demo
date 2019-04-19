package dataType.link;

public class Link {

    public int data;
    Link next;
    Link previous;


    public Link(int data){
        this.data = data;
    }



    public void display(){
        System.out.println("{"+data+"}");
    }


}
