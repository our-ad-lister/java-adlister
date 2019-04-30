package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
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

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/editAd")
public class EditAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String edit = request.getParameter("selectedAdEdit");
        System.out.println(edit);
        request.setAttribute("ad", DaoFactory.getAdsDao().findByID(edit));
        request.getRequestDispatcher("/WEB-INF/editAd.jsp").forward(request, response);
    }  // doGet



    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Ad newAd = (Ad) request.getSession().getAttribute("adEdit");
        String ad_id = request.getParameter("id");
        Long id = Long.parseLong(ad_id);
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        DaoFactory.getAdsDao().editAd(id,title, description);
        response.sendRedirect("/profile");

//        if (!request.getParameter("title").isEmpty()) {
//            newAd.setTitle(request.getParameter("title"));
//        }
//        if (!request.getParameter("description").isEmpty()) {
//            newAd.setDescription(request.getParameter("description"));
//        }
//        if (!request.getParameter("category").isEmpty()) {
//            newAd.setCategory(request.getParameter("category"));
//        }


    } // doPost

} // EditAdServlet class



