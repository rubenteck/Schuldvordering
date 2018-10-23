package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public final int personeelsNr;
    public String departement;
    public String naam;
    public String straat;
    public String gemeente;
    public String activiteit;
    public String land;
    public String stad;
    public String vertrekDatum;
    public String retourDatum;
    public String campus;


    public User(int personeelsNr, String departement, String naam, String straat, String gemeente, String activiteit, String land, String stad, String vertrekDatum, String retourDatum, String campus) {
        this.personeelsNr = personeelsNr;
        this.departement = departement;
        this.naam = naam;
        this.straat = straat;
        this.gemeente = gemeente;
        this.activiteit = activiteit;
        this.land = land;
        this.stad = stad;
        this.vertrekDatum = vertrekDatum;
        this.retourDatum = retourDatum;
        this.campus = campus;
    }
}
