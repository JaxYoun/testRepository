package com.controller.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.controller.BaseController;
import com.entity.demo.Demo;
import com.entity.demo.MyPager;
import com.entity.user.User;
import com.service.demo.IDemoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/demo")//标识controller类的命名空间
public class DemoController extends BaseController {

	@Autowired
	private IDemoService demoService;
	
	/**
	 * 用于非后台交互的单纯页面跳转
	 */
	@RequestMapping("/*")
	public void toView(){}
	
	
	@RequestMapping("/sayHi")
	public void sayHi(Demo demo, PrintWriter printWriter){
		int id = demo.getId();
		Demo dm = (Demo) demoService.getDemoById(id);//从数据库取出对象
		JSONObject jsonObject = JSONObject.fromObject(dm);//将对象转换为json对象
		String jsonObjectStr = jsonObject.toString();//将json对象转化为string
		printWriter.write(jsonObjectStr);//将string通过response输出到视图曾
		System.err.println(dm.getName());
	}
	
	@RequestMapping("/sayHi1")
	public void sayHi11(Demo demo, PrintWriter printWriter){
		int id = demo.getId();
		List<Object> demoList = demoService.getDemoById(id);//从数据库取出对象list
		JSONArray jsonArray = JSONArray.fromObject(demoList);//将list转为json数组
		String jsonArrayStr = jsonArray.toString();//将json数组转为json字符串
		printWriter.write(jsonArrayStr);//将json字符串响应到前台
	}
	@RequestMapping("/sayHi1")
	public void sayHi1(Demo demo, PrintWriter printWriter){
		int id = demo.getId();
		List<Object> demoList = demoService.getDemoById(id);//从数据库取出对象list
		MyPager<Object> myPager = new MyPager<Object>();
		myPager.setToalSize(demoList.size());
		myPager.setList(demoList);
		
		JSONObject jsonArray = JSONObject.fromObject(myPager);//将list转为json数组
		String jsonArrayStr = jsonArray.toString();//将json数组转为json字符串
		System.out.println(jsonArrayStr + "======");
		printWriter.write(jsonArrayStr);//将json字符串响应到前台
	}
	
