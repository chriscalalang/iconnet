package ph.edu.bulsu.compnetworkingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class Topic implements Parcelable {

    private String title;
    private String text;
    private List<String> images;
    private String html;


    public Topic(String title, String text) {
        this.title = title;
        this.text = text;
    }

    protected Topic(Parcel in) {
        title = in.readString();
        text = in.readString();
        images = in.createStringArrayList();
        html = in.readString();
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        @Override
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }

        @Override
        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
        dest.writeStringList(images);
        dest.writeString(html);
    }
}
