package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f90 extends a90 {
    public boolean f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.c) {
            return;
        }
        if (!this.f) {
            a(false, null);
        }
        this.c = true;
    }

    @Override // defpackage.a90, defpackage.n11
    public final long j(mh mhVar, long j) throws IOException {
        if (this.c) {
            s1.f("closed");
            return 0L;
        }
        if (this.f) {
            return -1L;
        }
        long j2 = super.j(mhVar, 8192L);
        if (j2 != -1) {
            return j2;
        }
        this.f = true;
        a(true, null);
        return -1L;
    }
}
