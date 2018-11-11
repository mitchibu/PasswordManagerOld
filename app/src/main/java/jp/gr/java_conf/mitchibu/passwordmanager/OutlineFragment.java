package jp.gr.java_conf.mitchibu.passwordmanager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import jp.gr.java_conf.mitchibu.passwordmanager.adapter.OutlineAdapter;
import jp.gr.java_conf.mitchibu.passwordmanager.databinding.FragmentOutlineBinding;
import jp.gr.java_conf.mitchibu.passwordmanager.db.Account;
import jp.gr.java_conf.mitchibu.passwordmanager.db.AppDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

public class OutlineFragment extends DaggerFragment {
	@Inject
	AppDatabase db;

	private final CompositeDisposable disposables = new CompositeDisposable();
	private final OutlineAdapter adapter = new OutlineAdapter();

	private MyViewModel model;
	private Listener listener = null;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		Object[] objects = {
				getActivity(),
				getTargetFragment(),
				getParentFragment()
		};
		for(int i = 0; i < objects.length && (listener == null); ++ i) {
			if(listener == null && objects[i] instanceof Listener) listener = (Listener)objects[i];
		}
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Account account = new Account();
		account.title = "title";
		account.name = "name";
		disposables.add(db.accountDao().insertAll(account)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(() -> {}, Throwable::printStackTrace));
		model = ViewModelProviders.of(this).get(MyViewModel.class);
		model.setDatabase(db);

		adapter.setOnItemClickListener(this::deliverOnSelectItem);

		FragmentOutlineBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_outline, container, false);
		binding.list.setAdapter(adapter);
		return binding.getRoot();
	}

	@Override
	public void onStart() {
		super.onStart();
		disposables.add(model.data.subscribe(adapter::submitList));
	}

	@Override
	public void onStop() {
		super.onStop();
		disposables.clear();
	}

	private void deliverOnSelectItem(Account account) {
		if(listener != null) listener.onSelectItem(this, account);
	}

	public interface Listener {
		void onSelectItem(Fragment fragment, Account account);
	}
}
