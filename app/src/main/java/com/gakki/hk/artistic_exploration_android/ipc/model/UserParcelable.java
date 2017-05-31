package com.gakki.hk.artistic_exploration_android.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HK on 2017/5/27.
 * Email: kaihu1989@gmail.com.
 */

public class UserParcelable implements Parcelable {
    public String name;
    public boolean isMale;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeByte(this.isMale ? (byte) 1 : (byte) 0);
    }

    public UserParcelable() {
    }

    protected UserParcelable(Parcel in) {
        this.name = in.readString();
        this.isMale = in.readByte() != 0;
    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel source) {
            return new UserParcelable(source);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };
}
