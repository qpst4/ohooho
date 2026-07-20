package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import defpackage.cb;
import defpackage.fx0;
import defpackage.gg0;
import defpackage.gx0;
import defpackage.ix0;
import defpackage.l11;
import defpackage.s1;
import defpackage.sp1;
import defpackage.wh0;
import defpackage.wt;
import defpackage.xh0;
import defpackage.y30;
import defpackage.zy;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final Object j = new Object();
    public final Object a = new Object();
    public final ix0 b = new ix0();
    public int c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;

    public b() {
        Object obj = j;
        this.f = obj;
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        ((cb) cb.K0().n).getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        s1.f(l11.j("Cannot invoke ", str, " on a background thread"));
    }

    public final void b(xh0 xh0Var) {
        if (xh0Var.c) {
            if (!xh0Var.e()) {
                xh0Var.b(false);
                return;
            }
            int i = xh0Var.d;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            xh0Var.d = i2;
            sp1 sp1Var = xh0Var.b;
            Object obj = this.e;
            sp1Var.getClass();
            gg0 gg0Var = (gg0) obj;
            wt wtVar = (wt) sp1Var.c;
            if (gg0Var == null || !wtVar.f0) {
                return;
            }
            View viewA0 = wtVar.a0();
            if (viewA0.getParent() != null) {
                s1.f("DialogFragment can not be attached to a container view");
                return;
            }
            if (wtVar.j0 != null) {
                if (y30.I(3)) {
                    Log.d("FragmentManager", "DialogFragment " + sp1Var + " setting the content view on " + wtVar.j0);
                }
                wtVar.j0.setContentView(viewA0);
            }
        }
    }

    public final void c(xh0 xh0Var) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (xh0Var != null) {
                b(xh0Var);
                xh0Var = null;
            } else {
                ix0 ix0Var = this.b;
                ix0Var.getClass();
                gx0 gx0Var = new gx0(ix0Var);
                ix0Var.d.put(gx0Var, Boolean.FALSE);
                while (gx0Var.hasNext()) {
                    b((xh0) ((Map.Entry) gx0Var.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public final void d(sp1 sp1Var) {
        Object obj;
        a("observeForever");
        wh0 wh0Var = new wh0(this, sp1Var);
        ix0 ix0Var = this.b;
        fx0 fx0VarB = ix0Var.b(sp1Var);
        if (fx0VarB != null) {
            obj = fx0VarB.c;
        } else {
            fx0 fx0Var = new fx0(sp1Var, wh0Var);
            ix0Var.e++;
            fx0 fx0Var2 = ix0Var.c;
            if (fx0Var2 == null) {
                ix0Var.b = fx0Var;
                ix0Var.c = fx0Var;
            } else {
                fx0Var2.d = fx0Var;
                fx0Var.e = fx0Var2;
                ix0Var.c = fx0Var;
            }
            obj = null;
        }
        xh0 xh0Var = (xh0) obj;
        if (xh0Var instanceof LiveData$LifecycleBoundObserver) {
            zy.n("Cannot add the same observer with different lifecycles");
        } else {
            if (xh0Var != null) {
                return;
            }
            wh0Var.b(true);
        }
    }

    public final void e(Object obj) {
        a("setValue");
        this.g++;
        this.e = obj;
        c(null);
    }
}
