import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Book b1 = new Book("Kitap1","Yazar1",10,"01-01-2000");
        Book b2 = new Book("Kitap2","Yazar2",20,"01-01-2000");
        Book b3 = new Book("Kitap3","Yazar3",30,"01-01-2000");
        Book b4 = new Book("Kitap4","Yazar4",40,"01-01-2000");
        Book b5 = new Book("Kitap5","Yazar5",50,"01-01-2000");
        Book b6 = new Book("Kitap6","Yazar6",60,"01-01-2000");
        Book b7 = new Book("Kitap7","Yazar7",70,"01-01-2000");
        Book b8 = new Book("Kitap8","Yazar8",80,"01-01-2000");
        Book b9 = new Book("Kitap9","Yazar9",90,"01-01-2000");
        Book b10 = new Book("Kitap10","Yazar10",105,"01-01-2000");

        List<Book> books = new ArrayList<>();

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);

        List<Book> pageCountBiggerThanHundred = books.stream().filter(b -> b.getPageCount() > 100).toList();
        Map<String ,String> bookMap  = books.stream().collect(Collectors.toMap(Book::getName, Book::getAuthor));

        pageCountBiggerThanHundred.forEach(b -> System.out.println("Kitap adi : " + b.getName() + " Yazar : " + b.getAuthor()));
        System.out.println("################################");
        bookMap.forEach((m,c) -> System.out.println("Kitap adi : " + m + " Yazar : " + c ));


    }
}
