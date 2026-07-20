package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class gd0 implements yc0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(gd0.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ long d;
    public static final /* synthetic */ long e;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    static {
        Unsafe unsafe = sz.a;
        e = unsafe.objectFieldOffset(gd0.class.getDeclaredField("_state$volatile"));
        c = AtomicReferenceFieldUpdater.newUpdater(gd0.class, Object.class, "_parentHandle$volatile");
        d = unsafe.objectFieldOffset(gd0.class.getDeclaredField("_parentHandle$volatile"));
    }

    public gd0(boolean z) {
        this._state$volatile = z ? yb0.k : yb0.j;
    }

    public static ak C(hi0 hi0Var) {
        while (hi0Var.l()) {
            hi0Var = hi0Var.k();
        }
        while (true) {
            hi0Var = hi0Var.j();
            if (!hi0Var.l()) {
                if (hi0Var instanceof ak) {
                    return (ak) hi0Var;
                }
                if (hi0Var instanceof wm0) {
                    return null;
                }
            }
        }
    }

    public static String L(Object obj) {
        if (!(obj instanceof ed0)) {
            return obj instanceof xa0 ? ((xa0) obj).a() ? "Active" : "New" : obj instanceof am ? "Cancelled" : "Completed";
        }
        ed0 ed0Var = (ed0) obj;
        return ed0Var.f() ? "Cancelling" : ed0Var.g() ? "Completing" : "Active";
    }

    public boolean A() {
        return false;
    }

    public final Object B(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objO;
        do {
            objO = O(v(), obj);
            if (objO == yb0.e) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                am amVar = obj instanceof am ? (am) obj : null;
                throw new IllegalStateException(str, amVar != null ? amVar.a : null);
            }
        } while (objO == yb0.g);
        return objO;
    }

    public final void D(wm0 wm0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Object objI = wm0Var.i();
        objI.getClass();
        cm cmVar = null;
        for (hi0 hi0VarJ = (hi0) objI; !hi0VarJ.equals(wm0Var); hi0VarJ = hi0VarJ.j()) {
            if (hi0VarJ instanceof ad0) {
                cd0 cd0Var = (cd0) hi0VarJ;
                try {
                    cd0Var.q(th);
                } catch (Throwable th2) {
                    if (cmVar != null) {
                        f01.b(cmVar, th2);
                    } else {
                        cmVar = new cm("Exception in completion handler " + cd0Var + " for " + this, th2);
                    }
                }
            }
        }
        if (cmVar != null) {
            x(cmVar);
        }
        l(th);
    }

    public final void G(ky kyVar) {
        wm0 wm0Var = new wm0();
        Object wa0Var = kyVar.a ? wm0Var : new wa0(wm0Var);
        while (true) {
            b.getClass();
            Unsafe unsafe = sz.a;
            long j = e;
            gd0 gd0Var = this;
            ky kyVar2 = kyVar;
            if (unsafe.compareAndSwapObject(gd0Var, j, kyVar2, wa0Var) || unsafe.getObjectVolatile(gd0Var, j) != kyVar2) {
                return;
            }
            this = gd0Var;
            kyVar = kyVar2;
        }
    }

    public final void H(cd0 cd0Var) {
        cd0Var.e(new wm0());
        hi0 hi0VarJ = cd0Var.j();
        while (true) {
            b.getClass();
            Unsafe unsafe = sz.a;
            long j = e;
            gd0 gd0Var = this;
            cd0 cd0Var2 = cd0Var;
            if (unsafe.compareAndSwapObject(gd0Var, j, cd0Var2, hi0VarJ) || unsafe.getObjectVolatile(gd0Var, j) != cd0Var2) {
                return;
            }
            this = gd0Var;
            cd0Var = cd0Var2;
        }
    }

    public final void I(cd0 cd0Var) {
        gd0 gd0Var;
        while (true) {
            Object objV = this.v();
            if (!(objV instanceof cd0)) {
                if (!(objV instanceof xa0) || ((xa0) objV).d() == null) {
                    return;
                }
                cd0Var.m();
                return;
            }
            if (objV != cd0Var) {
                return;
            }
            ky kyVar = yb0.k;
            while (true) {
                b.getClass();
                Unsafe unsafe = sz.a;
                long j = e;
                gd0Var = this;
                if (unsafe.compareAndSwapObject(gd0Var, j, objV, kyVar)) {
                    return;
                }
                if (unsafe.getObjectVolatile(gd0Var, j) != objV) {
                    break;
                } else {
                    this = gd0Var;
                }
            }
            this = gd0Var;
        }
    }

    public final void J(zj zjVar) {
        c.getClass();
        sz.a.putObjectVolatile(this, d, zjVar);
    }

    public final int K(Object obj) {
        Unsafe unsafe;
        Unsafe unsafe2;
        boolean z = obj instanceof ky;
        long j = e;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        if (z) {
            if (((ky) obj).a) {
                return 0;
            }
            ky kyVar = yb0.k;
            do {
                atomicReferenceFieldUpdater.getClass();
                unsafe2 = sz.a;
                if (unsafe2.compareAndSwapObject(this, e, obj, kyVar)) {
                    return 1;
                }
            } while (unsafe2.getObjectVolatile(this, j) == obj);
            return -1;
        }
        if (!(obj instanceof wa0)) {
            return 0;
        }
        wm0 wm0Var = ((wa0) obj).a;
        do {
            atomicReferenceFieldUpdater.getClass();
            unsafe = sz.a;
            if (unsafe.compareAndSwapObject(this, e, obj, wm0Var)) {
                return 1;
            }
        } while (unsafe.getObjectVolatile(this, j) == obj);
        return -1;
    }

    public final boolean M(xa0 xa0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        Object ya0Var = obj instanceof xa0 ? new ya0((xa0) obj) : obj;
        while (true) {
            b.getClass();
            Unsafe unsafe = sz.a;
            long j = e;
            gd0 gd0Var = this;
            xa0 xa0Var2 = xa0Var;
            if (unsafe.compareAndSwapObject(gd0Var, j, xa0Var2, ya0Var)) {
                gd0Var.E(obj);
                gd0Var.o(xa0Var2, obj);
                return true;
            }
            if (unsafe.getObjectVolatile(gd0Var, j) != xa0Var2) {
                return false;
            }
            this = gd0Var;
            xa0Var = xa0Var2;
        }
    }

    public final boolean N(xa0 xa0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        wm0 wm0VarT = t(xa0Var);
        if (wm0VarT == null) {
            return false;
        }
        ed0 ed0Var = new ed0(wm0VarT, th);
        while (true) {
            b.getClass();
            Unsafe unsafe = sz.a;
            long j = e;
            gd0 gd0Var = this;
            xa0 xa0Var2 = xa0Var;
            if (unsafe.compareAndSwapObject(gd0Var, j, xa0Var2, ed0Var)) {
                gd0Var.D(wm0VarT, th);
                return true;
            }
            if (unsafe.getObjectVolatile(gd0Var, j) != xa0Var2) {
                return false;
            }
            this = gd0Var;
            xa0Var = xa0Var2;
        }
    }

    public final Object O(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (!(obj instanceof xa0)) {
            return yb0.e;
        }
        if (((obj instanceof ky) || (obj instanceof cd0)) && !(obj instanceof ak) && !(obj2 instanceof am)) {
            return M((xa0) obj, obj2) ? obj2 : yb0.g;
        }
        xa0 xa0Var = (xa0) obj;
        wm0 wm0VarT = t(xa0Var);
        if (wm0VarT == null) {
            return yb0.g;
        }
        ak akVarC = null;
        ed0 ed0Var = xa0Var instanceof ed0 ? (ed0) xa0Var : null;
        if (ed0Var == null) {
            ed0Var = new ed0(wm0VarT, null);
        }
        synchronized (ed0Var) {
            if (ed0Var.g()) {
                return yb0.e;
            }
            ed0.b.set(ed0Var, 1);
            if (ed0Var != xa0Var) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, xa0Var, ed0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != xa0Var) {
                        return yb0.g;
                    }
                }
            }
            boolean zF = ed0Var.f();
            am amVar = obj2 instanceof am ? (am) obj2 : null;
            if (amVar != null) {
                ed0Var.b(amVar.a);
            }
            Throwable thE = ed0Var.e();
            if (zF) {
                thE = null;
            }
            if (thE != null) {
                D(wm0VarT, thE);
            }
            ak akVar = xa0Var instanceof ak ? (ak) xa0Var : null;
            if (akVar == null) {
                wm0 wm0VarD = xa0Var.d();
                if (wm0VarD != null) {
                    akVarC = C(wm0VarD);
                }
            } else {
                akVarC = akVar;
            }
            if (akVarC != null) {
                while (i1.B(akVarC.h, false, new dd0(this, ed0Var, akVarC, obj2), 1) == xm0.a) {
                    akVarC = C(akVarC);
                    if (akVarC == null) {
                    }
                }
                return yb0.f;
            }
            return q(ed0Var, obj2);
        }
    }

    @Override // defpackage.yc0
    public boolean a() {
        Object objV = v();
        return (objV instanceof xa0) && ((xa0) objV).a();
    }

    @Override // defpackage.ep
    public final Object g(Object obj, z40 z40Var) {
        return z40Var.f(obj, this);
    }

    @Override // defpackage.cp
    public final dp getKey() {
        return ow0.f;
    }

    @Override // defpackage.ep
    public final ep h(ep epVar) {
        return xy0.t(this, epVar);
    }

    @Override // defpackage.ep
    public final cp i(dp dpVar) {
        dpVar.getClass();
        if (fc0.b(ow0.f, dpVar)) {
            return this;
        }
        return null;
    }

    public void j(Object obj) {
        f(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037 A[PHI: r0
  0x0037: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v9 java.lang.Object) binds: [B:3:0x0005, B:16:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.Object r8) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gd0.k(java.lang.Object):boolean");
    }

    public final boolean l(Throwable th) {
        if (A()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        zj zjVarU = u();
        return (zjVarU == null || zjVarU == xm0.a) ? z : zjVarU.c(th) || z;
    }

    @Override // defpackage.ep
    public final ep m(dp dpVar) {
        dpVar.getClass();
        return fc0.b(ow0.f, dpVar) ? my.b : this;
    }

    public String n() {
        return "Job was cancelled";
    }

    public final void o(xa0 xa0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        zj zjVarU = u();
        if (zjVarU != null) {
            zjVarU.b();
            J(xm0.a);
        }
        cm cmVar = null;
        am amVar = obj instanceof am ? (am) obj : null;
        Throwable th = amVar != null ? amVar.a : null;
        if (xa0Var instanceof cd0) {
            try {
                ((cd0) xa0Var).q(th);
                return;
            } catch (Throwable th2) {
                x(new cm("Exception in completion handler " + xa0Var + " for " + this, th2));
                return;
            }
        }
        wm0 wm0VarD = xa0Var.d();
        if (wm0VarD != null) {
            Object objI = wm0VarD.i();
            objI.getClass();
            for (hi0 hi0VarJ = (hi0) objI; !hi0VarJ.equals(wm0VarD); hi0VarJ = hi0VarJ.j()) {
                if (hi0VarJ instanceof cd0) {
                    cd0 cd0Var = (cd0) hi0VarJ;
                    try {
                        cd0Var.q(th);
                    } catch (Throwable th3) {
                        if (cmVar != null) {
                            f01.b(cmVar, th3);
                        } else {
                            cmVar = new cm("Exception in completion handler " + cd0Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (cmVar != null) {
                x(cmVar);
            }
        }
    }

    public final Throwable p(Object obj) {
        Throwable thE;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        gd0 gd0Var = (gd0) obj;
        Object objV = gd0Var.v();
        if (objV instanceof ed0) {
            thE = ((ed0) objV).e();
        } else if (objV instanceof am) {
            thE = ((am) objV).a;
        } else {
            if (objV instanceof xa0) {
                zy.q("Cannot be cancelling child in this state: ", objV);
                return null;
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        return cancellationException == null ? new zc0("Parent job is ".concat(L(objV)), thE, gd0Var) : cancellationException;
    }

    public final Object q(ed0 ed0Var, Object obj) throws Throwable {
        ed0 ed0Var2;
        Throwable th;
        ArrayList arrayListH;
        gd0 gd0Var;
        ed0 ed0Var3;
        Object obj2 = null;
        Throwable zc0Var = null;
        am amVar = obj instanceof am ? (am) obj : null;
        Throwable th2 = amVar != null ? amVar.a : null;
        synchronized (ed0Var) {
            try {
                ed0Var.f();
                arrayListH = ed0Var.h(th2);
            } catch (Throwable th3) {
                ed0Var2 = ed0Var;
                th = th3;
            }
            try {
                if (!arrayListH.isEmpty()) {
                    int size = arrayListH.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        Object obj3 = arrayListH.get(i);
                        i++;
                        if (!(((Throwable) obj3) instanceof CancellationException)) {
                            obj2 = obj3;
                            break;
                        }
                    }
                    zc0Var = (Throwable) obj2;
                    if (zc0Var == null) {
                        zc0Var = (Throwable) arrayListH.get(0);
                    }
                } else if (ed0Var.f()) {
                    zc0Var = new zc0(n(), null, this);
                }
                if (zc0Var != null && arrayListH.size() > 1) {
                    Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListH.size()));
                    int size2 = arrayListH.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj4 = arrayListH.get(i2);
                        i2++;
                        Throwable th4 = (Throwable) obj4;
                        if (th4 != zc0Var && th4 != zc0Var && !(th4 instanceof CancellationException) && setNewSetFromMap.add(th4)) {
                            f01.b(zc0Var, th4);
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                ed0Var2 = ed0Var;
                throw th;
            }
        }
        if (zc0Var != null && zc0Var != th2) {
            obj = new am(zc0Var);
        }
        if (zc0Var != null && (l(zc0Var) || w(zc0Var))) {
            obj.getClass();
            am.b.compareAndSet((am) obj, 0, 1);
        }
        E(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        Object ya0Var = obj instanceof xa0 ? new ya0((xa0) obj) : obj;
        while (true) {
            atomicReferenceFieldUpdater.getClass();
            Unsafe unsafe = sz.a;
            long j = e;
            gd0Var = this;
            ed0Var3 = ed0Var;
            if (unsafe.compareAndSwapObject(gd0Var, j, ed0Var3, ya0Var) || unsafe.getObjectVolatile(gd0Var, j) != ed0Var3) {
                break;
            }
            this = gd0Var;
            ed0Var = ed0Var3;
        }
        gd0Var.o(ed0Var3, obj);
        return obj;
    }

    public final CancellationException r() {
        CancellationException cancellationException;
        Object objV = v();
        if (objV instanceof ed0) {
            Throwable thE = ((ed0) objV).e();
            if (thE == null) {
                zy.q("Job is still new or active: ", this);
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
            return cancellationException == null ? new zc0(strConcat, thE, this) : cancellationException;
        }
        if (objV instanceof xa0) {
            zy.q("Job is still new or active: ", this);
            return null;
        }
        if (!(objV instanceof am)) {
            return new zc0(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((am) objV).a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new zc0(n(), th, this) : cancellationException;
    }

    public boolean s() {
        return true;
    }

    public final wm0 t(xa0 xa0Var) {
        wm0 wm0VarD = xa0Var.d();
        if (wm0VarD != null) {
            return wm0VarD;
        }
        if (xa0Var instanceof ky) {
            return new wm0();
        }
        if (xa0Var instanceof cd0) {
            H((cd0) xa0Var);
            return null;
        }
        zy.q("State should have list: ", xa0Var);
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + L(v()) + '}');
        sb.append('@');
        sb.append(xr.p(this));
        return sb.toString();
    }

    public final zj u() {
        c.getClass();
        return (zj) sz.a.getObjectVolatile(this, d);
    }

    public final Object v() {
        while (true) {
            b.getClass();
            Object objectVolatile = sz.a.getObjectVolatile(this, e);
            if (!(objectVolatile instanceof xb)) {
                return objectVolatile;
            }
            ((xb) objectVolatile).c(this);
        }
    }

    public boolean w(Throwable th) {
        return false;
    }

    public final void y(yc0 yc0Var) {
        int iK;
        xm0 xm0Var = xm0.a;
        if (yc0Var == null) {
            J(xm0Var);
            return;
        }
        gd0 gd0Var = (gd0) yc0Var;
        do {
            iK = gd0Var.K(gd0Var.v());
            if (iK == 0) {
                break;
            }
        } while (iK != 1);
        zj zjVar = (zj) i1.B(gd0Var, true, new ak(this), 2);
        J(zjVar);
        if (v() instanceof xa0) {
            return;
        }
        zjVar.b();
        J(xm0Var);
    }

    public final lu z(boolean z, boolean z2, cd0 cd0Var) {
        cd0 kc0Var;
        gd0 gd0Var;
        Throwable thE;
        int iO;
        boolean z3;
        if (z) {
            kc0Var = cd0Var instanceof ad0 ? (ad0) cd0Var : null;
            if (kc0Var == null) {
                kc0Var = new jc0(cd0Var);
            }
        } else {
            kc0Var = cd0Var instanceof cd0 ? cd0Var : null;
            if (kc0Var == null) {
                kc0Var = new kc0(cd0Var);
            }
        }
        cd0 cd0Var2 = kc0Var;
        cd0Var2.g = this;
        loop0: while (true) {
            Object objV = this.v();
            if (objV instanceof ky) {
                ky kyVar = (ky) objV;
                if (kyVar.a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                    while (true) {
                        atomicReferenceFieldUpdater.getClass();
                        Unsafe unsafe = sz.a;
                        long j = e;
                        gd0Var = this;
                        if (unsafe.compareAndSwapObject(gd0Var, j, objV, cd0Var2)) {
                            break loop0;
                        }
                        if (unsafe.getObjectVolatile(gd0Var, j) != objV) {
                            break;
                        }
                        this = gd0Var;
                    }
                } else {
                    gd0Var = this;
                    gd0Var.G(kyVar);
                }
                this = gd0Var;
            } else {
                gd0Var = this;
                if (!(objV instanceof xa0)) {
                    if (z2) {
                        am amVar = objV instanceof am ? (am) objV : null;
                        cd0Var.q(amVar != null ? amVar.a : null);
                    }
                    return xm0.a;
                }
                xa0 xa0Var = (xa0) objV;
                wm0 wm0VarD = xa0Var.d();
                if (wm0VarD != null) {
                    lu luVar = xm0.a;
                    if (z && (objV instanceof ed0)) {
                        synchronized (objV) {
                            try {
                                thE = ((ed0) objV).e();
                                if (thE == null || ((cd0Var instanceof ak) && !((ed0) objV).g())) {
                                    fd0 fd0Var = new fd0(cd0Var2, gd0Var, (xa0) objV);
                                    while (true) {
                                        int iO2 = wm0VarD.k().o(cd0Var2, wm0VarD, fd0Var);
                                        if (iO2 == 1) {
                                            z3 = true;
                                            break;
                                        }
                                        if (iO2 == 2) {
                                            z3 = false;
                                            break;
                                        }
                                    }
                                    if (z3) {
                                        if (thE == null) {
                                            return cd0Var2;
                                        }
                                        luVar = cd0Var2;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        thE = null;
                    }
                    if (thE == null) {
                        fd0 fd0Var2 = new fd0(cd0Var2, gd0Var, xa0Var);
                        do {
                            iO = wm0VarD.k().o(cd0Var2, wm0VarD, fd0Var2);
                            if (iO == 1) {
                                break loop0;
                            }
                        } while (iO != 2);
                    } else {
                        if (z2) {
                            cd0Var.q(thE);
                        }
                        return luVar;
                    }
                } else {
                    gd0Var.H((cd0) objV);
                }
                this = gd0Var;
            }
        }
        return cd0Var2;
    }

    public void F() {
    }

    public void E(Object obj) {
    }

    public void f(Object obj) {
    }

    public void x(cm cmVar) {
        throw cmVar;
    }
}
