package com.example.lvivtram001;

import com.google.gson.annotations.SerializedName;

public class Route {
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

	@SerializedName("Id")
	 public double id;
	 
	 @SerializedName("Name")
	 public double name;
}
