package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v90 implements n11 {
    public final oh b;
    public int c;
    public byte d;
    public int e;
    public int f;
    public short g;

    public v90(oh ohVar) {
        this.b = ohVar;
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.b.b();
    }

    @Override // defpackage.n11
    public final long j(mh mhVar, long j) {
        int i;
        int i2;
        do {
            int i3 = this.f;
            oh ohVar = this.b;
            if (i3 == 0) {
                ohVar.skip(this.g);
                this.g = (short) 0;
                if ((this.d & 4) == 0) {
                    i = this.e;
                    int iR = w90.r(ohVar);
                    this.f = iR;
                    this.c = iR;
                    byte b = (byte) (ohVar.readByte() & 255);
                    this.d = (byte) (ohVar.readByte() & 255);
                    Logger logger = w90.f;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(h90.a(true, this.e, this.c, b, this.d));
                    }
                    i2 = ohVar.readInt() & Integer.MAX_VALUE;
                    this.e = i2;
                    if (b != 9) {
                        h90.c("%s != TYPE_CONTINUATION", Byte.valueOf(b));
                        throw null;
                    }
                }
            } else {
                long j2 = ohVar.j(mhVar, Math.min(8192L, i3));
                if (j2 != -1) {
                    this.f = (int) (((long) this.f) - j2);
                    return j2;
                }
            }
            return -1L;
        } while (i2 == i);
        h90.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
