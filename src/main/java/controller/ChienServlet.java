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

@WebServlet("/")
public class ChienServlet extends HttpServlet {
    private ChienRepository chienRepository;


    public void init(){
        chienRepository = new ChienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Chien> chiens = chienRepository.findAll();
        req.setAttribute("chiens",chiens);
        req.getRequestDispatcher("/WEB-INF/Chien.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Chien chien = Chien.builder()
                .nom(req.getParameter("nom"))
                .race(req.getParameter("race"))
                .favRepas(req.getParameter("favRepas"))
                .dateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")))
                .build();

        chienRepository.save(chien);
        doGet(req,resp);
    }
}
