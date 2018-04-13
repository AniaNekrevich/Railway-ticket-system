package by.grsu.nekrevich.datamodel;
import java.util.Date;

public class Request extends AbstractModel {
	
	private String stationName;
	private Date date;		
	private Passenger passenger;
	

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
}