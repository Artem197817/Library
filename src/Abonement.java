import java.util.Calendar;

public interface Abonement {
    public boolean isIssuedOfHand(int w);

    public Calendar dateOfIssued(Calendar calendar);
    public void setDateReturn(String dateReturn);
}
