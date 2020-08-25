package SnakeGame;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Apple{
	  private Image appleImg;


	public Apple(){
	     String appleResPath ="\\res\\apple.png";
	  	 URL appleUrl = getClass().getResource(appleResPath);
	  	 appleImg = new ImageIcon(appleUrl).getImage();
	}

	public void draw(Graphics g){
	   if(appleImg == null) return;
	  	 	    int imageWidth = appleImg.getWidth(null);
	  	 	    int imageHeight = appleImg.getHeight(null);

	  	 	    int x = 0;
	  	 	    int y = 0;
	  	 	    g.drawImage(appleImg,x*imageWidth,y*imageHeight,null);

		    }




}