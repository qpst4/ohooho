package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n20 implements rx {
    public final Context a;
    public final m20 b;
    public final ow0 c;
    public final Object d = new Object();
    public Handler e;
    public ThreadPoolExecutor f;
    public ThreadPoolExecutor g;
    public yb0 h;

    public n20(Context context, m20 m20Var) {
        f01.k("Context cannot be null", context);
        this.a = context.getApplicationContext();
        this.b = m20Var;
        this.c = o20.d;
    }

    @Override // defpackage.rx
    public final void a(yb0 yb0Var) {
        synchronized (this.d) {
            this.h = yb0Var;
        }
        synchronized (this.d) {
            try {
                if (this.h == null) {
                    return;
                }
                if (this.f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new tm("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.g = threadPoolExecutor;
                    this.f = threadPoolExecutor;
                }
                this.f.execute(new c(25, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.d) {
            try {
                this.h = null;
                Handler handler = this.e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.e = null;
                ThreadPoolExecutor threadPoolExecutor = this.g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f = null;
                this.g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final x20 c() {
        try {
            ow0 ow0Var = this.c;
            Context context = this.a;
            m20 m20Var = this.b;
            ow0Var.getClass();
            ArrayList arrayList = new ArrayList(1);
            Object obj = new Object[]{m20Var}[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            jl1 jl1VarA = l20.a(context, Collections.unmodifiableList(arrayList));
            int i = jl1VarA.b;
            if (i != 0) {
                throw new RuntimeException("fetchFonts failed (" + i + ")");
            }
            x20[] x20VarArr = (x20[]) ((List) jl1VarA.c).get(0);
            if (x20VarArr == null || x20VarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return x20VarArr[0];
        } catch (PackageManager.NameNotFoundException e) {
            zy.l("provider not found", e);
            return null;
        }
    }
}
