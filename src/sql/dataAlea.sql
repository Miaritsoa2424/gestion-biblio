INSERT INTO auteur (id_auteur, nom_auteur, prenom_auteur) VALUES
(1, 'Hugo', 'Victor'),
(2, 'Camus', 'Albert'),
(3, 'Rowling', 'J.K.');

INSERT INTO categorie (id_categorie, nom_categorie) VALUES
(1, 'Littérature classique'),
(2, 'Philosophie'),
(3, 'Jeunesse'),
(4, 'Fantastique');

INSERT INTO editeur (id_editeur, nom_editeur, localisation) VALUES
(1, 'Gallimard', 'Paris');


INSERT INTO livre (id_livre, titre, isbn, langue, annee_publication, synopsis, nb_page, age_requis, id_editeur, id_auteur) VALUES
(1, 'Les Misérables', '9782070409189', 'Français', 1862, 'Roman historique de Victor Hugo.', 1488, 12, 1, 1),
(2, 'LÉtranger', '9782070360022', 'Français', 1942, 'Roman philosophique dAlbert Camus.', 123, 15, 1, 2),
(3, 'Harry Potter à lécole des sorciers', '9782070643026', 'Français', 1997, 'Premier tome de la série Harry Potter.', 309, 10, 1, 3);

INSERT INTO categorie_livre (id_livre, id_categorie) VALUES
(1, 1),
(2, 2),
(3, 3),
(3, 4);

INSERT INTO exemplaire (id_exemplaire, id_livre) VALUES
(1, 1),  -- MIS001
(2, 1),  -- MIS002
(3, 1),  -- MIS003
(4, 2),  -- ETR001
(5, 2),  -- ETR002
(6, 3);  -- HAR001

INSERT INTO profil (id_profil, nom_profil, quota_penalite, quota_reservation) VALUES
(1, 'Etudiant', 2, 1),
(2, 'Enseignant', 3, 2),
(3, 'Professionnel', 4, 3);


INSERT INTO adherant (id_adherant, nom_adherant, prenom_adherant, password, date_naissance, id_profil) VALUES
(1, 'Bensaïd', 'Amine', '1234', '2000-01-01', 1),
(2, 'El Khattabi', 'Sarah', '1234', '2000-01-01', 1),
(3, 'Moujahid', 'Youssef', '1234', '2000-01-01', 1),
(4, 'Benali', 'Nadia', '1234', '1980-01-01', 2),
(5, 'Haddadi', 'Karim', '1234', '1980-01-01', 2),
(6, 'Touhami', 'Salima', '1234', '1980-01-01', 2),
(7, 'El Mansouri', 'Rachid', '1234', '1975-01-01', 3),
(8, 'Zerouali', 'Amina', '1234', '1975-01-01', 3);

INSERT INTO inscription (id_inscription, date_debut, date_fin, id_adherant) VALUES
(1, '2025-02-01', '2025-07-24', 1),
(2, '2025-02-01', '2025-07-01', 2),
(3, '2025-04-01', '2025-12-01', 3),
(4, '2025-07-01', '2026-07-01', 4),
(5, '2025-08-01', '2026-05-01', 5),
(6, '2025-07-01', '2026-06-01', 6),
(7, '2025-06-01', '2025-12-01', 7),
(8, '2024-10-01', '2025-06-01', 8);

INSERT INTO quota_prolongement (quota, id_profil) VALUES
(3, 1),
(5, 2),
(7, 3);

-- TYPE_PRET
INSERT INTO type_pret (id_type_pret, type) VALUES (1, 'A domicile');

-- On suppose que id_type_pret = 1 (par exemple : prêt standard)
INSERT INTO quota_type_pret (id_profil, id_type_pret, quota) VALUES
(1, 1, 7),  -- Etudiant
(2, 1, 9),  -- Enseignant
(3, 1, 12); -- Professionnel

INSERT INTO duree_pret (id_duree_pret, duree, id_profil) VALUES
(1, 7, 1),
(2, 9, 2),
(3, 12, 3);

-- ADMIN
INSERT INTO admin (id_admin, nom_admin, prenom_admin, password) VALUES (1, 'Dupont', 'Jean', 'admin1');

INSERT INTO jours_ferie (jour) VALUES
('2025-07-13'),
('2025-07-26'),
('2025-07-20'),
('2025-07-19'),
('2025-07-27'),
('2025-08-03'),
('2025-08-10'),
('2025-08-17');

INSERT INTO penalite_quota (id_profil, duree) VALUES
(1 10),
(2, 9),
(3, 8);







