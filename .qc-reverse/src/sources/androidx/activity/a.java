package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import defpackage.ao0;
import defpackage.bo0;
import defpackage.eb;
import defpackage.gg0;
import defpackage.r30;
import defpackage.vn0;
import defpackage.wn0;
import defpackage.xn0;
import defpackage.xp;
import defpackage.y30;
import defpackage.zf0;
import defpackage.zn0;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final Runnable a;
    public final eb b = new eb();
    public r30 c;
    public final OnBackInvokedCallback d;
    public OnBackInvokedDispatcher e;
    public boolean f;
    public boolean g;

    public a(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallbackA;
        this.a = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                int i2 = 0;
                int i3 = 1;
                onBackInvokedCallbackA = zn0.a.a(new vn0(this, i2), new vn0(this, i3), new wn0(this, i2), new wn0(this, i3));
            } else {
                onBackInvokedCallbackA = xn0.a.a(new wn0(this, 2));
            }
            this.d = onBackInvokedCallbackA;
        }
    }

    public final void a(gg0 gg0Var, r30 r30Var) {
        r30Var.getClass();
        androidx.lifecycle.a aVarP = gg0Var.p();
        if (aVarP.c == zf0.b) {
            return;
        }
        r30Var.b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, aVarP, r30Var));
        f();
        r30Var.c = new bo0(0, this, a.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final ao0 b(r30 r30Var) {
        r30Var.getClass();
        this.b.addLast(r30Var);
        ao0 ao0Var = new ao0(this, r30Var);
        r30Var.b.add(ao0Var);
        f();
        r30Var.c = new bo0(0, this, a.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 1);
        return ao0Var;
    }

    public final void c() {
        Object objPrevious;
        if (this.c == null) {
            eb ebVar = this.b;
            ListIterator<E> listIterator = ebVar.listIterator(ebVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((r30) objPrevious).a) {
                        break;
                    }
                }
            }
        }
        this.c = null;
    }

    public final void d() {
        Object objPrevious;
        r30 r30Var = this.c;
        if (r30Var == null) {
            eb ebVar = this.b;
            ListIterator listIterator = ebVar.listIterator(ebVar.d);
            while (true) {
                if (listIterator.hasPrevious()) {
                    objPrevious = listIterator.previous();
                    if (((r30) objPrevious).a) {
                        break;
                    }
                } else {
                    objPrevious = null;
                    break;
                }
            }
            r30Var = (r30) objPrevious;
        }
        this.c = null;
        if (r30Var == null) {
            this.a.run();
            return;
        }
        switch (r30Var.d) {
            case 0:
                y30 y30Var = (y30) r30Var.e;
                y30Var.z(true);
                if (!y30Var.h.a) {
                    y30Var.g.d();
                } else {
                    y30Var.P();
                }
                break;
            default:
                ((xp) r30Var.e).g(r30Var);
                break;
        }
    }

    public final void e(boolean z) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.e;
        if (onBackInvokedDispatcher == null || (onBackInvokedCallback = this.d) == null) {
            return;
        }
        xn0 xn0Var = xn0.a;
        if (z && !this.f) {
            xn0Var.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f = true;
        } else {
            if (z || !this.f) {
                return;
            }
            xn0Var.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f = false;
        }
    }

    public final void f() {
        boolean z = this.g;
        boolean z2 = false;
        eb ebVar = this.b;
        if (ebVar == null || !ebVar.isEmpty()) {
            Iterator<E> it = ebVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((r30) it.next()).a) {
                    z2 = true;
                    break;
                }
            }
        }
        this.g = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        e(z2);
    }
}
