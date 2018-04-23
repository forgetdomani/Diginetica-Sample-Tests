package testData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Journey {
	String pointOfDeparture;
	String destination;
	Date departureDate;
	String travelMonth;
	String travelDay;
	String comfortClass;

	public Journey(String pointOfDeparture, String destination, String dateString) {
		this.pointOfDeparture = pointOfDeparture;
		this.destination = destination;
		this.departureDate = getDate(dateString);
	}

	public Journey(String pointOfDeparture, String destination, String travelMonth, String travelDay, String comfortClass) {
		this.pointOfDeparture = pointOfDeparture;
		this.destination = destination;
		this.travelMonth = travelMonth;
		this.travelDay = travelDay;
		this.comfortClass = comfortClass;
	}

	private Date getDate(String dateString) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateObject = new Date();
		try {
			dateObject = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateObject;
	}

	public String getPointOfDeparture() {
		return pointOfDeparture;
	}

	public void setPointOfDeparture(String pointOfDeparture) {
		this.pointOfDeparture = pointOfDeparture;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getTravelMonth() {
		return travelMonth;
	}

	public void setTravelMonth(String travelMonth) {
		this.travelMonth = travelMonth;
	}

	public String getTravelDay() {
		return travelDay;
	}

	public void setTravelDay(String travelDay) {
		this.travelDay = travelDay;
	}

	public String getComfortClass() {
		return comfortClass;
	}

	public void setComfortClass(String comfortClass) {
		this.comfortClass = comfortClass;
	}

}
