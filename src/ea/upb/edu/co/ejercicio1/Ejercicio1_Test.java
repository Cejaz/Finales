package ea.upb.edu.co.ejercicio1;

import org.testng.annotations.Test;
import org.testng.Assert;   // https://javadoc.io/doc/org.testng/testng/latest/org/testng/Assert.html

import edu.princeton.cs.algs4.ST;

public class Ejercicio1_Test {

    private ST<String, Integer> st;
    private Iterable<String> it;

    @Test
    public void test_contarPalabras() {
        st = Ejercicio1.contarPalabras("aliceInWonderland.txt");
        Assert.assertNotNull(st);
    }

    @Test(dependsOnMethods = {"test_contarPalabras"})
    public void test_totalPalabras() {
        Assert.assertEquals(st.size(),3168);
    }

    @Test(dependsOnMethods = {"test_contarPalabras"})
    public void test_conteoPalabras() {
        Assert.assertEquals(st.get("work"),53);
        Assert.assertEquals(st.get("twist"),2);
    }

    @Test(dependsOnMethods = {"test_contarPalabras"})
    public void test_calcularTopM() {
        it = Ejercicio1.topM(st,5);
        Assert.assertNotNull(it);
    }

    @Test(dependsOnMethods = {"test_calcularTopM"})
    public void test_topM() {
        Assert.assertNotNull(it);
        String[] top = { "said", "alice", "that", "with", "this" };
        int i=0;
        for(String p: it) {
            Assert.assertEquals(p, top[i++]);
        }
    }



}
