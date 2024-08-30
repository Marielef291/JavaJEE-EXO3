<%@ page import="entity.Chien" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Chien chien = (Chien) request.getAttribute("chien");
%>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <title>Détail du Chien</title>
</head>
<body>

<header>
  <h1>Détails du Chien</h1>
</header>

<main class="container">
  <%
    if (chien != null) {
  %>
  <h2><%= chien.getNom() %></h2>
  <p><strong>Race:</strong> <%= chien.getRace() %></p>
  <p><strong>Plat favori:</strong> <%= chien.getFavRepas() %></p>
  <p><strong>Date de naissance:</strong> <%= chien.getDateOfBirth() %></p>
  <% } else { %>
  <p>Chien non trouvé.</p>
  <% } %>
</main>

</body>
</html>
