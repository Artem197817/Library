import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
       Journal j1 = new Journal("Times",130,2021,10);
       Person p1 = new Person("Pol",25);
       ActionLibrary.issue(j1,p1);
       Book b1 = new Book("She" ,"Raspberry",350,1990,Genre.FANTASTIC);
       ActionLibrary.issue(b1,p1);
       Books b2 = new Book("Шаман","Владимир Маханенко",420, 2017,Genre.FANTASTIC);
       Books.setCatalog(j1);
       Books.setCatalog(b1);
       Books.setCatalog(b2);
       Journal j2 = new Journal("За рулем",150,2020,3);
       Journal j3 = new Journal("Эксперт",120,2015,5);
       Books.setCatalog(j2);
       Books.setCatalog(j3);
       Person p2 = new Person("Bob",38);
       ActionLibrary.issue(j2,p2);
       //ActionLibrary.returnBook(b1);
       ActionLibrary.issue(b2,p1);
       Books.printBooks();
       b2.setDateReturn("27-04-2023");
       ActionLibrary.overdueRefundList();
       Book.catalog();
       Books.printBooks();
       ActionLibrary.bookIssue();
       ActionLibrary.personIssued();
         Person p4 = new Person("Polina",25);
       Save.save();
    }
}