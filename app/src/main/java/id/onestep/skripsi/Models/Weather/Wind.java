package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class Wind{

	@SerializedName("Speed")
	private Speed speed;

	@SerializedName("Direction")
	private Direction direction;

	public void setSpeed(Speed speed){
		this.speed = speed;
	}

	public Speed getSpeed(){
		return speed;
	}

	public void setDirection(Direction direction){
		this.direction = direction;
	}

	public Direction getDirection(){
		return direction;
	}

	@Override
 	public String toString(){
		return 
			"Wind{" + 
			"speed = '" + speed + '\'' + 
			",direction = '" + direction + '\'' + 
			"}";
		}
}