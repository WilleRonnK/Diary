package Main.java;

import java.time.LocalDate;

public class UserEntry {

private String date;
private String text;
private String title;

    public UserEntry() {
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "date=" + date +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserEntry(String date, String text, String title) {
        this.date = date;
        this.text = text;
        this.title = title;
    }
}


