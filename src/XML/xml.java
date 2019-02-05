package XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author a16alfonsofa
 */
public class xml {
    public static Document leeXML () throws ParserConfigurationException, SAXException, IOException {
        
        File fichero = new File("LibrosAutores.xml");
        Document documento;
        
        if(fichero.exists()) 
        documento=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new FileInputStream(fichero)));

        else{
        documento=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element raiz = documento.createElement("listalibros");
        documento.appendChild(raiz);}
    
        return documento;
    }
    
    public static void escribeXML (Document doc) {
        
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3"); 
            
            DOMSource origen = new DOMSource(doc);            
            StreamResult destino = new StreamResult("LibrosAutores.xml");
            transformer.transform(origen, destino);
        }
        
        catch(TransformerException e){System.out.println("Error en la transformación:" + e.getMessage());}
    }
}