import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ActionLibrary {
    public static HashMap<Abonement, Person> issue = new HashMap<>();

    public static void issue(Abonement l, Person p) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
        calendar.add(GregorianCalendar.DAY_OF_WEEK,14);
        l.setDateReturn(data.format(calendar.getTime()));
        issue.put(l, p);
        l.setIssued (true);
    }
    public static void listIssuedBook(){
        for (Abonement key: issue.keySet()) {
            System.out.println(key + ": " + issue.get(key));
        }
            System.out.println();
    }
}
