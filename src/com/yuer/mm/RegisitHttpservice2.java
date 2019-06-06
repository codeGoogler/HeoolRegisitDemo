package com.yuer.mm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisitHttpservice2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
//		String address = servletContext.getInitParameter("address");
		Properties properties = new Properties();
//		InputStream isInputStream = new FileInputStream("classes/config.properties");
//		properties.load(isInputStream );
//		String adre = properties.getProperty("address");
//		String name = properties.getProperty("name");
//		 System.out.println("ServiceRegisitDemo2  «Î«ÛµΩ¡À~~~"+servletContext + address+"===========" +adre+"=============" + name);
		
		
//		String localpath = servletContext.getRealPath("file/config.properties");
//		InputStream isInputStream = servletContext.getResourceAsStream("file/config.properties");
//		properties.load(isInputStream );
//		String adre = properties.getProperty("address");
//		String name = properties.getProperty("name");
//		System.out.println("localpath: " + localpath+"===========" +adre+"=============" + name);
		
		test3();
	}
	
	public void test3() throws IOException{
		ServletContext servletContext = getServletContext();
		Properties properties = new Properties();
		
		ClassLoader classLoader = getClass().getClassLoader();
		//E:\java_Study\apache-tomcat-8.5.33\wtpwebapps\HeoolRegisitDemo\file
		
		InputStream isInputStream =  classLoader.getResourceAsStream("../../file//config.properties");
//		InputStream isInputStream =  classLoader.getResourceAsStream("E:\\java_Study\\apache-tomcat-8.5.33\\wtpwebapps\\HeoolRegisitDemo\\file\\config.properties");
		properties.load(isInputStream);
		String adre = properties.getProperty("address");
		String name = properties.getProperty("name");
		String localpath = servletContext.getRealPath("file/config.properties");
		System.out.println(localpath+"===========" +adre+"=============" + name);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
