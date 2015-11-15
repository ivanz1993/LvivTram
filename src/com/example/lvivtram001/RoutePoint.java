package com.example.lvivtram001;

import com.google.gson.annotations.SerializedName;

public class RoutePoint {
	 @SerializedName("Id")
	 public double id;
	 
	 public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@SerializedName("X")
	 public double x;
	 
	 @SerializedName("Y")
	 public double y;
}
