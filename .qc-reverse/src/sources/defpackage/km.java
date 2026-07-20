package defpackage;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class km implements ViewTreeObserver.OnDrawListener, Runnable, Executor {
    public final long b = SystemClock.uptimeMillis() + 10000;
    public Runnable c;
    public boolean d;
    public final /* synthetic */ pm e;

    public km(pm pmVar) {
        this.e = pmVar;
    }

    public final void a(View view) {
        if (this.d) {
            return;
        }
        this.d = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        this.c = runnable;
        View decorView = this.e.getWindow().getDecorView();
        decorView.getClass();
        if (!this.d) {
            decorView.postOnAnimation(new c(14, this));
        } else if (fc0.b(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z;
        Runnable runnable = this.c;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.b) {
                this.d = false;
                this.e.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.c = null;
        j40 j40Var = (j40) this.e.h.a();
        synchronized (j40Var.a) {
            z = j40Var.b;
        }
        if (z) {
            this.d = false;
            this.e.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
