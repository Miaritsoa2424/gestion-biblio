<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Prêter un Livre</h1>
    <form action="/preter" method="post">
        <label for="adherantId">ID de l'adh&eacute;rant :</label>
        <input list="adherant-list" id="adherantId" name="adherantId" required autocomplete="off">
        <datalist id="adherant-list">
            <c:forEach var="ad" items="${adherants}">
                <option value="${ad.idAdherant}">${ad.nomAdherant} ${ad.prenomAdherant}</option>
            </c:forEach>
        </datalist>
        <br><br>
        <label for="exemplaires">S&eacute;lectionnez les exemplaires à preter :</label>
        <select id="exemplaires" name="exemplaires" multiple size="5" required>
            <c:forEach var="ex" items="${exemplaires}">
                <option value="${ex.idExemplaire}">
                    Exemplaire ${ex.idExemplaire}
                    <c:if test="${not empty ex.livre}">
                        - Livre: ${ex.livre.titre}
                    </c:if>
                </option>
            </c:forEach>
        </select>
        <br><br>
        <button type="submit">Valider le pret</button>
    </form>
</body>
</html>