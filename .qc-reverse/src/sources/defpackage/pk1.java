package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pk1 extends ij1 implements sk1 {
    public final int c(int i, String str, String str2, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        int i2 = uk1.a;
        parcelA.writeInt(1);
        bundle.writeToParcel(parcelA, 0);
        Parcel parcelB = b(parcelA, 10);
        int i3 = parcelB.readInt();
        parcelB.recycle();
        return i3;
    }

    public final Bundle d(String str, String str2, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeInt(9);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        int i = uk1.a;
        parcelA.writeInt(1);
        bundle.writeToParcel(parcelA, 0);
        Parcel parcelB = b(parcelA, 902);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle2;
    }

    public final Bundle e(String str, String str2, String str3) {
        Parcel parcelA = a();
        parcelA.writeInt(3);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        parcelA.writeString(null);
        Parcel parcelB = b(parcelA, 3);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle;
    }

    public final Bundle f(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        parcelA.writeString(null);
        int i2 = uk1.a;
        parcelA.writeInt(1);
        bundle.writeToParcel(parcelA, 0);
        Parcel parcelB = b(parcelA, 8);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle2;
    }

    public final Bundle g(String str, String str2, String str3, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeInt(6);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        int i = uk1.a;
        parcelA.writeInt(1);
        bundle.writeToParcel(parcelA, 0);
        Parcel parcelB = b(parcelA, 9);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle2;
    }

    public final Bundle h(String str, String str2, String str3) {
        Parcel parcelA = a();
        parcelA.writeInt(3);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        Parcel parcelB = b(parcelA, 4);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle;
    }

    public final Bundle i(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeString(str3);
        int i2 = uk1.a;
        parcelA.writeInt(1);
        bundle.writeToParcel(parcelA, 0);
        Parcel parcelB = b(parcelA, 11);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle2;
    }

    public final Bundle j(int i, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        int i2 = uk1.a;
        parcelA.writeInt(1);
        bundle.writeToParcel(parcelA, 0);
        parcelA.writeInt(1);
        bundle2.writeToParcel(parcelA, 0);
        Parcel parcelB = b(parcelA, 901);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle3 = (Bundle) uk1.a(parcelB);
        parcelB.recycle();
        return bundle3;
    }
}
