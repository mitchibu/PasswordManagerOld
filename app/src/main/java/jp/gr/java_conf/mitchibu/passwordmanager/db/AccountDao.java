package jp.gr.java_conf.mitchibu.passwordmanager.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;

@Dao
public interface AccountDao {
	@Query("SELECT * FROM Account")
	DataSource.Factory<Integer, Account> getAll();

	@Query("SELECT * FROM Account where id=:id")
	DataSource.Factory<Integer, Account> get(long id);

	@Insert
	Completable insertAll(Account... users);
}
