<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de prêt</title>
</head>
<body>
    <h2>Créer un nouveau prêt</h2>
    <form action="preter" method="post">
        <!-- Numéro d'adhérent -->
        <label for="adherent">Numéro adhérent :</label>
        <input type="number" id="adherent" name="adherent" required><br><br>

        <!-- Liste déroulante des livres -->
        <label for="livre">Livre :</label>
        <select name="livre" id="livre" required>
            <c:forEach var="livre" items="${livres}">
                <option value="${livre.getIdLivre()}">${livre.getTitre()}</option>
            </c:forEach>
        </select><br><br>

        <!-- Date de debut de prêt -->
        <label for="dateDeb">Date de debut de prêt :</label>
        <input type="date" id="dateDeb" name="dateDeb" required><br><br>


        <!-- Date de fin de prêt -->
        <label for="dateFin">Date de fin de prêt :</label>
        <input type="date" id="dateFin" name="dateFin" required><br><br>

        <button type="submit">Valider le prêt</button>
    </form>
</body>
</html>
