public class HistoryBook extends Book {

    String timePeriod;

    public HistoryBook (String title, String author, String timePeriod)
    {
        super(title, author);
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Time period: " + timePeriod;
    }
}
