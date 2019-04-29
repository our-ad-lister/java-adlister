package com.codeup.adlister.controllers;

import com.codeup.adlister.models.Ad;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.String;
import java.util.Arrays;

@WebServlet(urlPatterns = "/editAd")
public class EditAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().getAttribute("adEdit");
        request.getRequestDispatcher("/WEB-INF/editAd.jsp").forward(request, response);
    }  // doGet



    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Ad newAd = (Ad) request.getSession().getAttribute("adEdit");

        if (!request.getParameter("title").isEmpty()) {
            newAd.setTitle(request.getParameter("title"));
        }
        if (!request.getParameter("description").isEmpty()) {
            newAd.setDescription(request.getParameter("description"));
        }
        if (!request.getParameter("category").isEmpty()) {
            newAd.setCategory(request.getParameter("category"));
        }


    } // doPost

} // EditAdServlet class



