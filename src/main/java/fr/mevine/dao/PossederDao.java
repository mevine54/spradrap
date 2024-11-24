package fr.mevine.dao;

import fr.mevine.models.Posseder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PossederDao extends BaseDao<Posseder> {

    @Override
    protected String getTableName() {
        return "Posseder";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Posseder (cli_ID, med_ID, quantite) VALUES (?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(PreparedStatement pstmt, Posseder posseder) throws SQLException {
        pstmt.setInt(1, posseder.getCliId());
        pstmt.setInt(2, posseder.getMedicamentId());
        pstmt.setInt(3, posseder.getQuantite());
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Posseder SET quantite = ? WHERE cli_ID = ? AND med_ID = ?";
    }

    @Override
    protected void setUpdateParameters(PreparedStatement pstmt, Posseder posseder) throws SQLException {
        pstmt.setInt(1, posseder.getQuantite());
        pstmt.setInt(2, posseder.getCliId());
        pstmt.setInt(3, posseder.getMedicamentId());
    }

    @Override
    protected Posseder mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Posseder(
                rs.getInt("cli_ID"),
                rs.getInt("med_ID"),
                rs.getInt("quantite")
        );
    }
}

