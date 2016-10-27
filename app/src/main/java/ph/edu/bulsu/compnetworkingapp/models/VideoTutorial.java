package ph.edu.bulsu.compnetworkingapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

public class VideoTutorial implements Parcelable {

    private String fileName;
    private String title;
    private String description;
    @DrawableRes
    private int drawable;


    public VideoTutorial(String fileName, String title, String description, int drawable) {
        this.fileName = fileName;
        this.title = title;
        this.description = description;
        this.drawable = drawable;
    }


    protected VideoTutorial(Parcel in) {
        fileName = in.readString();
        title = in.readString();
        description = in.readString();
        drawable = in.readInt();
    }

    public static final Creator<VideoTutorial> CREATOR = new Creator<VideoTutorial>() {
        @Override
        public VideoTutorial createFromParcel(Parcel in) {
            return new VideoTutorial(in);
        }

        @Override
        public VideoTutorial[] newArray(int size) {
            return new VideoTutorial[size];
        }
    };

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fileName);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(drawable);
    }
}
