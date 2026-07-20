package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class db1 extends yp0 {
    public static final Parcelable.Creator<db1> CREATOR = new ip0(10);
    public boolean b;

    public db1(Parcel parcel) {
        super(parcel);
        this.b = parcel.readInt() == 1;
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b ? 1 : 0);
    }

    public db1() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
