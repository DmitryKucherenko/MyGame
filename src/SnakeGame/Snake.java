package SnakeGame;

import java.util.*;
import javax.print.attribute.standard.DialogOwner;
import javax.swing.*;
import java.awt.*;
import java.net.URL;



public class Snake{
  private java.util.List<GameObj> snakeBody = new ArrayList<>();
  private Image headImg;
    private Image headImgRed;
  private Image bodyImg;
  private Graphics g;
  private boolean eatenApple = false;

  private boolean alive = true;
  private DIRECTION direction = DIRECTION.UP;


  public Snake(){

	  String headResPath ="\\res\\head.png";
	   String bodyResPath ="\\res\\body.png";
	   String headRedResPath ="\\res\\head_red.png";
	  URL headUrl = getClass().getResource(headResPath);
	  URL headRedUrl = getClass().getResource(headRedResPath);
      URL bodyUrl = getClass().getResource(bodyResPath);


	  headImg = new ImageIcon(headUrl).getImage();
      headImgRed=new ImageIcon(headRedUrl).getImage();
      bodyImg = new ImageIcon(bodyUrl).getImage();

	  snakeBody.add(new GameObj(5,5));
	  snakeBody.add(new GameObj(5,6));
	  snakeBody.add(new GameObj(5,7));

  }

  public void move(){
     int x = snakeBody.get(0).getX();
     int y = snakeBody.get(0).getY();

      switch (direction) {
          case UP -> y--;
          case LEFT -> x--;
          case DOWN -> y++;
          case RIGHT -> x++;
      }

     if(x<=Game.getFieldSize()-1 &&x>=0 && y<=Game.getFieldSize()-1 && y>=0) {
         snakeBody.add(0, new GameObj(x, y));
         if(!eatenApple)  removeTail();else eatenApple = false;
     } else alive = false;


  }

  public void removeTail(){
	  snakeBody.remove(snakeBody.size()-1);
  }

  public boolean isAlive(){
      return alive;
  }

  public void draw(Graphics g){
     if(g==null) this.g = g;

      if(headImg == null) return;
	 	    int imageWidth = headImg.getWidth(null);
	 	    int imageHeight = headImg.getHeight(null);

	 	    for(int i=0; i<snakeBody.size();i++){
	 	    if(i==0) { if(!isAlive())headImg = headImgRed;
	 	        g.drawImage(headImg,snakeBody.get(i).getX()*imageWidth,snakeBody.get(i).getY()*imageHeight,null);

            }else
	 	    g.drawImage(bodyImg,snakeBody.get(i).getX()*imageWidth,snakeBody.get(i).getY()*imageHeight,null);

		    }
  }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }
    public DIRECTION getDirection(){return direction;}


    public GameObj getGameObj(){
      return snakeBody.get(0);
    }

    public void eat(Apple apple){

        if(getGameObj().equals(apple.getGameObj())){
            apple.eat();
            eatenApple = true;
        }

    }
}


