package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xl0 extends v {
    public static final Parcelable.Creator<xl0> CREATOR = new ip0(16);
    public final int b;
    public final int c;
    public final int d;
    public final long e;
    public final long f;
    public final String g;
    public final String h;
    public final int i;
    public final int j;

    public xl0(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = j2;
        this.g = str;
        this.h = str2;
        this.i = i4;
        this.j = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.V(parcel, 2, 4);
        parcel.writeInt(this.c);
        tk0.V(parcel, 3, 4);
        parcel.writeInt(this.d);
        tk0.V(parcel, 4, 8);
        parcel.writeLong(this.e);
        tk0.V(parcel, 5, 8);
        parcel.writeLong(this.f);
        tk0.N(parcel, 6, this.g);
        tk0.N(parcel, 7, this.h);
        tk0.V(parcel, 8, 4);
        parcel.writeInt(this.i);
        tk0.V(parcel, 9, 4);
        parcel.writeInt(this.j);
        tk0.U(parcel, iR);
    }
}
