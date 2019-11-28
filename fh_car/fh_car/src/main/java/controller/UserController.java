package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import model.Car;
import model.User;
import service.UserService;
import util.FileUtil;

@Controller
@RequestMapping("user")
public class UserController {
@Resource
private UserService userService;
 String aaa="";
@RequestMapping("toAdd")
public ModelAndView toAdd(){
	ModelAndView mv=new ModelAndView();
	List<Car> list=userService.queryListCar();
	mv.setViewName("buyCar");
	mv.addObject("list", list);
	return mv;
}
@RequestMapping("userAdd")
public String userAdd(User user){
	user.setImgUrl("/upload/"+aaa);
	userService.userAdd(user);	
	return "redirect:toList";
}
//去查询
@RequestMapping("toList")
public String toList(){
	return "benzCar";
	
}
//头像上传
	@RequestMapping("uploadFile")
	@ResponseBody
	public String uploadFile(HttpServletRequest request){
		 MultipartHttpServletRequest req=(MultipartHttpServletRequest) request;
		MultipartFile multipartFile = req.getFile("file");
		String aaa = FileUtil.multipartFileUpload(request, multipartFile, "upload");
		JSONObject json=new JSONObject();
		json.put("aaa", aaa);
		return json.toString();		
	}
//查询
	@RequestMapping("queryList")
	public ModelAndView queryList(User user,int pageNum,int pageSize){
		ModelAndView mv=new ModelAndView();		 
		PageEntity<User> userList=userService.queryList(user,pageNum,pageSize);
		mv.setViewName("table");
		mv.addObject("pager", userList);		 
		return mv;
	}
//删除
	@RequestMapping("userdelete")
	public String userdelete(int id){
		userService.userdelete(id);
		return "redirect:toList";
		
	}
	//下拉
	@RequestMapping("selectxiala")
	@ResponseBody
	public List<Car> selectxiala(){
		List<Car> list=userService.queryListCar();
		return list;
		
	}
}
