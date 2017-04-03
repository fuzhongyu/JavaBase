package com.fzy.regular;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配规则
 *
 * Created by fuzhongyu on 2017/3/6.
 * article from： http://www.regexlab.com/zh/regref.htm
 */
public class RegularTest {

    @Test
    public void test(){
        normalChar();
        transferChar();
        variousChar();
        defineVariousChar();
        decorateChar();
        abstractChar();
        sonChar();
        greedyMode();
        backwardRef();
        previewSearch();
        unRemberSonChar();
    }

    /**
     * ######################################################
     * #=========================正则方法====================#
     * ######################################################
     */

    /**
     * 正则匹配
     * @param validateString  需要验证的字符
     * @param regEx  匹配规则
     * @return true-能匹配  false-不能匹配
     */
    public static Boolean regularMatching(String validateString,String regEx){
        Pattern pattern=Pattern.compile(regEx);
        Matcher matcher=pattern.matcher(validateString);
        return matcher.matches();

    }

    /**
     * 正则查找是否含有某字符串
     * @param validateString  需要验证的字符
     * @param regEx  匹配规则
     * @return true-有  false-没有
     */
    public static Boolean regularFind(String validateString,String regEx){
        Pattern pattern=Pattern.compile(regEx);
        Matcher matcher=pattern.matcher(validateString);
        if(matcher.find()){
            return true;
        }else {
            return false;
        }

    }

    /**
     * 正则查找匹配的字符
     * @param validateString  需要验证的字符
     * @param regEx  匹配规则
     * @return 匹配字符
     */
    public static String regularFindWrite(String validateString,String regEx){
        StringBuilder builder=new StringBuilder();
        Pattern pattern=Pattern.compile(regEx);
        Matcher matcher=pattern.matcher(validateString);
        while (matcher.find()){
            builder.append(matcher.group());
        }
        return builder.toString();
    }

    /**
     * ######################################################
     * #=========================匹配规则====================#
     * ######################################################
     */

    /**
     * 普通字符匹配
     */
    public void normalChar(){
        String str1="ab";
        String regEx1="ab";
        System.out.println("normalChar1:"+regularMatching(str1,regEx1));
    }

    /**
     * 转义字符匹配
     * 注： 回车:\r  换行：\n  制表符：\t  \本身：\\  ^本身：\^    $本身：\$   .本身：\.
     *
     *    括号本身：\( 和 \)   \[ 和 \]  \{ 和 \}     ?本身：\?     +本身：\+      *本身：\*    |本身： \|
     */
    public void transferChar(){
        String str1="anc$de";
        String regEx1="c\\$d";   //这边第一个\是转义字符串中的\ ， \\$ 即表示\$
        System.out.println("tranferChar1:"+regularFind(str1,regEx1)); //匹配"c$d"
    }

    /**
     * 多种字符匹配规则（大写表示反向--不常用）
     *  注： 0~9中任意一个：\d                                         非数字: \D
     *      任意一个字母或数字或下划线（即：A~Z,a~z,0~9,_）: \w          非数字，字母，下划线： \W
     *      空格，制表符，换行符等空白字符的其中任意一个：\s               非单空白字符：\S
     *      除了换行符（\n）之外的任意字符：.
     */
    public void variousChar(){
        String str1="999";
        String regEx1="\\d\\d\\d";
        System.out.println("variousChar1:"+regularMatching(str1,regEx1));

        String str2="aaa 100";
        String regEx2="a.\\w\\s";  //.直接表示匹配除换行符之外的任意字符
        System.out.println("variousChar2:"+regularFind(str2,regEx2));  //匹配"aaa "
    }

    /**
     * 自定义匹配多种字符的表达式
     * 注：  匹配 a或b或5或@ 中的任意字符 : [ab5@]
     *      匹配 a,b,c之外 的任意字符：[^abc]
     *      匹配 f~k之间 的任意字符：[f-k]
     *      匹配 A-F,0-3之外 的任意字符：[^A-F0-3]
     */
    public void defineVariousChar(){
        String str1="abd321";
        String regEx1="[cdf][^anc]";
        System.out.println("defineVariousChar1:"+regularFind(str1,regEx1));  //匹配"d3"

        String str2="aP357f9";
        String regEx2="[H-g][^1-3M-Z]";
        System.out.println("defineVariousChar2:"+regularFind(str2,regEx2));  //匹配"f9"

        //-----这种匹配方式会报错-----
        String regEx3="[a-F]";  //a的值大于f的值
    }

