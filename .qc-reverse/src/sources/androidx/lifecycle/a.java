package androidx.lifecycle;

import android.os.Looper;
import defpackage.cb;
import defpackage.dg0;
import defpackage.fg0;
import defpackage.fx0;
import defpackage.gg0;
import defpackage.hg0;
import defpackage.ig0;
import defpackage.j10;
import defpackage.l11;
import defpackage.o50;
import defpackage.os;
import defpackage.wf0;
import defpackage.yf0;
import defpackage.zf0;
import defpackage.zy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final boolean a;
    public j10 b;
    public zf0 c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h;

    public a(gg0 gg0Var) {
        new AtomicReference();
        this.a = true;
        this.b = new j10();
        this.c = zf0.c;
        this.h = new ArrayList();
        this.d = new WeakReference(gg0Var);
    }

    public final void a(fg0 fg0Var) {
        dg0 reflectiveGenericLifecycleObserver;
        Object obj;
        gg0 gg0Var;
        c("addObserver");
        zf0 zf0Var = this.c;
        zf0 zf0Var2 = zf0.b;
        if (zf0Var != zf0Var2) {
            zf0Var2 = zf0.c;
        }
        hg0 hg0Var = new hg0();
        HashMap map = ig0.a;
        boolean z = fg0Var instanceof dg0;
        boolean z2 = fg0Var instanceof os;
        if (z && z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((os) fg0Var, (dg0) fg0Var);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((os) fg0Var, null);
        } else if (z) {
            reflectiveGenericLifecycleObserver = (dg0) fg0Var;
        } else {
            Class<?> cls = fg0Var.getClass();
            if (ig0.b(cls) == 2) {
                Object obj2 = ig0.b.get(cls);
                obj2.getClass();
                List list = (List) obj2;
                if (list.size() == 1) {
                    ig0.a((Constructor) list.get(0), fg0Var);
                    throw null;
                }
                int size = list.size();
                o50[] o50VarArr = new o50[size];
                if (size > 0) {
                    ig0.a((Constructor) list.get(0), fg0Var);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(o50VarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(fg0Var);
            }
        }
        hg0Var.b = reflectiveGenericLifecycleObserver;
        hg0Var.a = zf0Var2;
        j10 j10Var = this.b;
        fx0 fx0VarB = j10Var.b(fg0Var);
        if (fx0VarB != null) {
            obj = fx0VarB.c;
        } else {
            HashMap map2 = j10Var.f;
            fx0 fx0Var = new fx0(fg0Var, hg0Var);
            j10Var.e++;
            fx0 fx0Var2 = j10Var.c;
            if (fx0Var2 == null) {
                j10Var.b = fx0Var;
                j10Var.c = fx0Var;
            } else {
                fx0Var2.d = fx0Var;
                fx0Var.e = fx0Var2;
                j10Var.c = fx0Var;
            }
            map2.put(fg0Var, fx0Var);
            obj = null;
        }
        if (((hg0) obj) == null && (gg0Var = (gg0) this.d.get()) != null) {
            boolean z3 = this.e != 0 || this.f;
            zf0 zf0VarB = b(fg0Var);
            this.e++;
            while (hg0Var.a.compareTo(zf0VarB) < 0 && this.b.f.containsKey(fg0Var)) {
                zf0 zf0Var3 = hg0Var.a;
                ArrayList arrayList = this.h;
                arrayList.add(zf0Var3);
                wf0 wf0Var = yf0.Companion;
                zf0 zf0Var4 = hg0Var.a;
                wf0Var.getClass();
                zf0Var4.getClass();
                int iOrdinal = zf0Var4.ordinal();
                yf0 yf0Var = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : yf0.ON_RESUME : yf0.ON_START : yf0.ON_CREATE;
                if (yf0Var == null) {
                    zy.t("no event up from ", hg0Var.a);
                    return;
                } else {
                    hg0Var.a(gg0Var, yf0Var);
                    arrayList.remove(arrayList.size() - 1);
                    zf0VarB = b(fg0Var);
                }
            }
            if (!z3) {
                g();
            }
            this.e--;
        }
    }

    public final zf0 b(fg0 fg0Var) {
        hg0 hg0Var;
        HashMap map = this.b.f;
        fx0 fx0Var = map.containsKey(fg0Var) ? ((fx0) map.get(fg0Var)).e : null;
        zf0 zf0Var = (fx0Var == null || (hg0Var = (hg0) fx0Var.c) == null) ? null : hg0Var.a;
        ArrayList arrayList = this.h;
        zf0 zf0Var2 = arrayList.isEmpty() ? null : (zf0) arrayList.get(arrayList.size() - 1);
        zf0 zf0Var3 = this.c;
        zf0Var3.getClass();
        if (zf0Var == null || zf0Var.compareTo(zf0Var3) >= 0) {
            zf0Var = zf0Var3;
        }
        return (zf0Var2 == null || zf0Var2.compareTo(zf0Var) >= 0) ? zf0Var : zf0Var2;
    }

    public final void c(String str) {
        if (this.a) {
            ((cb) cb.K0().n).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(l11.j("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(yf0 yf0Var) {
        yf0Var.getClass();
        c("handleLifecycleEvent");
        e(yf0Var.a());
    }

    public final void e(zf0 zf0Var) {
        zf0 zf0Var2 = this.c;
        if (zf0Var2 == zf0Var) {
            return;
        }
        zf0 zf0Var3 = zf0.c;
        zf0 zf0Var4 = zf0.b;
        if (zf0Var2 == zf0Var3 && zf0Var == zf0Var4) {
            StringBuilder sb = new StringBuilder("no event down from ");
            sb.append(this.c);
            Object obj = this.d.get();
            sb.append(" in component ");
            sb.append(obj);
            throw new IllegalStateException(sb.toString().toString());
        }
        this.c = zf0Var;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        g();
        this.f = false;
        if (this.c == zf0Var4) {
            this.b = new j10();
        }
    }

    public final void f(fg0 fg0Var) {
        fg0Var.getClass();
        c("removeObserver");
        this.b.c(fg0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r11.g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.a.g():void");
    }
}
