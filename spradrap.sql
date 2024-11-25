SET FOREIGN_KEY_CHECKS = 1;
-- Création de la base de données
CREATE DATABASE spradrap;
USE spradrap;

-- Table Adresse
CREATE TABLE Adresse (
    adr_ID INT AUTO_INCREMENT PRIMARY KEY,
    adr_rue VARCHAR(30),
    adr_code_postal CHAR(5),
    adr_ville VARCHAR(40)
);

-- Table Client
CREATE TABLE Client (
    cli_ID INT AUTO_INCREMENT PRIMARY KEY,
    uti_ID INT,
    cli_num_secu_social CHAR(15),
    cli_date_naissance DATE,
    adr_ID INT,
    mut_ID INT,
    med_ID INT,
    FOREIGN KEY (uti_ID) REFERENCES Utilisateur(uti_ID),
    FOREIGN KEY (adr_ID) REFERENCES Adresse(adr_ID),
    FOREIGN KEY (mut_ID) REFERENCES Mutuelle(mut_ID),
    FOREIGN KEY (med_ID) REFERENCES Medecin(med_ID)
);

SELECT c.cli_id AS client_id, u.uti_id AS utilisateur_id, c.cli_num_secu_social, c.cli_date_naissance, a.adr_id AS adresse_id, mu.mut_id AS mutuelle_id, med.med_id AS medecin_id, u.uti_nom AS utilisateur_nom, u.uti_prenom, u.uti_tel, u.uti_email
FROM utilisateur u
JOIN client c ON u.uti_id = c.uti_id
JOIN adresse a ON c.adr_id = a.adr_id
JOIN mutuelle mu ON c.mut_id = mu.mut_id
JOIN medecin med ON c.med_id = c.med_id;

select * from client;



-- Table Medecin
CREATE TABLE Medecin (
    med_ID INT AUTO_INCREMENT PRIMARY KEY,
    med_num_agreement CHAR(18),
    adr_ID INT,
    FOREIGN KEY (adr_ID) REFERENCES Adresse(adr_ID)
);

-- Table Medicament
CREATE TABLE Medicament (
    medi_ID INT AUTO_INCREMENT PRIMARY KEY,
    medi_nom VARCHAR(30),
    medi_prix DECIMAL(4,2),
    medi_date_mise_service DATE,
    medi_quantite INT
);

-- Table Mutuelle
CREATE TABLE Mutuelle (
    mut_ID INT AUTO_INCREMENT PRIMARY KEY,
    mut_nom VARCHAR(30),
    mut_tel CHAR(14),
    mut_email VARCHAR(50),
    mut_departement CHAR(3),
    mut_taux_prise_en_charge SMALLINT
);

-- Table Ordonnance
CREATE TABLE Ordonnance (
    ord_ID INT AUTO_INCREMENT PRIMARY KEY,
    ord_date DATE,
    ord_nom_client VARCHAR(30),
    ord_nom_medecin VARCHAR(30),
    ord_nom_specialiste VARCHAR(30)
);

-- Table Specialiste
CREATE TABLE Specialiste (
    spe_ID INT AUTO_INCREMENT PRIMARY KEY,
    spe_nom VARCHAR(30),
    spe_type ENUM('cardiologue', 'dermatologue', 'ophtalmologue', 'generaliste', 'orl')
);

-- Table Utilisateur
CREATE TABLE Utilisateur (
    uti_ID INT AUTO_INCREMENT PRIMARY KEY,
    uti_nom VARCHAR(30),
    uti_prenom VARCHAR(30),
    uti_tel CHAR(14),
    uti_email VARCHAR(50)
);

-- Table Achat
CREATE TABLE Achat (
    ach_ID INT AUTO_INCREMENT PRIMARY KEY,
    type_achat ENUM('direct', 'ordonnance')
);

-- Table TypeMedicament
CREATE TABLE TypeMedicament (
    type_med_ID INT AUTO_INCREMENT PRIMARY KEY,
    type_med_nom VARCHAR(50)
);

-- Table TypeSpecialite
CREATE TABLE TypeSpecialite (
    type_spe_ID INT AUTO_INCREMENT PRIMARY KEY,
    type_spe_nom VARCHAR(50)
);

-- Relations (associations du MCD)
-- Relation "Posseder" entre Client et Mutuelle
CREATE TABLE Posseder (
    uti_ID INT NOT NULL,        -- Clé étrangère vers Utilisateur
    adr_ID INT NOT NULL,        -- Clé étrangère vers Adresse
    PRIMARY KEY (uti_ID, adr_ID), -- Clé primaire composite
    FOREIGN KEY (uti_ID) REFERENCES Utilisateur(uti_ID),
    FOREIGN KEY (adr_ID) REFERENCES Adresse(adr_ID)
);

