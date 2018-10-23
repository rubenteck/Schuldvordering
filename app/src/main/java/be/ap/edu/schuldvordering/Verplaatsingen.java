package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.text.DecimalFormat;

@Entity(tableName = "Verplaatsingen",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "personeelsNr",
                        childColumns = "personeelsNr",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "personeelsNr")}
)
public class Verplaatsingen {

    @PrimaryKey(autoGenerate = true)
    long id;
    public long personeelsNr;

    public String datum;
    public String adresVertrek;
    public String adresBestemming;
    public String code;
    public String km;
    public String bedragLokaleMunt;
    public String bedrag;

    public Verplaatsingen(long personeelsNr, String datum, String adresVertrek, String adresBestemming, String code, String km, String bedragLokaleMunt, String bedrag) {
        this.personeelsNr = personeelsNr;
        this.datum = datum;
        this.adresBestemming = adresBestemming;
        this.adresVertrek = adresVertrek;
        this.code = code;
        this.km = km;
        this.bedragLokaleMunt = bedragLokaleMunt;
        this.bedrag = bedrag;
    }
}