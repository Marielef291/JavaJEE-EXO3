<%@ page import="entity.Chien" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/08/2024
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Chien> chiens = (List<Chien>) request.getAttribute("chiens");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Chien</title>
</head>
<body>

<header>
    <h1>Liste des chiens</h1>
</header>

<main class="container">

    <% if(!(chiens.isEmpty())){ %>
    <table class="table text-center align-middle">

        <tbody>
        <% for  (Chien chien : chiens){%>
        <tr>
            <td><%= chien.getNom()%></td>
            <td><a href="ChienDetail?id=<%= chien.getId() %>">Détail</a></td>
        </tr>

        <%}%>

        </tbody>

    </table>

    <% } else {%>
    <p>Vous n'avez aucun Chien dans votre liste</p>
    <% }%>

    <hr/>

    <h2>Formulaire d'ajout de chien</h2>

    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="" method="post">
            <div class="mb-3">
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom">
            </div>
            <div class="mb-3">
                <label for="race">Race :</label>
                <input type="text" id="race" name="race">
            </div>
            <div class="mb-3">
                <label for="favRepas">Plat favoris :</label>
                <input type="text" id="favRepas" name="favRepas">
            </div>
            <div class="mb-3">
                <label for="dateOfBirth">Date de naissance :</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth">
            </div>

            <button class="text-end">Ajouter</button>


        </form>
    </div>
</main>

</body>
</html>
