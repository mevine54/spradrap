package fr.mevine.dao;

import fr.mevine.models.Achat;
import fr.mevine.models.Client;
import fr.mevine.models.Medicament;
import fr.mevine.models.Ordonnance;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static fr.mevine.utilities.Singleton.getConnection;

public class AchatDao extends BaseDao<Achat> {

    private ClientDao clientDao = new ClientDao();
    private MedicamentDao medicamentDao = new MedicamentDao();
    private OrdonnanceDao ordonnanceDao = new OrdonnanceDao();

    @Override
    public Achat create(Achat obj) {
        String query = "INSERT INTO Achat (dateAchat, cli_ID, medi_ID, quantite, prixTotal, ord_ID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, java.sql.Date.valueOf(obj.getDateAchat()));
            ps.setInt(2, obj.getClient().getCliId());
            ps.setInt(3, obj.getMedicament().getMediId());
            ps.setInt(4, obj.getQuantite());
            ps.setDouble(5, obj.getPrixTotal());
            ps.setInt(6, obj.getOrdonnance() != null ? obj.getOrdonnance().getOrdId() : null);

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        obj.setAchatId(generatedKeys.getInt(1));
                    }
                }
            }
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM Achat WHERE ach_ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Achat obj) {
        String query = "UPDATE Achat SET dateAchat = ?, cliID = ?, medi_ID = ?, quantite = ?, prixTotal = ?, ord_ID = ? WHERE ach_ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, java.sql.Date.valueOf(obj.getDateAchat()));
            ps.setInt(2, obj.getClient().getCliId());
            ps.setInt(3, obj.getMedicament().getMediId());
            ps.setInt(4, obj.getQuantite());
            ps.setDouble(5, obj.getPrixTotal());
            ps.setInt(6, obj.getOrdonnance() != null ? obj.getOrdonnance().getOrdId() : null);
            ps.setInt(7, obj.getAchatId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Achat getById(int id) {
        String query = "SELECT * FROM Achat WHERE ach_ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LocalDate dateAchat = rs.getDate("dateAchat").toLocalDate();
                Integer cliId = rs.getInt("cli_ID");
                Integer mediId = rs.getInt("medi_ID");
                Integer quantite = rs.getInt("quantite");
                Double prixTotal = rs.getDouble("prixTotal");
                Integer ordId = rs.getInt("ord_ID");

                Client client = clientDao.getById(cliId);
                Medicament medicament = medicamentDao.getById(mediId);
                Ordonnance ordonnance = ordId != null ? ordonnanceDao.getById(ordId) : null;

                return new Achat(id, dateAchat, client, medicament, quantite, prixTotal, ordonnance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Achat> getAll() {
        String query = "SELECT * FROM Achat";
        List<Achat> achats = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Integer achatId = rs.getInt("ach_ID");
                LocalDate dateAchat = rs.getDate("dateAchat").toLocalDate();
                Integer cliId = rs.getInt("cli_ID");
                Integer mediId = rs.getInt("medi_ID");
                Integer quantite = rs.getInt("quantite");
                Double prixTotal = rs.getDouble("prixTotal");
                Integer ordId = rs.getInt("ord_ID");

                Client client = clientDao.getById(cliId);
                Medicament medicament = medicamentDao.getById(mediId);
                Ordonnance ordonnance = ordId != null ? ordonnanceDao.getById(ordId) : null;

                Achat achat = new Achat(achatId, dateAchat, client, medicament, quantite, prixTotal, ordonnance);
                achats.add(achat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return achats;
    }
}
