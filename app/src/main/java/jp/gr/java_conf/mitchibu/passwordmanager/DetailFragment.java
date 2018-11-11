package jp.gr.java_conf.mitchibu.passwordmanager;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import jp.gr.java_conf.mitchibu.passwordmanager.databinding.FragmentDetailBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class DetailFragment extends Fragment {
	public static final String EXTRA_ACCOUNT = DetailFragment.class.getName() + ".extra.ACCOUNT";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		FragmentDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
		binding.setAccount(Objects.requireNonNull(getArguments()).getParcelable(EXTRA_ACCOUNT));
		return binding.getRoot();
	}
}
