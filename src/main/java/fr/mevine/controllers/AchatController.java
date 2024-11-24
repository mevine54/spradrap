package fr.mevine.controllers;

import fr.mevine.dao.AchatDao;
import fr.mevine.models.Achat;

import java.util.List;

public class AchatController {
    private final AchatDao achatDao = new AchatDao();

    public List<Achat> getAllAchats() {
        return achatDao.findAll();
    }

    public Achat getAchatById(int id) {
        return achatDao.findById(id);
    }

    public void createAchat(Achat achat) {
        achatDao.create(achat);
    }

    public void updateAchat(Achat achat) {
        achatDao.update(achat);
    }

    public void deleteAchat(int id) {
        achatDao.delete(id);
    }
}