    /**
     * 修饰匹配次数的特殊符号
     * 注： 表达式重复n次： {n}   即\d{2} 相当于\d\d
     *     表达式至少重复m次，最多重复n次 ： {m,n}   即 ba{1,3} 相当于可以匹配 ba或baa或baaa
     *     表达式至少重复m次: {m,}
     *     匹配出现0次或1次： ?  即相当于{0,1}
     *     匹配至少出现一次： +  即相当于{1,}
     *     匹配不出现或者任意多次： *  即相当于{0,}
     *
     */
    public void decorateChar(){
        String str1="it cost $12.5";
        String regEx1="\\d+\\.?\\d*";
        //注：这个表达式能匹配12.5也能匹配12，但默认是匹配能匹配的最长字符串(贪婪模式)，匹配12下文会讲到（非贪婪模式)
        System.out.println("decorateChar1 matching char:"+regularFindWrite(str1,regEx1));
        System.out.println("decorateChar1:"+regularFind(str1,regEx1)); //这边匹配的是12.5
    }


    /**
     * 抽象意义的特殊符号
     * 注： 与字符串开始的地方匹配，不匹配任何字符： ^
     *     与字符串结束的地方匹配，不匹配任何字符： $
     *     匹配一个单词边界(匹配结果中所处位置的两边，一边是 \w,另一边是 非\w)，不匹配任何字符： \b
     *     匹配非单词边界(匹配结果中所处位置的两边，两边都是\w,两边都不是\w)，不匹配任何字符： \B  (不常用)
     */
    public void abstractChar(){
        String str1="abc123d";
        String regEx1="^c1";
        System.out.println("abstractChar1:"+regularFind(str1,regEx1)); //匹配失败,^需要是最开头的

        String str2="week1end,end_for,end";
        String regEx2="\\bend\\b";
        System.out.println("abstractChar2:"+regularFind(str2,regEx2)); //匹配了字符串末尾的"end"（17~20位置），前两个不能匹配
    }

    /**
     * 影响表达式内部的子表达式
     * 注： 左右两边 "或" 关系： |
     *     (1)在匹配次数的时候可以作为整体被修饰，（2）取匹配结果的时候括号中的内容可以单独被取到 ： ()
     */
    public void sonChar(){
        String str1="i am tom,he is jack";
        String regEx1="tom|jack";
        System.out.println("sonChar1:"+regularFind(str1,regEx1)); //匹配到"tom"

        String str2="let's go go go!";
        String regEx2="(go\\s*)+";
        System.out.println("sonChar2:"+regularFind(str2,regEx2)); //匹配到"go go go"

    }

    /**
     * 贪婪模式和非贪婪模式
     * 注： 贪婪模式：使匹配次数不定的表达式尽可能多的匹配（即匹配能够匹配的最大长度），这种模式叫贪婪模式（默认的模式）。
     *     非贪婪模式：使匹配次数不定的表达式尽可能少的匹配（即匹配能够匹配的最小长度），这种模式叫非贪婪模式，也叫勉强模式。
     *               其语法是在修饰匹配次数的特殊符号后加 ?
     */
    public void greedyMode(){

        /** ###############################
         *  #============贪婪模式==========#
         *  ###############################
         */
        String str1="xxdxdxxdxd";
        String regEx1="(d)(\\w+)(d)";
        //这边在\w+的时候，总是尽可能多的匹配符合他规则的字符。但为了匹配能够成功，\w+没有匹配最后一个d
        System.out.println("greedyMode1:"+regularFind(str1,regEx1)); //匹配到"dxdxxdxd"


        /** ###############################
         *  #===========非贪婪模式=========#
         *  ###############################
         */
        String str2="xxdxdxxdxd";
        String regEx2="(d)(\\w+?)(d)";
        //在\w+后加?,使其变为非贪婪模式
        System.out.println("greedyMode2:"+regularFind(str2,regEx2));  //匹配到"dxd"
    }

