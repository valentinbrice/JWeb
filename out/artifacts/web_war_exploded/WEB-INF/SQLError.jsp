
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JBDD Shop : Oops</title>
</head>

<body>
    <h1>We're sorry but an error happened</h1>

    <p>SQL server error : <%=request.getAttribute("error")%>
    </p>

</body>
</html>
