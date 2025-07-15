<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de prêt</title>
    <!-- Bootstrap 5 + Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
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
    <h2 class="mb-4">Créer un nouveau prêt</h2>

    <!-- Alertes -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${error}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${success}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
    </c:if>

    <form action="preter" method="post" class="row g-3">

        <!-- Numéro d'adhérent -->
        <div class="col-md-6">
            <label for="adherent" class="form-label">Numéro adhérent</label>
            <input type="number" class="form-control" id="adherent" name="adherent" required>
        </div>

        <!-- Livre -->
        <div class="col-md-6">
            <label for="livre" class="form-label">Livre</label>
            <select class="form-select" name="livre" id="livre" required>
                <option value="" disabled selected>Choisissez un livre</option>
                <c:forEach var="livre" items="${livres}">
                    <option value="${livre.getIdLivre()}">${livre.getTitre()}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Type de prêt -->
        <div class="col-md-6">
            <label for="typePret" class="form-label">Type de prêt</label>
            <select class="form-select" name="typePret" id="typePret" required>
                <option value="" disabled selected>Choisissez un type</option>
                <c:forEach var="typePret" items="${typePrets}">
                    <option value="${typePret.getIdTypePret()}">${typePret.getType()}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Date début -->
        <div class="col-md-6">
            <label for="dateDeb" class="form-label">Date début de prêt</label>
            <input type="date" class="form-control" id="dateDeb" name="dateDeb" required>
        </div>

        <!-- Date fin -->
        <div class="col-md-6">
            <label for="dateFin" class="form-label">Date fin de prêt</label>
            <input type="date" class="form-control" id="dateFin" name="dateFin" required>
        </div>

        <!-- Bouton -->
        <div class="col-12">
            <button type="submit" class="btn btn-primary">
                <i class="bi bi-check-circle"></i> Valider le prêt
            </button>
        </div>
    </form>
</div>

<!-- JS Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
