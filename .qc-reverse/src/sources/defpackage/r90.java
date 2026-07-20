package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r90 extends km0 {
    public final boolean c;
    public final int d;
    public final int e;
    public final /* synthetic */ u90 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r90(u90 u90Var, boolean z, int i, int i2) {
        super("OkHttp %s ping %08x%08x", u90Var.e, Integer.valueOf(i), Integer.valueOf(i2));
        this.f = u90Var;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    @Override // defpackage.km0
    public final void a() {
        boolean z;
        u90 u90Var = this.f;
        boolean z2 = this.c;
        int i = this.d;
        int i2 = this.e;
        if (!z2) {
            synchronized (u90Var) {
                z = u90Var.l;
                u90Var.l = true;
            }
            if (z) {
                u90Var.g();
                return;
            }
        }
        try {
            u90Var.s.q(i, i2, z2);
        } catch (IOException unused) {
            u90Var.g();
        }
    }
}
