package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.ip0;
import defpackage.pn0;
import defpackage.qq0;
import defpackage.tk0;
import defpackage.v;
import defpackage.xm;
import defpackage.xy0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends v implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new ip0(21);
    public final int b;
    public final String c;
    public final PendingIntent d;
    public final xm e;

    public Status(int i, String str, PendingIntent pendingIntent, xm xmVar) {
        this.b = i;
        this.c = str;
        this.d = pendingIntent;
        this.e = xmVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.b == status.b && xy0.o(this.c, status.c) && xy0.o(this.d, status.d) && xy0.o(this.e, status.e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, this.d, this.e});
    }

    public final String toString() {
        pn0 pn0Var = new pn0(this);
        String strI = this.c;
        if (strI == null) {
            int i = this.b;
            switch (i) {
                case -1:
                    strI = "SUCCESS_CACHE";
                    break;
                case 0:
                    strI = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strI = qq0.i("unknown status code: ", i);
                    break;
                case 2:
                    strI = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strI = "SERVICE_DISABLED";
                    break;
                case 4:
                    strI = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strI = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strI = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strI = "NETWORK_ERROR";
                    break;
                case 8:
                    strI = "INTERNAL_ERROR";
                    break;
                case 10:
                    strI = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strI = "ERROR";
                    break;
                case 14:
                    strI = "INTERRUPTED";
                    break;
                case 15:
                    strI = "TIMEOUT";
                    break;
                case 16:
                    strI = "CANCELED";
                    break;
                case 17:
                    strI = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strI = "DEAD_CLIENT";
                    break;
                case 19:
                    strI = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strI = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strI = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strI = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        pn0Var.a("statusCode", strI);
        pn0Var.a("resolution", this.d);
        return pn0Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.N(parcel, 2, this.c);
        tk0.M(parcel, 3, this.d, i);
        tk0.M(parcel, 4, this.e, i);
        tk0.U(parcel, iR);
    }
}
