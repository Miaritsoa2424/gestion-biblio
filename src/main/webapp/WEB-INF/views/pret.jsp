<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prêter un Livre</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f4f6fa;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-top: 30px;
        }
        form {
            background: #fff;
            max-width: 500px;
            margin: 30px auto;
            padding: 30px 40px 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 16px rgba(44,62,80,0.08);
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #34495e;
            font-weight: 500;
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 8px 10px;
            margin-bottom: 18px;
            border: 1px solid #d0d7de;
            border-radius: 5px;
            font-size: 1em;
            background: #f9fafb;
        }
        button[type="submit"] {
            background: #2980b9;
            color: #fff;
            border: none;
            padding: 12px 25px;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
            transition: background 0.2s;
        }
        button[type="submit"]:hover {
            background: #1c5d85;
        }
        .message {
            color: #c0392b;
            background: #fdecea;
            border: 1px solid #e17055;
            border-radius: 5px;
            padding: 10px 15px;
            margin: 20px auto 0 auto;
            max-width: 500px;
            font-weight: bold;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Pr&ecirc;ter un Livre</h1>
    <form action="preter" method="post">
        <label for="adherantId">ID de l'adh&eacute;rant :</label>
        <input list="adherant-list" id="adherantId" name="adherantId" required autocomplete="off">
        <datalist id="adherant-list">
            <c:forEach var="ad" items="${adherants}">
                <option value="${ad.idAdherant}">${ad.nomAdherant} ${ad.prenomAdherant}</option>
            </c:forEach>
        </datalist>
        <label for="typePret">Type de pr&ecirc;t :</label>
        <select name="typePret" id="typePret">
            <c:forEach var="type" items="${typesPret}">
                <option value="${type.idTypePret}">${type.type}</option>
            </c:forEach>
        </select>
        <label for="livre">S&eacute;lectionnez le livre &agrave; pr&ecirc;ter :</label>
        <select id="livre" name="livre" required>
            <c:forEach var="livre" items="${livres}">
                <option value="${livre.idLivre}">
                    Livre: ${livre.titre}
                </option>
            </c:forEach>
        </select>
        <label for="dateFin">Date de fin du pr&ecirc;t :</label>
        <input type="date" name="dateFin" id="dateFin" required>
        <button type="submit">Valider le pr&ecirc;t</button>
    </form>
    <c:if test="${not empty message}">
        <div class="message">
            ${message}
        </div>
    </c:if>
</body>
</html>