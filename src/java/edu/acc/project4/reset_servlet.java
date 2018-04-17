package edu.acc.project4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "reset_servlet", urlPatterns = {"/reset"})
public class reset_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coin myCoin = (Coin)request.getSession().getAttribute("coin");
        request.getSession().setAttribute("finalScore", myCoin.getWinPercent());
        getServletContext().getRequestDispatcher("/WEB-INF/quitScreen.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/project4/home");
    }
    
}
