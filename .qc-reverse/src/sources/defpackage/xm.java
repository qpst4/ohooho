package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xm extends v {
    public final int b;
    public final int c;
    public final PendingIntent d;
    public final String e;
    public static final xm f = new xm(0);
    public static final Parcelable.Creator<xm> CREATOR = new ip0(22);

    public xm(int i, int i2, PendingIntent pendingIntent, String str) {
        this.b = i;
        this.c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    public static String a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i + ")";
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xm)) {
            return false;
        }
        xm xmVar = (xm) obj;
        return this.c == xmVar.c && xy0.o(this.d, xmVar.d) && xy0.o(this.e, xmVar.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), this.d, this.e});
    }

    public final String toString() {
        pn0 pn0Var = new pn0(this);
        pn0Var.a("statusCode", a(this.c));
        pn0Var.a("resolution", this.d);
        pn0Var.a("message", this.e);
        return pn0Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.V(parcel, 2, 4);
        parcel.writeInt(this.c);
        tk0.M(parcel, 3, this.d, i);
        tk0.N(parcel, 4, this.e);
        tk0.U(parcel, iR);
    }

    public xm(int i) {
        this(1, i, null, null);
    }

    public xm(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
