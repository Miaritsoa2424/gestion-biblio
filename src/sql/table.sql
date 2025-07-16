-- Base de données pour le système de gestion de bibliothèque

CREATE TABLE auteur (
   id_auteur INT AUTO_INCREMENT PRIMARY KEY,
   nom_auteur VARCHAR(50) NOT NULL,
   prenom_auteur VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE editeur (
   id_editeur INT AUTO_INCREMENT PRIMARY KEY,
   nom_editeur VARCHAR(50),
   localisation VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE categorie (
   id_categorie INT AUTO_INCREMENT PRIMARY KEY,
   nom_categorie VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE profil (
   id_profil INT AUTO_INCREMENT PRIMARY KEY,
   nom_profil VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE admin (
   id_admin INT AUTO_INCREMENT PRIMARY KEY,
   nom_admin VARCHAR(50),
   prenom_admin VARCHAR(50),
   password VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE type_pret (
   id_type_pret INT AUTO_INCREMENT PRIMARY KEY,
   type VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE duree_pret (
   id_duree_pret INT AUTO_INCREMENT PRIMARY KEY,
   duree INT,
   id_profil INT NOT NULL,
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
) ENGINE=InnoDB;

CREATE TABLE statut_reservation (
   id_statut_reservation INT AUTO_INCREMENT PRIMARY KEY,
   nom_statut VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE statut_prolongement (
   id_statut_prolongement INT AUTO_INCREMENT PRIMARY KEY,
   nom_statut VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE quota_prolongement (
   id_quota_prolongement INT AUTO_INCREMENT PRIMARY KEY,
   quota INT,
   id_profil INT NOT NULL,
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
) ENGINE=InnoDB;

CREATE TABLE livre (
   id_livre INT AUTO_INCREMENT PRIMARY KEY,
   titre VARCHAR(50),
   isbn VARCHAR(50),
   langue VARCHAR(50),
   annee_publication INT,
   synopsis VARCHAR(1000),
   nb_page INT,
   age_requis INT,
   id_editeur INT NOT NULL,
   id_auteur INT NOT NULL,
   FOREIGN KEY(id_editeur) REFERENCES editeur(id_editeur),
   FOREIGN KEY(id_auteur) REFERENCES auteur(id_auteur)
) ENGINE=InnoDB;

CREATE TABLE adherant (
   id_adherant INT AUTO_INCREMENT PRIMARY KEY,
   nom_adherant VARCHAR(50),
   numero_adherant INT,
   prenom_adherant VARCHAR(50),
   password VARCHAR(50),
   date_naissance DATE,
   id_profil INT NOT NULL,
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
) ENGINE=InnoDB;

CREATE TABLE inscription (
   id_inscription INT AUTO_INCREMENT PRIMARY KEY,
   date_debut DATETIME,
   date_fin DATETIME,
   id_adherant INT NOT NULL,
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
) ENGINE=InnoDB;

CREATE TABLE penalite (
   id_penalite INT AUTO_INCREMENT PRIMARY KEY,
   duree INT,
   date_penalite DATETIME,
   id_adherant INT NOT NULL,
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
) ENGINE=InnoDB;

CREATE TABLE exemplaire (
   id_exemplaire INT AUTO_INCREMENT PRIMARY KEY,
   id_livre INT NOT NULL,
   FOREIGN KEY(id_livre) REFERENCES livre(id_livre)
) ENGINE=InnoDB;

CREATE TABLE pret (
   id_pret INT AUTO_INCREMENT PRIMARY KEY,
   date_debut DATETIME,
   id_admin INT NOT NULL,
   id_type_pret INT NOT NULL,
   id_exemplaire INT NOT NULL,
   id_adherant INT NOT NULL,
   FOREIGN KEY(id_admin) REFERENCES admin(id_admin),
   FOREIGN KEY(id_type_pret) REFERENCES type_pret(id_type_pret),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id_exemplaire),
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
) ENGINE=InnoDB;

CREATE TABLE reservation (
   id_reservation INT AUTO_INCREMENT PRIMARY KEY,
   date_de_reservation DATETIME,
   id_admin INT NOT NULL,
   id_exemplaire INT NOT NULL,
   id_adherant INT NOT NULL,
   FOREIGN KEY(id_admin) REFERENCES admin(id_admin),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id_exemplaire),
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
) ENGINE=InnoDB;

CREATE TABLE fin_pret (
   id_fin_pret INT AUTO_INCREMENT PRIMARY KEY,
   date_fin DATETIME,
   id_pret INT NOT NULL,
   FOREIGN KEY(id_pret) REFERENCES pret(id_pret)
) ENGINE=InnoDB;

CREATE TABLE retour (
   id_retour INT AUTO_INCREMENT PRIMARY KEY,
   date_retour DATETIME,
   id_pret INT NOT NULL,
   FOREIGN KEY(id_pret) REFERENCES pret(id_pret)
) ENGINE=InnoDB;

CREATE TABLE prolongement (
   id_prolongement INT AUTO_INCREMENT PRIMARY KEY,
   date_fin DATETIME,
   id_pret INT NOT NULL,
   FOREIGN KEY(id_pret) REFERENCES pret(id_pret)
) ENGINE=InnoDB;

CREATE TABLE categorie_livre (
   id_livre INT,
   id_categorie INT,
   PRIMARY KEY(id_livre, id_categorie),
   FOREIGN KEY(id_livre) REFERENCES livre(id_livre),
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie)
) ENGINE=InnoDB;

CREATE TABLE quota_type_pret (
   id_profil INT,
   id_type_pret INT,
   quota INT,
   PRIMARY KEY(id_profil, id_type_pret),
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil),
   FOREIGN KEY(id_type_pret) REFERENCES type_pret(id_type_pret)
) ENGINE=InnoDB;

CREATE TABLE reservation_statut (
   id_reservation INT,
   id_statut_reservation INT,
   PRIMARY KEY(id_reservation, id_statut_reservation),
   FOREIGN KEY(id_reservation) REFERENCES reservation(id_reservation),
   FOREIGN KEY(id_statut_reservation) REFERENCES statut_reservation(id_statut_reservation)
) ENGINE=InnoDB;

CREATE TABLE restriction_categorie (
   id_categorie INT,
   id_profil INT,
   PRIMARY KEY(id_categorie, id_profil),
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie),
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
) ENGINE=InnoDB;

CREATE TABLE prolongement_statut (
   id_prolongement INT,
   id_statut_prolongement INT,
   PRIMARY KEY(id_prolongement, id_statut_prolongement),
   FOREIGN KEY(id_prolongement) REFERENCES prolongement(id_prolongement),
   FOREIGN KEY(id_statut_prolongement) REFERENCES statut_prolongement(id_statut_prolongement)
) ENGINE=InnoDB;
