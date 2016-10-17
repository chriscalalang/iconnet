package ph.edu.bulsu.compnetworkingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Tutorial extends Topic implements Parcelable {


    private String text;
    private List<String> images;
    private String html;

    public Tutorial(String title){
        super(title);
    }

    protected Tutorial(Parcel in) {
        super(in);
        text = in.readString();
        images = in.createStringArrayList();
        html = in.readString();
    }

    public Tutorial(String title, String text) {
        super(title);
        this.text = text;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(text);
        dest.writeStringList(images);
        dest.writeString(html);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tutorial> CREATOR = new Creator<Tutorial>() {
        @Override
        public Tutorial createFromParcel(Parcel in) {
            return new Tutorial(in);
        }

        @Override
        public Tutorial[] newArray(int size) {
            return new Tutorial[size];
        }
    };

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

    public String getBaseFolderPath() {
        return "file:///android_asset/topics/" + title + "/";
    }
}
