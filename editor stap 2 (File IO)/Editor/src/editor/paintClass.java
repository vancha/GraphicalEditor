/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author vancha
 */
public class paintClass extends JPanel implements MouseListener, MouseMotionListener
{
    ShapeFactory factory = new ShapeFactory();
    ArrayList<Shape> list;
    public State state;
    private Point startPoint = new Point(0,0);
    public enum State 
    {
        RECTANGLE, ELLIPSE, SELECT, MOVE,RESIZE 
    }
    
    public paintClass()
    {
        super();
        state = State.RECTANGLE;
        list = new ArrayList<Shape>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    protected void paintComponent(Graphics g) 
    {
         super.paintComponent(g);
        for(Shape s : list)
        {
            s.Draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
     
    }

    @Override
    public void mousePressed(MouseEvent me) {
        startPoint.x = me.getX();
        startPoint.y = me.getY();
        Shape shape = new Rectangle();
        switch(state)
        {
            case RECTANGLE:
                shape = factory.getShape("Rectangle");
            break;
             case ELLIPSE:
                shape = factory.getShape("Ellipse");
            break;
            case SELECT:
                 selection(me);
             
            break;
        }
        shape.setPosition(me.getX(), me.getY());
        list.add(shape);
        repaint();
    }

    public void selection(MouseEvent me)
    {
        for(Shape s : list)
        {
            if(me.getX() > s.getX() && me.getX() < s.getX() + s.getWidth())
            {
                if(me.getY() > s.getY() && me.getY() < s.getY() + s.getHeight())
                {
                    System.out.println("shape selected");
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent me) {
        //System.out.println("release event");
    }
     @Override
    public void mouseDragged(MouseEvent me) {
        
        Shape s = list.get(list.size()-1);
       int x = Math.min(startPoint.x, me.getX());
       int y = Math.min(startPoint.y, me.getY());
       int width = Math.abs(startPoint.x - me.getX());
        int height = Math.abs(startPoint.y - me.getY());
        s.setPosition(x, y);
        s.setWidth(width);
        s.setHeight(height);
            //s.setWidth(Math.abs(s.getX() - me.getX()));
            //s.setHeight(Math.abs(s.getY() - me.getY()));
        
        repaint();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //System.out.println("move:D");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //System.out.println("enter event" + state);
    }

    @Override
    public void mouseExited(MouseEvent me) {
       //System.out.println("exit event");
    }
   
    
}
