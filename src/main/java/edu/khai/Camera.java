package edu.khai;

public class Camera {


    private Camera() {
        this.rotateX = 0;
        this.rotateY = 0;
    }
    private static Camera instance;

    private float rotateX, rotateY;

    public static Camera getInstance() {
        if (instance == null){
            instance = new Camera();
        }
        return instance;
    }

    public float getRotateX() {
        return rotateX;
    }

    public void setRotateX(float rotateX) {
        this.rotateX = rotateX;
    }

    public float getRotateY() {
        return rotateY;
    }

    public void setRotateY(float rotateY) {
        this.rotateY = rotateY;
    }
}
