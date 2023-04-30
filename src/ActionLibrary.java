import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ActionLibrary {
    public static HashMap<Abonement, Person> issue = new HashMap<>();
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
            System.out.println("Книга выдана "+p);
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
        issue.entrySet().stream()
                .filter(entry -> p.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .forEachOrdered(System.out::println);
        System.out.println();
    }
    public static void overdueRefundList() throws ParseException {
        System.out.println("Список книг с просроченным возвратом");
        List<String> refundList = new ArrayList<>();
        Calendar dateNow = Calendar.getInstance();
        SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
        for (Map.Entry entry : issue.entrySet()) {
            Books b = (Books) entry.getKey();
            Date date = data.parse(b.getDateReturn());
            if (dateNow.getTime().after(date))
                refundList.add(entry.getKey().toString() + entry.getValue().toString());
        }
            refundList.stream()
                    .forEach(System.out::println);
            System.out.println();
            refundList.clear();
    }
}
