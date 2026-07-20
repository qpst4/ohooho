package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.ip0;
import defpackage.ve1;
import defpackage.we1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new ip0(0);
    public final we1 b;

    public ParcelImpl(Parcel parcel) {
        this.b = new ve1(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new ve1(parcel).k(this.b);
    }
}
