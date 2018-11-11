package jp.gr.java_conf.mitchibu.passwordmanager.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account implements Parcelable {
	public static final Creator<Account> CREATOR = new Creator<Account>() {
		@Override
		public Account createFromParcel(Parcel in) {
			return new Account(in);
		}

		@Override
		public Account[] newArray(int size) {
			return new Account[size];
		}
	};

	@PrimaryKey(autoGenerate = true)
	public long id;

	@ColumnInfo(name = "title")
	public String title;

	@ColumnInfo(name = "name")
	public String name;

	@ColumnInfo(name = "password")
	public String password;

	@ColumnInfo(name = "comment")
	public String comment;

	public Account() {
	}

	protected Account(Parcel in) {
		id = in.readLong();
		title = in.readString();
		name = in.readString();
		password = in.readString();
		comment = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(id);
		dest.writeString(title);
		dest.writeString(name);
		dest.writeString(password);
		dest.writeString(comment);
	}
}