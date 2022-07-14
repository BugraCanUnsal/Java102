import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Programme {

    public static void main(String[] args) {

        TreeSet<Book> books1 = new TreeSet<>();

        Book book1 = new Book("Sefiller",1724,"Victor Hugo","1862-01-01");
        Book book2 = new Book("Vadideki Zambak",336,"Honore de Balzac","1836-01-01");
        Book book3 = new Book("Ana",432,"Maksim Gorki","1906-01-01");
        Book book4 = new Book("Karamazov Kardesler",840,"Fyodor Dostoyevski","1880-01-01");
        Book book5 = new Book("Gazap Uzumleri",556,"John Steinbeck","1939-01-01");

        books1.add(book1);
        books1.add(book2);
        books1.add(book3);
        books1.add(book4);
        books1.add(book5);

        System.out.println("Ada gore siralama : ");
        for (Book b: books1 ) {
            System.out.println("Kitap adi : " + b.getName() + " ----Sayfa sayisi : " + b.getPageCount() + " ----Yazar : " + b.getAuthor() + " ----Tarih : " + b.getReleaseDate());
        }

        TreeSet<Book> books2 = new TreeSet<>(new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageCount()-o2.getPageCount();
            }

        });

        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);

        System.out.println("Sayfa sayisina gore siralama : ");
        for (Book b: books2 ) {
            System.out.println("Kitap adi : " + b.getName() + " ----Sayfa sayisi : " + b.getPageCount() + " ----Yazar : " + b.getAuthor() + " ----Tarih : " + b.getReleaseDate());
        }

    }
}
