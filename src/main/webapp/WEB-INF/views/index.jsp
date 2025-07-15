<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil - Bibliotheque</title>
    <!-- Bootstrap 5 + Icons -->
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
    <div class="container text-center mt-5">
        <h1 class="mb-4">Que voulez-vous faire ?</h1>

        <div class="d-grid gap-3 col-6 mx-auto">
            <a href="preter" class="btn btn-primary btn-lg">
                <i class="bi bi-journal-plus"></i> Preter un Livre
            </a>
            <a href="livre/" class="btn btn-primary btn-lg">
                <i class="bi bi-journal-plus"></i> Explorer
            </a>
            <a href="reservation/reservation" class="btn btn-warning btn-lg">
                <i class="bi bi-bookmark-plus"></i> Reserver un Livre
            </a>
            <a href="pret" class="btn btn-secondary btn-lg">
                <i class="bi bi-card-list"></i> Liste des prets
            </a>

            <a href="prolongement/prolongement-list" class="btn btn-secondary btn-lg">
                <i class="bi bi-card-list"></i> Liste des demandes de prolongement
            </a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
