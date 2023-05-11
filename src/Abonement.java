
public interface Abonement {
    public void setIssued(boolean issued);
    public void setDateReturn(String dateReturn);
    public boolean isIssued();
    public String getDateReturn();
    public String getName();
    public String getAuthor();
    public int getNumberOfPage();
    public int getYearOfPublication();
    public Genre getGenre();
    public int getNumber();
}
