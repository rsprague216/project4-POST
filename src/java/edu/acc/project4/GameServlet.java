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
@WebServlet(name = "GameServlet", urlPatterns = {"/rpsls"})
public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RPSLS myGame = (RPSLS) request.getSession().getAttribute("game");
        if (myGame == null) {
            myGame = new RPSLS();
            request.getSession().setAttribute("game", myGame);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/rockpaperscissors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RPSLS myGame = (RPSLS) request.getSession().getAttribute("game");
        // get the user's play
        String userPlay;
        userPlay = request.getParameter("hand");
        myGame.getIndexOf(userPlay);
        request.getSession().setAttribute("userPlay", userPlay);
        // computer plays a hand
        myGame.playHand();
        request.getSession().setAttribute("opponent", myGame.getHand());
        // check if user won
        request.getSession().setAttribute("gameResult", myGame.checkIfWon());
        // increment the counters
        myGame.incrementCounters();
        request.getSession().setAttribute("totalCount", myGame.getTotalCount());
        request.getSession().setAttribute("tieCount", myGame.getTiedCount());
        request.getSession().setAttribute("winCount", myGame.getCorrectCount());
        request.getSession().setAttribute("loseCount", myGame.getWrongCount());
        request.getSession().setAttribute("winPercent", myGame.getWinPercent());
        response.sendRedirect("/project4/rpsls");
    }
}
