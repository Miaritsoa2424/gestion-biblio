<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détail du livre</title>
    <style>
        body {
            background-color: #f8f5f1;
            font-family: 'Georgia', serif;
            color: #2c3e50;
        }
        .container {
            width: 90%;
            max-width: 1200px;
            margin: 40px auto;
            padding: 30px;
            background: white;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        .livre-titre {
            border-bottom: 2px solid #e0d5c1;
            padding-bottom: 15px;
            margin-bottom: 30px;
        }
        .livre-titre h2 {
            color: #34495e;
            font-size: 2.2em;
            margin: 0;
        }
        .livre-contenu {
            display: grid;
            grid-template-columns: 2fr 1fr;
            gap: 40px;
        }
        .synopsis {
            background: #fdfaf6;
            padding: 25px;
            border-radius: 5px;
            border-left: 4px solid #e0d5c1;
        }
        .synopsis h4 {
            color: #945d32;
            font-size: 1.4em;
            margin-top: 0;
        }
        .details-grid {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            border: 1px solid #e0d5c1;
        }
        .detail-item {
            margin: 15px 0;
            line-height: 1.6;
        }
        .detail-item strong {
            color: #945d32;
        }
        .boutons {
            margin-top: 30px;
            display: flex;
            gap: 15px;
        }
        .reserver-btn {
            padding: 12px 25px;
            background-color: #27ae60;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .reserver-btn:hover {
            background-color: #219a52;
        }
        .retour-btn {
            padding: 12px 25px;
            background-color: #95a5a6;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .retour-btn:hover {
            background-color: #7f8c8d;
        }
        .reservation-form {
            margin-top: 20px;
            padding: 20px;
            background: #fdfaf6;
            border-radius: 5px;
            border: 1px solid #e0d5c1;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #945d32;
            font-weight: bold;
        }
        .form-group input[type="date"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #e0d5c1;
            border-radius: 4px;
            font-family: inherit;
        }
        .submit-btn {
            padding: 12px 25px;
            background-color: #27ae60;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .submit-btn:hover {
            background-color: #219a52;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="livre-titre">
            <h2>${livre.getTitre()}</h2>
        </div>
        <div class="livre-contenu">
            <div>
                <div class="synopsis">
                    <h4>Synopsis</h4>
                    <p>${livre.getSynopsis()}</p>
                </div>
                <div class="details-grid">
                    <p class="detail-item"><strong>Auteur:</strong> ${livre.getAuteur()}</p>
                    <p class="detail-item"><strong>Date de publication:</strong> ${livre.getAnneePublication()}</p>
                    <p class="detail-item"><strong>Nombre de pages:</strong> ${livre.getNbPage()}</p>
                    <p class="detail-item"><strong>ISBN:</strong> ${livre.getIsbn()}</p>
                    <p class="detail-item"><strong>Éditeur:</strong> ${livre.getEditeur().getNomEditeur()}</p>
                    <p class="detail-item"><strong>Catégories:</strong> 
                        <c:forEach items="${livre.getCategories()}" var="categorie" varStatus="status">
                            ${categorie.getNomCategorie()}${!status.last ? ', ' : ''}
                        </c:forEach>
                    </p>
                </div>
                <div class="reservation-form">
                    <h4>Réserver ce livre</h4>
                    <form action="/biblio-spring-1.0/reservation/reserveBook" method="POST">
                        <input type="hidden" name="livre" value="${livre.getIdLivre()}">
                        <div class="form-group">
                            <label for="dateReservation">Date de réservation souhaitée:</label>
                            <input type="date" id="dateReservation" name="date" required>
                        </div>
                        <button type="submit" class="submit-btn">Confirmer la réservation</button>
                    </form>
                </div>
                <div class="boutons">
                    <a href="<c:url value='/livre'/>" class="retour-btn">Retour à la liste</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
