package org.nikolay.ligthexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private final String title;

    public Item(String title) {
        this.title = title;
    }

    private Item(Parcel source) {
        title = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[0];
        }
    };

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
