/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import javax.swing.JFileChooser;

/**
 *
 * @author vancha
 */
public class Editor {

    final static JFileChooser fc = new JFileChooser();
    //static paintClass panel;

    public Editor() {
        super();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() 
                {
                    @Override
                    public void run() {
                        paintClass p = new paintClass();
                        p.createGui();
                        //createGui();
                    }
                });
    }

}