    /**
     * 反向引用 \1 ,\2 …
     * 注： 表达式在匹配时，表达式引擎会将小括号()包含的表达式所匹配到的字符串记录下来，在获取匹配结果的时候，小括号包含的表达式所匹配到的字符串可以单独获取。
     *     在实际应用中，当用某种边界来查找，而所要获取的内容又不包含边界时，必须使用小括号来指定所要的范围，如"<td>(.*?)</td>"并取括号中的值"\1" ,来获取<td></td>之间的内容
     *
     *     其实，小括号包含的表达式所匹配到的字符串" 不仅是在匹配结束后才可以使用，在匹配过程中也可以使用。表达式后边的部分，可以引用前面 "括号内的子匹配已经匹配到的字符串"。
     *     引用方法是 "\" 加上一个数字。"\1" 引用第1对括号内匹配到的字符串，"\2" 引用第2对括号内匹配到的字符串……以此类推，如果一对括号内包含另一对括号，则外层的括号先排序号。
     */
    public void backwardRef(){
        String str1="'hello',\"world\"";
        String regEx1="('|\")(.*?)(\\1)";
        System.out.println("backwardRef1:"+regularFind(str1,regEx1));  //匹配到 "'hello'"

        String str2= "aa bbbb abcdefg ccccc 111121111 999999999";
        String regEx2="(\\w)\\1{4,}";
        //匹配到\w 然后重复4次以上，即至少重复5次
        System.out.println("backwardRef2:"+regularFind(str2,regEx2));  //匹配到"ccccc"

        String str3="<td id='td1' style=\"bgcolor:white\"></td>";
        String regEx3="<(\\w+)\\s*(\\w+(=('|\").*?\\4)?\\s*)*>.*?</\\1>";
        System.out.println("backwardRef3:"+regularMatching(str3,regEx3));  //匹配成功
    }

    /**
     * 预搜索，反向预搜索
     * 注： 正向预搜索： 能匹配：（?=xxxx）, 不能匹配：(?!xxxx)     xxxx代表需要匹配的字符串格式
     *     反向预搜索(js不支持)： 能匹配：(?<=xxxx), 不能匹配：(?<!xxxx)
     *
     *  格式："(?=xxxxx)"，在被匹配的字符串中，它对所处的 "缝隙" 或者 "两头" 附加的条件是：所在缝隙的右侧，必须能够匹配上 xxxx 这部分的表达式。
     *  因为它只是在此作为这个缝隙上附加的条件，所以它并不影响后边的表达式去真正匹配这个缝隙之后的字符。这就类似 "\b"，本身不匹配任何字符。
     *  "\b" 只是将所在缝隙之前、之后的字符取来进行了一下判断，不会影响后边的表达式来真正的匹配。
     */
    public void previewSearch(){

        /** ##################
         *  #====正向预搜索===#
         *  ##################
         */
        String str1="Windows 98, Windows NT, Windows 2000";
        String regEx1="Windows (?=NT|XP)";
        System.out.println("previewSearch1:"+regularFind(str1,regEx1)); //将只匹配 "Windows NT" 中的 "Windows "，其他的 "Windows " 字样则不被匹配

        String str2="aaa ffffff 999999999";
        String regEx2="(\\w)((?=\\1\\1\\1)(\\1))+";
        //将可以匹配6个"f"的前4个，可以匹配9个"9"的前7个。这个表达式可以读解成：重复4次及以上（包括4次）的字母数字，则匹配其剩下最后2位之前的部分。
        System.out.println("previewSearch2:"+regularFind(str2,regEx2));  //匹配ffffff

        String str3="fdjka ljfdl stop fjdsla fdj";
        String regEx3="((?!\\bstop\\b).)+";
        //将从头一直匹配到 "stop" 之前的位置，如果字符串中没有 "stop"，则匹配整个字符串。
        System.out.println("previewSearch3:"+regularFind(str3,regEx3)); //匹配"fdjka ljfdl "

        /** ##################
         *  #====反向预搜索===#
         *  ##################
         */
        String str4="1234567890123456";
        String regEx4="(?<=\\d{4})\\d+(?=\\d{4})";
        //将匹配除了前4个数字和后4个数字之外的中间8个数字
        System.out.println("previewSearch4:"+regularFind(str4,regEx4)); //匹配"56789012"
    }

    /**
     * 括号内的子表达式不进行记录
     * 注： 结果不记录供以后使用： (?:xxxx)
     */
    public void unRemberSonChar(){
        String str1="a bbccdd efg";
        String regEx1="(?:(\\w)\\1)+";
        //括号 "(?:)" 范围的匹配结果不进行记录，因此 "(\w)" 使用 "\1" 来引用
        System.out.println("unRemberSonChar1:"+regularFind(str1,regEx1)); //匹配bbccdd
    }

}
