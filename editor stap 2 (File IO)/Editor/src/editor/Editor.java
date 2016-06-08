/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import editor.paintClass.State;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 *
 * @author vancha
 */
public class Editor 
{
    
    static paintClass panel;
   
    public Editor()
    {
        super();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
         @Override
         public void run() 
         {
             createGui();
         }
        });
    }
    
    public static void DeSelectAllShapes(ArrayList<Shape> shapelist)
    {
        for(Shape s: shapelist)
        {
            s.setSelected(false);
        }
    }
    public static void createGui()
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
        addRect.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.RECTANGLE;
                DeSelectAllShapes(panel.list);
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
    }
}
