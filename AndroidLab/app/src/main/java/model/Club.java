package model;

/**
 * Created by chun on 2015-05-02.
 */
public class Club {
    private String nom;
    private String local;
    private String icone;
    private String siteweb;

    public Club(String nom, String local, String icone, String siteweb) {
        this.nom = nom;
        this.local = local;
        this.icone = icone;
        this.siteweb = siteweb;
    }

    public String getNom() {
        return nom;
    }

    public String getLocal() {
        return local;
    }

    public String getIcone() {
        return icone;
    }

    public String getSiteweb() {
        return siteweb;
    }
}
