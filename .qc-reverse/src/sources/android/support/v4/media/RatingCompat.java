package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.ip0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new ip0(5);
    public final int b;
    public final float c;

    public RatingCompat(int i, float f) {
        this.b = i;
        this.c = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.b);
        sb.append(" rating=");
        float f = this.c;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeFloat(this.c);
    }
}
