package ph.edu.bulsu.compnetworkingapp.activities;


import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;
import ph.edu.bulsu.compnetworkingapp.constants.BundleIDs;

public class Model3DViewerActivity extends RendererActivity {

    private Object3dContainer model;
    private float mPreviousX;
    private float mPreviousY;

    private float mScale = 1f;


    private ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
    }

    @Override
    public void initScene() {
        scene.lights().add(new Light());
//        scene.lights().add(new Light());
//        Light myLight = new Light();
//        myLight.position.setZ(150);
//        scene.lights().add(myLight);
        scene.backgroundColor().setAll(233, 233, 233, 255);

        IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "ph.edu.bulsu.compnetworkingapp:raw/" + getIntent().getStringExtra(BundleIDs.MODEL_FILE_NAME), true);
        myParser.parse();

        model = myParser.getParsedObject();
        model.position().x = model.position().y = model.position().z = 0;

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
            mScale *= detector.getScaleFactor();
            mScale = Math.max(0.1f, Math.min(mScale, 5.0f));


            model.scale().x = model.scale().y = model.scale().z = mScale;
            return true;
        }
    }
}
