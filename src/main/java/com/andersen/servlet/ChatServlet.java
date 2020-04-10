package com.andersen.servlet;

import com.andersen.entity.Message;
import com.andersen.entity.User;
import com.andersen.repository.impl.MessageRepositoryImpl;
import com.andersen.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    private MessageRepositoryImpl messageRepository = new MessageRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Message message = new Message(req.getParameter("message"));
        user.getMessages().add(message);
        new UserRepositoryImpl().saveOrUpdate(user);
        req.setAttribute("user", user);
        req.setAttribute("listMessage", messageRepository.getAll());
        req.getRequestDispatcher("/chatPage.jsp").forward(req, resp);
    }


}
