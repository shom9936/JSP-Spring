package dao;

import java.util.List;

public interface DAO {
	// CRUD
	int insert(Object ob); // Create
	List<String> selectList(); // Select
	int update(Object ob); // Update
	int delete(int i); // Delete
}
