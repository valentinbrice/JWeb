<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-INF/css/style.css" />
    <title>JBDD Shop : Connexion</title>
</head>
<body>
    <form  method="POST" action="${pageContext.request.contextPath}/Connect">
        <p>
            <label for="user">Votre pseudo :</label>
            <input type="text" name="pseudo" id="user" />
            <br />
            <label for="pass">Votre mot de passe :</label>
            <input type="password" name="pass" id="pass" />
        </p>
        <input name="but" type="submit" value="Connexion">
        <input name="but" type="submit" value="Inscription">
    </form>
</body>
</html>
