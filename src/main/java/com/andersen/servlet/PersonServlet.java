package com.andersen.servlet;

import com.andersen.entity.User;
import com.andersen.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPerson")
public class PersonServlet extends HttpServlet {
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        long id = Long.parseLong(req.getParameter("id"));
        User user = userRepository.get(id);
        user.setName(name);
        userRepository.saveOrUpdate(user);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        userRepository.delete(userRepository.get(id));
    }
}
