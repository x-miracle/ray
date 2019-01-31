package com.xmiracle.ray.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServerStatus", urlPatterns = "/status")
public class ServerStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 9144135009782770415L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {

        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        writer.print("SUCCESS");

        writer.close();

    }
}
