package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l10 extends v {
    public static final Parcelable.Creator<l10> CREATOR = new ip0(23);
    public final String b;
    public final int c;
    public final long d;

    public l10() {
        this.b = "CLIENT_TELEMETRY";
        this.d = 1L;
        this.c = -1;
    }

    public final long a() {
        long j = this.d;
        return j == -1 ? this.c : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l10) {
            l10 l10Var = (l10) obj;
            String str = l10Var.b;
            String str2 = this.b;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && a() == l10Var.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Long.valueOf(a())});
    }

    public final String toString() {
        pn0 pn0Var = new pn0(this);
        pn0Var.a("name", this.b);
        pn0Var.a("version", Long.valueOf(a()));
        return pn0Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.N(parcel, 1, this.b);
        tk0.V(parcel, 2, 4);
        parcel.writeInt(this.c);
        long jA = a();
        tk0.V(parcel, 3, 8);
        parcel.writeLong(jA);
        tk0.U(parcel, iR);
    }

    public l10(String str, int i, long j) {
        this.b = str;
        this.c = i;
        this.d = j;
    }
}
