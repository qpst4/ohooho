package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ad extends oi0 {
    public final long a;
    public final Integer b;
    public final long c;
    public final byte[] d;
    public final String e;
    public final long f;
    public final um0 g;

    public ad(long j, Integer num, long j2, byte[] bArr, String str, long j3, um0 um0Var) {
        this.a = j;
        this.b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = um0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof oi0) {
            oi0 oi0Var = (oi0) obj;
            ad adVar = (ad) oi0Var;
            if (this.a == adVar.a) {
                Integer num = adVar.b;
                Integer num2 = this.b;
                if (num2 != null ? num2.equals(num) : num == null) {
                    if (this.c == adVar.c) {
                        if (Arrays.equals(this.d, oi0Var instanceof ad ? ((ad) oi0Var).d : adVar.d)) {
                            String str = adVar.e;
                            String str2 = this.e;
                            if (str2 != null ? str2.equals(str) : str == null) {
                                if (this.f == adVar.f) {
                                    um0 um0Var = adVar.g;
                                    um0 um0Var2 = this.g;
                                    if (um0Var2 != null ? um0Var2.equals(um0Var) : um0Var == null) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j2 = this.c;
        int iHashCode2 = (((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.f;
        int i2 = (iHashCode3 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        um0 um0Var = this.g;
        return i2 ^ (um0Var != null ? um0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.b + ", eventUptimeMs=" + this.c + ", sourceExtension=" + Arrays.toString(this.d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f + ", networkConnectionInfo=" + this.g + "}";
    }
}
