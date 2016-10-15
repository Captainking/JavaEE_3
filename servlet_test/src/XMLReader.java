import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
	   private  String classname=null;
	    public XMLReader(String URLstr){
	    	classname=getName(URLstr);
	    }
	public String getName(String URLstr) {

		Element element = null;
		// 可以使用绝对路劲
		File f = new File("web.xml");
		// documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		String stringtem=null;
		try {
			// 返回documentBuilderFactory对象
			dbf = DocumentBuilderFactory.newInstance();
			// 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
			db = dbf.newDocumentBuilder();
			// 得到一个DOM并返回给document对象
			Document dt = db.parse(f);
			// 得到一个elment根元素
			element = dt.getDocumentElement();
			// 获得根节点
			NodeList childNodes = element.getChildNodes();
			// 遍历这些子节点
			for (int i = 0; i < childNodes.getLength(); i++) {
				// 获得每个对应位置i的结点
				Node node1 = childNodes.item(i);
				if ("servlet-mapping".equals(node1.getNodeName())) {					
					NodeList nodeDetail = node1.getChildNodes();
					for (int j = 0; j < nodeDetail.getLength(); j++) {
						Node detail = nodeDetail.item(j);
						if ("url-pattern".equals(detail.getNodeName())&& detail.getTextContent().equals(URLstr)){// 输出code
							for (int k = 0; k < nodeDetail.getLength(); k++) {
								Node d = nodeDetail.item(k);
								if ("servlet-name".equals(d.getNodeName())){
										stringtem=d.getTextContent();
								break;
								}
							}
						    break;
						}
					}	
					
				}
			}
			if(stringtem!=null){
				
				for (int i = 0; i < childNodes.getLength(); i++) {
					// 获得每个对应位置i的结点
					Node node1 = childNodes.item(i);
					if ("servlet".equals(node1.getNodeName())) {					
						NodeList nodeDetail = node1.getChildNodes();
						for (int j = 0; j < nodeDetail.getLength(); j++) {
							Node detail = nodeDetail.item(j);
							if ("servlet-name".equals(detail.getNodeName())&& detail.getTextContent().equals(stringtem)){// 输出code
								for (int k = 0; k < nodeDetail.getLength(); k++) {
									Node d = nodeDetail.item(k);
									if ("servlet-class".equals(d.getNodeName())){
										System.out.println(d.getTextContent());
											return d.getTextContent();
									}
								}
							    break;
							}
						}	
						
					}
				}
				
			}else{
			return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public String getClass_Name(){
		return classname;
	}
}
