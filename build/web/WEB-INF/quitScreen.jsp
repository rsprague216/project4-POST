<%-- 
    Document   : quitScreen
    Created on : Mar 29, 2018, 8:09:30 PM
    Author     : Ryan Sprague
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Game?</title>
    </head>
    <body>
        <h1>Coin Toss.</h1>
        <p>
            Your final score was a wopping ${sessionScope.finalScore}%
        </p>
        <form method="POST" action="reset">
            <input type="submit" name="new" value="New Game" />
        </form>
    </body>
</html>
