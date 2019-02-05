package domsaxlibros;

import Complementos.Lectura;
import XML.xml;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author a16alfonsofa
 */
public class DOMSAXLibros implements Lectura {

    public static Document documento;

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        byte op = 0;

        do {
            System.out.println("\nProyecto de Alfonso Fernandez Alvarez\n"
                    + "-------------------------------------------------------------------------------------------"
                    + "\nEjercicio XML Libros, introduzca comando:\n"
                    + "\t1\t - Alta de un libro.\n"
                    + "\t2\t - Ver todos los libros.\n"
                    + "\t3\t - Consulta de libro por ISBN.\n"
                    + "\t4\t - Consulta de libro por titulo.\n\n"
                    + "\t0\t - Salir.");

            documento = xml.leeXML();

            op = (byte) Complementos.Comprobaciones.insertNum(0, 4);

            switch (op) {
                case 0:
                    break;
                case 1:
                    Altas.altaLibros();
                    break;
                case 2:
                    Visualizacion.verTodo();
                    break;
                case 3:
                    Consulta.consulta();
                    break;
                case 4:
                    Consulta.consultaTitulo();
                    break;
            }

        } while (op != 0);
    }

}
