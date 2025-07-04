-- AUTEUR
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (1, 'Hugo', 'Victor');
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (2, 'Zola', 'Emile');
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (3, 'Dumas', 'Alexandre');
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (4, 'Maupassant', 'Guy');
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (5, 'Balzac', 'Honoré');

-- EDITEUR
INSERT INTO editeur (id_editeur, nom_editeur, localisation) VALUES (1, 'Gallimard', 'Paris');
INSERT INTO editeur (id_editeur, nom_editeur, localisation) VALUES (2, 'Flammarion', 'Lyon');
INSERT INTO editeur (id_editeur, nom_editeur, localisation) VALUES (3, 'Seuil', 'Paris');

-- CATEGORIE
INSERT INTO categorie (id_categorie, nom_categorie) VALUES (1, "Comedie");
INSERT INTO categorie (id_categorie, nom_categorie) VALUES (2, "Drame");
INSERT INTO categorie (id_categorie, nom_categorie) VALUES (3, "Action");

-- PROFIL
INSERT INTO profil (id_profil, nom_profil, quota_pret, quota_reservation) VALUES (1, "Professeur", 5, 3); -- Prof
INSERT INTO profil (id_profil, nom_profil, quota_pret, quota_reservation) VALUES (2, "Etudiant", 3, 2); -- Etudiant

-- ADMIN
INSERT INTO admin (id_admin, nom_admin, prenom_admin, password) VALUES (1, 'Dupont', 'Jean', 'admin1');
INSERT INTO admin (id_admin, nom_admin, prenom_admin, password) VALUES (2, 'Martin', 'Claire', 'admin2');

-- TYPE_PRET
INSERT INTO type_pret (id_type_pret, type) VALUES (1, 'A domicile');

-- DUREE_PRET
INSERT INTO duree_pret (id_duree_pret, duree, id_profil) VALUES (1, 30, 1);
INSERT INTO duree_pret (id_duree_pret, duree, id_profil) VALUES (2, 15, 2);

-- STATUT_RESERVATION
INSERT INTO statut_reservation (id_statut_reservation, nom_statut) VALUES (1, 'En attente');
INSERT INTO statut_reservation (id_statut_reservation, nom_statut) VALUES (2, 'Validée');
INSERT INTO statut_reservation (id_statut_reservation, nom_statut) VALUES (3, 'Annulée');


INSERT INTO statut_prolongement (nom_statut) VALUES ('En attente');
INSERT INTO statut_prolongement (nom_statut) VALUES ('En cours');
INSERT INTO statut_prolongement (nom_statut) VALUES ('Annule');
INSERT INTO statut_prolongement (nom_statut) VALUES ('Termine');

-- LIVRE (5 livres)
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, age_requis, id_editeur, id_auteur)
VALUES (1, 'Les Miserables', '9781234567890', 'Français', 1862, 'Roman historique', 1200, 12, 1, 1);
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, age_requis, id_editeur, id_auteur)
VALUES (2, 'Germinal', '9780987654321', 'Français', 1885, 'Roman social', 600, 14, 2, 2);
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, age_requis, id_editeur, id_auteur)
VALUES (3, 'Le Comte de Monte-Cristo', '9781111111111', 'Français', 1844, 'Roman d`aventure', 1300, 13, 1, 3);
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, age_requis, id_editeur, id_auteur)
VALUES (4, 'Bel-Ami', '9782222222222', 'Français', 1885, 'Roman réaliste', 400, 15, 3, 4);
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, age_requis, id_editeur, id_auteur)
VALUES (5, 'Le Père Goriot', '9783333333333', 'Français', 1835, 'Roman réaliste', 500, 14, 2, 5);

-- ADHERANT (4 adhérants, 2 profs, 2 étudiants)
INSERT INTO adherant (id_adherant,numero_adherant, nom_adherant, prenom_adherant, password, date_naissance, id_profil)
VALUES (1,1, 'Martin', 'Paul', 'passprof1', '1980-05-10', 1);
INSERT INTO adherant (id_adherant,numero_adherant, nom_adherant, prenom_adherant, password, date_naissance, id_profil)
VALUES (2,2, 'Durand', 'Sophie', 'passprof2', '1978-11-22', 1);
INSERT INTO adherant (id_adherant,numero_adherant, nom_adherant, prenom_adherant, password, date_naissance, id_profil)
VALUES (3,3, 'Petit', 'Lucas', 'passetud1', '2002-03-15', 2);
INSERT INTO adherant (id_adherant,numero_adherant, nom_adherant, prenom_adherant, password, date_naissance, id_profil)
VALUES (4,4, 'Leroy', 'Emma', 'passetud2', '2008-07-30', 2);

-- INSCRIPTION (dates en 2025)
INSERT INTO inscription (id_inscription, date_debut, date_fin, id_adherant)
VALUES (1, '2025-01-01 00:00:00', '2025-12-31 23:59:59', 1);
INSERT INTO inscription (id_inscription, date_debut, date_fin, id_adherant)
VALUES (2, '2025-01-01 00:00:00', '2025-12-31 23:59:59', 2);
INSERT INTO inscription (id_inscription, date_debut, date_fin, id_adherant)
VALUES (3, '2025-01-01 00:00:00', '2025-12-31 23:59:59', 3);
INSERT INTO inscription (id_inscription, date_debut, date_fin, id_adherant)
VALUES (4, '2025-01-01 00:00:00', '2025-12-31 23:59:59', 4);

-- EXEMPLAIRE (3 exemplaires par livre)
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (1, 1);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (2, 1);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (3, 1);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (4, 2);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (5, 2);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (6, 2);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (7, 3);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (8, 3);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (9, 3);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (10, 4);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (11, 4);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (12, 4);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (13, 5);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (14, 5);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (15, 5);

-- CATEGORIE_LIVRE (chaque livre dans une catégorie différente pour l'exemple)
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (1, 1);
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (2, 2);
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (3, 3);
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (4, 1);
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (5, 2);

-- QUOTA_TYPE_PRET (exemple pour chaque profil/type)
INSERT INTO quota_type_pret (id_profil, id_type_pret, quota) VALUES (1, 1, 5);
INSERT INTO quota_type_pret (id_profil, id_type_pret, quota) VALUES (2, 1, 2);

-- RESTRICTION_CATEGORIE (aucune restriction pour l'exemple)
-- (si tu veux tester des restrictions, ajoute des lignes ici)

SELECT COUNT(*) FROM pret p WHERE p.id_adherant = 4 AND p.id_type_pret = 1 AND p.id_pret NOT IN (SELECT r.id_pret FROM retour r);
SELECT * FROM pret p WHERE p.id_exemplaire = 3;


-- Tu peux faire cette requête SQL pour voir quels exemplaires sont en cours :
SELECT p.*
FROM pret p
LEFT JOIN retour r ON p.id_pret = r.id_pret
LEFT JOIN fin_pret f ON p.id_pret = f.id_pret
WHERE r.id_retour IS NULL AND f.id_fin_pret IS NULL;