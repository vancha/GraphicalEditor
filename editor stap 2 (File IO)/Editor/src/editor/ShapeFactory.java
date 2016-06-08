/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author vancha
 */
public class ShapeFactory 
{
    public Shape getShape(String shapeName)
    {
       if(shapeName == null)return null;
       if(shapeName.equalsIgnoreCase("Ellipse"))
       {
           return new Ellipse();
       }
       if(shapeName.equalsIgnoreCase("Rectangle"))
       {
           return new Rectangle();
       }
       return null;
    }
}
