<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détail du livre</title>
    <!-- Bootstrap CSS + Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f5f1;
            font-family: 'Georgia', serif;
            color: #2c3e50;
        }
        .synopsis {
            background: #fdfaf6;
            padding: 20px;
            border-left: 5px solid #e0d5c1;
            border-radius: 5px;
        }
        .details-grid {
            border: 1px solid #e0d5c1;
            border-radius: 5px;
            padding: 20px;
            background-color: white;
        }
        .detail-item strong {
            color: #945d32;
        }
        .submit-btn {
            background-color: #27ae60;
            color: white;
        }
        .submit-btn:hover {
            background-color: #219a52;
        }
        .retour-btn {
            background-color: #95a5a6;
            color: white;
        }
        .retour-btn:hover {
            background-color: #7f8c8d;
        }
    </style>
</head>
<body>

<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Bibliothèque</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link" href="/">Accueil</a></li>
                <li class="nav-item"><a class="nav-link" href="/pret">Prêts</a></li>
                <li class="nav-item"><a class="nav-link active" href="#">Livres</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h2 class="mb-4 border-bottom pb-2">${livre.getTitre()}</h2>

    <!-- Alertes -->
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${success}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${error}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>
        <div class="row">
            <div class="col-md-8">
                <!-- Synopsis -->
                <div class="synopsis mb-4">
                    <h4>Synopsis</h4>
                    <p>${livre.getSynopsis()}</p>
                </div>

                <!-- Détails -->
                <div class="details-grid mb-4">
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

                <!-- Formulaire de réservation -->
                <div class="card bg-light p-4 mb-4">
                    <h5 class="mb-3">Réserver ce livre</h5>
                    <form action="/biblio-spring-1.0/reservation/reserveBook" method="POST">
                        <input type="hidden" name="livre" value="${livre.getIdLivre()}">
                        <div class="mb-3">
                            <label for="dateReservation" class="form-label">Date de réservation souhaitée:</label>
                            <input type="date" class="form-control" id="dateReservation" name="date" required>
                        </div>
                        <button type="submit" class="btn submit-btn"><i class="bi bi-bookmark-plus"></i> Réserver</button>
                    </form>
                </div>

                <!-- Bouton retour -->
                <a href="<c:url value='/livre'/>" class="btn retour-btn"><i class="bi bi-arrow-left-circle"></i> Retour à la liste</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
