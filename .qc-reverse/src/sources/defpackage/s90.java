package defpackage;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s90 extends km0 {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ Object d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s90(u90 u90Var, w90 w90Var) {
        super("OkHttp %s", u90Var.e);
        this.d = u90Var;
        this.e = w90Var;
    }

    @Override // defpackage.km0
    public final void a() {
        int i = this.c;
        Object obj = this.e;
        Object obj2 = this.d;
        switch (i) {
            case 0:
                aa0 aa0Var = (aa0) obj;
                u90 u90Var = (u90) ((s90) obj2).d;
                try {
                    u90Var.c.b(aa0Var);
                    return;
                } catch (IOException e) {
                    qp0.a.l(4, "Http2Connection.Listener failure for " + u90Var.e, e);
                    try {
                        aa0Var.c(2);
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            case 1:
                u90 u90Var2 = (u90) ((s90) obj2).d;
                try {
                    u90Var2.s.a((jl1) obj);
                    return;
                } catch (IOException unused2) {
                    ThreadPoolExecutor threadPoolExecutor = u90.v;
                    u90Var2.g();
                    return;
                }
            default:
                u90 u90Var3 = (u90) obj2;
                w90 w90Var = (w90) obj;
                try {
                    try {
                        w90Var.h(this);
                        do {
                            break;
                        } while (w90Var.g(false, this));
                        u90Var3.a(1, 6);
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                    u90Var3.a(2, 2);
                } catch (Throwable th) {
                    try {
                        u90Var3.a(3, 3);
                        break;
                    } catch (IOException unused5) {
                    }
                    be1.c(w90Var);
                    throw th;
                }
                be1.c(w90Var);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s90(s90 s90Var, Object[] objArr, aa0 aa0Var) {
        super("OkHttp %s stream %d", objArr);
        this.d = s90Var;
        this.e = aa0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s90(s90 s90Var, Object[] objArr, jl1 jl1Var) {
        super("OkHttp %s ACK Settings", objArr);
        this.d = s90Var;
        this.e = jl1Var;
    }
}
