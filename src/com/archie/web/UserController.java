package com.archie.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.archie.model.User;
import com.archie.service.UserService;
import com.archie.util.Pages;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Resource
	private UserService userService;

	private final String LIST="redirect:/user/list/1";
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(@Valid User user,BindingResult result,HttpSession session){
		if(!result.hasErrors()){
		User loginUser=userService.login(user);
		if(loginUser!=null){
			session.setAttribute("USER", loginUser);
			return new ModelAndView("redirect:/user/list/1");
		}else{
			return new ModelAndView("redirect:/");
		}
	  }else{
		  ModelAndView view=new ModelAndView();
		  view.setViewName("redirect:/");
		  view.addObject("error", result.getAllErrors());
		  return view;
	  }
	}
	/**
	 * 跳转至添加页
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView toAdd(){
		return new ModelAndView("user/add");
	}
	/**
	 * 保存
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ModelAndView add(@Valid User user,BindingResult result){
		if(result.hasErrors()){
			return new ModelAndView("user/add","error", result.getAllErrors());
		}else{
			userService.addUser(user);
			return new ModelAndView(LIST);	
		}
	}
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del/{id}")
	public ModelAndView delete(@PathVariable int id){
		userService.deleteUser(id);
		return new ModelAndView(LIST);
	}
	/**
	 * 跳转至编辑页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable int id){
		User user=userService.getUserById(id);
		return new ModelAndView("user/edit","user",user);
	}
	/**
	 * 编辑
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView update(@Valid User user,BindingResult result){
		ModelAndView view=new ModelAndView();
		if(result.hasErrors()){
			view.addObject("error", result.getAllErrors());
			view.setViewName("user/edit");
			return view;
		}else{
		userService.updateUser(user);
		return new ModelAndView(LIST);
		}
	}
	/**
	 * 分页
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="/list/{pageNo}")
	public ModelAndView list(@PathVariable int pageNo){
		Pages<User> pages=userService.getUserByPageNo(pageNo);
		return new ModelAndView("user/main","pages",pages);
	}
}
