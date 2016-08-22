package ph.edu.bulsu.compnetworkingapp.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class HeightBasedSquareImageView extends ImageView {
    public HeightBasedSquareImageView(Context context) {
        super(context);
    }

    public HeightBasedSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeightBasedSquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HeightBasedSquareImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height = MeasureSpec.getSize(heightMeasureSpec);

        super.onMeasure(MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
    }
}
