package fr.mevine.dao;

import fr.mevine.models.Medecin;
import fr.mevine.models.Adresse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedecinDao extends BaseDao<Medecin> {

    private final AdresseDao adresseDao = new AdresseDao();
    private final UtilisateurDao utilisateurDao = new UtilisateurDao();

    @Override
    protected String getTableName() {
        return "Medecin";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Medecin (uti_ID, med_num_agrement) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Medecin medecin) throws SQLException {
        pstmt.setInt(1, medecin.getUtiId());
        pstmt.setString(2, medecin.getNumeroAgrement());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Medecin SET med_num_agrement = ? WHERE uti_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Medecin medecin) throws SQLException {
        pstmt.setString(1, medecin.getNumeroAgrement());
        pstmt.setInt(2, medecin.getUtiId());
    }

    @Override
    protected Medecin mapResultSetToEntity(ResultSet rs) throws SQLException {
        Adresse adresse = adresseDao.findById(null, rs.getInt("adr_ID"));
        return new Medecin(
                rs.getInt("uti_ID"),
                rs.getString("uti_nom"),
                rs.getString("uti_prenom"),
                rs.getString("uti_tel"),
                rs.getString("uti_email"),
                adresse,
                rs.getString("med_num_agrement")
        );
    }
}
