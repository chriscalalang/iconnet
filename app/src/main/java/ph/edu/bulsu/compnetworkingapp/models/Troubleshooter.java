package ph.edu.bulsu.compnetworkingapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Troubleshooter extends Topic implements Parcelable {

    private List<String> solutions;

    public Troubleshooter(String title) {
        super(title);
    }

    protected Troubleshooter(Parcel in) {
        super(in);
        solutions = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeStringList(solutions);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Troubleshooter> CREATOR = new Creator<Troubleshooter>() {
        @Override
        public Troubleshooter createFromParcel(Parcel in) {
            return new Troubleshooter(in);
        }

        @Override
        public Troubleshooter[] newArray(int size) {
            return new Troubleshooter[size];
        }
    };

    public List<String> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<String> solutions) {
        this.solutions = solutions;
    }
}
