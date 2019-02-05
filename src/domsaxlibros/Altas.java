package domsaxlibros;

import Complementos.Comprobaciones;
import static Complementos.Lectura.read;
import java.io.IOException;
import org.w3c.dom.Element;

/**
 *
 * @author a16alfonsofa
 */
class Altas {

    public static void altaLibros() throws IOException {

        Element libro = DOMSAXLibros.documento.createElement("libro");

        System.out.println("Introduzca ISBN de nuevo libro:\n"
                + "formato: A555555\n > ");
        String isbn;

        do {
            isbn = Comprobaciones.introduceISBN();
            if (Comprobaciones.compruebaISBN(isbn)) {
                System.out.println("Error - este ISBN ya ha sido registrado. Introduzca un isbn válido:");
            }
        } while (Comprobaciones.compruebaISBN(isbn));

        libro.setAttribute("isbn", isbn);
        libro.setIdAttribute("isbn", true);

        Element autor = DOMSAXLibros.documento.createElement("autor");

        System.out.print("Introduzca el primer apellido del autor:\n > ");
        autor.appendChild(DOMSAXLibros.documento.createElement("apellido1")).setTextContent(read.readLine());

        System.out.print("Introduzca el segundo apellido del autor:\n > ");
        autor.appendChild(DOMSAXLibros.documento.createElement("apellido2")).setTextContent(read.readLine());

        System.out.print("Introduzca nombre del autor:\n > ");
        autor.appendChild(DOMSAXLibros.documento.createElement("nombre")).setTextContent(read.readLine());

        libro.appendChild(autor);

        System.out.print("Introduzca título del libro:\n > ");
        libro.appendChild(DOMSAXLibros.documento.createElement("titulo")).setTextContent(read.readLine());

        System.out.print("Introduzca precio del  libro:\n > ");
        libro.appendChild(DOMSAXLibros.documento.createElement("precio")).setTextContent(String.format("%.2f", Comprobaciones.insertFloat(false)));

        DOMSAXLibros.documento.getDocumentElement().appendChild(libro);

        XML.xml.escribeXML(DOMSAXLibros.documento);

        System.out.println("--Éxito en el alta.");
    }

}
