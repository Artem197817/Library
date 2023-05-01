
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
                    "Название '" + name + '\'' +
                    ", Количество страниц " + numberOfPage +
                    ", Год " + yearOfPublication +
                    ", Номер " + number +
                    ", Журнал в библиотеке" + '}';
    }
}
