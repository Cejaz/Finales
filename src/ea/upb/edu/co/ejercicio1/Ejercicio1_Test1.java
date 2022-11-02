package ea.upb.edu.co.ejercicio1;

/*
 * Compile:
 * javac -encoding utf8 --source-path src -d bin .\src\ea\upb\edu\co\ejercicio1\Ejercicio1_Test1.java
 * Run:
 * java -cp ./bin ea.upb.edu.co.ejercicio1.Ejercicio1_Test1
 */

import edu.princeton.cs.algs4.ST;

public class Ejercicio1_Test1 {

    private static ST<String, Integer> st;
    private static Iterable<String> it;

    public static void test_contarPalabras() {
        st = Ejercicio1.contarPalabras("aliceInWonderland.txt");
        assert(st!=null);
    }

    public static void test_totalPalabras() {
        System.out.println(st.size());
    }

    public static void test_conteoPalabras() {
        System.out.println(st.get("work"));
        System.out.println(st.get("twist"));
    }

    public static void test_calcularTopM() {
        it = Ejercicio1.topM(st,5);
        assert(it!=null);
    }

    public static void test_topM() {
        assert(it!=null);
        String[] top = { "said", "alice", "that", "with", "this" };
        int i=0;
        for(String p: it) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        test_contarPalabras();
        test_totalPalabras();
        test_conteoPalabras();
        test_calcularTopM();
        test_topM();
    }

}
