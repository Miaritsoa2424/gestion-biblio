<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de Reservation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .form-container h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        select, button, input {
            box-sizing: border-box;
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Reserver un Livre</h1>
        <c:if test="${not empty success}">
            <div style="color: green; text-align: center; margin-bottom: 15px;">
                ${success}
            </div>
        </c:if>
        <form action="reserveBook" method="post">
            <label for="book">Selectionnez un livre :</label>
            <select id="book" name="livre">
                <option value="">--Choisir un livre--</option>
                <!-- Ajouter dynamiquement les options des livres -->
                <c:forEach var="book" items="${books}">
                    <option value="${book.getIdLivre()}">${book.getTitre()}</option>
                </c:forEach>
            </select>

            <label for="date">Date de reservation :</label>
            <input type="date" id="date" name="date" required>
            <br/>

            <button type="submit">Reserver</button>
        </form>
    </div>
</body>
</html>
