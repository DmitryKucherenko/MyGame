package SnakeGame;

public class GameObj{
	private int x;
	private int y;

	public GameObj(int x, int y){
	  this.x = x;
	  this.y = y;
	}

	public int getX(){
	  return x;
	}

	public int getY(){
	  return y;
	}

	public static GameObj getRandom(){

	   return new GameObj((int)Math.random()*Game.getFieldSize(), (int)Math.random()*Game.getFieldSize());
    }
}