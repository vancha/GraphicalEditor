/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author vancha
 */
public class paintClass extends JPanel implements MouseListener, MouseMotionListener
{
    paintClass panel;
    ShapeFactory factory = new ShapeFactory();
    ArrayList<Shape> list;
    public State state;
    private Point startPoint = new Point(0,0);
    public enum State 
    {
        RECTANGLE, ELLIPSE, SELECT, MOVE,RESIZE 
    }
    
    public void createGui()
    {
        JFrame frame = new JFrame();
        panel = new paintClass();
        frame.setLayout(new BorderLayout());
        JPanel optionPanel = new JPanel();
        final ArrayList<JRadioButton> InterfaceButtons = new ArrayList<>();
        final ButtonGroup group = new ButtonGroup();
        
        JRadioButton addRect = new JRadioButton("Rectangle");
        JRadioButton addEllipse = new JRadioButton("ellipse");
        JRadioButton moveShape = new JRadioButton("move");
        JRadioButton resizeShape = new JRadioButton("resize");
        JRadioButton selectShape = new JRadioButton("Select");
        
        group.add(addRect);
        group.add(addEllipse);
        group.add(moveShape);
        group.add(resizeShape);
        group.add(selectShape);
        
        Border b = BorderFactory.createEtchedBorder(Color.GRAY, Color.black);
        panel.setBorder(b);
        addRect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.RECTANGLE;
                DeSelectAllShapes(list);
            }
        });
        
        addEllipse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                 panel.state = State.ELLIPSE;
                 DeSelectAllShapes(panel.list);

            }
        });
        
        moveShape.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.MOVE;
                DeSelectAllShapes(panel.list);
            }
        });
        resizeShape.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                 panel.state = State.RESIZE;
                 DeSelectAllShapes(panel.list);
            }
        });
        selectShape.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.SELECT;
                DeSelectAllShapes(panel.list);
            }
        });
        
        
        optionPanel.setSize(800,100);
        frame.setSize(800,600);
        
        optionPanel.add(addRect);
        optionPanel.add(addEllipse);
        optionPanel.add(moveShape);
        optionPanel.add(resizeShape);
        optionPanel.add(selectShape);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setContentPane(panel);
        frame.add(optionPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu jmi = new JMenu("Menu");
        menuBar.add(jmi);
        final JMenuItem menuItem = new JMenuItem("Save",
                KeyEvent.VK_T);
        ActionListener al;
        al = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
               //LoadAndSave las = new LoadAndSave(ae, menuItem);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        menuItem.addActionListener(al);
        jmi.add(menuItem);
        frame.setJMenuBar(menuBar);
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
    
    public static void DeSelectAllShapes(ArrayList<Shape> shapelist)
    {
        for(Shape s: shapelist)
        {
            s.setSelected(false);
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
                 //return;
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
    public void mouseReleased(MouseEvent me) 
    {
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
