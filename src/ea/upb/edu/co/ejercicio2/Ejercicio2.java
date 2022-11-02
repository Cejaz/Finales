package ea.upb.edu.co.ejercicio2;

/*
 * @author Jorge Londoño
 * Datasets: 
 *  https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks
 *  https://www.kaggle.com/datasets/saurabhbagchi/books-dataset
 */


import java.util.*;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.MinPQ;

public class Ejercicio2 {


    static BST<Integer, List<Book>> indexarPorAño(List<Book> lista) {
        BST<Integer, List<Book>> librosPorAño = new BST<>();
        int i = 0;
        while (i < lista.size()) {
            Book lib = lista.get(i); 
            Calendar cal = lib.getPublication_date();
            int year = cal.get(1);
            if (!librosPorAño.contains(year)) {
                List<Book> list = new ArrayList<>();
                list.add(lib);
                librosPorAño.put(year, list);
            } else {
                List<Book> list = librosPorAño.get(year);
                list.add(lib);
                librosPorAño.put(year, list);
            }
            i++;
        }
    }

    static BST<Integer, MinPQ<Book>> topMPorAño(BST<Integer, List<Book>> librosPorAño, int m) {
        BST<Integer, MinPQ<Book>> topPorAño = new BST<>();
        for (Integer i : librosPorAño.keys()) {
            MinPQ<Book> clp = new MinPQ<>();
            for (Book lib : librosPorAño.get(i)) {;
                int k = clp.size();
                if (k != m) {
                    clp.insert(lib);
                } else {
                    float j = clp.min().getAverage_rating();
                    float l = lib.getAverage_rating();
                    if ( l >= j) {
                        clp.insert(lib);
                        clp.delMin();
                    }
                }
            }
            topPorAño.put(i, clp);
        }
    }

    public static Iterable<Book> listarTopm(BST<Integer, MinPQ<Book>> topM, int año) {
        Stack<Book> p = new Stack<>();
        for (Book lib : topM.get(año)) {
            p.add(lib);
        }
        return p;
    }

    public static BST<Integer,Book> mejorLibroAñoRango(BST<Integer, List<Book>> librosPorAño, int año_min, int año_max) {
        BST<Integer, Book> tb = new BST<>();
        for (Integer year : librosPorAño.keys()) {
            if (año_min <= year && year <= año_max ) {
                Book lib = null;
                int g = 0;
                for (Book b : librosPorAño.get(year)) {
                    if (g == 0){
                        lib = b;
                        g++;
                    }    
                    else {
                        float l = lib.getAverage_rating();
                        float j = b.getAverage_rating();
                        if (l < j) {
                            lib = b;
                        }
                    }
                }
                tb.put(year, lib);
            }
        }
        return tb;
    }



    public static void main(String[] args) {
        List<Book> listaLibros = Book.readFile("books.csv");
        System.out.println(listaLibros.size());

        for (Book lib : top2000) {
            System.out.println(lib.toString());
        

        for (Integer year : mejor.keys()) {
            System.out.println(year + "  " + mejor.get(year).toString());
        }

    }

}
