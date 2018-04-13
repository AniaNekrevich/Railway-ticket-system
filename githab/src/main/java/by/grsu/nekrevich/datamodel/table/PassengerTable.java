package by.grsu.nekrevich.datamodel.table;

import java.util.ArrayList ;
import java.util.List;

import by.grsu.nekrevich.datamodel.Passenger;

public class PassengerTable extends AbstractTable<Passenger>{
	private List<Passenger> rows;

	@Override
	public List<Passenger> getRows() {
		if (rows == null) {
			rows = new ArrayList<Passenger>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Passenger> rows) {
		this.rows = rows;
	} 
}