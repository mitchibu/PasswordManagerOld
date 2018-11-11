package jp.gr.java_conf.mitchibu.passwordmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import jp.gr.java_conf.mitchibu.passwordmanager.R;
import jp.gr.java_conf.mitchibu.passwordmanager.databinding.ItemOutlineBinding;
import jp.gr.java_conf.mitchibu.passwordmanager.db.Account;

public class OutlineAdapter extends BindablePagedAdapter<Account> {
	private OnItemClickListener<Account> onItemClickListener = null;

	public OutlineAdapter() {
		super(new DiffUtil.ItemCallback<Account>() {
			@Override
			public boolean areItemsTheSame(@NonNull Account oldItem, @NonNull Account newItem) {
				return oldItem.id == newItem.id;
			}

			@Override
			public boolean areContentsTheSame(@NonNull Account oldItem, @NonNull Account newItem) {
				return oldItem.equals(newItem);
			}
		});
	}

	public void setOnItemClickListener(OnItemClickListener<Account> listener) {
		onItemClickListener = listener;
	}

	@Override
	public ViewDataBinding onCreateViewDataBinding(@NonNull ViewGroup parent, int viewType) {
		return DataBindingUtil.inflate((LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE), R.layout.item_outline, parent, false);
	}

	@Override
	public void onBindViewHolder(@NonNull BindableViewHolder holder, int position) {
		Account account = getItem(position);
		if(holder.binding instanceof ItemOutlineBinding) {
			((ItemOutlineBinding)holder.binding).setAccount(account);
			((ItemOutlineBinding)holder.binding).setListener(onItemClickListener);
		}
		holder.binding.executePendingBindings();
	}
}
