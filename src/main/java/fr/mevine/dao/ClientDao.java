package fr.mevine.dao;

import fr.mevine.models.Client;
import fr.mevine.models.Adresse;

import java.sql.*;
import java.util.List;

import static fr.mevine.utilities.Singleton.getConnection;

public class ClientDao extends BaseDao<Client> {
    private AdresseDao adresseDao = new AdresseDao();
    private MutuelleDao mutuelleDao = new MutuelleDao();
    private MedecinDao medecinDao = new MedecinDao();


    @Override
    public Client create(Client obj) {
        // code SQL - JAVA
        String sql = "INSERT INTO client (uti_nom, uti_prenom, adr_id, uti_tel, uti_email, cli_num_secu_social, " +
                "cli_date_naissance, mut_id, med_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false); // désactive l'auto-commit

            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, obj.getUtiNom());
            statement.setString(2, obj.getUtiPrenom());
            statement.setInt(3, obj.getAdresse().getAdrId());
            statement.setString(4, obj.getUtiTel());
            statement.setString(5, obj.getUtiEmail());
            statement.setString(6, obj.getCliNumSecuSocial());
            statement.setDate(7, java.sql.Date.valueOf(obj.getCliDateNaissance()));
            statement.setInt(8, obj.getMutuelle().getMutId());
            statement.setInt(9, obj.getMedecin().getMedId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        obj.setCliId(generatedKeys.getInt(1));
                    }
                }
            }
            connection.commit(); // valide la transaction
        } catch (SQLException e){
            if (connection != null) {
                try {
                    connection.rollback(); // annule la transacton en cas d'erreur
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//                if (connection != null) {
//                    try {
//                     connection.close();
//                    } catch (SQLException e) {
//                    e.printStackTrace();
//                }
        }

        return obj;

    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Client obj) {
        return false;
    }

    @Override
    public Client getById(int id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }
}
