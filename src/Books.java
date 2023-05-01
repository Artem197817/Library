import java.util.ArrayList;
import java.util.List;

public abstract class Books implements Abonement{

    @Override
    public void setDateReturn(String dateReturn) {
    }
    @Override
    public void setIssued (boolean issued) {
    }

    public static void setCatalog(Books b) {
        catalog.add(b);
    }
    private static final List<Books> catalog = new ArrayList<>();
    public static List<Books> getCatalog(){
        return catalog;
    }
    public static void printBooks (){
        System.out.println("Каталог");
        catalog.forEach(System.out::println);
        System.out.println();
    }

}
