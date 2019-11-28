package service;

import java.util.List;

import controller.PageEntity;
import model.Car;
import model.User;

public interface UserService {

	List<Car> queryListCar();

	void userAdd(User user);

	PageEntity<User> queryList(User user, int pageNum, int pageSize);

	void userdelete(int id);

}
