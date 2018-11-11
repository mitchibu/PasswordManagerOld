package jp.gr.java_conf.mitchibu.passwordmanager;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import dagger.android.support.DaggerAppCompatActivity;
import jp.gr.java_conf.mitchibu.passwordmanager.databinding.ActivityMainBinding;
import jp.gr.java_conf.mitchibu.passwordmanager.db.Account;

import android.os.Bundle;

public class MainActivity extends DaggerAppCompatActivity implements OutlineFragment.Listener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		if(savedInstanceState != null) return;

		getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), new OutlineFragment()).commit();
	}

	@Override
	public void onSelectItem(Fragment fragment, Account account) {
		Bundle args = new Bundle();
		args.putParcelable(DetailFragment.EXTRA_ACCOUNT, account);
		Fragment newFragment = new DetailFragment();
		newFragment.setArguments(args);
		getSupportFragmentManager().beginTransaction().replace(fragment.getId(), newFragment).addToBackStack(null).commit();
	}
}
