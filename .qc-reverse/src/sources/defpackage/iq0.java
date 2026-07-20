package defpackage;

import android.text.TextUtils;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class iq0 {
    public final int a;
    public final int b;
    public final String c;

    public iq0(Preference preference) {
        this.c = preference.getClass().getName();
        this.a = preference.F;
        this.b = preference.G;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof iq0)) {
            return false;
        }
        iq0 iq0Var = (iq0) obj;
        return this.a == iq0Var.a && this.b == iq0Var.b && TextUtils.equals(this.c, iq0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((((527 + this.a) * 31) + this.b) * 31);
    }
}
