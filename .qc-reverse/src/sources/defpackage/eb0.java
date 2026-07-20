package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eb0 implements n11 {
    public final gt0 b;
    public final Inflater c;
    public int d;
    public boolean e;

    public eb0(gt0 gt0Var, Inflater inflater) {
        this.b = gt0Var;
        this.c = inflater;
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.b.c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.e) {
            return;
        }
        this.c.end();
        this.e = true;
        this.b.close();
    }

    @Override // defpackage.n11
    public final long j(mh mhVar, long j) throws IOException {
        boolean z;
        if (this.e) {
            s1.f("closed");
            return 0L;
        }
        do {
            Inflater inflater = this.c;
            boolean zNeedsInput = inflater.needsInput();
            gt0 gt0Var = this.b;
            z = false;
            if (zNeedsInput) {
                int i = this.d;
                if (i != 0) {
                    int remaining = i - inflater.getRemaining();
                    this.d -= remaining;
                    gt0Var.skip(remaining);
                }
                if (inflater.getRemaining() != 0) {
                    s1.f("?");
                    return 0L;
                }
                if (gt0Var.a()) {
                    z = true;
                } else {
                    wy0 wy0Var = gt0Var.b.b;
                    int i2 = wy0Var.c;
                    int i3 = wy0Var.b;
                    int i4 = i2 - i3;
                    this.d = i4;
                    inflater.setInput(wy0Var.a, i3, i4);
                }
            }
            try {
                wy0 wy0VarU = mhVar.u(1);
                int iInflate = inflater.inflate(wy0VarU.a, wy0VarU.c, (int) Math.min(8192L, 8192 - wy0VarU.c));
                if (iInflate > 0) {
                    wy0VarU.c += iInflate;
                    long j2 = iInflate;
                    mhVar.c += j2;
                    return j2;
                }
                if (!inflater.finished() && !inflater.needsDictionary()) {
                }
                int i5 = this.d;
                if (i5 != 0) {
                    int remaining2 = i5 - inflater.getRemaining();
                    this.d -= remaining2;
                    gt0Var.skip(remaining2);
                }
                if (wy0VarU.b != wy0VarU.c) {
                    return -1L;
                }
                mhVar.b = wy0VarU.a();
                xy0.x(wy0VarU);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!z);
        throw new EOFException("source exhausted prematurely");
    }
}
