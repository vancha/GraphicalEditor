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
import javax.swing.BorderFactory;
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
    
    
    public static void createGui()
    {
        JFrame frame = new JFrame();
        panel = new paintClass();
        frame.setLayout(new BorderLayout());
        JPanel optionPanel = new JPanel();
        JRadioButton addRect = new JRadioButton("Rectangle");
        Border b = BorderFactory.createEtchedBorder(Color.GRAY, Color.black);
        panel.setBorder(b);
        //panel.setBorder(border);
        addRect.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.RECTANGLE;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        JRadioButton addEllipse = new JRadioButton("ellipse");
        addEllipse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                 panel.state = State.ELLIPSE;
            }
        });
        JRadioButton moveShape = new JRadioButton("move");
        moveShape.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.MOVE;
            }
        });
        JRadioButton resizeShape = new JRadioButton("resize");
        resizeShape.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                 panel.state = State.RESIZE;
            }
        });
        JRadioButton clear = new JRadioButton("Select");
        clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.state = State.SELECT;
                 //clear hier het scherm in het paintclass paneel;
            }
        });
        
        
        optionPanel.setSize(800,100);
        frame.setSize(800,600);
        
        optionPanel.add(addRect);
        optionPanel.add(addEllipse);
        optionPanel.add(moveShape);
        optionPanel.add(resizeShape);
        optionPanel.add(clear);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setContentPane(panel);
        frame.add(optionPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
    }
}
