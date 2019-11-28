package dao;

import java.util.List;
import java.util.Map;

import model.Car;
import model.User;

public interface UserDao {

	List<Car> queryListCar();

	void userAdd(User user);

	long queryCount(Map<String, Object> map);

	List<User> queryList(Map<String, Object> map);

	void userdelete(int id);

}
