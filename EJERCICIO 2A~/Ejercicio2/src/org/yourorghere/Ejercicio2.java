package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


public class Ejercicio2 implements GLEventListener {
static GLU glu;
static GL gl;
static JFrame frame;

    public static void main(String[] args) {
         frame = new JFrame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Ejercicio2());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        animator.start();
    }
    
    public void init(GLAutoDrawable drawable) {
    glu = new GLU ();
    gl = drawable.getGL();
    gl.glClearColor(0, 0, 0, 1);
    gl.glMatrixMode(GL.GL_PROJECTION);
    glu.gluOrtho2D(-350,350,-300,300);
    
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
  
    }

@SuppressWarnings("empty-statement")
    public void display(GLAutoDrawable drawable) {
       gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPushMatrix();
        gl.glTranslated(-350, -300, 0);
        gl.glPointSize(1);
        gl.glColor3d(0, 255, 0);
       
         gl.glBegin(GL.GL_POINTS);
         for (int i=0;i<frame.getWidth();i++){
          for(int j=0; j<frame.getHeight()/30; j++){
               gl.glVertex2d(i, j*30); 
         
          }        
       }
        for (int i=0;i<frame.getWidth()/30;i++){
          for(int j=0; j<frame.getHeight(); j++){
               gl.glVertex2d(i*30, j);
          }
          }
        
        gl.glEnd();  
        gl.glPopMatrix();
        gl.glFlush(); 
    }
          
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    }


