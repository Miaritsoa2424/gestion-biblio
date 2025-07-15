<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Prêts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
    <div class="container mt-4">
        <h2>Liste des Prêts</h2>
        
        <!-- Messages d'alerte -->
        <c:if test="${not empty success}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${success}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${error}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        
        <!-- Formulaire de recherche -->
        <div class="row mb-3">
            <div class="col-md-6">
                <form class="d-flex" action="${pageContext.request.contextPath}/pret" method="GET">
                    <input type="text" name="numeroAdherent" class="form-control me-2" placeholder="Rechercher par numéro d'adhérent" value="${param.numeroAdherent}">
                    <input type="text" name="nom" class="form-control me-2" placeholder="Rechercher par nom etudiant" value="${param.nom}">
                    <input type="text" name="titre" class="form-control me-2" placeholder="Rechercher par titre" value="${param.titre}">
                    <input type="date" name="date" class="form-control me-2" value="${param.date}">
                    <button class="btn btn-primary" type="submit">Rechercher</button>
                </form>
            </div>
        </div>

        <!-- Tableau des prêts -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID Prêt</th>
                    <th>Numéro adhérent</th>
                    <th>Nom</th>
                    <th>Titre</th>
                    <th>Date du pret</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${prets}" var="pret">
                    <tr>
                        <td>${pret.getIdPret()}</td>
                        <td>${pret.getAdherant().getNumeroAdherant()}</td>
                        <td>${pret.getAdherant().getNomAdherant()}</td>
                        <td>${pret.getExemplaire().getLivre().getTitre()}</td>
                        <td>${pret.getDateDebut()}</td>
                        <td>
                            <div class="btn-group" role="group">
                                <button class="btn btn-sm btn-success" onclick="openRetourModal(${pret.getIdPret()})">
                                    <i class="bi bi-arrow-return-left"></i> Retour
                                </button>
                                <form action="${pageContext.request.contextPath}/prolongement/demander-prolongement" method="post" style="display:inline;">
                                    <input type="hidden" name="idPret" value="${pret.getIdPret()}" />
                                    <input type="hidden" name="idAdherant" value="${pret.getAdherant().getIdAdherant()}" />
                                    <button type="submit" class="btn btn-sm btn-outline-primary">
                                        <i class="bi bi-clock-history"></i> Prolonger
                                    </button>
                                </form>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Modal de retour -->
    <div class="modal fade" id="retourModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Date de retour</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form id="retourForm" action="detail-pret" method="POST">
                        <input type="hidden" id="idPret" name="id">
                        <div class="mb-3">
                            <label for="dateRetour" class="form-label">Date de retour</label>
                            <input type="date" class="form-control" id="dateRetour" name="dateRetour" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Confirmer</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function openRetourModal(idPret) {
            document.getElementById('idPret').value = idPret;
            var modal = new bootstrap.Modal(document.getElementById('retourModal'));
            modal.show();
        }
    </script>
</body>
</html>
