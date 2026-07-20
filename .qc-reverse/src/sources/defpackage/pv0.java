package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pv0 implements Executor {
    public final /* synthetic */ int b;
    public final Object c;

    public pv0() {
        this.b = 2;
        kk1 kk1Var = new kk1(Looper.getMainLooper());
        Looper.getMainLooper();
        this.c = kk1Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                Handler handler = (Handler) obj;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 1:
                ((Executor) obj).execute(new nc(13, runnable));
                return;
            default:
                ((kk1) obj).post(runnable);
                return;
        }
    }

    public /* synthetic */ pv0(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }
}
