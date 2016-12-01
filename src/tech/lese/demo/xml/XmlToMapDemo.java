package tech.lese.demo.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import tech.lese.demo.xml.utils.XmlUtils;

public class XmlToMapDemo {
 public static void main(String[] args) throws IOException,
   DocumentException {
  
//  FileInputStream fis = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\AccessRequest.xml");
//  FileInputStream fis = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\ShipmentConfirmRequest.xml");
  FileInputStream fis = new FileInputStream("E:\\book.xml");
  byte[] b = new byte[fis.available()];
  fis.read(b);
  String str = new String(b);
  
  Document doc = DocumentHelper.parseText(str);
  
//  System.out.println(doc.asXML());

  long beginTime = System.currentTimeMillis();
  
  Map<String, Object> map = XmlUtils.xml2Map(doc);

//  System.out.println(map.toString());
//  String xml = XmlUtils.map2XmlWithoutAttr(map, "rootElement");
  String xml = XmlUtils.map2XmlAddAttrType(map, "rootElement");
  
  System.out.println(xml);
  System.out.println("Use time:"+(System.currentTimeMillis()-beginTime));

 }
}