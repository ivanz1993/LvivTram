package com.example.lvivtram001;

import com.google.gson.annotations.SerializedName;

public class Vehicle {
	 // клас дл€ опису одноњ машини
	 //пол€
	 @SerializedName("X")
	 public double x;	 
	 @SerializedName("Y")
	 public double y;
	 
	 @SerializedName("VehicleName")
	 public String vehicleName;
	
	 @SerializedName("VehicleId")
	 public long vehicleId;
	 
	 @SerializedName("TimeToPoint")
	 public long timeToPoint;
	 
	 @SerializedName("State")
	 public long state;
	 
	 @SerializedName("StartPoint")
	 public String startPoint;
	 
	 @SerializedName("RouteName")
	 public String routeName;
	 
	 @SerializedName("RouteId")
	 public long routeId;
	 
	 @SerializedName("EndPoint")
	 public String endPoint;
	 
	 @SerializedName("Angle")
	 public double angle;
	 
	 //сетери-гетери
	 public long getVehicleId() {
		return vehicleId;
	 }
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public long getTimeToPoint() {
		return timeToPoint;
	}
	public void setTimeToPoint(long timeToPoint) {
		this.timeToPoint = timeToPoint;
	}
	public long getState() {
		return state;
	}
	public void setState(long state) {
		this.state = state;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public long getRouteId() {
		return routeId;
	}
	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public double getAngle() {
		return angle;
	}
	public void setEndPoint(String EndPoint){
		 this.endPoint = EndPoint;
	 }
	 public void setAngle(double Angle){
		 this.angle = Angle;
	 }
	 public void setVehicleName(String vehicleName){
		 this.vehicleName = vehicleName;
	 }
	 public void setX(double x){
		 this.x = x;
	 }
	 public void setY(double y){
		 this.y = y;
	 }
	 
}
