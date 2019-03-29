package dataType.link;

public class LinkList {

    Link first;


    public LinkList(){
        first = null;
    }

    public void insertFirst(int value){
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst(){
        Link  temp = first;
        first  = first.next;
        return temp;
    }

    public Link find(int value){
        Link current = first;

        if(current==null)return null;

        while(current.data == value){
            if(current.next==null){
                return null;
            }else{
                current = current.next;
            }
        }

        return current;

    }

    public Link delete(long value){

        Link current = first;  //需要删除的节点
        Link previous = first;//用于存储需要删除节点的前一个节点

        // 默认连表不为空,可能情况1.在第一个节点找到,2.在第一个节点之后找到,3没有找到

        while(current.data !=value){

            if(current.next==null){
                return null;
            }else{
                previous = current;
                current = current.next;
            }
        }
       //能执行到此处说明,找到了数据
        if(current==first){
            first = first.next;
        }else{
            previous.next = current.next;
        }

        return current;




    }

    public void display(){

        Link current = first;
        while(!(current==null)){

            System.out.print(current.data+",");
            current = current.next;

        }


    }


    //O(n)
    public void insertLast(int value){
        Link link  = new Link(value);

        if(first == null){
            first = link;
            return ;
        }

        Link last = first;

        while(!(last.next == null)){
            last = last.next;
        }

        last.next = link;






    }


    public static void main(String[] args) {
        LinkList  linkList = new LinkList();

       /* linkList.insertFirst(3);
        linkList.insertFirst(4);
        linkList.insertFirst(5);
        linkList.insertFirst(1);*/

        linkList.insertLast(1);
        linkList.insertLast(2);
        linkList.insertLast(3);
        linkList.insertLast(4);

       linkList.deleteFirst();
        linkList.delete(4);

        linkList.display();
    }
}
