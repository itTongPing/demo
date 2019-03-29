package dataType.link;

public class Link {

    public int data;
    Link next;


    public Link(int data){
        this.data = data;
    }



    public void display(){
        System.out.println("{"+data+"}");
    }


}
