package defpackage;

import android.os.Parcel;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ve1 extends ue1 {
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public ve1(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new kb(0), new kb(0), new kb(0));
    }

    @Override // defpackage.ue1
    public final ve1 a() {
        Parcel parcel = this.e;
        int iDataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        return new ve1(parcel, iDataPosition, i, l11.k(new StringBuilder(), this.h, "  "), this.a, this.b, this.c);
    }

    @Override // defpackage.ue1
    public final boolean e(int i) {
        while (true) {
            int i2 = this.j;
            int i3 = this.k;
            if (i2 >= this.g) {
                return i3 == i;
            }
            if (i3 == i) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i4 = this.j;
            Parcel parcel = this.e;
            parcel.setDataPosition(i4);
            int i5 = parcel.readInt();
            this.k = parcel.readInt();
            this.j += i5;
        }
    }

    @Override // defpackage.ue1
    public final void i(int i) {
        int i2 = this.i;
        SparseIntArray sparseIntArray = this.d;
        Parcel parcel = this.e;
        if (i2 >= 0) {
            int i3 = sparseIntArray.get(i2);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i3);
            parcel.writeInt(iDataPosition - i3);
            parcel.setDataPosition(iDataPosition);
        }
        this.i = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public ve1(Parcel parcel, int i, int i2, String str, kb kbVar, kb kbVar2, kb kbVar3) {
        super(kbVar, kbVar2, kbVar3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.k = -1;
        this.e = parcel;
        this.f = i;
        this.g = i2;
        this.j = i;
        this.h = str;
    }
}
