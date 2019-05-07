package com.springboot.com.springbootexample.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.springboot.com.springbootexample.entity.Order;
import com.springboot.com.springbootexample.entity.OrderDetail;
import com.springboot.com.springbootexample.entity.User;
import com.springboot.com.springbootexample.entity.Validate;
import com.springboot.com.springbootexample.entity.Validate.TestValidate;
import com.springboot.com.springbootexample.service.OrderDetailService;
import com.springboot.com.springbootexample.service.OrderService;
import com.springboot.com.springbootexample.service.UserService;

import sun.misc.BASE64Encoder;

/**
 * 
* <p>Title: HelloWordController</p>  
* <p>Description: 所有Spring Boot的练习都在这里面</p>  
* @author daihu  
* @date 2019年4月29日
 */
@Controller
public class HelloWordController {

	
	@Autowired
	private UserService service;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/say.html")
	public @ResponseBody String say() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping(path="/json.html",method=RequestMethod.GET)
	public @ResponseBody List<User> getJSON(){
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setId(1L);
		user.setLoginName("admin");
		user.setPassword("123456");
		user.setPhone("123456789");
		userList.add(user);
		user = new User();
		user.setId(2L);
		user.setLoginName("admin2");
		user.setPassword("123456");
		user.setPhone("1234567892");
		userList.add(user);
		return userList;
	}
	
	@RequestMapping(path="/parama.test")
	public @ResponseBody String test() {
		return "test";
	}
	
	/**
	 * url支持简单的表达式
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/value/{id}.json")
	public @ResponseBody String getById(@PathVariable String id) {
		return id;
	}
	
	//////////////////////////////////////ant路径表达式//////////////////////////////////////////////
	/**
	 * ant路径表达式*匹配任意字符
	 * @return
	 */
	@RequestMapping(value="/ant/*.json")
	public @ResponseBody String AntTest() {
		return "this is ant test *";
	}
	
	/**
	 * ant路径表达式*匹配任意字符
	 * @return
	 */
	@RequestMapping(value="/*/ant.json")
	public @ResponseBody String AntTest0() {
		return "this is ant test *";
	}
	
	/**
	 * ant路径表达式？匹配单个字符 请求中会优先匹配？
	 * @return
	 */
	@RequestMapping(value="/ant/?.json")
	public @ResponseBody String antTest2() {
		return "this is ant test 2 ?";
	}
	
	/**
	 * ant路径表达式？匹配单个字符 请求中会优先匹配？
	 * @return
	 */
	@RequestMapping(value="/?/ant.json")
	public @ResponseBody String antTest21() {
		return "this is ant test 2 ?";
	}
	
	
	/**
	 * ant 路径表达式**匹配任意路径
	 */
	@RequestMapping(value="/**/ant.json")
	public @ResponseBody String antTest3() {
		return "this is ant test 3 **";
	}
//////////////////////////////////////ant路径表达式//////////////////////////////////////////////
	
	
	
//////////////////////////////////////匹配系统环境变量和配置文件的值//////////////////////////////////////////////
	
	/**
	 * ${}用于匹配系统环境变量的值和配置文件的值（系统环境变量）
	 * @return
	 */
	@RequestMapping(value="/${JAVA_HOME}.json")
	public @ResponseBody String url() {
		return "url ${JAVA_HOME}";
	}
	
	/**
	 * ${}用于匹配系统环境变量的值和配置文件的值（配置文件）
	 * @return
	 */
	@RequestMapping(value="/${query}.json")
	public @ResponseBody String url2() {
		return "url ${query}";
	}
//////////////////////////////////////匹配系统环境变量和配置文件的值/////////////////////////////////////////////
	
	
///////////	///////////////////////Http Method匹配///////////////////////////////
	
	/**
	 * 用于获取服务端数据
	 * @return
	 */
	@GetMapping("/getMapping.json")
	public @ResponseBody String getMapping(){
		return "this is @GetMapping";
	}
	

	/**
	 * 用于向服务端提交数据
	 * @return
	 */
	@PostMapping("/postMapping.json")
	public @ResponseBody String postMapping(){
		return "this is @PostMapping";
	}
	/**
	 * 向服务端提交数据多次put数据不会改变相当于更新数据而post相当于插入一条数据
	 * @return
	 */
	@PutMapping("/putMapping.json")
	public @ResponseBody String putMapping(){
		return "this is @PutMapping";
	}
	
	/**
	 * 删除资源
	 * @return
	 */
	@DeleteMapping("/deleteMapping.json")
	public @ResponseBody String deleteMapping(){
		return "this is @DeleteMapping";
	}
	
