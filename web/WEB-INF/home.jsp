<%-- 
    Document   : home
    Created on : Mar 23, 2018, 12:17:08 PM
    Author     : Ryan Sprague
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home page</title>
    </head>
    <body>
        <h1>Coin Toss</h1>
        <p>
            <img src="${sessionScope.result}" width="150px" />
            <br>
            Correct guesses: ${sessionScope.correctGuessCount}
            <br>
            Incorrect guesses: ${sessionScope.wrongGuessCount}
            <br>
            Total guesses: ${sessionScope.totalGuessCount}
            <br>
            Percent guessed correct: ${sessionScope.winPercent}
        </p>
        <form method="POST" action="/project4/home">
            <input type="submit" name="toss" value="HEADS" />
            <input type="submit" name="toss" value="TAILS" />
        </form>
        <form method="GET" action="/project4/reset">
            <input type="submit" name="reset" value="Quit" />
        </form>
    </body>
</html>
