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
        return "INSERT INTO Mutuelle (mut_id, mut_nom, mut_taux_prise_en_charge) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Mutuelle mutuelle) throws SQLException {
        pstmt.setString(1, mutuelle.getMutNom());
        pstmt.setDouble(2, mutuelle.getMutTauxPriseEnCharge());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Mutuelle SET mut_nom = ?, mut_taux_prise_en_charge = ? WHERE mut_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Mutuelle mutuelle) throws SQLException {
        pstmt.setString(1, mutuelle.getMutNom());
        pstmt.setDouble(2, mutuelle.getMutTauxPriseEnCharge());
        pstmt.setInt(3, mutuelle.getMutId());
    }

    @Override
    protected Mutuelle mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Mutuelle(
                rs.getInt("mut_ID"),
                rs.getDouble("mut_taux_prise_en_charge"),
                rs.getString("mut_nom"),
                rs.getInt("adr_id"),
                rs.getString("mut_tel")
        );
    }
}

