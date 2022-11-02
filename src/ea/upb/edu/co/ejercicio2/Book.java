package ea.upb.edu.co.ejercicio2;

/*
 * @author Jorge Londoño
 * Dataset: https://www.kaggle.com/jealousleopard/goodreadsbooks
 */

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import edu.princeton.cs.algs4.In;


class Book implements Comparable<Book> {

    private int bookID;
    private String title;
    private String authors;
    private float average_rating;
    private String isbn;
    private String isbn13;
    private String language_code;
    private int num_pages;
    private int ratings_count;
    private int text_reviews_count;
    private Calendar publication_date;
    private String publisher;

    Book(String line) throws ParseException {
        String[] tmp = line.split(",");
        bookID = Integer.valueOf(tmp[0]);
        title = tmp[1];
        authors = tmp[2];
        average_rating = Float.parseFloat(tmp[3]);
        isbn = tmp[4];
        isbn13 = tmp[5];
        language_code = tmp[6];
        num_pages = Integer.valueOf(tmp[7]);
        ratings_count = Integer.valueOf(tmp[8]);
        text_reviews_count = Integer.valueOf(tmp[9]);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(tmp[10]));
        publication_date = calendar;
        publisher = tmp[11];
    }

    public Calendar getPublication_date() {
        return publication_date;
    }

    public float getAverage_rating() {
        return average_rating;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString(){
        return title;
    }

    @Override
    public int compareTo(Book b) {
        return Float.compare(average_rating, b.average_rating);
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public static List<Book> readFile(String file) {
        List<Book> lista = new ArrayList<>();
        In in = new In(file);
        in.readLine(); // ignorar primera linea
        while (!in.isEmpty()) {
            String l = in.readLine();
            try {
                Book b = new Book(l);
                lista.add(b);

            } catch (ParseException e) {
                System.err.println("Fecha no valida: " + l);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                System.err.println("Numero no valido: " + l);
            }
        }
        return lista;
    }

}


