<%@ page import="bdd.Category" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collections" %>
<%@ page import="bdd.Category" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-INF/css/style.css" />
    <title>JBDD Shop</title>
  </head>
  <body>
  <h1>Bienvenue sur le site de vente JBDD</h1>

  <p>Selectionner une catégorie d'article pour en afficher le contenu</p>
  <form method="POST" action="${pageContext.request.contextPath}/Articles">
      <select name="cat">
          <%
              ArrayList<Category> lst = (ArrayList<Category>) request.getAttribute("category");

              Iterator<Category> it = lst.iterator();

              while (it.hasNext()) {
                  Category cat = it.next();%>

        <option value=<%=cat.getId()%>><%=cat.getCat()%></option>
        <%}%>
      </select>
  <input type="submit" value="Go">
  </form> 