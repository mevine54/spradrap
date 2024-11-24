package fr.mevine.dao;

import fr.mevine.models.Specialiste;
import fr.mevine.models.Adresse;
import fr.mevine.enums.TypeSpecialite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialisteDao extends BaseDao<Specialiste> {

    private final AdresseDao adresseDao = new AdresseDao(); // Pour gérer l'adresse associée

    @Override
    protected String getTableName() {
        return "Specialiste";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Specialiste (uti_ID, spe_specialite) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Specialiste specialiste) throws SQLException {
        pstmt.setInt(1, specialiste.getUtiId()); // ID de l'utilisateur (héritage de Utilisateur)
        pstmt.setString(2, specialiste.getTypeSpecialite().name()); // Nom de la spécialité
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Specialiste SET spe_specialite = ? WHERE uti_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Specialiste specialiste) throws SQLException {
        pstmt.setString(1, specialiste.getTypeSpecialite().name());
        pstmt.setInt(2, specialiste.getUtiId());
    }

    @Override
    protected Specialiste mapResultSetToEntity(ResultSet rs) throws SQLException {
        // Récupérer les données d'Utilisateur via la table Adresse
        Adresse adresse = adresseDao.findById(null, rs.getInt("adr_ID")); // Récupération de l'adresse
        return new Specialiste(
                rs.getInt("uti_ID"), // ID du spécialiste
                rs.getString("uti_nom"), // Nom
                rs.getString("uti_prenom"), // Prénom
                rs.getString("uti_tel"), // Téléphone
                rs.getString("uti_email"), // Email
                adresse, // Adresse (via AdresseDao)
                TypeSpecialite.valueOf(rs.getString("spe_specialite")) // Spécialité
        );
    }
}
