-- Table auteur
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (1, 'Hugo', 'Victor');
INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES (2, 'Zola', 'Emile');

-- Table editeur
INSERT INTO editeur (id_editeur, nom_editeur, localisation) VALUES (1, 'Gallimard', 'Paris');
INSERT INTO editeur (id_editeur, nom_editeur, localisation) VALUES (2, 'Flammarion', 'Lyon');

-- Table categorie
INSERT INTO categorie (id_categorie, nom_categorie) VALUES (1, 'Roman');
INSERT INTO categorie (id_categorie, nom_categorie) VALUES (2, 'Essai');

-- Table profil
INSERT INTO profil (id_profil, nom_profil, quota_pret, quota_reservation) VALUES (1, 'Etudiant', 5, 2);
INSERT INTO profil (id_profil, nom_profil, quota_pret, quota_reservation) VALUES (2, 'Professeur', 10, 5);

-- Table admin
INSERT INTO admin (id_admin, nom_admin, prenom_admin, password) VALUES (1, 'Martin', 'Paul', 'admin123');
INSERT INTO admin (id_admin, nom_admin, prenom_admin, password) VALUES (2, 'Durand', 'Sophie', 'admin456');

-- Table type_pret
INSERT INTO type_pret (id_type_pret, type) VALUES (1, 'Normal');
INSERT INTO type_pret (id_type_pret, type) VALUES (2, 'Longue durée');

-- Table duree_pret
INSERT INTO duree_pret (id_duree_pret, duree, id_profil) VALUES (1, 15, 1);
INSERT INTO duree_pret (id_duree_pret, duree, id_profil) VALUES (2, 30, 2);

-- Table inscription_profil
INSERT INTO inscription_profil (id_inscri_profil, duree, id_profil) VALUES (1, 365, 1);
INSERT INTO inscription_profil (id_inscri_profil, duree, id_profil) VALUES (2, 730, 2);

-- Table statut_reservation
INSERT INTO statut_reservation (id_statut, nom_statut) VALUES (1, 'En attente');
INSERT INTO statut_reservation (id_statut, nom_statut) VALUES (2, 'Validée');

-- Table livre
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, id_editeur, id_auteur) VALUES (1, 'Les Misérables', '9781234567890', 'Français', 1862, 'Roman historique', 1200, 1, 1);
INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, id_editeur, id_auteur) VALUES (2, 'Germinal', '9780987654321', 'Français', 1885, 'Roman social', 600, 2, 2);

-- Table adherant
INSERT INTO adherant (id_adherant, nom_adherant, prenom_adherant, password, id_profil) VALUES (1, 'Dupont', 'Jean', 'pass123', 1);
INSERT INTO adherant (id_adherant, nom_adherant, prenom_adherant, password, id_profil) VALUES (2, 'Lefevre', 'Marie', 'pass456', 2);

-- Table inscription
INSERT INTO inscription (id_inscription, date_inscription, etat, id_adherant) VALUES (1, '2024-01-01 10:00:00', TRUE, 1);
INSERT INTO inscription (id_inscription, date_inscription, etat, id_adherant) VALUES (2, '2024-02-01 11:00:00', TRUE, 2);

-- Table exemplaire
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (1, 1);
INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES (2, 2);

-- Table pret
INSERT INTO pret (id_pret, date_debut, id_admin, id_type_pret, id_exemplaire, id_adherant) VALUES (1, '2024-06-01 09:00:00', 1, 1, 1, 1);
INSERT INTO pret (id_pret, date_debut, id_admin, id_type_pret, id_exemplaire, id_adherant) VALUES (2, '2024-06-02 10:00:00', 2, 2, 2, 2);

-- Table reservation
INSERT INTO reservation (id_reservation, date_de_reservation, id_admin, id_statut, id_exemplaire, id_adherant) VALUES (1, '2024-06-10 14:00:00', 1, 1, 1, 1);
INSERT INTO reservation (id_reservation, date_de_reservation, id_admin, id_statut, id_exemplaire, id_adherant) VALUES (2, '2024-06-11 15:00:00', 2, 2, 2, 2);

-- Table fin_pret
INSERT INTO fin_pret (id_fin_pret, date_fin, id_pret) VALUES (1, '2024-06-15 09:00:00', 1);
INSERT INTO fin_pret (id_fin_pret, date_fin, id_pret) VALUES (2, '2024-06-16 10:00:00', 2);

-- Table categorie_livre
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (1, 1);
INSERT INTO categorie_livre (id_livre, id_categorie) VALUES (2, 2);

-- Table quota_type_pret
INSERT INTO quota_type_pret (id_profil, id_type_pret, quota) VALUES (1, 1, 3);
INSERT INTO quota_type_pret (id_profil, id_type_pret, quota) VALUES (2, 2, 5);