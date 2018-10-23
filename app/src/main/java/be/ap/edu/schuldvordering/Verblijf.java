package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.text.DecimalFormat;

@Entity(tableName = "Verblijf",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "personeelsNr",
                        childColumns = "personeelsNr",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "personeelsNr")}
)
public class Verblijf {

    @PrimaryKey(autoGenerate = true)
    long id;
    public long personeelsNr;

    public String datumVerblijfsDag;
    public Boolean ontbijt;
    public Boolean lunch;
    public Boolean avondmaal;
    public Boolean kleineUitgaven;
    public String bedrag;

    public Verblijf(long personeelsNr, String datumVerblijfsDag, Boolean ontbijt, Boolean lunch, Boolean avondmaal, Boolean kleineUitgaven, String bedrag) {
        this.personeelsNr = personeelsNr;
        this.datumVerblijfsDag = datumVerblijfsDag;
        this.ontbijt = ontbijt;
        this.lunch = lunch;
        this.avondmaal = avondmaal;
        this.kleineUitgaven = kleineUitgaven;
        this.bedrag = bedrag;
    }
}