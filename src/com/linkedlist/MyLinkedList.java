package com.linkedlist;

public class MyLinkedList {
    Node myNode;

    public MyLinkedList() {  }

    public static void main(String args[]) {
        MyLinkedList myLinkedList = new MyLinkedList();

    }

    private void insert(String nodeVal, boolean insertEnd) {
        Node newNode = new Node(nodeVal);
        if(myNode == null) {
            myNode.first = newNode;
            myNode.last = newNode;
            myNode.next = null;
        } else {
            if(insertEnd) {

            } else {
                Node currentNode = myNode.first;
                while(currentNode.next != null) {
                    myNode.first = newNode;
                    currentNode = currentNode.next;
                }

            }

            Node current = newNode.last;
        }
    }

}

final class Node {
    protected Node first;
    protected Node last;
    protected Node next;
//    protected Node previous;

    private final String val;

    public Node(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
