package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n90 extends km0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ mh d;
    public final /* synthetic */ int e;
    public final /* synthetic */ u90 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n90(u90 u90Var, Object[] objArr, int i, mh mhVar, int i2, boolean z) {
        super("OkHttp %s Push Data[%s]", objArr);
        this.f = u90Var;
        this.c = i;
        this.d = mhVar;
        this.e = i2;
    }

    @Override // defpackage.km0
    public final void a() {
        try {
            ow0 ow0Var = this.f.k;
            mh mhVar = this.d;
            int i = this.e;
            ow0Var.getClass();
            mhVar.skip(i);
            this.f.s.r(this.c, 6);
            synchronized (this.f) {
                this.f.u.remove(Integer.valueOf(this.c));
            }
        } catch (IOException unused) {
        }
    }
}
