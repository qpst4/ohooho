package defpackage;

import android.app.Application;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.quickcursor.R;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vn1 implements Runnable {
    public final /* synthetic */ int b;
    public Object c;
    public final Object d;

    public vn1(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.b = 11;
        this.d = swipeDismissBehavior;
        this.c = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        xk0 xk0Var;
        ja0 ja0Var;
        final int i = 0;
        Throwable th = null;
        ja0 hs1Var = null;
        th = null;
        final int i2 = 1;
        switch (this.b) {
            case 0:
                t3 t3Var = (t3) this.d;
                zn1 zn1Var = (zn1) this.c;
                if (zn1Var instanceof on1) {
                    on1 on1Var = (on1) zn1Var;
                    if (on1Var instanceof kn1) {
                        Object obj = on1Var.b;
                        if (obj instanceof fn1) {
                            th = ((fn1) obj).a;
                        }
                    }
                    if (th != null) {
                        t3Var.g(th);
                        return;
                    }
                }
                try {
                    if (!zn1Var.isDone()) {
                        throw new IllegalStateException(lc1.y0("Future was expected to be done: %s", zn1Var));
                    }
                    while (true) {
                        try {
                            Object obj2 = zn1Var.get();
                            if (i != 0) {
                                Thread.currentThread().interrupt();
                            }
                            Integer num = (Integer) obj2;
                            int iIntValue = num.intValue();
                            ul1 ul1Var = (ul1) t3Var.d;
                            if (iIntValue <= 0) {
                                ((Runnable) t3Var.c).run();
                                return;
                            }
                            int i3 = t3Var.a;
                            df dfVarA = zl1.a("Billing override value was set by a license tester.", num.intValue());
                            ul1Var.D(105, i3, dfVarA);
                            ((Consumer) t3Var.b).accept(dfVarA);
                            return;
                        } catch (InterruptedException unused) {
                            i = 1;
                        } catch (Throwable th2) {
                            if (i != 0) {
                                Thread.currentThread().interrupt();
                            }
                            throw th2;
                        }
                    }
                } catch (ExecutionException e) {
                    t3Var.g(e.getCause());
                    return;
                } catch (Throwable th3) {
                    t3Var.g(th3);
                    return;
                }
                break;
            case 1:
                x1 x1Var = (x1) this.c;
                a2 a2Var = (a2) this.d;
                zk0 zk0Var = a2Var.d;
                if (zk0Var != null && (xk0Var = zk0Var.e) != null) {
                    xk0Var.n(zk0Var);
                }
                View view = (View) a2Var.i;
                if (view != null && view.getWindowToken() != null) {
                    if (x1Var.b()) {
                        a2Var.t = x1Var;
                    } else if (x1Var.e != null) {
                        x1Var.d(0, 0, false, false);
                        a2Var.t = x1Var;
                    }
                }
                a2Var.v = null;
                return;
            case 2:
                ((a4) this.c).b = this.d;
                return;
            case 3:
                ((Application) this.c).unregisterActivityLifecycleCallbacks((a4) this.d);
                return;
            case 4:
                Object obj3 = this.d;
                Object obj4 = this.c;
                try {
                    Method method = b4.d;
                    if (method != null) {
                        method.invoke(obj4, obj3, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        b4.e.invoke(obj4, obj3, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e2) {
                    if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                        throw e2;
                    }
                    return;
                } catch (Throwable th4) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th4);
                    return;
                }
            case 5:
                tb0 tb0Var = (tb0) this.c;
                Typeface typeface = (Typeface) this.d;
                i1 i1Var = (i1) tb0Var.c;
                if (i1Var != null) {
                    i1Var.H(typeface);
                    return;
                }
                return;
            case 6:
                ArrayList arrayList = (ArrayList) this.c;
                v11 v11Var = (v11) this.d;
                if (arrayList.contains(v11Var)) {
                    arrayList.remove(v11Var);
                    qq0.a(v11Var.c.H, v11Var.a);
                    return;
                }
                return;
            case 7:
                pc0 pc0Var = (pc0) this.c;
                final pu0 pu0Var = pc0Var.e;
                sc0 sc0Var = (sc0) this.d;
                ActionsRecyclerView actionsRecyclerView = sc0Var.r;
                if (actionsRecyclerView == null || !actionsRecyclerView.r || pc0Var.k || pu0Var.b() == -1) {
                    return;
                }
                vt0 itemAnimator = sc0Var.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.g()) {
                    ArrayList arrayList2 = sc0Var.p;
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (((pc0) arrayList2.get(i4)).l) {
                        }
                    }
                    final t3 t3Var2 = sc0Var.m;
                    if (((j) ((List) t3Var2.b).get(pu0Var.b())).b() == n3.nothing) {
                        t3Var2.f(pu0Var.b());
                        return;
                    }
                    jl1 jl1Var = new jl1(((ActionsRecyclerView) t3Var2.d).getContext());
                    x6 x6Var = (x6) jl1Var.c;
                    jl1Var.m(R.string.are_you_sure);
                    jl1Var.g(R.string.confirmation_delete_action);
                    x6Var.c = R.drawable.icon_warning;
                    jl1Var.k(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: r3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i5) {
                            int i6 = i;
                            pu0 pu0Var2 = pu0Var;
                            t3 t3Var3 = t3Var2;
                            switch (i6) {
                                case 0:
                                    t3Var3.getClass();
                                    t3Var3.f(pu0Var2.b());
                                    break;
                                default:
                                    qt0 adapter = ((ActionsRecyclerView) t3Var3.d).getAdapter();
                                    adapter.a.d(pu0Var2.b(), 1, null);
                                    break;
                            }
                        }
                    });
                    jl1Var.h(android.R.string.no, new DialogInterface.OnClickListener() { // from class: r3
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i5) {
                            int i6 = i2;
                            pu0 pu0Var2 = pu0Var;
                            t3 t3Var3 = t3Var2;
                            switch (i6) {
                                case 0:
                                    t3Var3.getClass();
                                    t3Var3.f(pu0Var2.b());
                                    break;
                                default:
                                    qt0 adapter = ((ActionsRecyclerView) t3Var3.d).getAdapter();
                                    adapter.a.d(pu0Var2.b(), 1, null);
                                    break;
                            }
                        }
                    });
                    x6Var.o = new DialogInterface.OnCancelListener() { // from class: s3
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            qt0 adapter = ((ActionsRecyclerView) t3Var2.d).getAdapter();
                            adapter.a.d(pu0Var.b(), 1, null);
                        }
                    };
                    jl1Var.n();
                    return;
                }
                sc0Var.r.post(this);
                return;
            case 8:
                jg0 jg0Var = (jg0) this.d;
                hp hpVar = jg0Var.d;
                while (true) {
                    try {
                        ((Runnable) this.c).run();
                    } catch (Throwable th5) {
                        fp1.m(my.b, th5);
                    }
                    Runnable runnableS = jg0Var.s();
                    if (runnableS == null) {
                        return;
                    }
                    this.c = runnableS;
                    i++;
                    if (i >= 16 && hpVar.r()) {
                        hpVar.q(jg0Var, this);
                        return;
                    }
                    break;
                }
                break;
            case 9:
                ei0 ei0Var = (ei0) this.c;
                ei0Var.a((di0) this.d);
                if (ei0Var.a) {
                    ArrayList arrayList3 = ei0Var.c;
                    int size2 = arrayList3.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Object obj5 = arrayList3.get(i5);
                        i5++;
                        ((di0) obj5).getClass();
                    }
                    ei0Var.a = false;
                    return;
                }
                return;
            case 10:
                ((q20) this.c).accept(this.d);
                return;
            case 11:
                wf1 wf1Var = ((SwipeDismissBehavior) this.d).a;
                if (wf1Var == null || !wf1Var.f()) {
                    return;
                }
                View view2 = (View) this.c;
                WeakHashMap weakHashMap = uf1.a;
                view2.postOnAnimation(this);
                return;
            case 12:
                xm xmVar = (xm) this.c;
                o90 o90Var = (o90) this.d;
                t7 t7Var = (t7) o90Var.c;
                mj1 mj1Var = (mj1) ((a70) o90Var.g).j.get((w7) o90Var.d);
                if (mj1Var == null) {
                    return;
                }
                if (xmVar.c != 0) {
                    mj1Var.o(xmVar, null);
                    return;
                }
                o90Var.b = true;
                if (t7Var.j()) {
                    if (!o90Var.b || (ja0Var = (ja0) o90Var.e) == null) {
                        return;
                    }
                    t7Var.k(ja0Var, (Set) o90Var.f);
                    return;
                }
                try {
                    t7Var.k(null, t7Var.a());
                    return;
                } catch (SecurityException e3) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e3);
                    t7Var.b("Failed to get service from broker.");
                    mj1Var.o(new xm(10), null);
                    return;
                }
            case 13:
                uj1 uj1Var = (uj1) this.d;
                fk1 fk1Var = (fk1) this.c;
                xm xmVar2 = fk1Var.c;
                if (xmVar2.c == 0) {
                    lk1 lk1Var = fk1Var.d;
                    xy0.d(lk1Var);
                    xm xmVar3 = lk1Var.d;
                    if (xmVar3.c != 0) {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(xmVar3)), new Exception());
                        uj1Var.i.a(xmVar3);
                        uj1Var.h.m();
                        return;
                    }
                    o90 o90Var2 = uj1Var.i;
                    IBinder iBinder = lk1Var.c;
                    if (iBinder != null) {
                        int i6 = b1.c;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        hs1Var = iInterfaceQueryLocalInterface instanceof ja0 ? (ja0) iInterfaceQueryLocalInterface : new hs1(iBinder);
                    }
                    Set set = uj1Var.f;
                    o90Var2.getClass();
                    if (hs1Var == null || set == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        o90Var2.a(new xm(4));
                    } else {
                        o90Var2.e = hs1Var;
                        o90Var2.f = set;
                        if (o90Var2.b) {
                            ((t7) o90Var2.c).k(hs1Var, set);
                        }
                    }
                } else {
                    uj1Var.i.a(xmVar2);
                }
                uj1Var.h.m();
                return;
            case 14:
                af afVar = (af) this.c;
                as0 as0Var = (as0) this.d;
                afVar.w(24, 9, zl1.l);
                bm1 bm1Var = em1.c;
                as0Var.a(tm1.f);
                return;
            case 15:
                Future future = (Future) this.c;
                if (future.isDone() || future.isCancelled()) {
                    return;
                }
                Runnable runnable = (Runnable) this.d;
                future.cancel(true);
                pn1.g("BillingClient", "Async task is taking too long, cancel it!");
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 16:
                af afVar2 = (af) this.c;
                zr0 zr0Var = (zr0) this.d;
                afVar2.getClass();
                df dfVar = zl1.l;
                afVar2.w(24, 11, dfVar);
                zr0Var.b(dfVar, null);
                return;
            case 17:
                af afVar3 = (af) this.c;
                ir0 ir0Var = (ir0) this.d;
                df dfVar2 = zl1.l;
                afVar3.w(24, 7, dfVar2);
                ir0Var.e(dfVar2, new ArrayList());
                return;
            case 18:
                synchronized (((gq1) this.d).b) {
                    pn0 pn0Var = ((gq1) this.d).c;
                    ((Map) ((pn0) pn0Var.d).d).remove((l41) pn0Var.c);
                    break;
                }
                return;
            default:
                af afVar4 = (af) this.c;
                df dfVar3 = (df) this.d;
                sf sfVar = (sf) afVar4.e.d;
                o90 o90Var3 = afVar4.e;
                if (sfVar != null) {
                    ((sf) o90Var3.d).e(dfVar3, null);
                    return;
                } else {
                    pn1.g("BillingClient", "No valid listener is set in BroadcastManager");
                    return;
                }
        }
    }

    public String toString() {
        switch (this.b) {
            case 0:
                ra raVar = new ra(vn1.class.getSimpleName());
                t3 t3Var = (t3) this.d;
                pn0 pn0Var = new pn0(21, false);
                ((pn0) raVar.e).c = pn0Var;
                raVar.e = pn0Var;
                pn0Var.d = t3Var;
                return raVar.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ vn1(Object obj, Object obj2, int i, boolean z) {
        this.b = i;
        this.d = obj;
        this.c = obj2;
    }

    public vn1(xs xsVar, ArrayList arrayList, v11 v11Var) {
        this.b = 6;
        this.c = arrayList;
        this.d = v11Var;
    }

    public /* synthetic */ vn1(Object obj, int i, Object obj2) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    public vn1(sc0 sc0Var, pc0 pc0Var, int i) {
        this.b = 7;
        this.d = sc0Var;
        this.c = pc0Var;
    }
}
