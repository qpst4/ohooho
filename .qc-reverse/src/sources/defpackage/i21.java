package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i21 implements Parcelable {
    public static final Parcelable.Creator<i21> CREATOR = new ip0(8);
    public int b;
    public int c;
    public int[] d;
    public boolean e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.b + ", mGapDir=" + this.c + ", mHasUnwantedGapAfter=" + this.e + ", mGapPerSpan=" + Arrays.toString(this.d) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.e ? 1 : 0);
        int[] iArr = this.d;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.d);
        }
    }
}
