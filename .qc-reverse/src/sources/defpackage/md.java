package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class md implements Parcelable {
    public static final Parcelable.Creator<md> CREATOR = new c4(3);
    public final int[] b;
    public final ArrayList c;
    public final int[] d;
    public final int[] e;
    public final int f;
    public final String g;
    public final int h;
    public final int i;
    public final CharSequence j;
    public final int k;
    public final CharSequence l;
    public final ArrayList m;
    public final ArrayList n;
    public final boolean o;

    public md(ld ldVar) {
        int size = ldVar.a.size();
        this.b = new int[size * 6];
        if (!ldVar.g) {
            s1.f("Not on back stack");
            throw null;
        }
        this.c = new ArrayList(size);
        this.d = new int[size];
        this.e = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            h40 h40Var = (h40) ldVar.a.get(i2);
            int i3 = i + 1;
            this.b[i] = h40Var.a;
            ArrayList arrayList = this.c;
            j30 j30Var = h40Var.b;
            arrayList.add(j30Var != null ? j30Var.g : null);
            int[] iArr = this.b;
            iArr[i3] = h40Var.c ? 1 : 0;
            iArr[i + 2] = h40Var.d;
            iArr[i + 3] = h40Var.e;
            int i4 = i + 5;
            iArr[i + 4] = h40Var.f;
            i += 6;
            iArr[i4] = h40Var.g;
            this.d[i2] = h40Var.h.ordinal();
            this.e[i2] = h40Var.i.ordinal();
        }
        this.f = ldVar.f;
        this.g = ldVar.i;
        this.h = ldVar.s;
        this.i = ldVar.j;
        this.j = ldVar.k;
        this.k = ldVar.l;
        this.l = ldVar.m;
        this.m = ldVar.n;
        this.n = ldVar.o;
        this.o = ldVar.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.b);
        parcel.writeStringList(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public md(Parcel parcel) {
        this.b = parcel.createIntArray();
        this.c = parcel.createStringArrayList();
        this.d = parcel.createIntArray();
        this.e = parcel.createIntArray();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.j = (CharSequence) creator.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) creator.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }
}
