package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ry {
    public final uy a;
    public final byte[] b;

    public ry(uy uyVar, byte[] bArr) {
        if (uyVar == null) {
            zy.r("encoding is null");
            throw null;
        }
        if (bArr == null) {
            zy.r("bytes is null");
            throw null;
        }
        this.a = uyVar;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ry)) {
            return false;
        }
        ry ryVar = (ry) obj;
        if (this.a.equals(ryVar.a)) {
            return Arrays.equals(this.b, ryVar.b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}
