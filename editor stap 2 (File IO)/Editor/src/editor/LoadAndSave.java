/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import static editor.Editor.fc;
import java.awt.Component;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author vancha
 */
public class LoadAndSave implements ActionListener
{
    MenuItem menuItem;
    public LoadAndSave(Component component)
    {
        //this.menuItem = component;
    }
   

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    }
}
