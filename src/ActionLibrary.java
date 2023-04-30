import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ActionLibrary {
    public static HashMap<Abonement, Person> issue = new HashMap<>();
    public boolean issIssued (Books b){
        return b.isIssued();
    }

    public static void issue(Abonement l, Person p) {
        if (l.isIssued())
            System.out.println("Книга на руках: Дата возврата "+l.getDateReturn());
        else {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
            calendar.add(GregorianCalendar.DAY_OF_WEEK, 14);
            l.setDateReturn(data.format(calendar.getTime()));
            issue.put(l, p);
            l.setIssued(true);
            System.out.println("Книга выдана");
        }
        System.out.println();
    }

    public static void listIssuedBook() {
        System.out.println("Список выданных книг");
        for (Abonement key : issue.keySet()) {
            System.out.println(key + ": " + issue.get(key));
        }
        System.out.println();
    }

    public static void returnBook(Books b) {
        issue.remove(b);
        b.setIssued(false);
        b.setDateReturn("Книга в библиотеке");
    }

    public static void personIssued(Person p) {
        System.out.println(p);
        for (Map.Entry entry : issue.entrySet()) {
            if (p.equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
    }
}
