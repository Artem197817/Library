import java.util.List;

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
}
