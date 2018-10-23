package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.text.DecimalFormat;

@Entity(tableName = "overige",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "personeelsNr",
                        childColumns = "personeelsNr",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "personeelsNr")}
)
public class Overige {

    @PrimaryKey(autoGenerate = true)
    long id;
    public long personeelsNr;

    public String datum;
    public String omschrijving;
    public String bedrag;

    public Overige(long personeelsNr, String datum, String omschrijving, String bedrag) {
        this.personeelsNr = personeelsNr;
        this.datum = datum;
        this.omschrijving = omschrijving;
        this.bedrag = bedrag;
    }
}