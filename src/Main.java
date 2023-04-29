
public class Main {
    public static void main(String[] args) {
       Journal j1 = new Journal("Times",130,2021,10);
       Person p1 = new Person("Pol",25);
       ActionLibrary.issue(j1,p1);
       ActionLibrary.listIssuedBook();
    }
}