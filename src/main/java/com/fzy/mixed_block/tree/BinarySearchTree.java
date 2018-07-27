package com.fzy.mixed_block.tree;

import java.util.Arrays;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Test;

/**
 * 二叉查找树(堆排序)
 * @author Fucai
 * @date 2018/5/17
 */

public class BinarySearchTree {

  /**
   * 定义根节点
   */
  private Node root;

  /**
   * 定义节点
   */
  @Getter
  @Setter
  @NoArgsConstructor
  private class Node{
    //左子节点
    private Node left;
    //右子节点
    private Node right;
    //记录节点
    private Integer number;
    //值
    private String value;


    public Node(Integer number,String value){
      this.number=number;
      this.value=value;
    }


  }

  /**
   * 添加节点
   * @param number
   * @param value
   */
  public void add(Integer number,String value){
    addValue(root,number,value);
  }

  private Node addValue(Node node,Integer number,String value){
    //不存在则先创建根节点
    if (node==null){
      return new Node(number,value);
    }
    //数字比节点小，则扫描左边，数字比节点大，则扫描右边，如果数字相等则更新
    if (number<node.number){
      node.left=addValue(node.left,number,value);
    }else if (number>node.number){
      node.right=addValue(node.right,number,value);
    }else {
      node.value=value;
    }
    return node;
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

  private Node getNode(Node node,Integer number){
    if (node==null){
      return null;
    }
    if (number<node.number){
      return getNode(node.left,number);
    }else if (number>node.number){
      return getNode(node.right,number);
    }else {
      return node;
    }
  }


  /**
   * 获取最大值(获取最小值类似，检索的是左边)
   * @return
   */
  public String getMax(){
    return getMaxNode(root).value;
  }

  public Node getMax(Node startNode){
    return getMaxNode(startNode);
  }

  private Node getMaxNode(Node node){
    if (node.right!=null){
      return getMaxNode(node.right);
    }
    return node;
  }

  /**
   * 删除最大值
   */
  public void deleteMax(){
    deleteMaxNode(root);
  }

  private Node deleteMaxNode(Node node){
    if (node.right==null){
      return node.left;
    }
    node.right=deleteMaxNode(node.right);
    return node;
  }

  /**
   * 删除
   */
  public void delete(Integer number){
    deleteNode(root,number);
  }

  private Node deleteNode(Node node,Integer number){
    if (number<node.number){
      node.left=deleteNode(node.left,number);
    }else if (number>node.number){
      node.right=deleteNode(node.right,number);
    }else {
      if (node.left==null){
        return node.right;
      }else if (node.right==null){
        return node.left;
      }else {
        Node maxLeftNode=getMax(node.left);
        Node maxLeftNode_Left=maxLeftNode.left;
        maxLeftNode.left=null;
        node.left.right=maxLeftNode_Left;
        deleteMaxNode(node.left);
        maxLeftNode.right=node.right;
        maxLeftNode.left=node.left;
        return maxLeftNode;
      }
    }
    return node;
  }




  @Test
  public void test(){
    root=new Node(6,"6");
    add(3,"3");
    add(14,"14");
    add(10,"10");
    add(9,"9");
    add(13,"13");
    add(11,"11");
    add(12,"12");
    add(16,"16");
//    System.out.println(get(15));
//    System.out.println(getMax());
//    deleteMax();
    delete(14);
//    System.out.println(root.right.value);
    System.out.println(root.right.left.right.value);



  }


}
