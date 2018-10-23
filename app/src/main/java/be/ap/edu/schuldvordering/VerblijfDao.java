package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface VerblijfDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addVerblijf(Verblijf verblijf);

    @Query("SELECT * FROM verblijf WHERE personeelsNr=:personeelsNr")
    List<Verblijf> findVerblijfForUser(int personeelsNr);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateVerblijf(Verblijf data);

    @Query("delete from verblijf where id = :id")
    void delete(long id);

}
