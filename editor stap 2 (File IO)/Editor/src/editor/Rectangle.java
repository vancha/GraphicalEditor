/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.awt.Graphics;

/**
 *
 * @author vancha
 */
public class Rectangle implements Shape{
    int width = 10;
    int height = 10;
    int x = 0;
    int y = 0;
    boolean selected = false;
  


    @Override
    public int getX() 
    {
        return x;
    }
    
      @Override
    public int getY() 
    {
        return y;
    }

    @Override
    public void Draw(Graphics g) {
         g.drawRect(x, y, width, height);
         
    }


    @Override
    public void setPosition(int posX, int posY) 
    {
     this.x = posX;
     this.y = posY;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setSelected(boolean b) {
        this.selected = b;
    }

    @Override
    public boolean getSelected() {
        return this.selected;
    }
    
}
