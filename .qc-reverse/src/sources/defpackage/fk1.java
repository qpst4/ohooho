package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fk1 extends v {
    public static final Parcelable.Creator<fk1> CREATOR = new ip0(15);
    public final int b;
    public final xm c;
    public final lk1 d;

    public fk1(int i, xm xmVar, lk1 lk1Var) {
        this.b = i;
        this.c = xmVar;
        this.d = lk1Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.M(parcel, 2, this.c, i);
        tk0.M(parcel, 3, this.d, i);
        tk0.U(parcel, iR);
    }
}
