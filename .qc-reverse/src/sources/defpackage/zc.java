package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zc {
    public static final zc f = new zc(10485760, 200, 10000, 604800000, 81920);
    public final long a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public zc(long j, int i, int i2, long j2, int i3) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = j2;
        this.e = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zc) {
            zc zcVar = (zc) obj;
            if (this.a == zcVar.a && this.b == zcVar.b && this.c == zcVar.c && this.d == zcVar.d && this.e == zcVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003;
        long j2 = this.d;
        return this.e ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.a + ", loadBatchSize=" + this.b + ", criticalSectionEnterTimeoutMs=" + this.c + ", eventCleanUpAge=" + this.d + ", maxBlobByteSizePerRow=" + this.e + "}";
    }
}
