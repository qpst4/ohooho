package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yc {
    public final String a;
    public final Integer b;
    public final ry c;
    public final long d;
    public final long e;
    public final Map f;

    public yc(String str, Integer num, ry ryVar, long j, long j2, HashMap map) {
        this.a = str;
        this.b = num;
        this.c = ryVar;
        this.d = j;
        this.e = j2;
        this.f = map;
    }

    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final a9 c() {
        a9 a9Var = new a9();
        String str = this.a;
        if (str == null) {
            zy.r("Null transportName");
            return null;
        }
        a9Var.a = str;
        a9Var.b = this.b;
        ry ryVar = this.c;
        if (ryVar == null) {
            zy.r("Null encodedPayload");
            return null;
        }
        a9Var.c = ryVar;
        a9Var.d = Long.valueOf(this.d);
        a9Var.e = Long.valueOf(this.e);
        a9Var.f = new HashMap(this.f);
        return a9Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof yc) {
            yc ycVar = (yc) obj;
            if (this.a.equals(ycVar.a)) {
                Integer num = ycVar.b;
                Integer num2 = this.b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.c.equals(ycVar.c) && this.d == ycVar.d && this.e == ycVar.e && this.f.equals(ycVar.f)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j = this.d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        return this.f.hashCode() ^ ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + "}";
    }
}
