package com.example.lvivtram001;

import com.google.gson.annotations.SerializedName;

public class Station {
	 public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public double getName() {
		return name;
	}

	public void setName(double name) {
		this.name = name;
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

	@SerializedName("Id")
	 public double id;
	 
	 @SerializedName("Name")
	 public double name;
	 
	 @SerializedName("X")
	 public double x;
	 
	 @SerializedName("Y")
	 public double y;
}
