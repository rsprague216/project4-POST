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
@WebServlet(name = "home_servlet", urlPatterns = {"/home"})
public class home_servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coin myCoin = (Coin) request.getSession().getAttribute("coin");
        if (myCoin == null) {
            myCoin = new Coin();
            request.getSession().setAttribute("coin", myCoin);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Coin myCoin = (Coin)request.getSession().getAttribute("coin");
        // Get the user's guess
        String userGuess;
        userGuess = request.getParameter("toss");
        // flip the coin
        myCoin.flip();
        // see if user guessed correctly and increment the counters
        myCoin.incrementCounters(userGuess);
        
        // message displaying the result of the coin toss
        request.getSession().setAttribute("result", "/project4/pics/" + myCoin.getSideUp() + ".jpg");
        
        // messages for the counters and win percentage
        request.getSession().setAttribute("correctGuessCount", myCoin.getRightCount());
        request.getSession().setAttribute("wrongGuessCount", myCoin.getWrongCount());
        request.getSession().setAttribute("totalGuessCount", myCoin.getTotalCount());
        request.getSession().setAttribute("winPercent", myCoin.getWinPercent() + "%");
        
        response.sendRedirect("/project4/home");
    }

}
