package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import defpackage.a9;
import defpackage.al1;
import defpackage.cs1;
import defpackage.do1;
import defpackage.hs1;
import defpackage.ie;
import defpackage.ja0;
import defpackage.l10;
import defpackage.mj1;
import defpackage.mk1;
import defpackage.nc;
import defpackage.ok1;
import defpackage.p60;
import defpackage.pm1;
import defpackage.qn1;
import defpackage.s1;
import defpackage.t7;
import defpackage.tb0;
import defpackage.tq1;
import defpackage.vo1;
import defpackage.w60;
import defpackage.x60;
import defpackage.xg;
import defpackage.xm;
import defpackage.xy0;
import defpackage.y60;
import defpackage.yr1;
import defpackage.z60;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements t7 {
    public static final l10[] x = new l10[0];
    public volatile String a;
    public xg b;
    public final Context c;
    public final cs1 d;
    public final al1 e;
    public final Object f;
    public final Object g;
    public ok1 h;
    public ie i;
    public IInterface j;
    public final ArrayList k;
    public qn1 l;
    public int m;
    public final tb0 n;
    public final tb0 o;
    public final int p;
    public final String q;
    public volatile String r;
    public xm s;
    public boolean t;
    public volatile tq1 u;
    public final AtomicInteger v;
    public final Set w;

    public a(Context context, Looper looper, int i, a9 a9Var, y60 y60Var, z60 z60Var) {
        synchronized (cs1.g) {
            try {
                if (cs1.h == null) {
                    cs1.h = new cs1(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        cs1 cs1Var = cs1.h;
        Object obj = w60.b;
        xy0.d(y60Var);
        xy0.d(z60Var);
        tb0 tb0Var = new tb0(23, y60Var);
        tb0 tb0Var2 = new tb0(24, z60Var);
        String str = (String) a9Var.d;
        this.a = null;
        this.f = new Object();
        this.g = new Object();
        this.k = new ArrayList();
        this.m = 1;
        this.s = null;
        this.t = false;
        this.u = null;
        this.v = new AtomicInteger(0);
        xy0.e("Context must not be null", context);
        this.c = context;
        xy0.e("Looper must not be null", looper);
        xy0.e("Supervisor must not be null", cs1Var);
        this.d = cs1Var;
        this.e = new al1(this, looper);
        this.p = i;
        this.n = tb0Var;
        this.o = tb0Var2;
        this.q = str;
        Set set = (Set) a9Var.b;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                s1.f("Expanding scopes is not permitted, use implied scopes instead");
                throw null;
            }
        }
        this.w = set;
    }

    public static /* bridge */ /* synthetic */ boolean t(a aVar, int i, int i2, IInterface iInterface) {
        synchronized (aVar.f) {
            try {
                if (aVar.m != i) {
                    return false;
                }
                aVar.u(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.t7
    public final Set a() {
        return j() ? this.w : Collections.EMPTY_SET;
    }

    @Override // defpackage.t7
    public final void b(String str) {
        this.a = str;
        m();
    }

    @Override // defpackage.t7
    public final boolean d() {
        boolean z;
        synchronized (this.f) {
            int i = this.m;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    @Override // defpackage.t7
    public final l10[] e() {
        tq1 tq1Var = this.u;
        if (tq1Var == null) {
            return null;
        }
        return tq1Var.c;
    }

    @Override // defpackage.t7
    public final void f() {
        if (!isConnected() || this.b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    @Override // defpackage.t7
    public final void g(ie ieVar) {
        this.i = ieVar;
        u(2, null);
    }

    @Override // defpackage.t7
    public final String h() {
        return this.a;
    }

    @Override // defpackage.t7
    public final void i(tb0 tb0Var) {
        ((mj1) tb0Var.c).m.m.post(new nc(23, tb0Var));
    }

    @Override // defpackage.t7
    public final boolean isConnected() {
        boolean z;
        synchronized (this.f) {
            z = this.m == 4;
        }
        return z;
    }

    @Override // defpackage.t7
    public boolean j() {
        return false;
    }

    @Override // defpackage.t7
    public final void k(ja0 ja0Var, Set set) {
        Bundle bundleO = o();
        String str = this.r;
        int i = x60.a;
        Scope[] scopeArr = p60.p;
        Bundle bundle = new Bundle();
        int i2 = this.p;
        l10[] l10VarArr = p60.q;
        p60 p60Var = new p60(6, i2, i, null, null, scopeArr, bundle, null, l10VarArr, l10VarArr, true, 0, false, str);
        p60Var.e = this.c.getPackageName();
        p60Var.h = bundleO;
        if (set != null) {
            p60Var.g = (Scope[]) set.toArray(new Scope[0]);
        }
        if (j()) {
            p60Var.i = new Account("<<default account>>", "com.google");
            if (ja0Var != null) {
                p60Var.f = ((hs1) ja0Var).b;
            }
        }
        p60Var.j = x;
        p60Var.k = n();
        try {
            synchronized (this.g) {
                try {
                    ok1 ok1Var = this.h;
                    if (ok1Var != null) {
                        ok1Var.a(new pm1(this, this.v.get()), p60Var);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i3 = this.v.get();
            al1 al1Var = this.e;
            al1Var.sendMessage(al1Var.obtainMessage(6, i3, 3));
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i4 = this.v.get();
            do1 do1Var = new do1(this, 8, null, null);
            al1 al1Var2 = this.e;
            al1Var2.sendMessage(al1Var2.obtainMessage(1, i4, -1, do1Var));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i42 = this.v.get();
            do1 do1Var2 = new do1(this, 8, null, null);
            al1 al1Var22 = this.e;
            al1Var22.sendMessage(al1Var22.obtainMessage(1, i42, -1, do1Var2));
        }
    }

    public abstract IInterface l(IBinder iBinder);

    public final void m() {
        this.v.incrementAndGet();
        synchronized (this.k) {
            try {
                int size = this.k.size();
                int i = 0;
                while (true) {
                    ArrayList arrayList = this.k;
                    if (i < size) {
                        mk1 mk1Var = (mk1) arrayList.get(i);
                        synchronized (mk1Var) {
                            mk1Var.a = null;
                        }
                        i++;
                    } else {
                        arrayList.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.g) {
            this.h = null;
        }
        u(1, null);
    }

    public l10[] n() {
        return x;
    }

    public abstract Bundle o();

    public final IInterface p() {
        IInterface iInterface;
        synchronized (this.f) {
            try {
                if (this.m == 5) {
                    throw new DeadObjectException();
                }
                if (!isConnected()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.j;
                xy0.e("Client is connected but service is null", iInterface);
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String q();

    public abstract String r();

    public boolean s() {
        return c() >= 211700000;
    }

    public final void u(int i, IInterface iInterface) {
        xg xgVar;
        if ((i == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f) {
            try {
                this.m = i;
                this.j = iInterface;
                if (i == 1) {
                    qn1 qn1Var = this.l;
                    if (qn1Var != null) {
                        cs1 cs1Var = this.d;
                        String str = (String) this.b.c;
                        xy0.d(str);
                        this.b.getClass();
                        if (this.q == null) {
                            this.c.getClass();
                        }
                        cs1Var.a(str, qn1Var, this.b.b);
                        this.l = null;
                    }
                } else if (i == 2 || i == 3) {
                    qn1 qn1Var2 = this.l;
                    if (qn1Var2 != null && (xgVar = this.b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) xgVar.c) + " on com.google.android.gms");
                        cs1 cs1Var2 = this.d;
                        String str2 = (String) this.b.c;
                        xy0.d(str2);
                        this.b.getClass();
                        if (this.q == null) {
                            this.c.getClass();
                        }
                        cs1Var2.a(str2, qn1Var2, this.b.b);
                        this.v.incrementAndGet();
                    }
                    qn1 qn1Var3 = new qn1(this, this.v.get());
                    this.l = qn1Var3;
                    String strR = r();
                    boolean zS = s();
                    this.b = new xg(strR, zS);
                    if (zS && c() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.b.c)));
                    }
                    cs1 cs1Var3 = this.d;
                    String str3 = (String) this.b.c;
                    xy0.d(str3);
                    this.b.getClass();
                    String name = this.q;
                    if (name == null) {
                        name = this.c.getClass().getName();
                    }
                    if (!cs1Var3.b(new yr1(str3, this.b.b), qn1Var3, name)) {
                        Log.w("GmsClient", "unable to connect to service: " + ((String) this.b.c) + " on com.google.android.gms");
                        int i2 = this.v.get();
                        vo1 vo1Var = new vo1(this, 16);
                        al1 al1Var = this.e;
                        al1Var.sendMessage(al1Var.obtainMessage(7, i2, -1, vo1Var));
                    }
                } else if (i == 4) {
                    xy0.d(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}
