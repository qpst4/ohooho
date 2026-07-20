package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i90 implements n11 {
    public final n11 b;
    public boolean c;
    public long d;
    public final /* synthetic */ j90 e;

    public i90(j90 j90Var, n11 n11Var) {
        this.e = j90Var;
        if (n11Var == null) {
            zy.n("delegate == null");
            throw null;
        }
        this.b = n11Var;
        this.c = false;
        this.d = 0L;
    }

    public final void a() throws IOException {
        this.b.close();
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.b.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a();
        if (this.c) {
            return;
        }
        this.c = true;
        j90 j90Var = this.e;
        j90Var.b.h(false, j90Var, null);
    }

    @Override // defpackage.n11
    public final long j(mh mhVar, long j) throws IOException {
        try {
            long j2 = this.b.j(mhVar, 8192L);
            if (j2 <= 0) {
                return j2;
            }
            this.d += j2;
            return j2;
        } catch (IOException e) {
            if (!this.c) {
                this.c = true;
                j90 j90Var = this.e;
                j90Var.b.h(false, j90Var, e);
            }
            throw e;
        }
    }

    public final String toString() {
        return i90.class.getSimpleName() + "(" + this.b.toString() + ")";
    }
}
