package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.text.DecimalFormat;

@Entity(tableName = "hotel",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "personeelsNr",
                        childColumns = "personeelsNr",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "personeelsNr")}
)
public class Hotel {

    @PrimaryKey(autoGenerate = true)
    long id;
    public long personeelsNr;

    public String periode;
    public String bedragLokaleMunt;
    public String bedrag;

    public Hotel(long personeelsNr, String periode, String bedragLokaleMunt, String bedrag) {
        this.personeelsNr = personeelsNr;
        this.periode = periode;
        this.bedragLokaleMunt = bedragLokaleMunt;
        this.bedrag = bedrag;
    }
}