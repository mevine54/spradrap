package fr.mevine.dao;

import fr.mevine.models.Ordonnance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdonnanceDao extends BaseDao<Ordonnance> {

    @Override
    protected String getTableName() {
        return "Ordonnance";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Ordonnance (ord_date, med_ID, cli_ID, spe_ID) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Ordonnance ordonnance) throws SQLException {
        pstmt.setDate(1, java.sql.Date.valueOf(ordonnance.getDate()));
        pstmt.setInt(2, ordonnance.getMedecin().getId());
        pstmt.setInt(3, ordonnance.getPatient().getId());
        pstmt.setInt(4, ordonnance.getSpecialiste() != null ? ordonnance.getSpecialiste().getId() : null);
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Ordonnance SET ord_date = ?, med_ID = ?, cli_ID = ?, spe_ID = ? WHERE ord_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Ordonnance ordonnance) throws SQLException {
        pstmt.setDate(1, java.sql.Date.valueOf(ordonnance.getDate()));
        pstmt.setInt(2, ordonnance.getMedecin().getId());
        pstmt.setInt(3, ordonnance.getClient().getCliId());
        pstmt.setInt(4, ordonnance.getSpecialiste() != null ? ordonnance.getSpecialiste().getId() : null);
        pstmt.setInt(5, ordonnance.getId());
    }

    @Override
    protected Ordonnance mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Ordonnance(
                rs.getInt("ord_ID"),
                rs.getDate("ord_date").toLocalDate(),
                null, // Implémentation nécessaire pour Medecin
                null, // Implémentation nécessaire pour Client
                null  // Implémentation nécessaire pour Specialiste
        );
    }
}

