package movie;

import java.time.Year;

public class Movie {
    private String title;
    private String description;
    private String url;

    public Movie(String title, String des, String url) {
        this.title = title;
        this.description = des;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return title + ". " + description + " " + url;
    }
}
