package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bk1 extends v {
    public static final Parcelable.Creator<bk1> CREATOR = new ip0(14);
    public final List b;
    public final String c;

    public bk1(String str, ArrayList arrayList) {
        this.b = arrayList;
        this.c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        List<String> list = this.b;
        if (list != null) {
            int iR2 = tk0.R(parcel, 1);
            parcel.writeStringList(list);
            tk0.U(parcel, iR2);
        }
        tk0.N(parcel, 2, this.c);
        tk0.U(parcel, iR);
    }
}
