package com.example.demo.entity;

public class CarBookingRequest {

	int carTypeID;
	int driverID;

	GeoCoordinate geocoordinate;

	public int getCarTypeID() {
		return carTypeID;
	}

	public GeoCoordinate getGeocoordinate() {
		return geocoordinate;
	}

	public void setGeocoordinate(GeoCoordinate geocoordinate) {
		this.geocoordinate = geocoordinate;
	}

	public void setCarTypeID(int carTypeID) {
		this.carTypeID = carTypeID;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

}
