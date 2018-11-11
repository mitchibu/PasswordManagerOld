package jp.gr.java_conf.mitchibu.passwordmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import jp.gr.java_conf.mitchibu.passwordmanager.db.AppDatabase;
import jp.gr.java_conf.mitchibu.passwordmanager.db.Account;

public class MyViewModel extends AndroidViewModel {
	Flowable<PagedList<Account>> data;

	public MyViewModel(@NonNull Application application) {
		super(application);
	}

	public void setDatabase(AppDatabase db) {
		data = new RxPagedListBuilder<>(db.accountDao().getAll(), 50).buildFlowable(BackpressureStrategy.LATEST);
	}
}
