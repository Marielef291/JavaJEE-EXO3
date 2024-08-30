package controller;

import Repository.ChienRepository;
import entity.Chien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.SessionFactorySingleton;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@WebServlet(value="/ChienDetail")
public class CHienDetailServlet extends HttpServlet {
    private ChienRepository chienRepository;

    @Override
    public void init() {
        chienRepository = new ChienRepository();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Chien chien = chienRepository.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("chien",chien);
        req.getRequestDispatcher("/WEB-INF/ChienDetail.jsp").forward(req,resp);
    }
}
