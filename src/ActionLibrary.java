
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ActionLibrary {
    public static HashMap<Abonement, Person> getIssue() {
        return issue;
    }

    public static void setIssue(HashMap<Abonement, Person> issue) {
        ActionLibrary.issue.putAll (issue);
    }

    public static HashMap<Abonement, Person> issue = new HashMap<>();

    public static void issue(Abonement l, Person p) {
        if (l.isIssued())
            System.out.println("Книга на руках: Дата возврата " + l.getDateReturn());
        else {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
            calendar.add(GregorianCalendar.DAY_OF_WEEK, 14);
            l.setDateReturn(data.format(calendar.getTime()));
            issue.put(l, p);
            l.setIssued(true);
            System.out.println("Книга выдана " + p);
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


    public static void personIssued() {
        Person p = Person.personName();
        if (p == null)
            return;
        System.out.println(p);
        HashMap<Abonement ,Person> pi = new HashMap<>();
        issue.entrySet().stream()
                        .filter(entry -> p.equals(entry.getValue()))
                                .forEach(System.out::println);
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
        refundList.forEach(System.out::println);
        System.out.println();
        refundList.clear();
    }

    public static void bookIssue() {
        Person person = Person.personName();
        if (person == null)
            person = Person.personNull();
        if (person == null)
            return;
        Books b = Book.nameBook();
            if (b == null) return;
            ActionLibrary.issue(b, person);
        }

    public static int checkId(int sizeList) {
        String id;
        while (true) {
            id = Decor.inputPane(" Введите id");
            if (!id.isEmpty() & id.matches("[0-9]*")) {
                if (Integer.parseInt(id) <= sizeList)
                    break;
            }
        }
            return Integer.parseInt(id);
    }
    public static void bookReturn() {
        Books b = Book.nameBook();
        if (b == null) return;
        if (!b.isIssued()) return;
        ActionLibrary.returnBook(b);
    }
}
