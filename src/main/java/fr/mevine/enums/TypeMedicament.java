package fr.mevine.enums;

public enum TypeMedicament {
    DOULEUR,
    ANTIINFLAMMATOIRE,
    ANTIBIOTIQUE,
    VITAMINE,
    CARDIOLOGIE,
    AUTRE;

    @Override
    public String toString() {
        switch (this) {
            case DOULEUR:
                return "Douleur";
            case ANTIINFLAMMATOIRE:
                return "Anti-Inflammatoire";
            case ANTIBIOTIQUE:
                return "Antibiotique";
            case VITAMINE:
                return "Vitamine";
            case CARDIOLOGIE:
                return "Cardiologie";
            case AUTRE:
            default:
                return "Autre";
        }
    }
}

