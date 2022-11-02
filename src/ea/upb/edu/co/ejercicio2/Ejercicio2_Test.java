package ea.upb.edu.co.ejercicio2;

/*
 * @author Jorge Londoño
 */

import org.testng.annotations.Test;
import org.testng.Assert;   // https://javadoc.io/doc/org.testng/testng/latest/org/testng/Assert.html

import java.util.*;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.MinPQ;


public class Ejercicio2_Test {

    private List<Book> listaLibros;
    private BST<Integer, List<Book>> librosPorAño;
    private BST<Integer, MinPQ<Book>> topM;

    @Test
    public void test_lecturaCSV() {
        listaLibros = Book.readFile("books.csv");
        Assert.assertNotNull(listaLibros);
    }

    @Test(dependsOnMethods = { "test_lecturaCSV" })
    public void test_cantidadLibros() {
        Assert.assertEquals(listaLibros.size(), 11127);
    }

    @Test
    public void text_indexarPorAño() {
        librosPorAño = Ejercicio2.indexarPorAño(listaLibros);
        Assert.assertNotNull(librosPorAño);
    }

    @Test(dependsOnMethods = {"text_indexarPorAño"})
    public void test_cantidadAños() {
        Assert.assertEquals(librosPorAño.size(),87);
    }

    @Test(dependsOnMethods = {"text_indexarPorAño"})
    public void test_topMPorAño() {
        topM = Ejercicio2.topMPorAño(librosPorAño, 5);
        Assert.assertEquals(topM.size(),87);
    }

    @Test(dependsOnMethods = {"test_topMPorAño"})
    public void test_topM() {
        MinPQ<Book> top2000 = topM.get(2000);
        Assert.assertEquals(top2000.size(),5);
        Book libro1 = top2000.delMin();
        Assert.assertEquals(libro1.getTitle(),"The Most of P.G. Wodehouse");
        Assert.assertEquals(libro1.getAverage_rating(),4.48, 0.001);
        Book libro2 = top2000.delMin();
        Assert.assertEquals(libro2.getTitle(),"Lonesome Dove");
        Assert.assertEquals(libro2.getAverage_rating(),4.49, 0.001);
    }

    @Test(dependsOnMethods = {"text_indexarPorAño"})
    public void test_mejorAñoRango() {
        BST<Integer,Book> mejor = Ejercicio2.mejorLibroAñoRango(librosPorAño, 1990, 2000);
        Assert.assertNotNull(mejor, "La tabla de mejores no puede ser null");
        Assert.assertEquals(mejor.size(),11);
        Assert.assertEquals(mejor.get(1990).getTitle(),"Cocolat: Extraordinary Chocolate Desserts");
    }


}