	/**
	 * 类似于put方法表示局部更新
	 * @return
	 */
	@PatchMapping("/patchMapping.json")
	public @ResponseBody String patchMapping(){
		return "this is @PatchMapping";
	}
	
	
///////////	///////////////////////Http Method匹配///////////////////////////////
	
	
//////////////////////////	consumes和produces///////////////////////////////////
	
	/**
	 * consumes表示http的请求头里面的content-Type的值，如果匹配则能访问
	 * @return
	 */
	@GetMapping(value="/consumes.json",consumes="application/json")
	public @ResponseBody String consumes(){
		return "this is consumes";
	}
	
	
	/**
	 * produces表示http的请求头里面的accept的值，如果匹配则能访问
	 * @return
	 */
	@GetMapping(value="/produces.json",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String produces(){
		return "this is produces";
	}
//////////////////////////consumes和produces///////////////////////////////////
	
	
	
	///////////////parms和header匹配/////////////////////////////////////////////////////////
	
	/**
	 * 只有当请求的参数中含有put=putMapping的时候才能匹配到此方法
	 * @return
	 */
	@PutMapping(value="/params.json",params="put=putMapping")
	public @ResponseBody String params() {
		return "this is params";
	}
	
	/**
	 * 只有当请求头里面含有put=putMapping的时候才能匹配到此方法
	 * @return
	 */
	@GetMapping(value="/header.json",headers="put=putMapping")
	public @ResponseBody String headers() {
		return "this is headers";
	}

	
	///////////////parms和header匹配/////////////////////////////////////////////////////////	
	
	//////////////方法参数///////////////////
	
	/**
	 * @PathVariable 用于匹配URL中的参数映射到方法的形参中
	 * @param pathVariable
	 * @return
	 */
	@GetMapping("/pathVariable/{pathVariable}.json")
	public @ResponseBody String pathVariable(@PathVariable("pathVariable") String pathVariables) {
		return "this is @PathVariable :"+pathVariables;
	}
	//http://127.0.0.1:8080/test=2;status=1/pathVariable.json Spring支持矩阵变量
	@GetMapping("/{pathVariable}{pathVariables}/pathVariable.json")
	public @ResponseBody String pathVariables(@PathVariable("pathVariable") String pathVariables) {
		return "this is @PathVariable :"+pathVariables;
	}
	
	
	/**
	 * Model 视图对象可像此对象中添加视图需要的变量在视图页面通过模板技术展现比如thymeleaf模板引擎存入的id通过${id}取出
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/model/{id}.html")
	public String model(@PathVariable Long id,Model model) {
		model.addAttribute("id", id);
		return "index.html";
	}
	
	/**
	 * ModelAndView类似于Model只是在Model多了一层视图名称层可通过添加视图名称从而到达相应的视图
	 * @param str
	 * @param modelAndView
	 * @return
	 */
	@GetMapping("/modelAndView/{modelAndView}.html")
	public ModelAndView modelAndView(@PathVariable("modelAndView")String str,ModelAndView modelAndView) {
		modelAndView.setViewName("index.html");
		modelAndView.addObject("id", str);
		return modelAndView;
	}
	
	/**
	 * Http提交的参数会根据方法的形参一一对应映射到形参上面
	 * @param name
	 * @param test
	 * @return
	 */
	@GetMapping("/javaBean/test.json")
	public @ResponseBody String javaBean(String name,Integer test) {
		return "name="+name+"|"+"test="+test;
	}
	
	
	/**
	 * @RequestParam 此注解可限定http请求的参数到controller的参数 三个方法 name指定要映射的参数名 required表示此参数是否必须有如果没有则会报错，defaultValue表示如果没有值则默认值为什么
	 * @param name
	 * @param test
	 * @return
	 */
	@GetMapping("/requestParam/test.json")
	public @ResponseBody String requestParam(@RequestParam(name="test",required=true,defaultValue="sssss")String name,Integer test) {
		return "this is @RequestParam name="+name+"|"+"test="+test;
	}
	
	/**
	 * 可以将HTTP的参数转换为JavaBean对象，HTTP参数的名字对应到POJO的属性名
	 * http://127.0.0.1:8080/pojo.json?id=12&loginName=dh&password=123456&phone=18428357134
	 * http://127.0.0.1:8080/pojo.json?id=12&loginName=dh&password=123456&phone=18428357134&order.id=20212&order.name=订单&order.code=D2016124554&details[0].id=0112&details[0].name=订单详情1&details[0].code=DX201258&details[1].id=132134&details[1].name=订单详情2&details[1].code=DX321351321
	 * @param user
	 * @return
	 */
	@PostMapping("/pojo.json")
	public @ResponseBody User pojo(User user) {
		return user;
	}
	
	
	/**
	 * MultipartFile 用于上传文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/multiPartFile.json")
	public @ResponseBody String multiPartFile(MultipartFile file) throws IOException{
		File newFile = new File("d://"+file.getOriginalFilename());
//		if(!newFile.exists())
//			newFile.createNewFile();
//		FileOutputStream out = new FileOutputStream(newFile);
//		FileCopyUtils.copy(file.getInputStream(), out);
		file.transferTo(newFile);
		return file.getOriginalFilename();
	}
	
	/**
	 * @ModelAttribute 方法上被标注了此注解的时候每次的请求会先请求此方法然后在请求url里面对应的方法
	 * @param id
	 * @param model
	 */
//	@ModelAttribute
//	public void modelAttribute(@PathVariable String date,Model model) {
//		System.out.println(date);
//		model.addAttribute("modelAttribute", "首先调用了使用ModelAttribute注解的方法");
//	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/afterModelAttribute/{id}.json")
	public @ResponseBody String getModelAttribute(@PathVariable String id,Model model){
		return model.containsAttribute("modelAttribute")+"";
	}
	
	/**
	 * 初始化绑定器
	 * @InitBinder 此注解可实现扩展的参数绑定，比如绑定时间类型
	 * @param binder 实现绑定的对象
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	/**
	 * 测试initBinder注解的使用
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/initBinder.json")
	public @ResponseBody String initBinderDate( Date date){
		return date.toString();
	}
	
//////////////方法参数////////////////////////////////////////////
	
///////////////////////验证框架JSR-303///////////////////////////////
	
	/**
	 * @Validated 是启动验证参数value代表是触发的哪一个接口的验证     内附自定义校验
	 * @param validate
	 * @param bindingResult
	 * @return
	 */
	@GetMapping("/validate.json")
	public @ResponseBody List<String> validate(@Validated(TestValidate.class) Validate validate,BindingResult bindingResult) {
		List<ObjectError>  error =bindingResult.getAllErrors();
		List<String>result = new ArrayList<>();
		error.forEach(out ->{
			FieldError fieldError = (FieldError)out;
			result.add(fieldError.getObjectName()+","+fieldError.getField()+","+fieldError.getDefaultMessage());
			System.out.println(fieldError.getObjectName()+","+fieldError.getField()+","+fieldError.getDefaultMessage());
		});
		result.add("验证出错数量："+bindingResult.getErrorCount());
		return result;
	}
	
	public @ResponseBody String validateDIY(@Validated(TestValidate.class) Validate validate,BindingResult bindingResult) {
		return "";
	}
	@GetMapping("/interceptor/interceptor.json")
	public @ResponseBody String interceptor(@Validated(TestValidate.class) Validate validate,BindingResult bindingResult) {
		return "返回成功";
	}
	/***
	 * 跨域访问页面详细跨域请求配置见返回页面
	 * @param validate
	 * @param bindingResult
	 * @return
	 */
	@GetMapping("/interceptor/interceptors.json")
	public  String interceptors(@Validated(TestValidate.class) Validate validate,BindingResult bindingResult) {
		return "index.html";
	}
///////////////////////验证框架JSR-303///////////////////////////////	
	
	////////////////格式化///////////////////////////////////////////////////
	/**
	 * 验证格式化
	 * 对于时间的格式化有两种方式：
	 * 1、使用@Configuretion实现一个配置类WebMvcConfigure接口的
	 * 	  addFormatters(FormatterRegistry registry)方法
	 *    registry.addFormatter(new DateFormatter("yyyy-MM-dd"));添加一个DateFormate类
	 *  2、使用@InitBinder注解使用Spring的参数绑定扩展在一个方法上面使用此注解
	 *  用WebDataBinder作为形式参数添加DateFormate类
	 *  binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	 * @param date
	 * @return
	 */
	@GetMapping("/validateDateFormat.json")
	public @ResponseBody Date  validateDateFormat(Date date){
		return date;
	}
	////////////////格式化////////////////////////////
	
	///////////////////////使用Jackson以及自定义Jackson///////////////
	/**
	 * 在MVC框架中，Spring Boot内置了Jackson来完成JSON的序列化和反序列化。
	 * 在Controller中方法注解为@ResponseBody，自动将方法返回的对象序列化成JSON
	 * @return
	 */
	@GetMapping("/testJackson.json")
	public @ResponseBody User testJackson() {
		User user = new User();
		user.setDate(new Date());
		user.setId(1L);
		user.setLoginName("admin");
		Order order = new Order();
		order.setCode(UUID.randomUUID()+"");
		order.setName("orderName");
		order.setId(2);
		user.setOrder(order);
		user.setPassword(new BASE64Encoder().encode(new String("123456").getBytes()));
		user.setPhone("18428357134");
		List<OrderDetail> details = new ArrayList<>();
		OrderDetail detail = new OrderDetail();
		detail.setCode(UUID.randomUUID()+"");
		detail.setId(3);
		detail.setName("orderDetailName");
		details.add(detail);
		user.setDetails(details);
		return user;
	}
	
	
///////////////////////使用Jackson以及自定义Jackson///////////////
	
	
///////////////////////Redirect和Forward///////////////
	/**
	 * 重定向的第一种方式：使用RedirectView实现
	 * @return
	 */
	@GetMapping("/testRedirectView1.json")
	public RedirectView  testRedirectView1() {
		RedirectView redirectView = new RedirectView("/testJackson.json");
		return redirectView;
	}
	
	/**
	 * 重定向的第二种方式：使用String实现
	 * @return
	 */
	@GetMapping("/testRedirectView2.json")
	public String  testRedirectView2() {
		return "redirect:/testJackson.json";
	}
	
	/**
	 * 重定向的第三种方式：使用ModelAndView实现
	 * @return
	 */
	@GetMapping("/testRedirectView3.json")
	public ModelAndView  testRedirectView3() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("redirect:/testJackson.json");
		return andView;
	}
	
	
	/**
	 * forward的第二种方式：使用String实现
	 * @return
	 */
	@GetMapping("/testForward1.json")
	public String  testForward1() {
		return "forward:/testJackson.json";
	}
	
