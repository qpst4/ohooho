package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zd implements Parcelable {
    public static final Parcelable.Creator<zd> CREATOR = new c4(5);
    public Integer A;
    public Integer B;
    public Integer C;
    public Integer D;
    public Boolean E;
    public int b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public Integer g;
    public Integer h;
    public Integer i;
    public String k;
    public Locale o;
    public CharSequence p;
    public CharSequence q;
    public int r;
    public int s;
    public Integer t;
    public Integer v;
    public Integer w;
    public Integer x;
    public Integer y;
    public Integer z;
    public int j = 255;
    public int l = -2;
    public int m = -2;
    public int n = -2;
    public Boolean u = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeSerializable(this.c);
        parcel.writeSerializable(this.d);
        parcel.writeSerializable(this.e);
        parcel.writeSerializable(this.f);
        parcel.writeSerializable(this.g);
        parcel.writeSerializable(this.h);
        parcel.writeSerializable(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        CharSequence charSequence = this.p;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.q;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.r);
        parcel.writeSerializable(this.t);
        parcel.writeSerializable(this.v);
        parcel.writeSerializable(this.w);
        parcel.writeSerializable(this.x);
        parcel.writeSerializable(this.y);
        parcel.writeSerializable(this.z);
        parcel.writeSerializable(this.A);
        parcel.writeSerializable(this.D);
        parcel.writeSerializable(this.B);
        parcel.writeSerializable(this.C);
        parcel.writeSerializable(this.u);
        parcel.writeSerializable(this.o);
        parcel.writeSerializable(this.E);
    }
}
