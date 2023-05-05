import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Save {
    private static final long serialVersionUID = 1L;
    public static void save () throws IOException {
        List<Books> books = Books.getCatalog();
        List<Person> people = Person.getPeople();
        HashMap<Abonement,Person> issue = ActionLibrary.getIssue();
        FileOutputStream fos = new FileOutputStream("people.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(people);
        oos.flush();
        oos.close();
        FileOutputStream fos1 = new FileOutputStream("book.bin");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos1.writeObject(books);
        oos1.flush();
        oos1.close();
        FileOutputStream fos2 = new FileOutputStream("issue.bin");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(issue);
        oos2.flush();
        oos2.close();
    }
    public static void read () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("book.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<?> catal = (ArrayList<?>) ois.readObject();
        ois.close();
        Books.setCatal((List<Books>) catal);
        FileInputStream fis1= new FileInputStream("people.bin");
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        ArrayList<?> people = (ArrayList<?>) ois1.readObject();
        ois1.close();
        Person.setPeople((ArrayList<Person>) people);
        FileInputStream fis2= new FileInputStream("issue.bin");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        HashMap<?,?> issue = (HashMap<?, ?>) ois2.readObject();
        ois2.close();
        ActionLibrary.setIssue((HashMap<Abonement, Person>) issue);
    }

}