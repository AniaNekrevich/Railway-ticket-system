package by.grsu.nekrevich.datamodel.table;

import java.util.ArrayList;
import java.util.List;

import by.grsu.nekrevich.datamodel.Train;

public class TrainTable extends AbstractTable<Train>{
	private List<Train> rows;

	@Override
	public List<Train> getRows() {
		if (rows == null) {
			rows = new ArrayList<Train>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Train> rows) {
		this.rows = rows;
	}
}
