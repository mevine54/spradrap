package fr.mevine.controllers;

import fr.mevine.dao.MedecinDao;
import fr.mevine.models.Medecin;

import java.util.List;

public class MedecinController {
    private final MedecinDao medecinDao = new MedecinDao();

    public List<Medecin> getAllMedecins() {
        return medecinDao.findAll();
    }

    public Medecin getMedecinById(int id) {
        return medecinDao.findById(id);
    }

    public void createMedecin(Medecin medecin) {
        medecinDao.create(medecin);
    }

    public void updateMedecin(Medecin medecin) {
        medecinDao.update(medecin);
    }

    public void deleteMedecin(int id) {
        medecinDao.delete(id);
    }
}

