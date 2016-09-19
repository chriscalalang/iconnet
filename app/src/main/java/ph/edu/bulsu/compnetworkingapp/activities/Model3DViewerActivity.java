package ph.edu.bulsu.compnetworkingapp.activities;


import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;

public class Model3DViewerActivity extends RendererActivity {

    private Object3dContainer faceObject3D;

    @Override
    public void initScene() {
        scene.lights().add(new Light());
        scene.lights().add(new Light());

        Light myLight = new Light();
        myLight.position.setZ(150);
        scene.lights().add(myLight);

        IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "ph.edu.bulsu.compnetworkingapp:raw/router_obj", true);
        myParser.parse();

        faceObject3D = myParser.getParsedObject();
        faceObject3D.position().x = faceObject3D.position().y = faceObject3D.position().z = 0;
// Depending on the model you will need to change the scale
        faceObject3D.scale().x = faceObject3D.scale().y = faceObject3D.scale().z = 1f;

        scene.addChild(faceObject3D);
    }

    @Override
    public void updateScene() {
        faceObject3D.rotation().x += 0.5;
        faceObject3D.rotation().z += 1;
    }
}
