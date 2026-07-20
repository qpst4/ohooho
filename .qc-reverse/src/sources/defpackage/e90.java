package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e90 extends a90 {
    public long f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zO;
        if (this.c) {
            return;
        }
        if (this.f != 0) {
            try {
                zO = be1.o(this, 100);
            } catch (IOException unused) {
                zO = false;
            }
            if (!zO) {
                a(false, null);
            }
        }
        this.c = true;
    }

    @Override // defpackage.a90, defpackage.n11
    public final long j(mh mhVar, long j) throws IOException {
        if (this.c) {
            s1.f("closed");
            return 0L;
        }
        long j2 = this.f;
        if (j2 == 0) {
            return -1L;
        }
        long j3 = super.j(mhVar, Math.min(j2, 8192L));
        if (j3 == -1) {
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }
        long j4 = this.f - j3;
        this.f = j4;
        if (j4 == 0) {
            a(true, null);
        }
        return j3;
    }
}
