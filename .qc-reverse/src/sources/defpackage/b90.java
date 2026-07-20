package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b90 implements c11 {
    public final c30 b;
    public boolean c;
    public final /* synthetic */ g90 d;

    public b90(g90 g90Var) {
        this.d = g90Var;
        this.b = new c30(g90Var.d.b());
    }

    @Override // defpackage.c11
    public final a61 b() {
        return this.b;
    }

    @Override // defpackage.c11
    public final void c(mh mhVar, long j) {
        nh nhVar = this.d.d;
        if (this.c) {
            s1.f("closed");
        } else {
            if (j == 0) {
                return;
            }
            nhVar.d(j);
            nhVar.o("\r\n");
            nhVar.c(mhVar, j);
            nhVar.o("\r\n");
        }
    }

    @Override // defpackage.c11, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.d.d.o("0\r\n\r\n");
        c30 c30Var = this.b;
        a61 a61Var = c30Var.e;
        c30Var.e = a61.d;
        a61Var.a();
        a61Var.b();
        this.d.e = 3;
    }

    @Override // defpackage.c11, java.io.Flushable
    public final synchronized void flush() {
        if (this.c) {
            return;
        }
        this.d.d.flush();
    }
}
