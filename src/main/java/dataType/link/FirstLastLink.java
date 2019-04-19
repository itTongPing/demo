package dataType.link;

public class FirstLastLink {


    Link first;
    Link last;


    public FirstLastLink(){
        first = null;
        last = null;
    }


    public boolean isEmpty(){


        return first == null;
    }


    public void insertFirst(int value){

        Link link  = new Link(value);
          //当插入的是第一个元素时需要更新last的指向

        if(isEmpty()){
            last = link;
        }

        link.next = first;
        first = link;

    }


    public void insertLast(int value){

        Link link  = new Link(value);
        if(isEmpty()){
            first = link;
        }else{

        last.next = link;
        }

        last = link;

    }



}
