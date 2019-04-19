package dataType.link;

public class SortedList {


    Link first;

    int nElements;
    public SortedList(){
        first = null;
        nElements = 0;
    }


    public SortedList(Link[] arrList){

        for(int i = 0 ;i<arrList.length;i++){
            insert(arrList[i]);
        }
    }

    /**
     * 插入数据
     * @param link
     */
    private void insert(Link link) {
        Link previous = null;

        Link current = first;

        //查找第一个比插入的数据大的位置
       while(current !=null &&link.data>current.data){

           previous = current;
           current = current.next;
       }


       if(previous == null){
           first = link;
       }else{
           previous.next = link;
           link.next = current;
       }
        nElements++;

    }

    public Link removeFirst(){

        if(nElements == 1){
            Link temp = first;
            first = null;
            return temp;
        }

        Link temp = first;
        first = first.next;

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


        SortedList sortedList = new SortedList();
        sortedList.insert(new Link(2));
        sortedList.insert(new Link(9));
        sortedList.insert(new Link(7));
        sortedList.insert(new Link(8));
        sortedList.insert(new Link(4));
        sortedList.display();
    }

}
