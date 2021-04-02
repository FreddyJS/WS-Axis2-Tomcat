package movie;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.net.URL;
import java.net.URLConnection;

public class MovieReader {
    public static final String base_api = "http://www.omdbapi.com/?";
    private static final String apikey = "&r=xml&apikey=13a96bc3";

    public static String get_movie(String movie) {
        try {
            URL url = new URL(base_api + "t=" + movie + apikey);
            URLConnection conn = url.openConnection();
    
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());
            return parse_movie(doc);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }

    public static String parse_movie(Document doc) throws Exception {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // optional, but recommended
        // process XML securely, avoid attacks like XML External Entities (XXE)
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        System.out.println("------------");

        // get <staff>
        NodeList list = doc.getElementsByTagName("movie");

        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                // get staff's attribute
                String title = element.getAttribute("title");
                String year = element.getAttribute("year");
                String plot = element.getAttribute("plot");

                System.out.println("Readed Element:" + node.getNodeName());
                System.out.println("Movie Title: " + title);
                System.out.println("Movie Year: " + year);
                System.out.println("Movie Plot: " + plot);

                return title + " - " + year + " - " + plot;

            }
        }

        return "";
    }
}