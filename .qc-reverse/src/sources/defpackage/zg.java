package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zg extends g {
    public static final Parcelable.Creator<zg> CREATOR = new f(1);
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public zg(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt() == 1;
        this.g = parcel.readInt() == 1;
        this.h = parcel.readInt() == 1;
    }

    @Override // defpackage.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
    }

    public zg(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.d = bottomSheetBehavior.L;
        this.e = bottomSheetBehavior.e;
        this.f = bottomSheetBehavior.b;
        this.g = bottomSheetBehavior.I;
        this.h = bottomSheetBehavior.J;
    }
}
