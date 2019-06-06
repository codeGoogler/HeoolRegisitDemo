package com.yuer.mm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHttpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String userName = req.getParameter("userName");
		 String password = req.getParameter("password");
//		 PrintWriter  ps = resp.getWriter();
		 if(userName.equals("admin") && password.equals("123456")){
//			 PrintWriter ps = new PrintWriter("");
//			 ps.print("登陆成功~~");
//			 ps.print("login success");
//			 ps.flush();
//			 ps.close();
//			 System.out.println("登陆成功~~");
			 Object object = getServletContext().getAttribute("count");
			 int count = 0 ;
			 if(object!= null){
				 count = (int) object;
			 }
			 getServletContext().setAttribute("count", count+1);
//			 resp.setStatus(302);
			// resp.addHeader("Location", "LoginSuccess.html");
			 System.out.println("count:  " +count );
			 
			 
			 Enumeration<String> list =  req.getHeaderNames();
			 while (list.hasMoreElements()) {
				String string = (String) list.nextElement();
				String rel = req.getHeader(string);
				System.out.println("====> " + string + " ======" + rel);
			}
			 
//			 resp.setHeader("Content-Type", "text/html;charset=UTF-8");
//			   ps = resp.getWriter();
//			   ps.write("你好，世界");
			 
			 
			 resp.setContentType("text/html;charset=UTF-8");
			 resp.getOutputStream().write("你好，世界".getBytes("UTF-8"));
			 
		
		 }else{
//			 PrintWriter ps = new PrintWriter("");
//			 ps.print("登陆失败！");
//			 ps.print("login faise");
//			 ps.flush();
//			 ps.close();
			 System.out.println("登陆失败！");
			 resp.setStatus(302);
			 resp.addHeader("Location", "LoginFaild.html");
		 }
		 
		 Map<String, String[]> headMap = req.getParameterMap();
//		 headMap.entrySet();
		 Set<String> set = headMap.keySet();
		 Iterator<String> iteation = set.iterator();
		 while(iteation.hasNext()){
			 String key = iteation.next();
			 System.out.println("key:  "+key+"   valaue: " + headMap.get(key) +"\n");
			 String [] valueArray = headMap.get(key);
			 for (int i = 0; i < valueArray.length; i++) {
				 System.out.println("valueArray["+i+"]: "+valueArray[i] +"\n");
			}
		 }
		 //ISO-8859-1
		 userName = new String(userName.getBytes("gbk"),  "UTF-8");
		 password = new String(password.getBytes("gbk"),  "UTF-8");
		 
		 
		 //获取到客户提交上来的数据
		 System.out.println("====> " + userName + " ======" + password);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
//		req.setCharacterEncoding("UTF-8");
//		 String userName = req.getParameter("userName");
//		 String password = req.getParameter("password");
//		 System.out.println("====> " + userName + " ======" + password);
	}

}
