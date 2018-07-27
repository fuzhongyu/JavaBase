package com.fzy.mixed_block.tree;

import javax.xml.transform.Source;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Test;

/**
 * @author Fucai
 * @date 2018/6/12
 */

public class Reply {

  private Nod root;


  @Getter
  @Setter
  @NoArgsConstructor
  private class Nod{

    private Nod left;

    private Nod right;

    private Integer val;

    public Nod(Integer val) {
      this.val = val;
    }
  }

  public Nod add(Nod nod,Integer val){
    if (nod==null){
      return new Nod(val);
    }
    if (val>nod.val){
      nod.right=add(nod.right,val);
    }else if (val<nod.val){
      nod.left=add(nod.left,val);
    }else {
      nod.val=val;
    }

    return nod;
  }

  public Nod get(Nod nod,Integer val){
    if (nod==null){
      return null;
    }
    if (val>nod.val){
      return get(nod.right,val);
    }else if (val<nod.val){
      return get(nod.left,val);
    }else {
      return nod;
    }
  }

  public Nod getMax(Nod nod){
    if (root==null){
      return null;
    }
    if (nod.right!=null){
      return getMax(nod.right);
    }else {
      return nod;
    }
  }


  public Nod delMaxNode(Nod nod){
    if (nod.right==null){
      return nod.left;
    }
    nod.right=delMaxNode(nod.right);
    return nod;
  }


  public Nod delNode(Nod nod,Integer val){
    if (val<nod.val){
      return nod.left=delNode(nod.left,val);
    }else if (val>nod.val){
      return nod.right=delNode(nod.right,val);
    }else {
      if (nod.left==null){
        return nod.right;
      }else if (nod.right==null){
        return nod.left;
      }else {
        Nod max=getMax(nod.left);
        delMaxNode(nod.left);
        max.left=nod.left;
        max.right=nod.right;
        return max;

      }
    }
  }


  @Test
  public void test(){

    root=add(root,6);
    add(root,3);
    add(root,14);
    add(root,10);
    add(root,9);
    add(root,13);
    add(root,11);
    add(root,12);
    add(root,16);

    delNode(root,14);

    System.out.println(root.right.val);
    System.out.println(root.right.right.val);
    System.out.println(root.right.left.right.val);

  }

}
