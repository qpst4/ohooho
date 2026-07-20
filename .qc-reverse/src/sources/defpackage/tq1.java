package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tq1 extends v {
    public static final Parcelable.Creator<tq1> CREATOR = new ip0(24);
    public Bundle b;
    public l10[] c;
    public int d;
    public bn e;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        Bundle bundle = this.b;
        if (bundle != null) {
            int iR2 = tk0.R(parcel, 1);
            parcel.writeBundle(bundle);
            tk0.U(parcel, iR2);
        }
        tk0.O(parcel, 2, this.c, i);
        int i2 = this.d;
        tk0.V(parcel, 3, 4);
        parcel.writeInt(i2);
        tk0.M(parcel, 4, this.e, i);
        tk0.U(parcel, iR);
    }
}
