package com.fuzhongyu.regular;

import org.junit.Test;

/**
 * 常用的正则匹配规则
 * Created by fuzhongyu on 2017/3/7.
 */
public class UsuallyUseMatching {

    //身份证匹配规则
    final static String idCardRegEx="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";

    //手机号匹配规则
    final static  String mobileRegEx="^1[34578]\\d{9}$";

    //邮箱匹配规则
    final static String emailRegEx="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    //匹配中文字符
    final static String chineseCharRegEx="[\\u4e00-\\u9fa5]";

    //匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
    final static String accountRegEx="^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

    //固定电话
    final static String telphoneRegEx="^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";

    //qq号
    final static String qqRegEx="^\\d{5,10}$";

    @Test
    public void test() {

        System.out.println(RegularTest.regularMatching("18365268284",mobileRegEx));

    }

}
