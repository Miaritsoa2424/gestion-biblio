<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Livres</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS + Icons -->
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

<!-- Contenu principal -->
<div class="container mt-4">
    <h2 class="mb-4">Liste des Livres Disponibles</h2>

    <!-- Formulaire de filtrage -->
    <form method="get" action="/filterBooks" class="row g-3 mb-4">
        <div class="col-md-3">
            <label for="date" class="form-label">Date de sortie</label>
            <input type="date" class="form-control" id="date" name="date">
        </div>

        <div class="col-md-3">
            <label for="auteur" class="form-label">Auteur</label>
            <input type="text" class="form-control" id="auteur" name="auteur">
        </div>

        <div class="col-md-3">
            <label for="categorie" class="form-label">Catégorie</label>
            <select id="categorie" name="categorie" class="form-select">
                <option value="">Toutes</option>
                <c:forEach var="cat" items="${categories}">
                    <option value="${cat}">${cat}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-md-3 d-flex align-items-end">
            <button type="submit" class="btn btn-primary w-100"><i class="bi bi-funnel-fill"></i> Filtrer</button>
        </div>
    </form>

    <!-- Tableau des livres -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover align-middle">
            <thead class="table-light">
                <tr>
                    <th>Titre</th>
                    <th>Auteur</th>
                    <th>ISBN</th>
                    <th>Langue</th>
                    <th>Catégorie</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="livre" items="${livres}">
                    <tr>
                        <td>${livre.getTitre()}</td>
                        <td>${livre.getAuteur().getNomAuteur()}</td>
                        <td>${livre.getIsbn()}</td>
                        <td>${livre.getLangue()}</td>
                        <td>
                            <c:forEach var="categorie" items="${livre.getCategories()}">
                                <span class="badge bg-secondary">${categorie.getNomCategorie()}</span><br>
                            </c:forEach>
                        </td>
                        <td>
                            <div class="d-flex gap-2">
                                <a href="detail?id=${livre.getIdLivre()}" class="btn btn-sm btn-info">
                                    <i class="bi bi-eye-fill"></i> Détail
                                </a>
                                <a href="/reserveBook?id=${livre.getIdLivre()}" class="btn btn-sm btn-success">
                                    <i class="bi bi-bookmark-plus"></i> Réserver
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
