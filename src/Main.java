
public class Main {
    public static void main(String[] args) {
       Journal j1 = new Journal("Times",130,2021,10);
       Person p1 = new Person("Pol",25);
       ActionLibrary.issue(j1,p1);
       ActionLibrary.listIssuedBook();
       Book b1 = new Book("She" ,"Raspberry",350,1990);
       ActionLibrary.issue(b1,p1);
       ActionLibrary.listIssuedBook();
       Books b2 = new Book("Шаман","Владимир Маханенко",420, 2017);
       Books.setCatalog(j1);
       Books.setCatalog(b1);
       Books.setCatalog(b2);
       Books.printBooks();
       Journal j2 = new Journal("За рулем",150,2020,3);
       Books.setCatalog(j2);
       Person p2 = new Person("Bob",38);
       ActionLibrary.issue(j2,p2);
       Books.printBooks();
    }
}