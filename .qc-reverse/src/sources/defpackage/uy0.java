package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uy0 extends yp0 {
    public static final Parcelable.Creator<uy0> CREATOR = new ip0(7);
    public int b;
    public int c;
    public int d;

    public uy0(Parcel parcel) {
        super(parcel);
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    public uy0() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
