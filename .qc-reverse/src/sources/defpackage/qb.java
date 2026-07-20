package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qb implements Parcelable {
    public static final Parcelable.Creator<qb> CREATOR = new c4(2);
    public final String b;
    public final float c;
    public final float d;

    public qb(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
    }

    public qb(String str, float f, float f2) {
        this.b = str;
        this.c = f;
        this.d = f2;
    }
}
