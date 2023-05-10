
import java.util.Objects;

public class Journal extends Books implements Abonement{
    private  String name;
    private int numberOfPage;
    private int yearOfPublication;
    private int number;
    private boolean isIssued = false;
    private String dateReturn = "Книга в библиотеке";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return "Редколлегия";
    }

    public boolean isIssued() {
        return isIssued;
    }
    public void setIssued(boolean issued) {
        isIssued = issued;
    }
    @Override
    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }
    public String getDateReturn() {
        return dateReturn;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Journal(String name, int numberOfPage, int yearOfPublication, int number) {
        this.name = name;
        this.numberOfPage = numberOfPage;
        this.yearOfPublication = yearOfPublication;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return numberOfPage == journal.numberOfPage && yearOfPublication == journal.yearOfPublication
                && number == journal.number && isIssued == journal.isIssued
                && Objects.equals(name, journal.name) && Objects.equals(dateReturn, journal.dateReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPage, yearOfPublication, number, isIssued, dateReturn);
    }

    @Override
    public String toString() {
        if (isIssued)
        return "Журнал{" +
                "Название '" + name + '\'' +
                ", Количество страниц " + numberOfPage +
                ", Год " + yearOfPublication +
                ", Номер " + number +
                ", Журнал на руках: Дата возврата " + dateReturn + '\'' +
                '}';
        else
            return "Журнал{" +
                    "Название " + name + '\'' +
                    ", Количество страниц " + numberOfPage +
                    ", Год " + yearOfPublication +
                    ", Номер " + number +
                    ", Журнал в библиотеке" + '}';
    }
    public static int inputNumberJournal () {
        String number;
        while (true) {
            number = Decor.inputPane(" Введите номер");
            if (number != null)
                if (number.matches("[0-9]*"))
                    if (Integer.parseInt(number) <= 52 & Integer.parseInt(number) > 0)
                        break;
        }
        return Integer.parseInt(number);
    }
    public static void newJournal () {
        Journal j = new Journal(Book.inputName(), Book.inputNumberPage(), Book.inputYearOfPublication(),
                Journal.inputNumberJournal());
        if (j.getName().equals("Xrenas2")) {
            Decor.messagePane("Некорректные данные");
            return;
        }
        Book.setCatalog(j);
    }
}
