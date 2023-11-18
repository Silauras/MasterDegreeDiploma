package edu.khai;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import edu.khai.listener.ControlsListener;
import edu.khai.listener.GLRenderer;
import edu.khai.renderer.UniversalRenderer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static edu.khai.Config.*;

public class Application extends Frame {

    private final Camera camera;
    private final UniversalRenderer universalRenderer;
    private GLCanvas glCanvas;
    private Timer timer;


    public Application() {
        super(TITLE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setLocation(100, 100);
        this.camera = Camera.getInstance();
        this.universalRenderer = new UniversalRenderer();
        universalRenderer.setRenderMode(UniversalRenderer.Mode.POINTS);
        initJOGL();
        setVisible(true);
    }


    private void initJOGL() {
        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);

        glCanvas = new GLCanvas(glCapabilities);
        addControlListeners();
        glCanvas.addGLEventListener(new GLRenderer(this.universalRenderer));
        timer = new Timer(1000 / 60, e -> glCanvas.display());
        timer.start();

        add(glCanvas);
    }

    private void addControlListeners() {
        ControlsListener controlsListener = new ControlsListener(this.camera);
        glCanvas.addMouseListener(controlsListener);
        glCanvas.addMouseMotionListener(controlsListener);
    }

    public static void main(String[] args) {
        new Application();
    }
}