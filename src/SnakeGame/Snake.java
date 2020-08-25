package SnakeGame;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Snake{
  private java.util.List<GameObj> snakeBody = new ArrayList<>();
  private Image headImg;
  private Image bodyImg;
  private Graphics g;


  public Snake(){

	  String headResPath ="\\res\\head.png";
	   String bodyResPath ="\\res\\body.png";
	  URL headUrl = getClass().getResource(headResPath);
 URL bodyUrl = getClass().getResource(bodyResPath);


	  headImg = new ImageIcon(headUrl).getImage();
 bodyImg = new ImageIcon(bodyUrl).getImage();

	  snakeBody.add(new GameObj(5,5));
	  snakeBody.add(new GameObj(5,6));
	  snakeBody.add(new GameObj(5,7));

  }

  public void move(){
     int x = snakeBody.get(0).getX();
     int y = snakeBody.get(0).getY();
    // x++;
     y--;
     if(x<Game.getFieldSize() && y<Game.getFieldSize()) {
         snakeBody.add(0, new GameObj(x, y));
         removeTail();


     }


  }

  public void removeTail(){
	  snakeBody.remove(snakeBody.size()-1);

  }

  public void draw(Graphics g){
     if(g==null) this.g = g;

      if(headImg == null) return;
	 	    int imageWidth = headImg.getWidth(null);
	 	    int imageHeight = headImg.getHeight(null);

	 	    for(int i=0; i<snakeBody.size();i++){
	 	    if(i==0) g.drawImage(headImg,snakeBody.get(i).getX()*imageWidth,snakeBody.get(i).getY()*imageHeight,null);else
	 	    g.drawImage(bodyImg,snakeBody.get(i).getX()*imageWidth,snakeBody.get(i).getY()*imageHeight,null);

		    }
  }


}