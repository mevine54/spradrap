package fr.mevine.controllers;

import fr.mevine.dao.OrdonnanceDao;
import fr.mevine.models.Ordonnance;

import java.util.List;

public class OrdonnanceController {
    private final OrdonnanceDao ordonnanceDao = new OrdonnanceDao();

    public List<Ordonnance> getAllOrdonnances() {
        return ordonnanceDao.findAll();
    }

    public Ordonnance getOrdonnanceById(int id) {
        return ordonnanceDao.findById(id);
    }

    public void createOrdonnance(Ordonnance ordonnance) {
        ordonnanceDao.create(ordonnance);
    }

    public void updateOrdonnance(Ordonnance ordonnance) {
        ordonnanceDao.update(ordonnance);
    }

    public void deleteOrdonnance(int id) {
        ordonnanceDao.delete(id);
    }
}
