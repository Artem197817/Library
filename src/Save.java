import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Save {
    private static final long serialVersionUID = 1L;
    public static void save () throws IOException {
        List<Books> books = Books.getCatalog();
        List<Person> people = Person.getPeople();
        HashMap<Abonement,Person> issue = ActionLibrary.getIssue();
        List<Abonement> issue1=new ArrayList<>();
        List <Person> issue2 =new ArrayList<>();
        for(Map.Entry is:issue.entrySet()){
            issue1.add((Abonement) is.getKey());
            issue2.add((Person) is.getValue());
        }
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
        oos2.writeObject(issue1);
        oos2.flush();
        oos2.close();
        FileOutputStream fos3 = new FileOutputStream("issue1.bin");
        ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
        oos3.writeObject(issue2);
        oos3.flush();
        oos3.close();
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

        ois2.close();
        ActionLibrary.setIssue(issue);
    }

}
