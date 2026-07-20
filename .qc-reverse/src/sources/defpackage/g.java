package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements Parcelable {
    public final Parcelable b;
    public static final e c = new e();
    public static final Parcelable.Creator<g> CREATOR = new f(0);

    public g(Parcelable parcelable) {
        if (parcelable != null) {
            this.b = parcelable == c ? null : parcelable;
        } else {
            zy.n("superState must not be null");
            throw null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }

    public g() {
        this.b = null;
    }

    public g(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.b = parcelable == null ? c : parcelable;
    }
}
