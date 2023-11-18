package edu.khai.listener;

import edu.khai.Camera;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ControlsListener extends MouseAdapter {

    private final Camera camera;
    private int lastMouseX, lastMouseY;
    private boolean mousePressed;

    public ControlsListener(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastMouseX = e.getX();
        lastMouseY = e.getY();
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mousePressed) {
            int deltaX = e.getX() - lastMouseX;
            int deltaY = e.getY() - lastMouseY;

            camera.setRotateX(camera.getRotateX() + deltaY);
            camera.setRotateY(camera.getRotateY() + deltaX);

            lastMouseX = e.getX();
            lastMouseY = e.getY();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }
}
