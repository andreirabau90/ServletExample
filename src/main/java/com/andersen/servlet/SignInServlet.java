package com.andersen.servlet;

import com.andersen.entity.User;
import com.andersen.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = userRepository.getUserByEmailAndPassword(email, password);
        if (user != null) {
            req.setAttribute("user", user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.getRequestDispatcher("chatPage.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "data is not correct");
            req.getRequestDispatcher("signInPage.jsp").forward(req, resp);
        }

    }
}
