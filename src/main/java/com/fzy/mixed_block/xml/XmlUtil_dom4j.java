package com.fzy.mixed_block.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml解析工具类
 *
 * Created by fuzhongyu on 2017/5/24.
 */
public class XmlUtil_dom4j {

    /**
     * xml数据流转map
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static Map<String, Object> parseXml(InputStream inputStream) throws Exception {
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Map<String,Object> map=xml2map(document);
        //关闭资源
        inputStream.close();
        return map;
    }

    /**
     * xmlString 转map
     * @param xmlString
     * @return
     * @throws Exception
     */
    public static Map<String, Object> parseXml(String xmlString) throws Exception {

        Document document = DocumentHelper.parseText(xmlString);
        Map<String,Object> map=xml2map(document);
        return map;
    }

    /**
     * xml转string类型
     * @param document
     * @return
     */
    public static String xml2string(Document document){
        return document.asXML();
    }


    /**
     * 将xml元素存放到map中
     * @param document
     * @return
     */
    public static Map<String,Object> xml2map(Document document){

        Map<String, Object> retrunMap = new HashMap();
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            retrunMap.put(e.getName(), e.getText());
        return retrunMap;
    }



    public static void main(String[] args) {
        String str="<xml>\n" +
                " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[image]]></MsgType>\n" +
                " <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
                " <MediaId><![CDATA[media_id]]></MediaId>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        try {
            Map<String,Object> map=parseXml(str);
            for (Map.Entry<String,Object> entry:map.entrySet()){
                System.out.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
