import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       Person p3 = new Person("Сергей",17);
       Person p1 = new Person("Полина",25);
       Person p2 = new Person("Борис",38);
       Person p5 = new Person("Алексей",55);
       Save.inputBook();
       Books.printBooks();
       Person p4 = new Person("Виола",25);
       Save.save();

    }
}