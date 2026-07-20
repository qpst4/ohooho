package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jx extends yp0 {
    public static final Parcelable.Creator<jx> CREATOR = new c4(13);
    public String b;

    public jx(Parcel parcel) {
        super(parcel);
        this.b = parcel.readString();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.b);
    }

    public jx() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
