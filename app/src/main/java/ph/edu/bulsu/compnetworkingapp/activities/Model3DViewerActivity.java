package ph.edu.bulsu.compnetworkingapp.activities;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;
import android.widget.TextView;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;
import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;

public class Model3DViewerActivity extends RendererActivity {

    private Object3dContainer model;
    private float mPreviousX;
    private float mPreviousY;

    private float mScale = 1f;


    private ScaleGestureDetector scaleGestureDetector;
    private FrameLayout flContent;
    private TextView tvParts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
    }

    @Override
    protected void onCreateSetContentView() {
        setContentView(R.layout.frame_3d);
        flContent = (FrameLayout) findViewById(R.id.flContent);
        tvParts = (TextView) findViewById(R.id.tvParts);

        if (getIntent().getExtras().containsKey(BundleIDs.PARTS)) {
            tvParts.setText(getIntent().getStringExtra(BundleIDs.PARTS));
        }
        flContent.addView(glSurfaceView(), 0);
    }

    @Override
    public void initScene() {
        Light myLight = new Light();
        myLight.position.setZ(400);
        myLight.position.setX(400);
        myLight.position.setY(400);
        myLight.direction.setX(45);
        myLight.direction.setY(90);
        myLight.direction.setZ(45);
        scene.lights().add(myLight);
        scene.backgroundColor().setAll(233, 233, 233, 255);

        IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "ph.edu.bulsu.compnetworkingapp:raw/" + getIntent().getStringExtra(BundleIDs.MODEL_FILE_NAME), true);
        myParser.parse();

        model = myParser.getParsedObject();
        model.position().x = model.position().y = model.position().z = 0;
        model.scale().x = model.scale().y = model.scale().z = .5f;

        scene.addChild(model);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null) {

            scaleGestureDetector.onTouchEvent(event);

            if (event.getPointerCount() < 2) {
                float x = event.getX();
                float y = event.getY();

                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (model != null) {
                        float deltaX = (x - mPreviousX) / 8f;
                        float deltaY = (y - mPreviousY) / 8f;

                        model.rotation().x += deltaY;
                        model.rotation().y += deltaX;
                    }
                }

                mPreviousX = x;
                mPreviousY = y;

                return true;
            }
            if (event.getPointerCount() == 2) {
                scene.camera().target = model.position();
            }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void updateScene() {


    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            if (model != null) {
                mScale *= detector.getScaleFactor();
                mScale = Math.max(0.1f, Math.min(mScale, 5.0f));


                model.scale().x = model.scale().y = model.scale().z = mScale;
            }
            return true;
        }
    }
}
