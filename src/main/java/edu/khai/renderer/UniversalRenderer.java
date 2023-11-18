package edu.khai.renderer;

import com.jogamp.opengl.GL2;
import edu.khai.Camera;
import edu.khai.PointGenerator;
import edu.khai.math.Point;

public class UniversalRenderer {

    Camera camera;
    Mode renderMode;

    Point[] points;

    SphereDotsRenderer sphereDotsRenderer;

    public UniversalRenderer() {
        this.camera = Camera.getInstance();
        this.points = new PointGenerator().generatePoints();


        this.sphereDotsRenderer = new SphereDotsRenderer(points);
    }

    public void render(GL2 gl){
        switch (renderMode) {
            case POINTS:
                sphereDotsRenderer.drawSpherePoints(gl, camera.getRotateX(), camera.getRotateY());
                break;
            case EDGES:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + renderMode);
        }
    }

    public void setRenderMode(Mode renderMode) {
        this.renderMode = renderMode;
    }

    public enum Mode{
        POINTS,
        EDGES
    }
}
