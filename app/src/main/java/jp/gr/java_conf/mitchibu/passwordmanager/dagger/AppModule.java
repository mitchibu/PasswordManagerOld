package jp.gr.java_conf.mitchibu.passwordmanager.dagger;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import jp.gr.java_conf.mitchibu.passwordmanager.MyApplication;
import jp.gr.java_conf.mitchibu.passwordmanager.db.AppDatabase;

@Module
public class AppModule {
	@Singleton
	@Provides
	AppDatabase provideAppDatabase(MyApplication app) {
		return Room.inMemoryDatabaseBuilder(app, AppDatabase.class).build();
//		return Room.databaseBuilder(app,
//				AppDatabase.class,
//				"database-name").build();
	}
}
