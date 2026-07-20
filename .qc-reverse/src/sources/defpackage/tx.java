package defpackage;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tx extends yb0 {
    public final /* synthetic */ yb0 s;
    public final /* synthetic */ ThreadPoolExecutor t;

    public tx(yb0 yb0Var, ThreadPoolExecutor threadPoolExecutor) {
        this.s = yb0Var;
        this.t = threadPoolExecutor;
    }

    @Override // defpackage.yb0
    public final void q(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.t;
        try {
            this.s.q(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // defpackage.yb0
    public final void r(g7 g7Var) {
        ThreadPoolExecutor threadPoolExecutor = this.t;
        try {
            this.s.r(g7Var);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
