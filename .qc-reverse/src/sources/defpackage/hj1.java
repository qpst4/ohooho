package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hj1 extends v {
    public static final Parcelable.Creator<hj1> CREATOR = new ip0(12);
    public final int b;
    public final int c;
    public final Intent d;

    public hj1(int i, int i2, Intent intent) {
        this.b = i;
        this.c = i2;
        this.d = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.V(parcel, 2, 4);
        parcel.writeInt(this.c);
        tk0.M(parcel, 3, this.d, i);
        tk0.U(parcel, iR);
    }
}
