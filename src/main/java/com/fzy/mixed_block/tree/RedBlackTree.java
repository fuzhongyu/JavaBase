package com.fzy.mixed_block.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Test;

/**
 * 红黑树
 * @author Fucai
 * @date 2018/5/19
 */

public class RedBlackTree {

  /**
   * 根节点
   */
  private Node root;

  @Getter
  @Setter
  @NoArgsConstructor
  private class Node{

    /**
     * 左节点
     */
    private Node left;

    /**
     * 右节点
     */
    private Node right;

    /**
     * 记录点
     */
    private Integer number;

    /**
     * 值
     */
    private String value;

    /**
     * 指向父节点的颜色：flase-黑， true-红
     */
    private Boolean color;

    public Node(Integer number,String value,Boolean color){
      this.number=number;
      this.value=value;
      this.color=color;
    }

  }

  public void printNodeInfo(Node node){
    if (node==null){
      System.out.println("null");
    }else {
      System.out.println(node.value+"   "+node.color);
    }
  }



  /**
   * 查找值
   * @param number
   * @return
   */
  public String get(Integer number){
    Node node=getNode(root,number);
    if (node!=null){
      return node.value;
    }
    return "没有找到值";
  }

  public Node getNode(Node node,Integer number){
    if (number<node.number){
      return getNode(node.left,number);
    }else if (number>node.number){
      return getNode(node.right,number);
    }else {
      return node;
    }

  }

  public Node getMaxNode(Node node){
    if (node.right!=null){
      return getMaxNode(node.right);
    }
    return node;
  }

  /**
   * 判断是否为红
   * @param node
   * @return
   */
  private Boolean isRed(Node node){
    if (node==null || node.color==null){
      return false;
    }
    return node.color;
  }


  /**
   * 左旋转
   */
  private Node rotateLeft(Node node){
    Node rightNode=node.right;
    node.right=rightNode.left;
    rightNode.left=node;
    rightNode.color=node.color;
    node.color=true;
    return rightNode;
  }


  /**
   * 右旋转
   * @param node
   * @return
   */
  private Node rotateRight(Node node){
    Node leftNode=node.left;
    node.left=leftNode.right;
    leftNode.right=node;
    leftNode.color=node.color;
    node.color=true;
    return leftNode;
  }

  /**
   * 合并color
   * @param node
   * @return
   */
  private Node flip(Node node){
    node.left.color=false;
    node.right.color=false;
    node.color=true;
    return node;
  }


  /**
   * 插入
   * @param number
   * @param value
   */
  public void add(Integer number,String value){
    root=addNode(root,number,value);
    root.color=false;
  }

  public Node addNode(Node node,Integer number,String value){
    if (node==null){
      return new Node(number,value,true);
    }

    //插入
    if (number<node.number){
      node.left=addNode(node.left,number,value);
    }else if (number>node.number){
      node.right=addNode(node.right,number,value);
    }else {
      node.value=value;
    }

    //做平衡操作
    if (isRed(node.right) && !isRed(node.left)){
      node=rotateLeft(node);
    }else if (isRed(node.left)&& isRed(node.left.left)){
      node=rotateRight(node);
    } else if (isRed(node.left)&& isRed(node.right)){
      node=flip(node);
    }


    return node;
  }

  /**
   * 删除
   * @param number
   */
  public void delete(Integer number){
    deleteNode(root,null,null,number);
  }

  public Node deleteNode(Node node,Node parentNode,Boolean isLeft,Integer number){
    if (number<node.number){
      node=deleteNode(node.left,node,true,number);
    }else if (number>node.number){
      node=deleteNode(node.right,node,false,number);
    }else {
      //设置兄弟节点
      if (!isRed(node)){
        Node brotherNode=getBrotherNode(parentNode,isLeft);
        if (!isRed(brotherNode)){
//          brotherNode
        }
      }

      //删除当前节点
      if (node.right==null){
        return node.left;
      }else if (node.left==null){
        return node.right;
      }else {
        Node maxLeftNode=getMaxNode(node.left);
        Node maxLefNode_Left=maxLeftNode.left;
        maxLeftNode.left=null;
        node.left.right=maxLefNode_Left;
        maxLeftNode.left=node.left;
        maxLeftNode.right=node.right;

        return maxLeftNode;
      }
    }


    //做平衡操作
    if (isRed(node.right) && !isRed(node.left)){
      node=rotateLeft(node);
    }else if (isRed(node.left)&& isRed(node.left.left)){
      node=rotateRight(node);
    } else if (isRed(node.left)&& isRed(node.right)){
      node=flip(node);
    }

    if (isLeft){
      parentNode.left=node;
    }else {
      parentNode.right=node;
    }


    return parentNode;
  }


  private Node getBrotherNode(Node parentNode,Boolean isLeft){
    if (isLeft){
      return parentNode.right;
    }else {
      return parentNode.left;
    }
  }


  @Test
  public void test(){
    root=new Node(6,"6",false);
    add(3,"3");
    add(2,"2");
    printNodeInfo(root);
  }

}
