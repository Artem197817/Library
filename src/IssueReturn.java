import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class IssueReturn{
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
       Save.read();
        Books.printBooks();
      // ActionLibrary.bookIssue();
         ActionLibrary.listIssuedBook();
      // ActionLibrary.bookReturn();
       ActionLibrary.personIssued();
       //ActionLibrary.listIssuedBook();
        // Save.save();
        Person p = Person.getPeople().get(0);
        System.out.println(p);
        Abonement b = Books.getCatalog().get(2);
        System.out.println(b);
        HashMap<Books,Person> isu = ActionLibrary.getIssue();
        isu.remove(b);
        for (Map.Entry is: isu.entrySet())
            System.out.println(is.getKey()+" "+is.getValue());


    }
}
