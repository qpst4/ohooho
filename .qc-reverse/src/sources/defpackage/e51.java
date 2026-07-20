package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e51 extends g {
    public static final Parcelable.Creator<e51> CREATOR = new f(8);
    public CharSequence d;
    public boolean e;

    public e51(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.d) + "}";
    }

    @Override // defpackage.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.d, parcel, i);
        parcel.writeInt(this.e ? 1 : 0);
    }
}
