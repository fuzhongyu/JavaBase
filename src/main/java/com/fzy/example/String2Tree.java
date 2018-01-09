package com.fzy.example;


import java.util.ArrayList;
import java.util.List;

/**
 * @author fuzhongyu
 * @date 2017/12/19
 */

public class String2Tree {

    static Integer idtemp=1;

    public static void main(String[] args) {

        List<Tre> list=new ArrayList<>();

        String str="(A(B,C),D(E(F)),G)";

        char[] chars=str.toCharArray();
        Tre root=new Tre();
        root.setId(getIncreaceId());
        if(chars[0]=='('){
            //设置根节点
            root.setValue("root");
        }else {
            root.setValue(String.valueOf(chars[0]));
        }
        list.add(root);

        Tre tempParentTre=root;
        for (int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                Tre thisThr=new Tre(getIncreaceId(),tempParentTre,String.valueOf(chars[i+1]));
                list.add(thisThr);
                tempParentTre=thisThr;
                continue;
            }else if(chars[i]==')'){
                tempParentTre=tempParentTre.getParentTre();
            }else if(chars[i]==','){
                Tre thisThr=new Tre(getIncreaceId(),tempParentTre.getParentTre(),String.valueOf(chars[i+1]));
                list.add(thisThr);
                tempParentTre=thisThr;
                continue;
            }
        }

        for (Tre tre:list){
           if(tre.getParentTre()!=null){
               System.out.println(tre.getValue()+"   "+tre.getParentTre().getValue());
           }

        }
    }




    public static Integer getIncreaceId(){
        return idtemp++;
    }



}


class Tre {

    private Integer id;

    private Tre parentTre;

    private String value;


    public Tre() {
    }

    public Tre(Integer id,Tre parentTre, String value) {
        this.id = id;
        this.value = value;
        this.parentTre=parentTre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tre getParentTre() {
        return parentTre;
    }

    public void setParentTre(Tre parentTre) {
        this.parentTre = parentTre;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