	/**
	 * forward的第三种方式：使用ModelAndView实现
	 * @return
	 */
	@GetMapping("/testForward2.json")
	public ModelAndView  testForward2() {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("forward:/testJackson.json");
		return andView;
	}
///////////////////////Redirect和Forward///////////////
	
	
///////////////////////通用错误处理///////////////
	/**
	 * 测试通用错误处理
	 * @return
	 */
	@GetMapping("/testError.json")
	public @ResponseBody String  testError(){
	String [] strs = new String[10];
	strs[11]="10";
		return "error";
	}
///////////////////////通用错误处理///////////////
	
///////////////////////Spring JDBC Template///////////////
	@GetMapping("/getUser/{id}.json")
	public @ResponseBody User getUser(@PathVariable Long id) {
		User user = service.findUser(id);
		return user;
	}
	
	/**
	 * 插入操作
	 * @param user
	 * @return
	 */
	@GetMapping("/insert.json")
	public @ResponseBody Long insertUser(User user) {
		return service.insertUser(user);
	}
///////////////////////Spring JDBC Template///////////////
	
///////////////////////增强的JdbcTemplate namedparameterJdbcTemplate///////////////
	@GetMapping("/getUserNamed/{id}.json")
	public @ResponseBody User getUserNamed(@PathVariable Long id) {
		User user = service.findUser(id);
		return user;
	}
///////////////////////增强的JdbcTemplate namedparameterJdbcTemplate///////////////
	
///////////////////////Spring Data JPA///////////////
	/**
	 * CrudRepository的使用
	 * @param order
	 * @return
	 */
	@PostMapping("/testCrudRepository.json")
	public @ResponseBody Order saveOrder(Order order) {
		orderService.save(order);
		return order;
	}
	
	/**
	 * PagingAndSoring的使用
	 * @param order
	 * @return
	 */
	@PostMapping("/testPagingAndSortingRepository.json")
	public @ResponseBody OrderDetail saveOrderDetail(OrderDetail orderDetail) {
		orderDetailService.save(orderDetail);
		return orderDetail;
	}
	
	/**
	 * PagingAndSoring的分页使用
	 * @param order
	 * @return
	 */
	@PostMapping("/testPagingAndSortingRepositoryFindAll.json")
	public @ResponseBody Page<OrderDetail> findAllOrderDetail(int start,int limit) {
		Pageable pageable =  PageRequest.of(start,limit);
		Page<OrderDetail> page =orderDetailService.findAll(pageable);
		
		return page;
	}
///////////////////////Spring Data JPA///////////////
}
