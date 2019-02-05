package domsaxlibros;

import static Complementos.Lectura.read;
import java.io.IOException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author a16alfonsofa
 */
class Consulta {

    public static void consultaTitulo() throws IOException {

        boolean encontrado = false;

        System.out.print("Introduzca título de consula:\n > ");
        String titulo = read.readLine();
        NodeList libros = DOMSAXLibros.documento.getElementsByTagName("libro");
        Element libro = null;

        for (int i = 0; i < libros.getLength(); i++) {
            libro = (Element) libros.item(i);
            if (libro.getElementsByTagName("titulo").item(0).getTextContent().equalsIgnoreCase(titulo)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado == true) {
            Visualizacion.verLibro(libro);
            System.out.println("EXITO -- Libro encontrado, presione ENTER para continuar.");
            read.readLine();
        } else {
            System.err.println("ERROR -- No se ha encontrado ningún libro con ese titulo");
        }

    }

    public static void consulta() throws IOException {

        System.out.print("Introduzca isbn de consula:\n > ");
        String isbn = read.readLine();
        System.out.println(isbn);

        try {
            Element libro = DOMSAXLibros.documento.getElementById(isbn);
            System.out.println("El libro con isbn " + isbn + " se titula " + libro.getElementsByTagName("titulo").item(0).getTextContent());

        } catch (NullPointerException e) {
            System.err.println("ERROR -- No existe ningún libro con ese isbn.");
        }

    }

}
