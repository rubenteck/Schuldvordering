package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface OverigeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addOverige(Overige overige);

    @Query("SELECT * FROM overige WHERE personeelsNr=:personeelsNr")
    List<Overige> findOverigeForUser(int personeelsNr);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateOverige(Overige overige);

    @Query("delete from overige where id = :id")
    void delete(long id);

}
