<%@ page import="bdd.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
    <title>JBDD Shop :: Articles</title>
</head>
<body>
    <table>
        <tr>
            <td>Nom</td>
            <td>Prix</td>
            <td>Stock</td>
            <td>Description</td>
            <td>Ajouter</td>
            <td>Enlever</td>
        </tr>
        <%ArrayList<Article> lst = (ArrayList<Article>) request.getAttribute("articles");

            Iterator<Article> it = lst.iterator();

            while (it.hasNext()) {
                Article art = it.next();%>
        <tr>
            <td><%=art.getNom()%></td>
            <td><%=art.getPrix()%></td>
            <td><%=art.getStock()%></td>
            <td><%=art.getDesc()%></td>
            <td><a href="http://localhost:8080/add&art=<%=art.getId()%>"><img src="/WEB-INF/src/add.png" ></a></td>
            <td><a href="http://localhost:8080/del&art=<%=art.getId()%>"><img src="/WEB-INF/src/del.png" ></a></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
