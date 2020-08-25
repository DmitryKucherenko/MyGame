package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Game{
	private static final int FIELD_SIZE=10;

	public static void main(String[] args) throws InterruptedException {

         JFrame mainWindow = new MainWidown();
         Field field = new Field(FIELD_SIZE);
         mainWindow.add(field);
	     mainWindow.pack();
         mainWindow.setVisible(true);
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			Field.snake.move();
			field.repaint();
		}





	}
	public static int getFieldSize(){
	  return FIELD_SIZE;
	}

}

class MainWidown extends JFrame{
	private static final int DEFAULT_HEIGTH = 550;
	private static final int DEFAULT_WIDTH = 550;

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

    public static Snake snake;
    private static Apple apple;

	public Field(int fieldSize){
		String tileResPath = "\\res\\tile.png";



      URL tileUrl = getClass().getResource(tileResPath);

	  this.fieldSize = fieldSize;
	  tileImg = new ImageIcon(tileUrl).getImage();

	    snake = new Snake();
	    apple = new Apple();

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
	    apple.draw(g);



	}



	public Dimension getPreferredSize(){

		return new Dimension(DEFAULT_HEIGTH, DEFAULT_WIDTH);
		}

}