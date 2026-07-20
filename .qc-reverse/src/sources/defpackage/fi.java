package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fi implements Parcelable {
    public static final Parcelable.Creator<fi> CREATOR = new c4(6);
    public final yl0 b;
    public final yl0 c;
    public final pr d;
    public final yl0 e;
    public final int f;
    public final int g;
    public final int h;

    public fi(yl0 yl0Var, yl0 yl0Var2, pr prVar, yl0 yl0Var3, int i) {
        Objects.requireNonNull(yl0Var, "start cannot be null");
        Objects.requireNonNull(yl0Var2, "end cannot be null");
        Objects.requireNonNull(prVar, "validator cannot be null");
        this.b = yl0Var;
        this.c = yl0Var2;
        this.e = yl0Var3;
        this.f = i;
        this.d = prVar;
        if (yl0Var3 != null && yl0Var.b.compareTo(yl0Var3.b) > 0) {
            zy.n("start Month cannot be after current Month");
            throw null;
        }
        if (yl0Var3 != null && yl0Var3.b.compareTo(yl0Var2.b) > 0) {
            zy.n("current Month cannot be after end Month");
            throw null;
        }
        if (i < 0 || i > wd1.c(null).getMaximum(7)) {
            zy.n("firstDayOfWeek is not valid");
            throw null;
        }
        this.h = yl0Var.d(yl0Var2) + 1;
        this.g = (yl0Var2.d - yl0Var.d) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fi)) {
            return false;
        }
        fi fiVar = (fi) obj;
        return this.b.equals(fiVar.b) && this.c.equals(fiVar.c) && Objects.equals(this.e, fiVar.e) && this.f == fiVar.f && this.d.equals(fiVar.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.e, Integer.valueOf(this.f), this.d});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeParcelable(this.e, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeInt(this.f);
    }
}
