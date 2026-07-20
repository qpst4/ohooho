package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    public /* synthetic */ f(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return g.c;
                }
                s1.f("superState must be null");
                return null;
            case 1:
                return new zg(parcel, classLoader);
            case 2:
                return new yj(parcel, classLoader);
            case 3:
                return new so(parcel, classLoader);
            case 4:
                return new p00(parcel, classLoader);
            case 5:
                return new qj0(parcel, classLoader);
            case 6:
                return new ju0(parcel, classLoader);
            case 7:
                return new p01(parcel, classLoader);
            case 8:
                return new e51(parcel, classLoader);
            case 9:
                return new x61(parcel, classLoader);
            default:
                return new lg1(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new g[i];
            case 1:
                return new zg[i];
            case 2:
                return new yj[i];
            case 3:
                return new so[i];
            case 4:
                return new p00[i];
            case 5:
                return new qj0[i];
            case 6:
                return new ju0[i];
            case 7:
                return new p01[i];
            case 8:
                return new e51[i];
            case 9:
                return new x61[i];
            default:
                return new lg1[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return g.c;
                }
                s1.f("superState must be null");
                return null;
            case 1:
                return new zg(parcel, null);
            case 2:
                return new yj(parcel, null);
            case 3:
                return new so(parcel, null);
            case 4:
                return new p00(parcel, null);
            case 5:
                return new qj0(parcel, null);
            case 6:
                return new ju0(parcel, null);
            case 7:
                return new p01(parcel, null);
            case 8:
                return new e51(parcel, null);
            case 9:
                return new x61(parcel, null);
            default:
                return new lg1(parcel, null);
        }
    }
}
