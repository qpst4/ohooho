package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.ip0;
import defpackage.tk0;
import defpackage.v;
import defpackage.zy;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends v implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new ip0(19);
    public final int b;
    public final String c;

    public Scope(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            zy.n("scopeUri must not be null or empty");
            throw null;
        }
        this.b = i;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.c.equals(((Scope) obj).c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.N(parcel, 2, this.c);
        tk0.U(parcel, iR);
    }
}
