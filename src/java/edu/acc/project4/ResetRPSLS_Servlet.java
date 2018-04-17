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
 * @author RyanSprague
 */
@WebServlet(name = "ResetRPSLS_Servlet", urlPatterns = {"/resetRPSLS"})
public class ResetRPSLS_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RPSLS myGame = (RPSLS)request.getSession().getAttribute("game");
        System.out.println("myGame is " + myGame);
        request.getSession().setAttribute("winPercent", myGame.getWinPercent());
        
        request.getRequestDispatcher("/WEB-INF/quitRPSLS.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("/project4/rpsls");
    }
    
}
