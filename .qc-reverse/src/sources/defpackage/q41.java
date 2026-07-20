package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q41 extends v {
    public static final Parcelable.Creator<q41> CREATOR = new ip0(11);
    public final int b;
    public List c;

    public q41(int i, List list) {
        this.b = i;
        this.c = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.P(parcel, 2, this.c);
        tk0.U(parcel, iR);
    }
}
