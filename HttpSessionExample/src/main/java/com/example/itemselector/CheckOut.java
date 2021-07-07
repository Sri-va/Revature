package com.example.itemselector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckOut
 */
public class CheckOut extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie [] cookies = request.getCookies();
        //out.println("You have selected....");
        
        for(int i=0; i<cookies.length; i++){
            if(cookies[i].getName().equals("name")){
                out.print("Dear ");
                out.print("<h2>"+cookies[i].getValue()+"</h2><br/>");
                out.print("plz pay for the listed items"+"<br/>");
            }
            else{
            out.println(cookies[i].getValue()+"<br/>");
            }
           
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}