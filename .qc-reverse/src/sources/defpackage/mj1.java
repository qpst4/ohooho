package defpackage;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mj1 implements y60, z60 {
    public final t7 c;
    public final w7 d;
    public final pn0 e;
    public final int h;
    public final uj1 i;
    public boolean j;
    public final /* synthetic */ a70 m;
    public final LinkedList b = new LinkedList();
    public final HashSet f = new HashSet();
    public final HashMap g = new HashMap();
    public final ArrayList k = new ArrayList();
    public xm l = null;

    public mj1(a70 a70Var, gk1 gk1Var) {
        this.m = a70Var;
        Looper looper = a70Var.m.getLooper();
        ra raVarA = gk1Var.a();
        a9 a9Var = new a9((mb) raVarA.c, (String) raVarA.d, (String) raVarA.e);
        gj1 gj1Var = (gj1) gk1Var.c.c;
        xy0.d(gj1Var);
        t7 t7VarA = gj1Var.a(gk1Var.a, looper, a9Var, gk1Var.d, this, this);
        String str = gk1Var.b;
        if (str != null && (t7VarA instanceof a)) {
            ((a) t7VarA).r = str;
        }
        if (str != null && (t7VarA instanceof ym0)) {
            qq0.j(t7VarA);
            throw null;
        }
        this.c = t7VarA;
        this.d = gk1Var.e;
        this.e = new pn0(18);
        this.h = gk1Var.f;
        if (!t7VarA.j()) {
            this.i = null;
            return;
        }
        Context context = a70Var.e;
        kk1 kk1Var = a70Var.m;
        ra raVarA2 = gk1Var.a();
        this.i = new uj1(context, kk1Var, new a9((mb) raVarA2.c, (String) raVarA2.d, (String) raVarA2.e));
    }

    @Override // defpackage.y60
    public final void a(int i) {
        Looper looperMyLooper = Looper.myLooper();
        kk1 kk1Var = this.m.m;
        if (looperMyLooper == kk1Var.getLooper()) {
            i(i);
        } else {
            kk1Var.post(new hi(i, 3, this));
        }
    }

    @Override // defpackage.z60
    public final void b(xm xmVar) {
        o(xmVar, null);
    }

    @Override // defpackage.y60
    public final void c() {
        Looper looperMyLooper = Looper.myLooper();
        kk1 kk1Var = this.m.m;
        if (looperMyLooper == kk1Var.getLooper()) {
            h();
        } else {
            kk1Var.post(new nc(22, this));
        }
    }

    public final void d(xm xmVar) {
        HashSet hashSet = this.f;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else if (it.next() != null) {
            s1.d();
        } else {
            if (xy0.o(xmVar, xm.f)) {
                this.c.f();
            }
            throw null;
        }
    }

    public final void e(Status status) {
        xy0.c(this.m.m);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z) {
        xy0.c(this.m.m);
        if ((status == null) == (exc == null)) {
            zy.n("Status XOR exception should be null");
            return;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            rj1 rj1Var = (rj1) it.next();
            if (!z || rj1Var.a == 2) {
                if (status != null) {
                    rj1Var.c(status);
                } else {
                    rj1Var.d(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.b;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            rj1 rj1Var = (rj1) arrayList.get(i);
            if (!this.c.isConnected()) {
                return;
            }
            if (k(rj1Var)) {
                linkedList.remove(rj1Var);
            }
        }
    }

    public final void h() {
        a70 a70Var = this.m;
        xy0.c(a70Var.m);
        this.l = null;
        d(xm.f);
        kk1 kk1Var = a70Var.m;
        if (this.j) {
            w7 w7Var = this.d;
            kk1Var.removeMessages(11, w7Var);
            kk1Var.removeMessages(9, w7Var);
            this.j = false;
        }
        Iterator it = this.g.values().iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        g();
        j();
    }

    public final void i(int i) {
        a70 a70Var = this.m;
        kk1 kk1Var = a70Var.m;
        xy0.c(a70Var.m);
        this.l = null;
        this.j = true;
        String strH = this.c.h();
        pn0 pn0Var = this.e;
        pn0Var.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strH != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strH);
        }
        pn0Var.a0(true, new Status(20, sb.toString(), null, null));
        w7 w7Var = this.d;
        kk1Var.sendMessageDelayed(Message.obtain(kk1Var, 9, w7Var), 5000L);
        kk1Var.sendMessageDelayed(Message.obtain(kk1Var, 11, w7Var), 120000L);
        ((SparseIntArray) a70Var.g.c).clear();
        Iterator it = this.g.values().iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
    }

    public final void j() {
        a70 a70Var = this.m;
        kk1 kk1Var = a70Var.m;
        w7 w7Var = this.d;
        kk1Var.removeMessages(12, w7Var);
        kk1Var.sendMessageDelayed(kk1Var.obtainMessage(12, w7Var), a70Var.a);
    }

    public final boolean k(rj1 rj1Var) {
        l10 l10Var;
        if (rj1Var == null) {
            pn0 pn0Var = this.e;
            t7 t7Var = this.c;
            rj1Var.f(pn0Var, t7Var.j());
            try {
                rj1Var.e(this);
                return true;
            } catch (DeadObjectException unused) {
                a(1);
                t7Var.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        l10[] l10VarArrB = rj1Var.b(this);
        if (l10VarArrB == null || l10VarArrB.length == 0) {
            l10Var = null;
        } else {
            l10[] l10VarArrE = this.c.e();
            if (l10VarArrE == null) {
                l10VarArrE = new l10[0];
            }
            kb kbVar = new kb(l10VarArrE.length);
            for (l10 l10Var2 : l10VarArrE) {
                kbVar.put(l10Var2.b, Long.valueOf(l10Var2.a()));
            }
            int length = l10VarArrB.length;
            for (int i = 0; i < length; i++) {
                l10Var = l10VarArrB[i];
                Long l = (Long) kbVar.get(l10Var.b);
                if (l == null || l.longValue() < l10Var.a()) {
                    break;
                }
            }
            l10Var = null;
        }
        if (l10Var == null) {
            pn0 pn0Var2 = this.e;
            t7 t7Var2 = this.c;
            rj1Var.f(pn0Var2, t7Var2.j());
            try {
                rj1Var.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                a(1);
                t7Var2.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.c.getClass().getName() + " could not execute call because it requires feature (" + l10Var.b + ", " + l10Var.a() + ").");
        if (!this.m.n || !rj1Var.a(this)) {
            rj1Var.d(new nd1(l10Var));
            return true;
        }
        nj1 nj1Var = new nj1(this.d, l10Var);
        int iIndexOf = this.k.indexOf(nj1Var);
        ArrayList arrayList = this.k;
        if (iIndexOf >= 0) {
            nj1 nj1Var2 = (nj1) arrayList.get(iIndexOf);
            this.m.m.removeMessages(15, nj1Var2);
            kk1 kk1Var = this.m.m;
            kk1Var.sendMessageDelayed(Message.obtain(kk1Var, 15, nj1Var2), 5000L);
        } else {
            arrayList.add(nj1Var);
            kk1 kk1Var2 = this.m.m;
            kk1Var2.sendMessageDelayed(Message.obtain(kk1Var2, 15, nj1Var), 5000L);
            kk1 kk1Var3 = this.m.m;
            kk1Var3.sendMessageDelayed(Message.obtain(kk1Var3, 16, nj1Var), 120000L);
            xm xmVar = new xm(2, null);
            if (!l(xmVar)) {
                this.m.a(xmVar, this.h);
            }
        }
        return false;
    }

    public final boolean l(xm xmVar) {
        synchronized (a70.q) {
        }
        return false;
    }

    public final void m() {
        a70 a70Var = this.m;
        xy0.c(a70Var.m);
        t7 t7Var = this.c;
        if (t7Var.isConnected() || t7Var.d()) {
            return;
        }
        try {
            pn0 pn0Var = a70Var.g;
            Context context = a70Var.e;
            SparseIntArray sparseIntArray = (SparseIntArray) pn0Var.c;
            xy0.d(context);
            int iC = t7Var.c();
            int iB = ((SparseIntArray) pn0Var.c).get(iC, -1);
            if (iB == -1) {
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > iC && sparseIntArray.get(iKeyAt) == 0) {
                        iB = 0;
                        break;
                    }
                    i++;
                }
                if (iB == -1) {
                    iB = ((w60) pn0Var.d).b(context, iC);
                }
                sparseIntArray.put(iC, iB);
            }
            if (iB != 0) {
                xm xmVar = new xm(iB, null);
                Log.w("GoogleApiManager", "The service for " + t7Var.getClass().getName() + " is not available: " + xmVar.toString());
                o(xmVar, null);
                return;
            }
            o90 o90Var = new o90();
            o90Var.g = a70Var;
            o90Var.e = null;
            o90Var.f = null;
            o90Var.b = false;
            o90Var.c = t7Var;
            o90Var.d = this.d;
            if (t7Var.j()) {
                uj1 uj1Var = this.i;
                xy0.d(uj1Var);
                Handler handler = uj1Var.d;
                a9 a9Var = uj1Var.g;
                q01 q01Var = uj1Var.h;
                if (q01Var != null) {
                    q01Var.m();
                }
                a9Var.f = Integer.valueOf(System.identityHashCode(uj1Var));
                uj1Var.h = (q01) uj1Var.e.a(uj1Var.c, handler.getLooper(), a9Var, (r01) a9Var.e, uj1Var, uj1Var);
                uj1Var.i = o90Var;
                Set set = uj1Var.f;
                if (set == null || set.isEmpty()) {
                    handler.post(new nc(24, uj1Var));
                } else {
                    q01 q01Var2 = uj1Var.h;
                    q01Var2.getClass();
                    q01Var2.g(new sp1(7, q01Var2));
                }
            }
            try {
                t7Var.g(o90Var);
            } catch (SecurityException e) {
                o(new xm(10), e);
            }
        } catch (IllegalStateException e2) {
            o(new xm(10), e2);
        }
    }

    public final void n(rj1 rj1Var) {
        xy0.c(this.m.m);
        boolean zIsConnected = this.c.isConnected();
        LinkedList linkedList = this.b;
        if (zIsConnected) {
            if (k(rj1Var)) {
                j();
                return;
            } else {
                linkedList.add(rj1Var);
                return;
            }
        }
        linkedList.add(rj1Var);
        xm xmVar = this.l;
        if (xmVar == null || xmVar.c == 0 || xmVar.d == null) {
            m();
        } else {
            o(xmVar, null);
        }
    }

    public final void o(xm xmVar, RuntimeException runtimeException) {
        q01 q01Var;
        xy0.c(this.m.m);
        uj1 uj1Var = this.i;
        if (uj1Var != null && (q01Var = uj1Var.h) != null) {
            q01Var.m();
        }
        xy0.c(this.m.m);
        this.l = null;
        ((SparseIntArray) this.m.g.c).clear();
        d(xmVar);
        if ((this.c instanceof ik1) && xmVar.c != 24) {
            a70 a70Var = this.m;
            a70Var.b = true;
            kk1 kk1Var = a70Var.m;
            kk1Var.sendMessageDelayed(kk1Var.obtainMessage(19), 300000L);
        }
        if (xmVar.c == 4) {
            e(a70.p);
            return;
        }
        if (this.b.isEmpty()) {
            this.l = xmVar;
            return;
        }
        a70 a70Var2 = this.m;
        if (runtimeException != null) {
            xy0.c(a70Var2.m);
            f(null, runtimeException, false);
            return;
        }
        boolean z = a70Var2.n;
        w7 w7Var = this.d;
        if (!z) {
            e(a70.b(w7Var, xmVar));
            return;
        }
        f(a70.b(w7Var, xmVar), null, true);
        if (this.b.isEmpty() || l(xmVar) || this.m.a(xmVar, this.h)) {
            return;
        }
        if (xmVar.c == 18) {
            this.j = true;
        }
        if (!this.j) {
            e(a70.b(this.d, xmVar));
            return;
        }
        a70 a70Var3 = this.m;
        w7 w7Var2 = this.d;
        kk1 kk1Var2 = a70Var3.m;
        kk1Var2.sendMessageDelayed(Message.obtain(kk1Var2, 9, w7Var2), 5000L);
    }

    public final void p(xm xmVar) {
        xy0.c(this.m.m);
        t7 t7Var = this.c;
        t7Var.b("onSignInFailed for " + t7Var.getClass().getName() + " with " + String.valueOf(xmVar));
        o(xmVar, null);
    }

    public final void q() {
        xy0.c(this.m.m);
        Status status = a70.o;
        e(status);
        this.e.a0(false, status);
        for (vh0 vh0Var : (vh0[]) this.g.keySet().toArray(new vh0[0])) {
            n(new dk1(new l41()));
        }
        d(new xm(4));
        t7 t7Var = this.c;
        if (t7Var.isConnected()) {
            t7Var.i(new tb0(22, this));
        }
    }
}
