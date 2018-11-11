package jp.gr.java_conf.mitchibu.passwordmanager.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public abstract class BindablePagedAdapter<T> extends PagedListAdapter<T, BindableViewHolder> {
	protected BindablePagedAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
		super(diffCallback);
	}

	@NonNull
	@Override
	public BindableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new BindableViewHolder(onCreateViewDataBinding(parent, viewType));
	}

	@Override
	public void onBindViewHolder(@NonNull BindableViewHolder holder, int position) {
	}

	public abstract ViewDataBinding onCreateViewDataBinding(@NonNull ViewGroup parent, int viewType);
}
