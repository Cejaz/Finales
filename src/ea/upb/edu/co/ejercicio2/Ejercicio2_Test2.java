package ea.upb.edu.co.ejercicio2;

/*
 * @author Jorge Londoño
 */

/*
 * Compile:
 * javac -encoding utf8 --source-path ./src -d ./bin src/ea/upb/edu/co/ejercicio2/Ejercicio2_Test2.java
 * Run:
 * java -cp ./bin ea.upb.edu.co.ejercicio2.Ejercicio2_Test2
 */

import java.util.*;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.MinPQ;


public class Ejercicio2_Test2 {

    private static List<Book> listaLibros;
    private static BST<Integer, List<Book>> librosPorAño;
    private static BST<Integer, MinPQ<Book>> topM;

    public static void test_lecturaCSV() {
        listaLibros = Book.readFile("books.csv");
    }

    public static void test_cantidadLibros() {
        System.out.println(listaLibros.size());
    }

    public static void text_indexarPorAño() {
        librosPorAño = Ejercicio2.indexarPorAño(listaLibros);
    }

    public static void test_cantidadAños() {
        System.out.println(librosPorAño.size());
    }

    public static void test_topMPorAño() {
        topM = Ejercicio2.topMPorAño(librosPorAño, 5);
        System.out.println(topM.size());
    }

    public static void test_topM() {
        MinPQ<Book> top2000 = topM.get(2000);
        System.out.println(top2000.size());
        Book libro1 = top2000.delMin();
        System.out.println(libro1.getTitle()+","+libro1.getAverage_rating());
        Book libro2 = top2000.delMin();
        System.out.println(libro2.getTitle()+","+libro2.getAverage_rating());
    }
    /*
    Año: 2000
    The American Campaign: U.S. Presidential Campaigns and the National Vote : 5.0
    Harry Potter and the Goblet of Fire (Harry Potter  #4) : 4.56
    1968: War and Democracy : 4.5
    Lonesome Dove : 4.49
    The Most of P.G. Wodehouse : 4.48
    */

    public static void test_mejorAñoRango() {
        BST<Integer,Book> mejor = Ejercicio2.mejorLibroAñoRango(librosPorAño, 1990, 2000);
        System.out.println(mejor.size());
        System.out.println(mejor.get(1990).getTitle()+","+mejor.get(1990).getAverage_rating());
    }
    /*
    1990 : Cocolat: Extraordinary Chocolate Desserts
    1991 : Herbert the Timid Dragon
    1992 : Organizational Architecture: Designs for Changing Organizations
    1993 : The Days Are Just Packed
    1994 : Wissenschaft der Logik: Die Lehre Vom Begriff (1816)
    1995 : The Goon Show  Volume 11: He's Fallen in the Water!
    1996 : The Goon Show  Volume 4: My Knees Have Fallen Off!
    1997 : Dionysiac Poetics and Euripides' Bacchae
    1998 : Restless Till We Rest in You: 60 Reflections from the Writings of St. Augustine (Saints Speak Today)
    1999 : The Gospel According to Luke
    2000 : The American Campaign: U.S. Presidential Campaigns and the National Vote
    */

    public static void main(String[] args) {
        test_lecturaCSV();        
        test_cantidadLibros();
        text_indexarPorAño();
        test_cantidadAños();
        test_topMPorAño();
        test_topM();
        test_mejorAñoRango();
    }

}
