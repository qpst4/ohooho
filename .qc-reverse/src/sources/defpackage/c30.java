package defpackage;

import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c30 extends a61 {
    public a61 e;

    public c30(a61 a61Var) {
        if (a61Var != null) {
            this.e = a61Var;
        } else {
            zy.n("delegate == null");
            throw null;
        }
    }

    @Override // defpackage.a61
    public final a61 a() {
        return this.e.a();
    }

    @Override // defpackage.a61
    public final a61 b() {
        return this.e.b();
    }

    @Override // defpackage.a61
    public final long c() {
        return this.e.c();
    }

    @Override // defpackage.a61
    public final a61 d(long j) {
        return this.e.d(j);
    }

    @Override // defpackage.a61
    public final boolean e() {
        return this.e.e();
    }

    @Override // defpackage.a61
    public final void f() throws InterruptedIOException {
        this.e.f();
    }

    @Override // defpackage.a61
    public final a61 g(long j) {
        return this.e.g(j);
    }
}
