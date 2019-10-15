package database;

import java.util.List;

public interface InterfaceDAO<R> {

	public R get(String id);

	public List<R> getAll();

	public void add(R obj);

	public void delete(R obj);

	public void update(R obj);

}
