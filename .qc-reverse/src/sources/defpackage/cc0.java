package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cc0 implements Parcelable {
    public static final Parcelable.Creator<cc0> CREATOR = new c4(17);
    public final IntentSender b;
    public final Intent c;
    public final int d;
    public final int e;

    public cc0(IntentSender intentSender, Intent intent, int i, int i2) {
        intentSender.getClass();
        this.b = intentSender;
        this.c = intent;
        this.d = i;
        this.e = i2;
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
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
