package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pw0 extends v {
    public static final Parcelable.Creator<pw0> CREATOR = new ip0(20);
    public final int b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;

    public pw0(int i, int i2, int i3, boolean z, boolean z2) {
        this.b = i;
        this.c = z;
        this.d = z2;
        this.e = i2;
        this.f = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.V(parcel, 2, 4);
        parcel.writeInt(this.c ? 1 : 0);
        tk0.V(parcel, 3, 4);
        parcel.writeInt(this.d ? 1 : 0);
        tk0.V(parcel, 4, 4);
        parcel.writeInt(this.e);
        tk0.V(parcel, 5, 4);
        parcel.writeInt(this.f);
        tk0.U(parcel, iR);
    }
}
