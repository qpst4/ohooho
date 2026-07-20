package defpackage;

import android.content.LocusId;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ni0 {
    public final String a;
    public final LocusId b;

    public ni0(String str) {
        if (TextUtils.isEmpty(str)) {
            zy.n("id cannot be empty");
            throw null;
        }
        this.a = str;
        if (Build.VERSION.SDK_INT >= 29) {
            this.b = ua.a(str);
        } else {
            this.b = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ni0.class != obj.getClass()) {
            return false;
        }
        String str = ((ni0) obj).a;
        String str2 = this.a;
        return str2 == null ? str == null : str2.equals(str);
    }

    public final int hashCode() {
        String str = this.a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LocusIdCompat[");
        sb.append(this.a.length() + "_chars");
        sb.append("]");
        return sb.toString();
    }
}
