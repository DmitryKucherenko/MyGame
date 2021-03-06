package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

public class Game{
	private static final int FIELD_SIZE=10;
	private static int score = 0;
	private static Apple apple;
	private static Snake snake;
	private static Field field;



	public static void main(String[] args) {

         JFrame mainWindow = new MainWidown();

		apple = new Apple();
		snake = new Snake();
		field = new Field(FIELD_SIZE, snake,apple);
         mainWindow.addKeyListener(new KeyAdapter() {
			 @Override
			 public void keyPressed(KeyEvent e) {
				 switch (e.getKeyCode()) {
					 case KeyEvent.VK_RIGHT: if(snake.getDirection()!=DIRECTION.LEFT)snake.setDirection(DIRECTION.RIGHT);break;
					 case KeyEvent.VK_LEFT: if(snake.getDirection()!=DIRECTION.RIGHT) snake.setDirection(DIRECTION.LEFT);break;
					 case KeyEvent.VK_UP :if(snake.getDirection()!=DIRECTION.DOWN) snake.setDirection(DIRECTION.UP);break;
					 case KeyEvent.VK_DOWN: if(snake.getDirection()!=DIRECTION.UP)snake.setDirection(DIRECTION.DOWN);break;

				 }
		 }});
         mainWindow.add(field);
	     mainWindow.pack();
         mainWindow.setVisible(true);

		while(snake.isAlive()){
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}


			snake.move();
			snake.eat(apple);
			if(apple.isEaten()){
				apple.getNewApple();;
				score=score+10;
			}
			field.repaint();


		}

	}



	public static int getFieldSize(){
	  return FIELD_SIZE;
	}

	public static int getScore(){
		return score;
	}

}

class MainWidown extends JFrame{
	private static final int DEFAULT_HEIGTH = 550;
	private static final int DEFAULT_WIDTH = 600;

  public MainWidown(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Game Snake");
    setSize(DEFAULT_HEIGTH,DEFAULT_WIDTH);
    setCenter();
  }

  private void setCenter(){
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeigth = screenSize.height;
    int screenWidth = screenSize.width;
    setLocation(screenWidth/2-DEFAULT_WIDTH/2,screenHeigth/2-DEFAULT_HEIGTH/2);
  }


  public Dimension getPreferredSize(){
  	  return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGTH);
  }

}

class Field extends JComponent{
	private static final int DEFAULT_HEIGTH = 500;
	private static final int DEFAULT_WIDTH = 500;
	private final int fieldSize;
    private Image tileImg;
	private static Snake snake;
    private static Apple apple;

	public Field(int fieldSize, Snake snake, Apple apple){
	  this.snake = snake;
	  this.apple = apple;
      URL tileUrl = getClass().getResource("\\res\\tile.png");
	  this.fieldSize = fieldSize;
	  tileImg = new ImageIcon(tileUrl).getImage();

	  setVisible(true);
	}

	public void paintComponent(Graphics g){
	    if(tileImg == null) return;
	    int imageWidth = tileImg.getWidth(null);
	    int imageHeight = tileImg.getHeight(null);
	    for(int i=0;i<fieldSize;i++)
	    for(int j=0;j<fieldSize;j++)
	    g.drawImage(tileImg,j*imageWidth,i*imageHeight,null);
	    snake.draw(g);
	    if(!apple.isEaten())apple.draw(g);
	    g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString("Score:"+Game.getScore(),imageWidth*fieldSize,20);
		if(!snake.isAlive()){
			g.setFont(new Font("TimesRoman", Font.BOLD, 50));
			g.drawString("GAME OVER",imageWidth*fieldSize/2,imageHeight*fieldSize/2);
		}


	}



	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_HEIGTH, DEFAULT_WIDTH);
	}

}