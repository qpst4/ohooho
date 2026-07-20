package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z30 implements Parcelable {
    public static final Parcelable.Creator<z30> CREATOR = new c4(15);
    public ArrayList b;
    public ArrayList c;
    public md[] d;
    public int e;
    public String f;
    public ArrayList g;
    public ArrayList h;
    public ArrayList i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.b);
        parcel.writeStringList(this.c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeStringList(this.g);
        parcel.writeTypedList(this.h);
        parcel.writeTypedList(this.i);
    }
}