-- Relation "Delivrer" entre Ordonnance et Medicament
CREATE TABLE Delivrer (
    ord_ID INT,
    medi_ID INT,
    PRIMARY KEY (ord_ID, medi_ID),
    FOREIGN KEY (ord_ID) REFERENCES Ordonnance(ord_ID),
    FOREIGN KEY (medi_ID) REFERENCES Medicament(medi_ID)
);

-- Relation "Fournir" entre Specialiste et TypeSpecialite
CREATE TABLE Fournir (
    spe_ID INT,
    type_spe_ID INT,
    PRIMARY KEY (spe_ID, type_spe_ID),
    FOREIGN KEY (spe_ID) REFERENCES Specialiste(spe_ID),
    FOREIGN KEY (type_spe_ID) REFERENCES TypeSpecialite(type_spe_ID)
);

-- Relation "Effectuer" entre Client et Achat
CREATE TABLE Effectuer (
    cli_ID INT,
    ach_ID INT,
    PRIMARY KEY (cli_ID, ach_ID),
    FOREIGN KEY (cli_ID) REFERENCES Client(cli_ID),
    FOREIGN KEY (ach_ID) REFERENCES Achat(ach_ID)
);

-- Relation "Adherer" entre Medecin et Mutuelle
CREATE TABLE Adherer (
    med_ID INT,
    mut_ID INT,
    PRIMARY KEY (med_ID, mut_ID),
    FOREIGN KEY (med_ID) REFERENCES Medecin(med_ID),
    FOREIGN KEY (mut_ID) REFERENCES Mutuelle(mut_ID)
);

-- Insérer dans Adresse
INSERT INTO Adresse (adr_rue, adr_code_postal, adr_ville) 
VALUES ('1 rue de Paris', '75001', 'Paris');

-- Insérer dans Client
INSERT INTO Client (cli_num_secu_social, cli_date_naissance, adr_ID) 
VALUES ('123456789012345', '1985-05-20', 1);

-- Insérer dans Medecin
INSERT INTO Medecin (med_num_agreement, adr_ID) 
VALUES ('AGREE123456', 1);

-- Insérer dans Medicament
INSERT INTO Medicament (medi_nom, medi_prix, medi_date_mise_service, medi_quantite) 
VALUES ('Doliprane', 2.50, '2022-01-01', 100);

-- Insérer dans Mutuelle
INSERT INTO Mutuelle (mut_nom, mut_tel, mut_email, mut_departement, mut_taux_prise_en_charge) 
VALUES ('Mutuelle Santé', '0123456789', 'contact@mutuellesante.com', '75', 70);

-- Insérer dans Ordonnance
INSERT INTO Ordonnance (ord_date, ord_nom_client, ord_nom_medecin, ord_nom_specialiste) 
VALUES ('2024-11-25', 'Jean Dupont', 'Dr Martin', 'Dr Durand');

-- Insérer dans Specialiste
INSERT INTO Specialiste (spe_nom, spe_type) 
VALUES ('Dr Durand', 'cardiologue');

-- Insérer dans Utilisateur
INSERT INTO Utilisateur (uti_nom, uti_prenom, uti_tel, uti_email) 
VALUES ('Admin', 'System', '0123456789', 'admin@system.com');

-- Insérer dans Achat
INSERT INTO Achat (type_achat) 
VALUES ('direct');

-- Insérer dans TypeMedicament
INSERT INTO TypeMedicament (type_med_nom) 
VALUES ('Antalgique');

-- Insérer dans TypeSpecialite
INSERT INTO TypeSpecialite (type_spe_nom) 
VALUES ('Cardiologie');

-- Insérer dans relations
-- Relation Posseder (Client - Mutuelle)
INSERT INTO Posseder (uti_ID, adr_ID) 
VALUES (1, 1);

-- Relation Delivrer (Ordonnance - Medicament)
INSERT INTO Delivrer (ord_ID, medi_ID) 
VALUES (1, 1);

-- Relation Fournir (Specialiste - TypeSpecialite)
INSERT INTO Fournir (spe_ID, type_spe_ID) 
VALUES (1, 1);

-- Relation Effectuer (Client - Achat)
INSERT INTO Effectuer (cli_ID, ach_ID) 
VALUES (1, 1);

-- Relation Adherer (Medecin - Mutuelle)
INSERT INTO Adherer (med_ID, mut_ID) 
VALUES (1, 1);


SELECT * FROM spradrap.Posseder;


