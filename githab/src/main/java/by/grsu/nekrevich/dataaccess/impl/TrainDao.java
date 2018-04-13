package by.grsu.nekrevich.dataaccess.impl;

import java.io.Serializable;

import java.util.List;
import by.grsu.nekrevich.dataaccess.AbstractDao;
import by.grsu.nekrevich.datamodel.Train;
import by.grsu.nekrevich.datamodel.table.TrainTable;

public class TrainDao extends AbstractDao <TrainTable,Train> implements Serializable{

	public TrainDao(final String rootFolderPath) {
		super(rootFolderPath);
	}
	
      @Override
	   public void saveNew(Train newTrain) {
		// set ID
		newTrain.setId(getNextId());
		// get existing data
		final TrainTable trainTable = deserializeFromXml();
		// add new row
		trainTable.getRows().add(newTrain);
		// save data
		serializeToXml(trainTable);
		//
	}

	@Override
	public void update(Train entity) {
		// get existing data
		final TrainTable TrainTable = deserializeFromXml();
		// find by ID
		for (final Train row : TrainTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				// found!!!
				// copy data
				row.setStationName(entity.getStationName());
				
				break;
			}
		}
		// save updated table
		serializeToXml(TrainTable);
	}
	
	
	
	
	

	@Override
	public Train get(Long id) {
		// get existing data
		final TrainTable TrainTable = deserializeFromXml();
		// find by ID
		for (final Train row : TrainTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<Train> getAll() {
		// get existing data
		final TrainTable TrainTable = deserializeFromXml();
		return TrainTable.getRows();
	}

	@Override
	public void delete(Long id) {
		// get existing data
		final TrainTable TrainTable = deserializeFromXml();
		// find by ID
		Train toBeDeleted = null;
		for (final Train row : TrainTable.getRows()) {
			if (row.getId().equals(id)) {
				// found!!!
				toBeDeleted = row;
				break;
			}
		}
		// remove from list
		TrainTable.getRows().remove(toBeDeleted);
		// save updated table
		serializeToXml(TrainTable);
	}

	@Override
	protected Class<TrainTable> getTableClass() {
		return TrainTable.class;
	}

}
