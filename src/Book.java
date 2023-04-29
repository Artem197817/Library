import java.util.Calendar;



    public class Book implements Abonement {
        private  String name;
        private int numberOfPage;
        private int yearOfPublication;
        private String dateReturn;

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

        public void setNumberOfPage(int numberOfPage) {
            this.numberOfPage = numberOfPage;
        }

        public int getYearOfPublication() {
            return yearOfPublication;
        }

        public void setYearOfPublication(int yearOfPublication) {
            this.yearOfPublication = yearOfPublication;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Book(String name, int numberOfPage, int yearOfPublication) {
            this.name = name;
            this.numberOfPage = numberOfPage;
            this.yearOfPublication = yearOfPublication;
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
            return "Book{" +
                    "name='" + name + '\'' +
                    ", numberOfPage=" + numberOfPage +
                    ", yearOfPublication=" + yearOfPublication +
                    ", dateReturn='" + dateReturn + '\'' +
                    '}';
        }
    }
