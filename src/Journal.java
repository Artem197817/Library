import java.util.Calendar;

public class Journal implements Abonement{
    private  String name;
    private int numberOfPage;
    private int yearOfPublication;
    private int number;

    @Override
    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    private String dateReturn;

    public String getDateReturn() {
        return dateReturn;
    }

    public String getName() {
        return name;
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
    public boolean isIssuedOfHand(int w) {
        if (w==1) return  true;
        else
            return false;
    }

    @Override
    public Calendar dateOfIssued(Calendar calendar) {
        return calendar;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "name='" + name + '\'' +
                ", numberOfPage=" + numberOfPage +
                ", yearOfPublication=" + yearOfPublication +
                ", number=" + number +
                ", dateReturn='" + dateReturn + '\'' +
                '}';
    }
}
