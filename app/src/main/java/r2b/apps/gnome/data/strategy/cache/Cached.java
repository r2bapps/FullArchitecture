package r2b.apps.gnome.data.strategy.cache;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Cached object.
 */
public class Cached implements Parcelable {

    private long currentPersistedTime;
    private String operation;

    /**
     * Current time when stored.
     * @return Time in milliseconds.
     */
    public long getCurrentPersistedTime() {
        return currentPersistedTime;
    }

    /**
     * Set current time.
     * @param currentPersistedTime The current time in milliseconds.
     */
    public void setCurrentPersistedTime(long currentPersistedTime) {
        this.currentPersistedTime = currentPersistedTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.currentPersistedTime);
        dest.writeString(this.operation);
    }

    public Cached() {
    }

    protected Cached(Parcel in) {
        this.currentPersistedTime = in.readLong();
        this.operation = in.readString();
    }

    public Cached(String operation, long currentPersistedTime) {
        this.currentPersistedTime = currentPersistedTime;
        this.operation = operation;
    }

    public static final Creator<Cached> CREATOR = new Creator<Cached>() {
        public Cached createFromParcel(Parcel source) {
            return new Cached(source);
        }

        public Cached[] newArray(int size) {
            return new Cached[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cached cached = (Cached) o;

        if (currentPersistedTime != cached.currentPersistedTime) return false;
        return operation.equals(cached.operation);

    }

    @Override
    public int hashCode() {
        int result = (int) (currentPersistedTime ^ (currentPersistedTime >>> 32));
        result = 31 * result + operation.hashCode();
        return result;
    }
}
