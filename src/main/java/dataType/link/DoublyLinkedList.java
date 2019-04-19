package dataType.link;

public class DoublyLinkedList {

    Link first;
    Link last;

    int nElements;

    public DoublyLinkedList(){
        first = null;

        last = null;
        nElements = 0 ;
    }

    public void insertFirst(Link link){

        if(nElements ==0){
            first = link;
            last = link;
            nElements++;
            return ;
        }

        link.next = first;     //新节点的next指向原数据第一个数据
        first.previous = link; //原数据的第一个节点的前一个节点指向新节点
        first = link;
        nElements++;

    }
    public Link deleteFirst(){
        if(nElements==1){
            Link temp  =first;
            first = null;
            last = null;
            nElements--;
            return temp;
        }

        Link temp = first;

        first = first.next;
        first.previous = null;
        nElements--;
        return temp;

    }


    public Link deleteLast(){
        if(nElements==1){
            Link temp  =first;

            first = null;
            last = null;
            nElements--;
            return temp;
        }
        Link temp  = last;
        last.previous.next = null;
        last = last.previous;
        nElements--;
           return temp;

    }





    public void display(){

        Link current = first;
        while(!(current==null)){

            System.out.print(current.data+",");
            current = current.next;

        }


    }




    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertFirst(new Link(3));
        doublyLinkedList.insertFirst(new Link(23));
        doublyLinkedList.insertFirst(new Link(13));
        doublyLinkedList.insertFirst(new Link(5));

        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteLast();
        doublyLinkedList.display();

    }


}
