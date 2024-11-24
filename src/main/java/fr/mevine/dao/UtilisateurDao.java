package fr.mevine.dao;

import fr.mevine.models.Utilisateur;
import fr.mevine.models.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDao extends BaseDao<Utilisateur> {

    private final AdresseDao adresseDao = new AdresseDao();

    @Override
    protected String getTableName() {
        return "Utilisateur";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Utilisateur (uti_nom, uti_prenom, uti_tel, uti_email, adr_ID) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Utilisateur utilisateur) throws SQLException {
        pstmt.setString(1, utilisateur.getUtiNom());
        pstmt.setString(2, utilisateur.getPrenom());
        pstmt.setString(3, utilisateur.getTelephone());
        pstmt.setString(4, utilisateur.getEmail());
        pstmt.setInt(5, utilisateur.getAdresse().getId());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Utilisateur SET uti_nom = ?, uti_prenom = ?, uti_tel = ?, uti_email = ?, adr_ID = ? WHERE uti_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Utilisateur utilisateur) throws SQLException {
        pstmt.setString(1, utilisateur.getUtiNom());
        pstmt.setString(2, utilisateur.getPrenom());
        pstmt.setString(3, utilisateur.getTelephone());
        pstmt.setString(4, utilisateur.getEmail());
        pstmt.setInt(5, utilisateur.getAdresse().getId());
        pstmt.setInt(6, utilisateur.getUtiId());
    }

    @Override
    protected Utilisateur mapResultSetToEntity(ResultSet rs) throws SQLException {
        Adresse adresse = adresseDao.findById(null, rs.getInt("adr_ID")); // Connexion à passer
        return new Utilisateur(
                rs.getInt("uti_ID"),
                rs.getString("uti_nom"),
                rs.getString("uti_prenom"),
                adresse,
                rs.getString("uti_tel"),
                rs.getString("uti_email")
        );
    }
}

