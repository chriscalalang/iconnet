package ph.edu.bulsu.compnetworkingapp.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.TextView;

import ph.edu.bulsu.compnetworkingapp.R;

public abstract class HidingToolbarActivity extends AppCompatActivity {

    protected Toolbar tbHiding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hiding_toolbar);

        tbHiding = (Toolbar) findViewById(R.id.tbHiding);
        setSupportActionBar(tbHiding);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ViewStub vs_container = (ViewStub) findViewById(R.id.vs_container);
        vs_container.setLayoutResource(getContentViewId());
        vs_container.inflate();

        setStatusbarColor(getResources().getColor(R.color.colorPrimaryDark));

    }

    protected void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


    protected void setToolbarColor(int color) {
        tbHiding.setBackgroundColor(color);
    }

    protected void setStatusbarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected abstract int getContentViewId();


}
