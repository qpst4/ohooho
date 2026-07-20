package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qj0 extends g {
    public static final Parcelable.Creator<qj0> CREATOR = new f(5);
    public boolean d;

    public qj0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            qj0.class.getClassLoader();
        }
        this.d = parcel.readInt() == 1;
    }

    @Override // defpackage.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.d ? 1 : 0);
    }
}
