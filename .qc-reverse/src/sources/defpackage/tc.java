package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tc {
    public final int a;
    public final long b;

    public tc(int i, long j) {
        if (i == 0) {
            zy.r("Null status");
            throw null;
        }
        this.a = i;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof tc) {
                tc tcVar = (tc) obj;
                int i = tcVar.a;
                int i2 = this.a;
                if (i2 == 0) {
                    throw null;
                }
                if (!(i2 == i) || this.b != tcVar.b) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iR = (l11.r(this.a) ^ 1000003) * 1000003;
        long j = this.b;
        return ((int) ((j >>> 32) ^ j)) ^ iR;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.b);
        sb.append("}");
        return sb.toString();
    }
}
