package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x61 extends g {
    public static final Parcelable.Creator<x61> CREATOR = new f(9);
    public int d;
    public boolean e;

    public x61(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.d = parcel.readInt();
        this.e = parcel.readInt() != 0;
    }

    @Override // defpackage.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e ? 1 : 0);
    }
}
