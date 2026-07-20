package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k90 extends km0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ u90 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k90(u90 u90Var, Object[] objArr, int i, int i2) {
        super("OkHttp %s stream %d", objArr);
        this.e = u90Var;
        this.c = i;
        this.d = i2;
    }

    @Override // defpackage.km0
    public final void a() {
        u90 u90Var = this.e;
        try {
            u90Var.s.r(this.c, this.d);
        } catch (IOException unused) {
            u90Var.g();
        }
    }
}
