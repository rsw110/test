package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.User;

public class Test {
public static void main(String[] args) {
	/*List<User> userList=new ArrayList<>();
	User u=new User();
	u.setId(1);
	u.setUname("流畅");
	userList.add(u);
	userList.forEach( x ->System.out.println(x.getId()));*/
	Map<String, String>map=new HashMap<String, String>();
	map.put("1", "流畅");
	map.put("2", "连永浩");
	/*Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
	while(iterator.hasNext()){
		Entry<String, String> next = iterator.next();
		System.out.println(next.getKey()+""+next.getValue());
	}*/
	
	/*Set<Entry<String, String>> entrySet = map.entrySet();
	 for (Entry<String, String> entry : entrySet) {
		System.out.println(entry.getKey());
	}*/
	/* map.forEach((x,y)->System.out.println(x+""+y));*/
	 List<Map<String,String>> listmap=new ArrayList<>();
	 listmap.forEach(a->a.forEach((m,b)->System.out.println(m+""+b)));
	 
}
public void test1(){
	
}
}
