package SnakeGame;

import java.util.Objects;

public class GameObj{
	private int x;
	private int y;

	public GameObj(int x, int y){
	  this.x = x;
	  this.y = y;
	}


	public GameObj(GameObj obj){
		this.x = obj.getX();
		this.y = obj.getY();
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GameObj gameObj = (GameObj) o;
		return x == gameObj.x &&
				y == gameObj.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "GameObj{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}