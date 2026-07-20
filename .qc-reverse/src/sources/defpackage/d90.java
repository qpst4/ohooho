package defpackage;

import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d90 implements c11 {
    public final c30 b;
    public boolean c;
    public long d;
    public final /* synthetic */ g90 e;

    public d90(g90 g90Var, long j) {
        this.e = g90Var;
        this.b = new c30(g90Var.d.b());
        this.d = j;
    }

    @Override // defpackage.c11
    public final a61 b() {
        return this.b;
    }

    @Override // defpackage.c11
    public final void c(mh mhVar, long j) throws ProtocolException {
        if (this.c) {
            s1.f("closed");
            return;
        }
        long j2 = mhVar.c;
        byte[] bArr = be1.a;
        if (j < 0 || 0 > j2 || j2 < j) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (j <= this.d) {
            this.e.d.c(mhVar, j);
            this.d -= j;
            return;
        }
        throw new ProtocolException("expected " + this.d + " bytes but received " + j);
    }

    @Override // defpackage.c11, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws ProtocolException {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.d > 0) {
            throw new ProtocolException("unexpected end of stream");
        }
        c30 c30Var = this.b;
        a61 a61Var = c30Var.e;
        c30Var.e = a61.d;
        a61Var.a();
        a61Var.b();
        this.e.e = 3;
    }

    @Override // defpackage.c11, java.io.Flushable
    public final void flush() {
        if (this.c) {
            return;
        }
        this.e.d.flush();
    }
}
