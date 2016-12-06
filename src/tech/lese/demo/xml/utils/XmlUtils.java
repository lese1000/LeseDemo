package tech.lese.demo.xml.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 
 * @author lese
 *将xml转换成Map,能够应对不用结构的xml,而不是只针对固定格式的xml.
 *转换规则:
 *1.主要是Map与List的互相嵌套
 *2.同名称的节点会被装进List
 */
public class XmlUtils { 
	
	public static Map<String,Object> xml2Map(String str){
		Document doc =null;
		try {
			doc = DocumentHelper.parseText(str);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return xml2Map(doc);
	}
  @SuppressWarnings("unchecked")  
    public static Map<String, Object> xml2Map(Document doc){ 
        Map<String, Object> map = new HashMap<String, Object>(); 
        if(doc == null) 
            return map; 
        Element root = doc.getRootElement(); 
        return buildXml2Map(root); 
    } 
     @SuppressWarnings("unchecked")
    public static Map buildXml2Map(Element e){ 
        Map map = new HashMap(); 
        List list = e.elements(); 
        if(list.size() > 0){ 
            for (int i = 0;i < list.size(); i++) { 
                Element iter = (Element) list.get(i); 
                List mapList = new ArrayList(); 
                 
                if(iter.elements().size() > 0){ 
                    Map m = buildXml2Map(iter); 
                    if(map.get(iter.getName()) != null){ 
                        Object obj = map.get(iter.getName()); 
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = new ArrayList(); 
                            mapList.add(obj); 
                            mapList.add(m); 
                        } 
                        if(obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = (List) obj; 
                            mapList.add(m); 
                        } 
                        map.put(iter.getName(), mapList); 
                    }else 
                        map.put(iter.getName(), m); 
                } 
                else{ 
                    if(map.get(iter.getName()) != null){ 
                        Object obj = map.get(iter.getName()); 
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = new ArrayList(); 
                            mapList.add(obj); 
                            mapList.add(iter.getText()); 
                        } 
                        if(obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = (List) obj; 
                            mapList.add(iter.getText()); 
                        } 
                        map.put(iter.getName(), mapList); 
                    }else 
                        map.put(iter.getName(), iter.getText()); 
                } 
            } 
        }else 
            map.put(e.getName(), e.getText()); 
        return map; 
    } 
     
     /**
      * 生成的xml中除了String类型，其他会添加Type属性。
      * @param map
      * @param rootElement 指定xml根元素
      * @return
      */
     public static String map2XmlAddAttrType(Map<String, Object> map, String rootElement) {
         Document doc = DocumentHelper.createDocument();
         Element body = DocumentHelper.createElement(rootElement);
         doc.add(body);
         buildMap2XmlAddAttrType(body, map);
         return doc.asXML();
     }
     /**
      * 生成的xml不添加元素属性
      * @param map
      * @param rootElement
      * @return
      */
     public static String map2XmlWithoutAttr(Map<String, Object> map, String rootElement) {
         Document doc = DocumentHelper.createDocument();
         Element body = DocumentHelper.createElement(rootElement);
         doc.add(body);
         buildMap2XmlWithoutAttr(body, map);
         return doc.asXML();
     }
      
     /**
      * 未完待续
      * @param body
      * @param map
      * 根据数据类型，在元素上增加type属性。String,map,list类型不添加
      * eg:<Address type="java.util.Map">
      * <AddressLine3></AddressLine3>
	  *	<AddressLine2></AddressLine2>
      * </Address>
      */
     private static void buildMap2XmlAddAttrType(Element body, Map<String, Object> map) {
         if (map != null) {
             Iterator<String> it = map.keySet().iterator();
             while (it.hasNext()) {
                 String key = (String) it.next();
                 if (null!=key&&!key.equals("")) {
                     Object obj = map.get(key);
                    
                     if (obj != null) {
                         if (obj instanceof java.lang.String) {
                        	 Element element = DocumentHelper.createElement(key);
                             element.setText((String) obj);
                             body.add(element);
                         } else {
                             if (obj instanceof java.lang.Character || obj instanceof java.lang.Boolean || obj instanceof java.lang.Number
                                     || obj instanceof java.math.BigInteger || obj instanceof java.math.BigDecimal) {
                            	 Element element = DocumentHelper.createElement(key);
                                 Attribute attr = DocumentHelper.createAttribute(element, "type", obj.getClass().getCanonicalName());
                                 element.add(attr);
                                 element.setText(String.valueOf(obj));
                                 body.add(element);
                             } else if (obj instanceof java.util.Map) {
                            	 Element element = DocumentHelper.createElement(key);
                                 buildMap2XmlAddAttrType(element, (Map<String, Object>) obj);
                                 body.add(element);
                             } else if (obj instanceof java.util.List){
                            	 for(Object item:(List)obj){
                            		 Element itemElement = DocumentHelper.createElement(key);
                            		 if( item instanceof java.util.Map){
                            			 buildMap2XmlAddAttrType(itemElement,(Map)item);
                            		 }else{
                            			 if (item instanceof java.lang.Character || item instanceof java.lang.Boolean || item instanceof java.lang.Number
                                                 || item instanceof java.math.BigInteger || item instanceof java.math.BigDecimal) {
                                             Attribute attr = DocumentHelper.createAttribute(itemElement, "type", item.getClass().getCanonicalName());
                                             itemElement.add(attr);
                                             itemElement.setText(String.valueOf(item));
                                         }
                            		 }
                            		 body.add(itemElement);
                            	 }
                             }
                         }
                     }
                     
                 }
             }
         }
     }
     
     /**
      * 生成的xml不添加元素属性type
      * @param body
      * @param map
      */
     public static void buildMap2XmlWithoutAttr(Element body, Map<String, Object> map){
    	 if (map != null) {
             Iterator<String> it = map.keySet().iterator();
             while (it.hasNext()) {
                 String key = (String) it.next();
                 Object item = map.get(key);
                 if (item instanceof java.util.Map) {
                	 Element itemElement = DocumentHelper.createElement(key);
                	 buildMap2XmlWithoutAttr(itemElement,(Map)item);
                	 body.add(itemElement); 
                 }else if(item instanceof java.util.List){
                	 for(Object obj:(List)item){
                		 Element itemElement = DocumentHelper.createElement(key);
                		 if( obj instanceof java.util.Map){
                        	 buildMap2XmlWithoutAttr(itemElement,(Map)obj);
                		 }else{
                			 itemElement.setText(String.valueOf(obj));
                		 }
                		 body.add(itemElement);
                	 }
                 }else{
                	 Element itemElement = DocumentHelper.createElement(key);
                	 itemElement.setText(String.valueOf(item));
                	 body.add(itemElement); 
                 }
                 
             }
    	 }
     }
     
} 