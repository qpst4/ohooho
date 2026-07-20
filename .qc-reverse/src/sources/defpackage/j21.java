package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j21 implements Parcelable {
    public static final Parcelable.Creator<j21> CREATOR = new ip0(9);
    public int b;
    public int c;
    public int d;
    public int[] e;
    public int f;
    public int[] g;
    public ArrayList h;
    public boolean i;
    public boolean j;
    public boolean k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        if (this.d > 0) {
            parcel.writeIntArray(this.e);
        }
        parcel.writeInt(this.f);
        if (this.f > 0) {
            parcel.writeIntArray(this.g);
        }
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeList(this.h);
    }
}
