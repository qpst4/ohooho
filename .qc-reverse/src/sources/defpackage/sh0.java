package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sh0 extends yp0 {
    public static final Parcelable.Creator<sh0> CREATOR = new c4(19);
    public String b;

    public sh0(Parcel parcel) {
        super(parcel);
        this.b = parcel.readString();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.b);
    }

    public sh0() {
        super(AbsSavedState.EMPTY_STATE);
    }
}
