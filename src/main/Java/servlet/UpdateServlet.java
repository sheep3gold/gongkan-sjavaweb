package servlet;

import dao.Film;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmid=request.getParameter("filmid");
        String title=request.getParameter("title");
        String description=request.getParameter("description");
        String language=request.getParameter("language");
        Film.updateFilm(title,description,language,filmid);
        response.sendRedirect("film");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
