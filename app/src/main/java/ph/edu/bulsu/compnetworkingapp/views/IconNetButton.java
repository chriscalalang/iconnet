package ph.edu.bulsu.compnetworkingapp.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import ph.edu.bulsu.compnetworkingapp.R;


public class IconNetButton extends Button {
    private AttributeSet attrs;

    public static final int BUTTON_THEME_PRIMARY = 1;
    public static final int BUTTON_THEME_PRIMARY_DARK = 2;
    public static final int BUTTON_THEME_RED = 3;
    public static final int BUTTON_THEME_GREEN = 4;
    public static final int BUTTON_THEME_FACEBOOK = 5;
    public static final int BUTTON_THEME_TRANSPARENT = 28;

    public IconNetButton(Context context) {
        super(context);
        init(null);

        this.attrs = null;
    }

    public IconNetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

        this.attrs = attrs;
    }

    public IconNetButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

        this.attrs = attrs;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconNetButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);

        this.attrs = attrs;
    }


    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.IconNetButtonTheme);

            int buttonTheme = a.getInt(R.styleable.IconNetButtonTheme_buttonTheme, BUTTON_THEME_PRIMARY);
            setButtonTheme(buttonTheme);
            a.recycle();
        }
        setTextColor(Color.WHITE);
    }

    public void setButtonTheme(int buttonTheme) {
        Drawable drawable = getResources().getDrawable(R.drawable.bg_iconnet_button);
        drawable.setLevel(buttonTheme);
        setBackgroundDrawable(drawable);
    }
}
