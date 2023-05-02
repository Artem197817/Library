import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ActionLibrary {
    public static HashMap<Abonement, Person> getIssue() {
        return issue;
    }

    public static void setIssue(HashMap<Abonement, Person> issue) {
        ActionLibrary.issue = issue;
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
    public static Person personName(String name){
        List<Person> p = Person.getPeople().stream()
                .filter(person -> person.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        if (p.isEmpty()) {
            System.out.println("Читатель незарегистрирован");
            return Person.personNew();
        }
        if (p.size() == 1) {
            return p.get(0);
        } else {
            for (int i = 0; i < p.size(); i++)
                System.out.println((i + 1) + "  " + p.get(i));
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите id читателя");
            int n = sc.nextInt();
            sc.close();
            if (n <= p.size())
                return p.get(n - 1);
            else {
                System.out.println("Читатель не идентифицирован");
               return new Person();
            }
        }
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
        refundList.forEach(System.out::println);
        System.out.println();
        refundList.clear();
    }

    public static void nameIssue(String nameBook, Person person) {
        List<Books> b = Books.getCatalog().stream()
                .filter(w -> w.getName().toLowerCase().contains(nameBook.toLowerCase()))
                .toList();
        if (b.size() == 1) {
            ActionLibrary.issue(b.get(0), person);
            ActionLibrary.personIssued(person);
        } else {
            for (int i = 0; i < b.size(); i++)
                System.out.println((i + 1) + "  " + b.get(i));
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите номер выдаваемой книги из списка");
            int n = sc.nextInt();
            sc.close();
            if (n<=b.size())
            ActionLibrary.issue(b.get(n-1), person);
            else System.out.println("Книга не выдана");
            ActionLibrary.personIssued(person);
        }
    }
    public static void nameIssueName (String nameBook,String name) {
        Person person = ActionLibrary.personName(name);
        List<Books> b = Books.getCatalog().stream()
                .filter(w -> w.getName().toLowerCase().contains(nameBook.toLowerCase()))
                .toList();
        if (b.size() == 1) {
            ActionLibrary.issue(b.get(0), person);
            ActionLibrary.personIssued(person);
        } else {
            for (int i = 0; i < b.size(); i++)
                System.out.println((i + 1) + "  " + b.get(i));
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите номер выдаваемой книги из списка");
            int n = sc.nextInt();
            sc.close();
            if (n<=b.size())
                ActionLibrary.issue(b.get(n-1), person);
            else System.out.println("Книга не выдана");
            ActionLibrary.personIssued(person);
        }
    }
}
