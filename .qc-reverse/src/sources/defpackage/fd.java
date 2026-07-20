package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fd {
    public final xk a;
    public final HashMap b;

    public fd(xk xkVar, HashMap map) {
        this.a = xkVar;
        this.b = map;
    }

    public final long a(tq0 tq0Var, long j, int i) {
        long jD = j - this.a.d();
        gd gdVar = (gd) this.b.get(tq0Var);
        long j2 = gdVar.a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * j2 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j2 > 1 ? j2 : 2L) * ((long) r12)))), jD), gdVar.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fd)) {
            return false;
        }
        fd fdVar = (fd) obj;
        return this.a.equals(fdVar.a) && this.b.equals(fdVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.b + "}";
    }
}
