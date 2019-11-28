package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.PageEntity;
import dao.UserDao;
import model.Car;
import model.User;

@Service
public class UserServiceimp implements UserService{
@Autowired
private UserDao userDao;

@Override
public List<Car> queryListCar() {
	// TODO Auto-generated method stub
	return userDao.queryListCar();
}

@Override
public void userAdd(User user) {
	// TODO Auto-generated method stub
	userDao.userAdd(user);
}

@Override
public PageEntity<User> queryList(User user, int pageNum, int pageSize) {
	PageEntity<User> pager=new PageEntity<User>(pageNum,pageSize);
	Map<String, Object>  map=new HashMap<String, Object>();
	map.put("uname", user.getUname().trim());
	map.put("carid", user.getCarid());
	map.put("buyDate", user.getBuyDate());
	long totalCount=userDao.queryCount(map);
	pager.setTotalCount(totalCount);
	map.put("pager", pager);
	List<User> list=userDao.queryList(map);
	pager.setList(list);
	return pager;
}

@Override
public void userdelete(int id) {
	// TODO Auto-generated method stub
	userDao.userdelete(id);
}
}