	@RequestMapping("/doUpload")
	public String doUpload(HttpServletRequest request){
		MultipartHttpServletRequest multiPartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multiPartRequest.getFile("myFile");
		String originalFileName = file.getOriginalFilename();
		byte[] fileByte = null;
		try {
			fileByte = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = request.getSession().getServletContext().getRealPath("/");
		
		try {
			OutputStream os = new FileOutputStream(new File(path + "/upload/" + originalFileName));
			try {
				os.write(fileByte);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		}
		return null;
	}
	
	
//********************************请求映射***********************
	/**
	 * 请求映射
	 * @return String类型的返回值表示view标识
	 */
	@RequestMapping("/sayHello")
	public String sayHello(){
		System.out.println("来了！");
		return "demo/sayHello";
	}
	
	/**
	 * 请求映射，同时限定前台请求方式为POST，否则请求失败
	 * @return
	 */
	@RequestMapping(value="/sayHello1", method=RequestMethod.POST)
	public String sayHello1(){
		System.out.println("来了！");
		return "demo/sayHello1";
	}
	
	
//********************************请求重定向***********************
	/**
	 * 内部重定向（同一命名空间），冒号后跟目的requestMapping的映射值
	 * @return
	 */
	@RequestMapping("/redirectToForm")
	public String redirectToForm(){
		return "redirect:/sayHello1";
	}
	
	/**
	 * 外部重定向（跨命名空间），必须要加根目录和目的命名空间
	 * @return
	 */
	@RequestMapping("/redirectToForm1")
	public String redirectToForm1(){
		return "redirect:/admin/sayHello1";
	}
	
	
//********************************参数传递与参数列表*********************************
	/**
	 * 通过在方法参数列表中声明原生ServletRequest来取前台参数
	 * @param request
	 * @return
	 */
	@RequestMapping("/toPerson")
	public String toPerson(HttpServletRequest request){
		String name = request.getParameter("name");
		System.out.println(name);
		return "/demo/toPerson";
	}
	
	/**
	 * 通过在方法参数列表中声明与前台参数同类型且同名的参数，来取前台参数
	 * @param personName
	 * @return
	 */
	@RequestMapping("/toPerson1")
	public String toPerson1(String personName){
		System.out.println(personName);
		return "/demo/toPerson1";
	}
	
	/**
	 * 通过在方法参数列表中声明与前台参数同类型且同名的参数（数字会【自动适配类型】），来取前台参数
	 * @param personAge
	 * @return
	 */
	@RequestMapping("/toPerson11")
	public String toPerson11(String personName, Integer personAge){
		System.out.println(personAge + "******" + personName);
		return "/demo/toPerson11";
	}
	
	/**
	 * 只要前台参数名与后台参数对象的属性名相同，且不存在类型转换冲突，就可以用对象类接受前台属性参数，前台属性名不需写成"demo.name"这等形式
	 * @param demo
	 * @return
	 */
	@RequestMapping("/toPerson12")
	public String toPerson12(Demo demo){
		System.out.println(demo.getName());
		return "/demo/toPerson12";
	}
	
	/**
	 * 如果参数列表中的另个不同类对象拥有同名属性，如果前台只有一个共名参数，则两个实体会被注入同样的属性；
	 * 如果前台有多个匹配的参数将以数组的方式注入到两个实体类中
	 * @param demo
	 * @param user
	 * @return
	 */
	@RequestMapping("/toPerson13")
	public String toPerson13(Demo demo, User user){
		System.out.println(demo.getName());
		return "/demo/toPerson13";
	}
	
	/**
	 * 接受前台传来的数组nameArr，只要前台多个参数名同为"nameArr",方法的参数会自动被装填
	 * @param nameArr
	 * @return
	 */
	@RequestMapping("/toPerson13")
	public String toPerson14(String[] nameArr){
		System.out.println(nameArr[0]);
		return "/demo/toPerson14";
	}
	
	/**
	 * 注册时间类型的属性编辑器，在这个controller类中注册了，本类中的所有前台时间都会被正常接受和转换
	 * @param dateBinder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder dateBinder){
		dateBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
//*********************************将后端数据渲染到view中********************************
	/**（不建议使用）
	 * 通过返回ModelAndView对象，将后台对象渲染到指定视图，由于这种方式实质是将map中的键值对放到request作用于中
	 * 所以，视图层EL表达式直接用map的键值就能取到对象
	 * <fmt:formatDate value="${userEntity.birthday}" pattern="yyyy-MM-dd"/>
	 * @return
	 */
	@RequestMapping("/toPerson2")
	public ModelAndView toPerson2(){
		User user = new User();
		user.setName("messi");
		user.setAge(29);
		user.setBirthday(new Date());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userEntity", user);
		return new ModelAndView("/demo/toPerson2", map);
	}
	
	/**（不建议使用）
	 * 直接在方法参数列表中定义map，此map与ModelAndView中的map等同，
	 * 作用机理与上一个方法是同样的，统一走ModelAndView接口
	 * 前台取值方式同上
	 * @param map
	 * @return
	 */
	@RequestMapping("/toPerson21")
	public String toPerson21(Map<String, Object> map){
		User user = new User();
		user.setName("messi");
		user.setAge(29);
		user.setBirthday(new Date());
		
		map.put("userEntity", user);
		return "/demo/toPerson21";
	}
	
	/**
	 * 推荐使用的方式，含义更为直观，可读性更强，
	 * 前台取值方式同上
	 * @param mode
	 * @return
	 */
	@RequestMapping("/toPerson22")
	public String toPerson22(Model mode){
		User user = new User();
		user.setName("messi");
		user.setAge(29);
		user.setBirthday(new Date());
		
		mode.addAttribute("userEntity", user);
		return "/demo/toPerson22";
	}
	
	
//********************************ajax与json*********************************
	/**（不建议使用）
	 * 通过re日response的writer将数据写到视图层
	 * 返回类型void
	 * @param response
	 * @param password
	 */
	@RequestMapping("/ajax")
	public void ajax(HttpServletResponse response, String password){
		String result = "hello" + password;
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**推荐使用的方式
	 * 机理同上，利用方法的参数列表简化了代码
	 * @param printWriter
	 * @param password
	 */
	@RequestMapping("/ajax1")
	public void ajax1(PrintWriter printWriter, String password){
		String result = "hello" + password;
		printWriter.write(result);
	}
}
