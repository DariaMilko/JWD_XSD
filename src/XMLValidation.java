import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;


public class XMLValidation {
	public static boolean checkXMLforXSD(String pathXml, String pathXsd) throws Exception {	
       try {
    	   File xml = new File(pathXml);
    	   File xsd = new File(pathXsd);
    	   
    	   if (!xml.exists()) {
    		   System.out.println("XML not found " + pathXml);
    		   }
	             
    	   if (!xsd.exists()) {
    		   System.out.println("XSD not found " + pathXsd);
    		   }
    	   
    	   if (!xml.exists() || !xsd.exists()) {
    		   return false;
    		   }
	 
    	   SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    	   Schema schema = factory.newSchema(new StreamSource(pathXsd));
    	   Validator validator = schema.newValidator();
    	   validator.validate(new StreamSource(pathXml));
    	   return true;
    	   } catch (SAXException e) {
    		   System.out.println(e.getMessage());
    		   return false;
    		   }
       }
	
	public static void main(String[] args) throws Exception {
		boolean b = XMLValidation.checkXMLforXSD("web.xml", "web.xsd");
		System.out.println("Does the XML match XSD? - " + b);
		}
	}