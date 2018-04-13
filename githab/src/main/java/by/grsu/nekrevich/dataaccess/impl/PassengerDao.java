package by.grsu.nekrevich.dataaccess.impl;

import java.io.Serializable;

import java.util.List;

import by.grsu.nekrevich.dataaccess.AbstractDao;
import by.grsu.nekrevich.datamodel.Passenger;
import by.grsu.nekrevich.datamodel.table.PassengerTable;

public class PassengerDao extends AbstractDao<PassengerTable, Passenger> implements Serializable{


	public PassengerDao(final String rootFolderPath) {
		super(rootFolderPath);
	}

	@Override
	public void saveNew(Passenger newPassenger) {
		// set ID
		newPassenger.setId(getNextId());
		// get existing data
		final PassengerTable PassengerTable = deserializeFromXml();
		// add new row
		PassengerTable.getRows().add(newPassenger);
		// save data
		serializeToXml(	PassengerTable);
		System.out.println(newPassenger.getId());
		//
	}

	@Override
	public void update( Passenger entity) {
		// get existing data
		final PassengerTable PassengerTable = deserializeFromXml();
		// find by ID
		for (final Passenger row : PassengerTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				row.setUserProfile(entity.getUserProfile());
			//	row.setRequest(entity.getRequest());
				break;
			}
	
		}
		// save updated table
		serializeToXml(PassengerTable);
	}
	
	
	
	

	@Override
	public Passenger get(Long id) {
		// get existing data
		final PassengerTable PassengerTable = deserializeFromXml();
		// find by ID
		for (final Passenger row : PassengerTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<Passenger> getAll() {
		// get existing data
		final PassengerTable PassengerTable = deserializeFromXml();
		return PassengerTable.getRows();
	}

@Override
	public void delete(final Long id) {
		}

	@Override
	protected Class<PassengerTable> getTableClass() {
		return PassengerTable.class;
	}

}
