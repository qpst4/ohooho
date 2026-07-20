package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a90 implements n11 {
    public final c30 b;
    public boolean c;
    public long d = 0;
    public final /* synthetic */ g90 e;

    public a90(g90 g90Var) {
        this.e = g90Var;
        this.b = new c30(g90Var.c.b());
    }

    public final void a(boolean z, IOException iOException) {
        g90 g90Var = this.e;
        int i = g90Var.e;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            zy.g("state: ", g90Var.e);
            return;
        }
        c30 c30Var = this.b;
        a61 a61Var = c30Var.e;
        c30Var.e = a61.d;
        a61Var.a();
        a61Var.b();
        g90Var.e = 6;
        u21 u21Var = g90Var.b;
        if (u21Var != null) {
            u21Var.h(!z, g90Var, iOException);
        }
    }

    @Override // defpackage.n11
    public final a61 b() {
        return this.b;
    }

    @Override // defpackage.n11
    public long j(mh mhVar, long j) throws IOException {
        try {
            long j2 = this.e.c.j(mhVar, j);
            if (j2 <= 0) {
                return j2;
            }
            this.d += j2;
            return j2;
        } catch (IOException e) {
            a(false, e);
            throw e;
        }
    }
}
