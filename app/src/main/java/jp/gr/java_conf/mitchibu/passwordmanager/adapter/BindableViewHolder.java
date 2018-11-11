package jp.gr.java_conf.mitchibu.passwordmanager.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BindableViewHolder extends RecyclerView.ViewHolder {
	public final ViewDataBinding binding;

	public BindableViewHolder(@NonNull ViewDataBinding binding) {
		super(binding.getRoot());
		this.binding = binding;
	}
}
