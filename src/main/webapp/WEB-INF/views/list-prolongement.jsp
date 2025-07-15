<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Prolongements en attente</title>
    <!-- Bootstrap 5 + Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<!-- Barre de navigation -->
<%-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="livre/">Bibliothèque</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link" href="/">Accueil</a></li>
                <li class="nav-item"><a class="nav-link" href="pret">Prêts</a></li>
                <li class="nav-item"><a class="nav-link" href="prolongement/prolongement-list">Prolongements</a></li>
            </ul>
        </div>
    </div>
</nav> --%>
<div class="container mt-5">
    <h2 class="mb-4">Liste des prolongements en attente</h2>

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

    <!-- Tableau -->
    <table class="table table-bordered table-hover align-middle">
        <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Date fin prévue</th>
                <th>ID Prêt</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="prolongement" items="${prolongements}">
                <tr>
                    <td>${prolongement.idProlongement}</td>
                    <td>${prolongement.dateFin}</td>
                    <td>${prolongement.pret.idPret}</td>
                    <td>
                        <div class="btn-group" role="group">
                            <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/prolongement/valider?id=${prolongement.idProlongement}">
                                <i class="bi bi-check-circle"></i> Valider
                            </a>
                            <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/prolongement/refuser?id=${prolongement.idProlongement}">
                                <i class="bi bi-x-circle"></i> Refuser
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- JS Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
