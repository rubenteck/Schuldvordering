package be.ap.edu.schuldvordering;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addHotel(Hotel hotel);

    @Query("SELECT * FROM hotel WHERE personeelsNr=:personeelsNr")
    List<Hotel> findHotelForUser(int personeelsNr);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateHotel(Hotel hotel);

    @Query("delete from hotel where id = :id")
    void delete(long id);

}
