
    public class Book extends Books implements Abonement {
        private  String name;
        private int numberOfPage;
        private int yearOfPublication;
        private String dateReturn;

        public boolean isIssued() {
            return isIssued;
        }

        public void setIssued(boolean issued) {
            isIssued = issued;
        }

        private boolean isIssued = false;

        public String getAuthor() {
            return author;
        }

        private String author;

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
        public Book(String name,String author, int numberOfPage, int yearOfPublication) {
            this.name = name;
            this.numberOfPage = numberOfPage;
            this.yearOfPublication = yearOfPublication;
            this.author = author;
        }
        @Override
        public String toString() {
            if (isIssued)
            return "Книга {" +
                    "Название " + name + '\'' +
                    ", Автор " + author +
                    ", Количество страниц " + numberOfPage +
                    ", Год издания " + yearOfPublication +
                    ", Книга на руках: Дата возврата '" + dateReturn + '\'' +
                    '}';
            else
                return "Книга {" +
                        "Название " + name + '\'' +
                        ", Автор " + author +
                        ", Количество страниц " + numberOfPage +
                        ", Год издания " + yearOfPublication +
                        ", Книга в библиотеке" + '}';
        }
    }
