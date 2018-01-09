package com.fzy.example;

/**
 * Created by fuzhongyu on 2017/10/13.
 */
public class ReversalNode {

    /**
     * 反转链表
     * @param headNode
     * @return
     */
    public static Node reverse(Node headNode) {
        if (headNode == null || (headNode!=null&&headNode.nextNode == null)){
            return headNode;
        }
        Node rehead = reverse(headNode.nextNode);
        headNode.nextNode.nextNode = headNode;
        headNode.nextNode = null;
        return rehead;
    }
    /**
     * 打印链表
     *
     * @param headNode
     */
    public static void printList(Node headNode) {
        if (headNode == null)
            return;
        while (headNode != null) {
            System.out.print(headNode.val + " ");
            headNode = headNode.nextNode;
        }
    }
}

/**
 * 定义链表
 */
class Node{
    int val;
    Node nextNode;
    public Node(int val) {
        this.val = val;
    }
}
