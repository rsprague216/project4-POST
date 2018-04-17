<%-- 
    Document   : rockpaperscissors
    Created on : Apr 5, 2018, 1:11:42 AM
    Author     : Ryan Sprague
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rock Paper Scissors Lizard Spock</title>
    </head>
    <body>
        <h1>Rock Paper Scissors Lizard Spock</h1>
        <p>
            You played ${sessionScope.userPlay}!
            <br>
            Your opponent played ${sessionScope.opponent}!
            <br>
            You ${sessionScope.gameResult}.
            <br>
            Total plays: ${sessionScope.totalCount}
            <br>
            Wins: ${sessionScope.winCount}
            <br>
            Losses: ${sessionScope.loseCount}
            <br>
            Ties: ${sessionScope.tieCount}
            <br>
            Win percent: ${sessionScope.winPercent}%
        <form method="POST" action="/project4/rpsls">
            <input type="submit" name="hand" value="Rock" />
            <input type="submit" name="hand" value="Paper" />
            <input type="submit" name="hand" value="Scissors" />
            <input type="submit" name="hand" value="Lizard" />
            <input type="submit" name="hand" value="Spock" />
        </form>
        <form method="GET" action="/project4/resetRPSLS">
            <input type="submit" name="resetGame" value="quit" />
        </form>
        </p>
    </body>
</html>
