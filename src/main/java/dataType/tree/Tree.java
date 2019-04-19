package dataType.tree;

import org.springframework.http.MediaType;

import java.awt.*;

public class Tree {


    private Node root;



    public void insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
        }else{

        Node current = root;
        Node father;
        while(true){
            father = current;

            //在当前节点的左节点上
            if(value<current.data){
                current = current.leftNode;
                if(current==null){
                    father.leftNode = newNode;
                    return;
                }
            }else{
                current = current.rightNode;
                if(current==null){
                    father.rightNode =  newNode;
                    return ;
                }
            }
        }
        }
    }

    public void inOrder(Node localRoot){

        if(localRoot !=null){
            inOrder(localRoot.leftNode);
            System.out.println(localRoot.data);
            inOrder(localRoot.rightNode);
        }
    }

    /**
     * 获取最大节点
     * @return
     */
    public Node findMax(){


        Node current,last = null;

        current = root;

        while(current !=null){


            last = current;
            current = current.rightNode;

        }
     return last;
    }

    public Node findMin(){
        Node current,last = null;

        current  =root;

        while(current !=null){
            last = current;
            current = current.leftNode;

        }
        return last;
    }

    public boolean delete(int value){
        //1.先找到value值节点的位置
        Node current = root;
        Node parent  =root;
        Boolean isleftNodeChild = true;

        while(current.data != value){
            parent = current;
            if(value<current.data){  //在做节点上
                isleftNodeChild = true;
              current = current.leftNode;

            }else{
            current = current.rightNode;
            isleftNodeChild = false;
        }
            if(current == null){
                return false;
            }
        }
        //找到了节点current ,1.左右节点都为空

        //左右节点为空
        if(current.leftNode == null && current.rightNode == null){
                //是根节点
            if(current == root){
                root = null;
            }else if(isleftNodeChild){  //是左节点
                 parent.leftNode = null;
            }else{   //是在右节点
                parent.rightNode = null;
            }

        }else if(current.leftNode == null){  //节点的左节点为空,右节点有值
            //为根节点
            if(current == root){
                root = current.rightNode;
            }else if(isleftNodeChild){ //是其父节点的左节点上
                parent.leftNode = current.rightNode;
            }else{
                parent.rightNode = current.rightNode;
            }

        }else if(current.rightNode == null){  //找到的节点的右节点为空,左节点有值
            if(current == root){
                root = current.leftNode;
            }else if(isleftNodeChild){
                parent.leftNode = current.leftNode;
            }else{
                parent.rightNode = current.leftNode;
            }
        }else{   //当删除节点有左右节点时

            Node  successor = getSuccessor(current);

            if(current == root){  //如果当前节点为根节点,删除了根节点,则后继节点则为根节点
                root = successor;
            }else if(isleftNodeChild){
                parent.leftNode = successor;
            }else{
                parent.rightNode = successor;
            }
            successor.leftNode = current.leftNode;
        }

        return true;

    }


    /**
     * 获取目标节点的后继节点
     * @param delNode
     * @return
     */
    public Node  getSuccessor(Node delNode){


        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightNode;

        while(current !=null){
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }

        if(successor != delNode.rightNode){  //当后继节点不为删除节点有节点时
            successorParent.leftNode = successor.rightNode;  //后继节点的右节点成为其父节点的左节点
            successor.rightNode  = delNode.rightNode;

        }
        return successor;

    }



    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(12);
        tree.insert(10);
        tree.insert(14);
        tree.insert(13);
        tree.insert(16);
        //System.out.println(tree.root.rightNode.rightNode.data);

       //tree.inOrder(tree.root);

        tree.delete(16);
        Node max = tree.findMax();
        System.out.println(max.data);
        System.out.println(tree.findMin().data);
    }

}
