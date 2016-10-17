package ph.edu.bulsu.compnetworkingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Sheychan on 6/17/2016.
 */
public class Topic implements Parcelable {

    protected String title;
    protected List<String> tags;


    public Topic(String title) {
        this.title = title;
    }

    public Topic(){

    }

    protected Topic(Parcel in) {
        title = in.readString();
        tags = in.createStringArrayList();
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeStringList(tags);
    }

}
