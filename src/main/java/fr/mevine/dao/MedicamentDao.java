package fr.mevine.dao;

import fr.mevine.models.Medicament;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentDao extends BaseDao<Medicament> {

    @Override
    protected String getTableName() {
        return "Medicament";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Medicament (med_nom, med_prix, typ_med_ID) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Medicament medicament) throws SQLException {
        pstmt.setString(1, medicament.getNom());
        pstmt.setDouble(2, medicament.getPrix());
        pstmt.setInt(3, medicament.getMediId());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Medicament SET med_nom = ?, med_prix = ?, typ_med_ID = ? WHERE med_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Medicament medicament) throws SQLException {
        pstmt.setString(1, medicament.getNom());
        pstmt.setDouble(2, medicament.getPrix());
        pstmt.setInt(3, medicament.getMediId());
        pstmt.setInt(4, medicament.getMediId());
    }

    @Override
    protected Medicament mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Medicament(
                rs.getInt("medi_ID"),
                rs.getString("medi_nom"),
                rs.getDouble("medi_prix"),
                rs.getInt("typ_med_ID")
        );
    }
}
