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
 * Servlet implementation class ItemSelector
 */
public class ItemCollector extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");//Jasdhir
        Cookie nameCookie = new Cookie("name",name); // name--->Jasdhir
        nameCookie.setMaxAge(30*60); // delete in 30 min
        response.addCookie(nameCookie); // sends to browser
        String [] values = request.getParameterValues("items"); // values frm chkbox
        Cookie[] cookieList = new Cookie[values.length]; // array of cookies 
        out.println("<html> <head> <title>  </title> </head> <body>");
        out.print("<h1>Hello  "+name+"</h1>");
        out.println("You have selected...<br/>");
        for(int i=0; i<values.length; i++){ // loop through the array
            cookieList[i]= new Cookie("values"+i,values[i]); // create cookie
            cookieList[i].setMaxAge(30*60);
            response.addCookie(cookieList[i]);
            out.println(values[i]+"<br />");
        }
        out.println("Proceed for check out");
        out.println("<form action=checkout method=post>");
        out.println("<input type=submit value=check>");
        out.println("</form></body></html>");
    }
}