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
    private final String key = myapi.clientId;
    private String url ="";
    private void resetUrl(String word){
        url = "https://opendict.korean.go.kr/api/search?certkey_no=6977";
        url += "&key=" + key;
        url += "&req_type=xml";
        url += "&target_type=search";
        url += "&part=word";
        url += "&q=" + word;
        url += "&sort=dict";
        url += "&start=1";
        url += "&num=10";
        url += "&advanced=y";
        url += "&letter_s=2";
        url += "letter_e=60";
    }

    public boolean isWordExist(String word) {
        try {
            resetUrl(word);
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

    public boolean isNextWordExist(String lastword) {
        try {
            resetUrl(lastword);
            url+="$method=start";

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
            NodeList nl = doc.getElementsByTagName("item");
            if (nl.getLength() == 0) {
                System.out.println("'" + lastword + "'로 시작하는 단어가 없습니다.");
                return false;
            } else {
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
