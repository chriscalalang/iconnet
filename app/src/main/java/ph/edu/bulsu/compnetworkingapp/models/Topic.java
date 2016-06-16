package ph.edu.bulsu.compnetworkingapp.models;

import java.util.List;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class Topic {

    private String title;
    private String text;
    private List<String> images;
    private String html;


    public Topic(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
