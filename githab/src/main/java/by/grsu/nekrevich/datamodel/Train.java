package by.grsu.nekrevich.datamodel;

import java.util.HashMap;
import java.util.Map;

public class Train extends AbstractModel {
	
	private String trainName;
    private Map<String, Double> stationName = new HashMap< String, Double>();

	public Map<String, Double> getStationName() {
		return stationName;
	}

	public void setStationName(Map<String, Double> stationName) {
		this.stationName = stationName;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

}
