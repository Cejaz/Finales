package ea.upb.edu.co.ejercicio1;

/*
 * @author Jorge Londoño
 * Datasets: 
 *  https://www.gutenberg.org/ebooks/11
 *  https://gist.github.com/ismaproco/6781d297ee65c6a707cd3c901e87ec56
 */



import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;


public class Ejercicio1 {

    private static int minlen=3;

    public static ST<String, Integer> contarPalabras(String filename) {
        Pattern p = Pattern.compile("[\"—‘“?”,!.’_():;-]");
        ST<String, Integer> st = new ST<String, Integer>();
        In in = new In(filename);
        while (!in.isEmpty()) {
            String key = in.readString().toLowerCase();
            if (key.length() <= minlen)
                continue;
            Matcher m = p.matcher(key);
            key = m.replaceAll("");
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }
        return st;
    }

    static void listarPalabras(ST<String, Integer> st) {
        for(String p: st.keys()) {
            System.out.println(p +" : "+ st.get(p));
        }
    }

  
        public static Iterable<String> topM(ST<String, Integer> st, int m) {
            Iterable<String> topMpalabras = null;
            class Palabra implements Comparable<Palabra> {
                private String pal;
                private int frec;
    
                public Palabra(String palabra, int val) {
                    this.pal = palabra;
                    this.frec = val;
                }
    
                @Override
                public int compareTo(Palabra pala) {
                    return Integer.compare(this.frec, pala.frec);
                }
            }
            
            MinPQ<Palabra> clp = new MinPQ<>();
            Stack<String> p = new Stack<>();
            Palabra pal;
            for (String pl : st.keys()) {
                pal = new Palabra(pl, st.get(pl));
                int k = clp.size();
                if (k != m) {
                    clp.insert(pal);
                } else {
                    if (0 < pal.compareTo(clp.min())) {
                        clp.insert(pal);
                        clp.delMin();
                    }
                }
    
            }
            Iterator<Palabra> itr = clp.iterator();
            while (itr.hasNext()) {
                p.push(itr.next().pal);
            }
            topMpalabras = p;
            return topMpalabras;
        }
    }

    public static void main(String[] args) {
        ST<String, Integer> st = contarPalabras("aliceInWonderland.txt");
        // System.out.println(st.size());
        // listarPalabras(st);
        // Iterable<String> it = topM(st,5);
        // for(String x: it) System.out.println(x+" : "+st.get(x));
    }

}
