package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lg1 extends g {
    public static final Parcelable.Creator<lg1> CREATOR = new f(10);
    public int d;
    public Parcelable e;
    public final ClassLoader f;

    public lg1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? lg1.class.getClassLoader() : classLoader;
        this.d = parcel.readInt();
        this.e = parcel.readParcelable(classLoader);
        this.f = classLoader;
    }

    public final String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.d + "}";
    }

    @Override // defpackage.g, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
    }
}
