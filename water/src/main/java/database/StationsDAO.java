package database;

import java.util.List;

import javax.persistence.EntityManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StationsDAO implements InterfaceDAO<Station> {

	private static ObservableList<Station> stations;

	@Override
	public Station get(String id) {
		if (stations != null)
			for (Station user : stations)
				if (user.getStation().contentEquals(id))
					return user;

		EntityManager entityMng = Conn.getEntityManager();
		Station station = entityMng.find(Station.class, id);
		entityMng.close();
		return station;
	}

	@Override
	public List<Station> getAll() {
		if (stations == null) {
			EntityManager entityMng = Conn.getEntityManager();
			stations = FXCollections.observableArrayList(
					entityMng.createQuery("select station from Station as station", Station.class).getResultList());
			entityMng.close();
		}
		return stations;
	}

	@Override
	public void add(Station station) {
		EntityManager entityMng = Conn.getEntityManager();
		entityMng.getTransaction().begin();
		entityMng.persist(station);
		entityMng.getTransaction().commit();
		entityMng.close();

		if (stations != null)
			stations.add(station);
}

	@Override
	public void delete(Station station) {
		EntityManager entityMng = Conn.getEntityManager();
		entityMng.getTransaction().begin();
		Station stationDB = entityMng.find(Station.class, station.getStation());
		entityMng.remove(stationDB);
		entityMng.getTransaction().commit();
		entityMng.close();

		Station found = null;
		if (stations != null)
			for (Station user : stations)
				if (station.getStation().contentEquals(station.getStation()))
					found = user;
		if (found != null)
			stations.remove(found);
	}

	@Override
	public void update(Station station) {
		EntityManager entityMng = Conn.getEntityManager();
		entityMng.getTransaction().begin();
		Station stationDB = entityMng.find(Station.class, station.getStation());
		stationDB.setName(station.getName());
		stationDB.setDescription(station.getDescription());
		entityMng.getTransaction().commit();
		entityMng.close();

		if (station != null) {
			for (Station user : stations) {
				if (user.getStation().contentEquals(station.getStation())) {
					user.setName(station.getName());
					user.setDescription(station.getDescription());
				}
			}
		}

}

}
