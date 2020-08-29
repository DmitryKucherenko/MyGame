package SnakeGame;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Apple{
	  private Image appleImg;
	  private boolean eaten = false;
	  private GameObj gameObj;


	public Apple(){
	     String appleResPath ="\\res\\apple.png";
	  	 URL appleUrl = getClass().getResource(appleResPath);
	  	 appleImg = new ImageIcon(appleUrl).getImage();
	  	 gameObj = new GameObj((int)(Math.random()*Game.getFieldSize()),(int)(Math.random()*Game.getFieldSize()));

	}

	public void draw(Graphics g){
	   if(appleImg == null) return;
	  	 	    int imageWidth = appleImg.getWidth(null);
	  	 	    int imageHeight = appleImg.getHeight(null);

	  	 	    int x = gameObj.getX();
	  	 	    int y = gameObj.getY();
	  	 	    g.drawImage(appleImg,x*imageWidth,y*imageHeight,null);

		    }
		    public boolean isEaten(){
		        return eaten;
			}

			public void eat(){
		       eaten = true;
				getNewApple();
			}

			public GameObj getGameObj(){
		       return gameObj;
			}

			public void getNewApple(){
				gameObj = new GameObj((int)(Math.random()*Game.getFieldSize()),(int)(Math.random()*Game.getFieldSize()));
				eaten = false;
			}




}