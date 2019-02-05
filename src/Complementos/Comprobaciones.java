package Complementos;

import domsaxlibros.DOMSAXLibros;
import java.io.IOException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author a16alfonsofa
 */
public class Comprobaciones implements Lectura {

    public static String introduceISBN() throws IOException {

        String isbn = null;
        boolean repite = false;
        do {
            try {
                repite = false;

                isbn = read.readLine();
                if (isbn.length() != 7) {
                    System.err.println("ERROR -- El isbn debe constar de 7 caracteres.");
                    repite = true;
                }
                if (!isbn.substring(0, 1).matches("[A-Z a-z]")) {
                    System.err.println("ERROR -- El 1º caracter debe ser una letra.");
                    repite = true;
                }
                if (!isbn.substring(1, 7).matches("[0-9]*")) {
                    System.err.println("ERROR -- Los 6 últimos caracteres deben ser dígitos");
                    repite = true;
                }
            } catch (Exception e) {
            }
            if (repite == true) {
                System.err.println("ERROR -- Entrada incorrecta. Introduzca un valor válido:");
            }
        } while (repite == true);

        return isbn;
    }

    public static boolean compruebaISBN(String isbn) {

        NodeList libros = DOMSAXLibros.documento.getElementsByTagName("libro");

        for (int i = 0; i < libros.getLength(); i++) {

            Element libro = (Element) libros.item(i);
            if (libro.getAttribute("isbn").equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    public static int insertNum(int min, int max) throws IOException {
        boolean repite;
        int num = 0;

        do {
            repite = false;

            try {
                num = Integer.parseInt(read.readLine());
                if (num < min || num > max) {
                    repite = true;
                }
            } catch (NumberFormatException e) {
                repite = true;
            }
            if (repite == true) {
                System.err.println("ERROR -- El numero introducido no es válido. Introduzca un número válido (" + min + "-" + max + ").");
            }
        } while (repite == true);

        return num;
    }

    public static float insertFloat(boolean negativo) throws IOException {
        boolean repite;
        float num = 0;

        do {
            repite = false;

            try {
                num = Float.parseFloat(read.readLine());
                if (negativo == false && num < 0) {
                    repite = true;
                }
            } catch (NumberFormatException e) {
                repite = true;
            }
            if (repite == true) {
                System.err.println("ERROR -- El numero introducido no es válido. Introduzca un número real válido.");
            }
        } while (repite == true);
        return num;
    }
}
