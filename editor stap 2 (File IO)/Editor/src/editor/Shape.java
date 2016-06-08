/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author vancha
 */
public interface Shape 
{
    
    public void setWidth(int width);
    public void setHeight(int height);
    public int getWidth();
    public void setSelected(boolean b);
    public boolean getSelected();
    public int getHeight();
    public int getX();
    public int getY();
    public void setPosition(int posX, int posY);
    public void Draw(Graphics g);
}
