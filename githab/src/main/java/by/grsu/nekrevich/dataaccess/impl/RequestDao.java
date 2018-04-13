package by.grsu.nekrevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.nekrevich.dataaccess.AbstractDao;
import by.grsu.nekrevich.datamodel.Request;
import by.grsu.nekrevich.datamodel.table.RequestTable;

public class RequestDao extends AbstractDao <RequestTable, Request> implements Serializable{

	public RequestDao(final String rootFolderPath) {
		super(rootFolderPath);
	}
	
      @Override
	   public void saveNew(Request newRequest) {
		// set ID
		newRequest.setId(getNextId());
		// get existing data
		final RequestTable requestTable = deserializeFromXml();
		// add new row
		requestTable.getRows().add(newRequest);
		// save data
		 serializeToXml(requestTable);
		//
	}

	@Override
	public void update(Request entity) {
		// get existing data
		final RequestTable requestTable = deserializeFromXml();
		// find by ID
		for (final Request row : requestTable.getRows()) {
			if (row.getId().equals(entity.getId())) {
				// found!!!
				// copy data
				row.setStationName(entity.getStationName());
				row.setDate(entity.getDate());
				break;
			}
		}
		// save updated table
		serializeToXml(requestTable);
	}

	@Override
	public Request get(Long id) {
		// get existing data
		final RequestTable requestTable = deserializeFromXml();
		// find by ID
		for (final Request row : requestTable.getRows()) {
			if (row.getId().equals(id)) {
				return row;
			}
		}
		return null;
	}

	@Override
	public List<Request> getAll() {
		// get existing data
		final RequestTable requestTable = deserializeFromXml();
		return requestTable.getRows();
	}

	@Override
	public void delete(Long id) {
		// get existing data
		final RequestTable requestTable = deserializeFromXml();
		// find by ID
		Request toBeDeleted = null;
		for (final Request row : requestTable.getRows()) {
			if (row.getId().equals(id)) {
				// found!!!
				toBeDeleted = row;
				break;
			}
		}
		// remove from list
		requestTable.getRows().remove(toBeDeleted);
		// save updated table
		serializeToXml(requestTable);
	}

	@Override
	protected Class<RequestTable> getTableClass() {
		return RequestTable.class;
	}
}
