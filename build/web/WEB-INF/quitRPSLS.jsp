<%-- 
    Document   : quitRPSLS
    Created on : Apr 16, 2018, 9:33:02 PM
    Author     : Ryan Sprague
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Game</title>
    </head>
    <body>
        <h1>Here's your results!</h1>
        You won a whopping ${sessionScope.winPercent}% of the time.
        <form method="POST" action="/project4/resetRPSLS">
            <input type="submit" name="resetGame" value="New Game" />
        </form>
    </body>
</html>
