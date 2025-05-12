package LinkedLists;

import java.util.*;

public class Link{
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<String>();
        /* 
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");
        linkedList.pop();
        */

        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");
        //linkedList.poll();




        System.out.println(linkedList);

    }
}