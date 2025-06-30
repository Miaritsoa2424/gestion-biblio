CREATE TABLE auteur(
   id_auteur INT,
   nom_auteur VARCHAR(50) NOT NULL,
   prenom_auteur VARCHAR(50),
   PRIMARY KEY(id_auteur)
);

CREATE TABLE editeur(
   id_editeur INT,
   nom_editeur VARCHAR(50),
   localisation VARCHAR(50),
   PRIMARY KEY(id_editeur)
);

CREATE TABLE categorie(
   id_categorie INT,
   nom_categorie INT NOT NULL,
   PRIMARY KEY(id_categorie)
);

CREATE TABLE profil(
   id_profil INT,
   nom_profil INT NOT NULL,
   quota_pret INT,
   quota_reservation INT,
   PRIMARY KEY(id_profil)
);

CREATE TABLE admin(
   id_admin INT,
   nom_admin VARCHAR(50),
   prenom_admin VARCHAR(50),
   password VARCHAR(50),
   PRIMARY KEY(id_admin)
);

CREATE TABLE type_pret(
   id_type_pret INT,
   type VARCHAR(50),
   PRIMARY KEY(id_type_pret)
);

CREATE TABLE duree_pret(
   id_duree_pret INT,
   duree INT,
   id_profil INT NOT NULL,
   PRIMARY KEY(id_duree_pret),
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
);

CREATE TABLE inscription_profil(
   id_inscri_profil INT,
   duree INT,
   id_profil INT NOT NULL,
   PRIMARY KEY(id_inscri_profil),
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
);

CREATE TABLE statut_reservation(
   id_statut INT,
   nom_statut VARCHAR(50),
   PRIMARY KEY(id_statut)
);

CREATE TABLE livre(
   id_livre INT,
   titre VARCHAR(50),
   isbn VARCHAR(50),
   langue VARCHAR(50),
   annee_publication INT,
   synopsis VARCHAR(1000),
   nb_page INT,
   id_editeur INT NOT NULL,
   id_auteur INT NOT NULL,
   PRIMARY KEY(id_livre),
   FOREIGN KEY(id_editeur) REFERENCES editeur(id_editeur),
   FOREIGN KEY(id_auteur) REFERENCES auteur(id_auteur)
);

CREATE TABLE adherant(
   id_adherant INT,
   nom_adherant VARCHAR(50),
   prenom_adherant VARCHAR(50),
   password VARCHAR(50),
   id_profil INT NOT NULL,
   PRIMARY KEY(id_adherant),
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil)
);

CREATE TABLE inscription(
   id_inscription INT,
   date_inscription DATETIME,
   etat LOGICAL,
   id_adherant INT NOT NULL,
   PRIMARY KEY(id_inscription),
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
);

CREATE TABLE penalite(
   id_penalite INT,
   duree INT,
   date_penalite DATETIME,
   id_adherant INT NOT NULL,
   PRIMARY KEY(id_penalite),
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
);

CREATE TABLE exemplaire(
   id_exemplaire INT,
   dispo LOGICAL,
   id_livre INT NOT NULL,
   PRIMARY KEY(id_exemplaire),
   FOREIGN KEY(id_livre) REFERENCES livre(id_livre)
);

CREATE TABLE pret(
   id_pret INT,
   date_debut DATETIME,
   id_admin INT NOT NULL,
   id_type_pret INT NOT NULL,
   id_exemplaire INT NOT NULL,
   id_adherant INT NOT NULL,
   PRIMARY KEY(id_pret),
   FOREIGN KEY(id_admin) REFERENCES admin(id_admin),
   FOREIGN KEY(id_type_pret) REFERENCES type_pret(id_type_pret),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id_exemplaire),
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
);

CREATE TABLE reservation(
   id_reservation INT,
   date_de_reservation DATETIME,
   id_admin INT NOT NULL,
   id_statut INT NOT NULL,
   id_exemplaire INT NOT NULL,
   id_adherant INT NOT NULL,
   PRIMARY KEY(id_reservation),
   FOREIGN KEY(id_admin) REFERENCES admin(id_admin),
   FOREIGN KEY(id_statut) REFERENCES statut_reservation(id_statut),
   FOREIGN KEY(id_exemplaire) REFERENCES exemplaire(id_exemplaire),
   FOREIGN KEY(id_adherant) REFERENCES adherant(id_adherant)
);

CREATE TABLE fin_pret(
   id_fin_pret INT,
   date_fin DATETIME,
   id_pret INT NOT NULL,
   PRIMARY KEY(id_fin_pret),
   FOREIGN KEY(id_pret) REFERENCES pret(id_pret)
);

CREATE TABLE categorie_livre(
   id_livre INT,
   id_categorie INT,
   PRIMARY KEY(id_livre, id_categorie),
   FOREIGN KEY(id_livre) REFERENCES livre(id_livre),
   FOREIGN KEY(id_categorie) REFERENCES categorie(id_categorie)
);

CREATE TABLE quota_type_pret(
   id_profil INT,
   id_type_pret INT,
   quota INT,
   PRIMARY KEY(id_profil, id_type_pret),
   FOREIGN KEY(id_profil) REFERENCES profil(id_profil),
   FOREIGN KEY(id_type_pret) REFERENCES type_pret(id_type_pret)
);
