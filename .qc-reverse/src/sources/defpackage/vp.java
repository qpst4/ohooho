package defpackage;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vp implements Parcelable {
    public static final Parcelable.Creator<vp> CREATOR = new c4(9);
    public final Uri b;
    public final Uri c;
    public final Exception d;
    public final float[] e;
    public final Rect f;
    public final Rect g;
    public final int h;
    public final int i;

    public vp(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
        this.b = uri;
        this.c = uri2;
        this.d = exc;
        this.e = fArr;
        this.f = rect;
        this.g = rect2;
        this.h = i;
        this.i = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeSerializable(this.d);
        parcel.writeFloatArray(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
    }
}
