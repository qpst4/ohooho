package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ed0 implements xa0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ed0.class, "_isCompleting$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(ed0.class, Object.class, "_rootCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d;
    public static final /* synthetic */ long e;
    public static final /* synthetic */ long f;
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;
    public final wm0 a;

    static {
        Unsafe unsafe = sz.a;
        f = unsafe.objectFieldOffset(ed0.class.getDeclaredField("_rootCause$volatile"));
        d = AtomicReferenceFieldUpdater.newUpdater(ed0.class, Object.class, "_exceptionsHolder$volatile");
        e = unsafe.objectFieldOffset(ed0.class.getDeclaredField("_exceptionsHolder$volatile"));
    }

    public ed0(wm0 wm0Var, Throwable th) {
        this.a = wm0Var;
        this._rootCause$volatile = th;
    }

    @Override // defpackage.xa0
    public final boolean a() {
        return e() == null;
    }

    public final void b(Throwable th) {
        Throwable thE = e();
        if (thE == null) {
            j(th);
            return;
        }
        if (th == thE) {
            return;
        }
        Object objC = c();
        if (objC == null) {
            i(th);
            return;
        }
        if (!(objC instanceof Throwable)) {
            if (objC instanceof ArrayList) {
                ((ArrayList) objC).add(th);
                return;
            } else {
                zy.q("State is ", objC);
                return;
            }
        }
        if (th == objC) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(objC);
        arrayList.add(th);
        i(arrayList);
    }

    public final Object c() {
        d.getClass();
        return sz.a.getObjectVolatile(this, e);
    }

    @Override // defpackage.xa0
    public final wm0 d() {
        return this.a;
    }

    public final Throwable e() {
        c.getClass();
        return (Throwable) sz.a.getObjectVolatile(this, f);
    }

    public final boolean f() {
        return e() != null;
    }

    public final boolean g() {
        return b.get(this) != 0;
    }

    public final ArrayList h(Throwable th) {
        ArrayList arrayList;
        Object objC = c();
        if (objC == null) {
            arrayList = new ArrayList(4);
        } else if (objC instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(objC);
            arrayList = arrayList2;
        } else {
            if (!(objC instanceof ArrayList)) {
                zy.q("State is ", objC);
                return null;
            }
            arrayList = (ArrayList) objC;
        }
        Throwable thE = e();
        if (thE != null) {
            arrayList.add(0, thE);
        }
        if (th != null && !th.equals(thE)) {
            arrayList.add(th);
        }
        i(yb0.i);
        return arrayList;
    }

    public final void i(Object obj) {
        d.getClass();
        sz.a.putObjectVolatile(this, e, obj);
    }

    public final void j(Throwable th) {
        c.getClass();
        sz.a.putObjectVolatile(this, f, th);
    }

    public final String toString() {
        return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + c() + ", list=" + this.a + ']';
    }
}
