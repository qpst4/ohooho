package defpackage;

import android.util.Base64;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hd {
    public final String a;
    public final byte[] b;
    public final tq0 c;

    public hd(String str, byte[] bArr, tq0 tq0Var) {
        this.a = str;
        this.b = bArr;
        this.c = tq0Var;
    }

    public static ra a() {
        ra raVar = new ra(1);
        raVar.e = tq0.b;
        return raVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof hd) {
            hd hdVar = (hd) obj;
            if (this.a.equals(hdVar.a) && Arrays.equals(this.b, hdVar.b) && this.c.equals(hdVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() ^ ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003);
    }

    public final String toString() {
        byte[] bArr = this.b;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        return l11.k(sb, strEncodeToString, ")");
    }
}
