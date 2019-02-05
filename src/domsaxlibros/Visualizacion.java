package domsaxlibros;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author a16alfonsofa
 */
class Visualizacion {

    public static void verTodo() {

        Element libro;

        NodeList libros = DOMSAXLibros.documento.getElementsByTagName("libro");
        System.out.println(libros.getLength());
        for (int i = 0; i < libros.getLength(); i++) {

            libro = (Element) libros.item(i);
            String isbn = libro.getAttribute("isbn");
            String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
            String precio = libro.getElementsByTagName("precio").item(0).getTextContent();
            String apellido1 = libro.getElementsByTagName("apellido1").item(0).getTextContent();
            String apellido2 = libro.getElementsByTagName("apellido2").item(0).getTextContent();
            String autor = libro.getElementsByTagName("nombre").item(0).getTextContent();

            System.out.println("\nLIBRO " + (i + 1) + " ----------------------");
            System.out.println("Autor: \t" + autor + " " + apellido1 + " " + apellido2);
            System.out.println("ISBN: \t" + isbn);
            System.out.println("Titulo: \t" + titulo);
            System.out.println("Precio: \t" + precio + "€");

        }
    }

    public static void verLibro(Element libro) {

        String isbn = libro.getAttribute("isbn");
        String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
        String precio = libro.getElementsByTagName("precio").item(0).getTextContent();
        String apellido1 = libro.getElementsByTagName("apellido1").item(0).getTextContent();
        String apellido2 = libro.getElementsByTagName("apellido2").item(0).getTextContent();
        String autor = libro.getElementsByTagName("nombre").item(0).getTextContent();

        System.out.println("isbn: " + isbn);
        System.out.println("titulo: " + titulo);
        System.out.println("precio: " + precio + "€");
        System.out.println("autor: " + autor + " " + apellido1 + " " + apellido2);

    }

}
