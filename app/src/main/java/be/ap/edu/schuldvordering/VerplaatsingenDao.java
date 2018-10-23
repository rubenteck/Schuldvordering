package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface VerplaatsingenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVerplaatsingen(Verplaatsingen verplaatsingen);

    @Query("SELECT * FROM verplaatsingen WHERE personeelsNr=:personeelsNr")
    List<Verplaatsingen> findVerplaatsingenForUser(int personeelsNr);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateVerplaatsingen(Verplaatsingen verplaatsingen);

    @Query("delete from verplaatsingen where id = :id")
    void delete(long id);

}
