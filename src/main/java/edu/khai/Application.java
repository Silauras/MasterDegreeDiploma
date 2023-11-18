package edu.khai;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import edu.khai.renderer.UniversalRenderer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static edu.khai.Config.*;

public class Application extends Frame {


    private final Camera camera;
    private final UniversalRenderer universalRenderer;

    
    private int lastMouseX, lastMouseY;
    private boolean mousePressed;

    private GLCanvas glCanvas;
    private GLU glu;

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
        camera = Camera.getInstance();
        this.universalRenderer = new UniversalRenderer();
        universalRenderer.setRenderMode(UniversalRenderer.Mode.POINTS);
        this.mousePressed = false;

        initJOGL();

        setVisible(true);
    }

    private void initJOGL() {

        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);

        glCanvas = new GLCanvas(glCapabilities);

        addControlsListeners();

        glCanvas.addGLEventListener(new GLEventListener() {
            @Override
            public void init(GLAutoDrawable glAutoDrawable) {
                GL2 gl = glAutoDrawable.getGL().getGL2();

                // Ваш код инициализации OpenGL здесь
                gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                gl.glEnable(GL2.GL_DEPTH_TEST);
                glu = new GLU();
            }

            @Override
            public void dispose(GLAutoDrawable glAutoDrawable) {

            }

            @Override
            public void display(GLAutoDrawable glAutoDrawable) {
                GL2 gl = glAutoDrawable.getGL().getGL2();

                gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
                gl.glLoadIdentity();

                universalRenderer.render(gl);
            }

            @Override
            public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
                GL2 gl = drawable.getGL().getGL2();

                if (height == 0) height = 1;

                float aspect = (float) width / height;

                gl.glMatrixMode(GL2.GL_PROJECTION);
                gl.glLoadIdentity();
                glu.gluPerspective(45.0, aspect, 0.1, 100.0); // Задаем угол обзора, соотношение сторон и диапазон видимости
                gl.glMatrixMode(GL2.GL_MODELVIEW);
                gl.glLoadIdentity();
            }
        });

        timer = new Timer(1000 / 60, e -> glCanvas.display());
        timer.start();

        add(glCanvas);
    }

    private void addControlsListeners() {
        glCanvas.addMouseListener(new MouseAdapter() {
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

        });
        glCanvas.addMouseMotionListener(new MouseMotionAdapter() {


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
        });
    }

    public static void main(String[] args) {
        new Application();
    }
}