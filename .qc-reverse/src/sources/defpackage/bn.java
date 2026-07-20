package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bn extends v {
    public static final Parcelable.Creator<bn> CREATOR = new ip0(25);
    public final pw0 b;
    public final boolean c;
    public final boolean d;
    public final int[] e;
    public final int f;
    public final int[] g;

    public bn(pw0 pw0Var, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.b = pw0Var;
        this.c = z;
        this.d = z2;
        this.e = iArr;
        this.f = i;
        this.g = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.M(parcel, 1, this.b, i);
        tk0.V(parcel, 2, 4);
        parcel.writeInt(this.c ? 1 : 0);
        tk0.V(parcel, 3, 4);
        parcel.writeInt(this.d ? 1 : 0);
        int[] iArr = this.e;
        if (iArr != null) {
            int iR2 = tk0.R(parcel, 4);
            parcel.writeIntArray(iArr);
            tk0.U(parcel, iR2);
        }
        tk0.V(parcel, 5, 4);
        parcel.writeInt(this.f);
        int[] iArr2 = this.g;
        if (iArr2 != null) {
            int iR3 = tk0.R(parcel, 6);
            parcel.writeIntArray(iArr2);
            tk0.U(parcel, iR3);
        }
        tk0.U(parcel, iR);
    }
}
