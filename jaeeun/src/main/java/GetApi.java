//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetApi {
    public GetApi() {
    }

    public boolean isWordExist(String word) {
        try {
            String key = myapi.clientId;
            String url = "https://opendict.korean.go.kr/api/search?certkey_no=6977";
            url = url + "&key=" + key;
            url = url + "&req_type=xml";
            url = url + "&target_type=search";
            url = url + "&part=word";
            url = url + "&q=" + word;
            url = url + "&sort=dict";
            url = url + "&start=1&num=10";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
            NodeList nl = doc.getElementsByTagName("item");
            if (nl.getLength() == 0) {
                System.out.println("'" + word + "'란 단어는 없습니다.");
                return false;
            } else {
                Node node = nl.item(0);
                if (node.getNodeType() == 1) {
                    Element element = (Element)node;
                    System.out.println("word : " + this.getValue("word", element));
                    System.out.println("pos : " + this.getValue("pos", element));
                    System.out.println("definition : " + this.getValue("definition", element));
                    System.out.println();
                }

                return true;
            }
        } catch (Exception var10) {
            Exception e = var10;
            e.printStackTrace();
            return false;
        }
    }

    public String getValue(String tag, Element element) {
        NodeList nl = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node value = nl.item(0);
        return value.getNodeValue();
    }
}
