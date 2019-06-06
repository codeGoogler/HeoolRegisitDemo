package com.yuer.mm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLaodHttpServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("filename");

		String path = getServletContext().getRealPath("download/"+fileName);
		System.out.println(path);
		System.out.println(getServletContext().getContextPath());
		
		InputStream iStream = new FileInputStream(path);
		
		OutputStream oStream =   resp.getOutputStream();
		
		
		
		FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
