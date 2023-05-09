import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Book extends Books implements Abonement {
        private final String name;
        private final int numberOfPage;
        private final int yearOfPublication;
        private String dateReturn = "Книга в библиотеке";
        private boolean isIssued = false;
        private final String author;
        private final Genre genre;
    public static void main(String[] args) {

    }

        @Override
        public boolean isIssued() {
            return isIssued;
        }

        public void setIssued(boolean issued) {
            isIssued = issued;
        }
        public String getAuthor() {
            return author;
        }
        public String getDateReturn() {
            return dateReturn;
        }

        public void setDateReturn(String dateReturn) {
            this.dateReturn = dateReturn;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPage == book.numberOfPage && yearOfPublication == book.yearOfPublication
                && isIssued == book.isIssued && Objects.equals(name, book.name)
                && Objects.equals(dateReturn, book.dateReturn) && Objects.equals(author, book.author)
                && genre == book.genre;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPage, yearOfPublication, dateReturn, isIssued, author, genre);
    }

    public String getName() {
            return name;
        }
        public int getNumberOfPage() {
            return numberOfPage;
        }
        public int getYearOfPublication() {
            return yearOfPublication;
        }
        public Book(String name,String author, int numberOfPage, int yearOfPublication,Genre genre) {
            this.name = name;
            this.numberOfPage = numberOfPage;
            this.yearOfPublication = yearOfPublication;
            this.author = author;
            this.genre = genre;
        }
        @Override
        public String toString() {
            if (isIssued)
            return "Книга {" +
                    "Название " + name + '\'' +
                    ", Автор " + author +
                    ", Количество страниц " + numberOfPage +
                    ", Год издания " + yearOfPublication +
                    ", Жанр " + genre +
                    ", Книга на руках: Дата возврата '" + dateReturn + '\'' +
                    '}';
            else
                return "Книга {" +
                        "Название " + name + '\'' +
                        ", Автор " + author +
                        ", Количество страниц " + numberOfPage +
                        ", Год издания " + yearOfPublication +
                        ", Жанр " + genre +
                        ", Книга в библиотеке" + '}';
        }

    public static void catalog (){
        Books.setCatalog(new Book("Хождение за три моря","Афанасий Никитин", 456, 1900, Genre.HISTORICAL));
        Books.setCatalog(new Book("Лабиринт отражений", "Сергей Лукьяненко", 357, 1990, Genre.FANTASTIC));
        Books.setCatalog(new Book("Жизнь замечательных людей", "Жорж Великолепный", 479, 1986, Genre.HISTORICAL));
        Books.setCatalog(new Book("Ночной дозор", "Сергей Лукьяненко", 415, 2002, Genre.FANTASTIC));
        Books.setCatalog(new Book("Властелин колец", "Джон Рональд Руэл Толкиен", 1235, 2006, Genre.FANTASY));
        Books.setCatalog(new Book("Ищите ведьму", "Ольга Паншина", 327, 2022, Genre.LOVE));
        Books.setCatalog(new Book("На дне", "Максим Горький", 275, 1970, Genre.PROSE));
        Books.setCatalog(new Book("Война и мир", "Лев Толстой", 1500, 1961, Genre.PROSE));
        Books.setCatalog(new Book("Джон Леннон", "Макс Любимов", 357, 2015, Genre.BIOGRAPHY));
        Books.setCatalog(new Book("Оптика", "Евгений Физиков", 523, 1991, Genre.SCIENTIFIC));
        Books.setCatalog(new Book("Ведьма и лорд", "Ольга Паншина", 357, 2021, Genre.LOVE));
        Books.setCatalog(new Book("Теоретическая механика", "Сергей Лучезарный", 359, 1996, Genre.SCIENTIFIC));
        Books.setCatalog(new Book("Черчиль", "Сергей Драгунский", 369, 1976, Genre.BIOGRAPHY));
    }
    public static Books nameBook() {
        String nameBook = Decor.inputPane("Имя книги?");
            if (nameBook == null) return null;
        List<Books> b = Books.getCatalog().stream()
                .filter(w -> w.getName().toLowerCase().contains(nameBook.toLowerCase()))
                .toList();
        if (b.isEmpty()) return null;
        if (b.size() == 1)
            return b.get(0);
        for (int i = 0; i < b.size(); i++)
                System.out.println("id = " + (i + 1) + "  " + b.get(i));
        System.out.println("Уточните книгу указав id");
         int n = ActionLibrary.checkId(b.size());
               return b.get(n-1);
    }
    public static int inputYearOfPublication () {
        Calendar calendar = Calendar.getInstance();
        int yearCurrent = Integer.parseInt(String.valueOf(calendar.get(Calendar.YEAR)));
        String year;
        while (true) {
            year = Decor.inputPane(" Введите год публикации");
            if (!year.isEmpty() & year.matches("[0-9]*"))
                if (Integer.parseInt(year) <= yearCurrent & Integer.parseInt(year) > 1000)
                    break;
        }
        return Integer.parseInt(year);
    }
    public static String inputName(){
        return Decor.inputPane("Введите наименование книги");
    }
    public static String inputAuthor(){
        return  Decor.inputPane("Введите автора");
    }
    public static int inputNumberPage () {
        String numberPage;
        while (true){
            numberPage = Decor.inputPane("Введите количество страниц");
            if (!numberPage.isEmpty() & numberPage.matches("[0-9]*"))
                    break;
        }
        return Integer.parseInt(numberPage);
    }
}
