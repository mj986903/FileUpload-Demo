package com.mohit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Part> parts = request.getParts();
			for (Part part : parts) {
	            part.write("E:\\"+part.getSubmittedFileName());
	        }
		}catch (Exception e){
			e.printStackTrace();
			response.sendRedirect("index.html");
		}
		PrintWriter out = response.getWriter();
		out.println("Upload Sucessfully");
	}
}
