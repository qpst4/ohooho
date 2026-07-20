package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nd implements Parcelable {
    public static final Parcelable.Creator<nd> CREATOR = new c4(4);
    public final ArrayList b;
    public final ArrayList c;

    public nd(Parcel parcel) {
        this.b = parcel.createStringArrayList();
        this.c = parcel.createTypedArrayList(md.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.b);
        parcel.writeTypedList(this.c);
    }
}
