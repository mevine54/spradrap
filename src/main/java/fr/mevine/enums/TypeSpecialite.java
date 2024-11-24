package fr.mevine.enums;

public enum TypeSpecialite {
    CARDIOLOGUE,
    DERMATOLOGUE,
    OPHTALMOLOGUE,
    GENERALISTE,
    ORL,
    AUTRE;

    @Override
    public String toString() {
        switch (this) {
            case CARDIOLOGUE:
                return "Cardiologue";
            case DERMATOLOGUE:
                return "Dermatologue";
            case OPHTALMOLOGUE:
                return "Ophtalmologue";
            case GENERALISTE:
                return "Généraliste";
            case ORL:
                return "ORL";
            case AUTRE:
            default:
                return "Autre";
        }
    }
}

