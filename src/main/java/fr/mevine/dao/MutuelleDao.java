package fr.mevine.dao;

import fr.mevine.models.Mutuelle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MutuelleDao extends BaseDao<Mutuelle> {

    @Override
    protected String getTableName() {
        return "Mutuelle";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Mutuelle (mut_nom, mut_taux_prise_en_charge) VALUES (?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Mutuelle mutuelle) throws SQLException {
        pstmt.setString(1, mutuelle.getNom());
        pstmt.setDouble(2, mutuelle.getTauxPriseEnCharge());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Mutuelle SET mut_nom = ?, mut_taux_prise_en_charge = ? WHERE mut_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Mutuelle mutuelle) throws SQLException {
        pstmt.setString(1, mutuelle.getNom());
        pstmt.setDouble(2, mutuelle.getTauxPriseEnCharge());
        pstmt.setInt(3, mutuelle.getId());
    }

    @Override
    protected Mutuelle mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Mutuelle(
                rs.getInt("mut_ID"),
                rs.getString("mut_nom"),
                rs.getDouble("mut_taux_prise_en_charge")
        );
    }
}

