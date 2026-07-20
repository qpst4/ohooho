package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.quickcursor.R;
import defpackage.a40;
import defpackage.b40;
import defpackage.c40;
import defpackage.dg0;
import defpackage.e40;
import defpackage.f40;
import defpackage.g40;
import defpackage.g7;
import defpackage.gg0;
import defpackage.h31;
import defpackage.i30;
import defpackage.i40;
import defpackage.i9;
import defpackage.j30;
import defpackage.jf1;
import defpackage.l11;
import defpackage.l30;
import defpackage.qq0;
import defpackage.ra;
import defpackage.s1;
import defpackage.si;
import defpackage.t11;
import defpackage.t30;
import defpackage.uf1;
import defpackage.v11;
import defpackage.xs;
import defpackage.y30;
import defpackage.yf0;
import defpackage.yh0;
import defpackage.z7;
import defpackage.zf0;
import defpackage.zy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final i9 a;
    public final g7 b;
    public final j30 c;
    public boolean d = false;
    public int e = -1;

    public a(i9 i9Var, g7 g7Var, ClassLoader classLoader, t30 t30Var, e40 e40Var) {
        this.a = i9Var;
        this.b = g7Var;
        j30 j30VarA = t30Var.a(e40Var.b);
        Bundle bundle = e40Var.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        j30VarA.c0(bundle);
        j30VarA.g = e40Var.c;
        j30VarA.o = e40Var.d;
        j30VarA.q = true;
        j30VarA.x = e40Var.e;
        j30VarA.y = e40Var.f;
        j30VarA.z = e40Var.g;
        j30VarA.C = e40Var.h;
        j30VarA.n = e40Var.i;
        j30VarA.B = e40Var.j;
        j30VarA.A = e40Var.l;
        j30VarA.P = zf0.values()[e40Var.m];
        Bundle bundle2 = e40Var.n;
        if (bundle2 != null) {
            j30VarA.c = bundle2;
        } else {
            j30VarA.c = new Bundle();
        }
        this.c = j30VarA;
        if (y30.I(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + j30VarA);
        }
    }

    public final void a() {
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + j30Var);
        }
        Bundle bundle = j30Var.c;
        j30Var.v.O();
        j30Var.b = 3;
        j30Var.F = false;
        j30Var.G();
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onActivityCreated()"));
        }
        if (y30.I(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + j30Var);
        }
        View view = j30Var.H;
        if (view != null) {
            Bundle bundle2 = j30Var.c;
            SparseArray<Parcelable> sparseArray = j30Var.d;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                j30Var.d = null;
            }
            if (j30Var.H != null) {
                j30Var.R.e.c(j30Var.e);
                j30Var.e = null;
            }
            j30Var.F = false;
            j30Var.W(bundle2);
            if (!j30Var.F) {
                throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onViewStateRestored()"));
            }
            if (j30Var.H != null) {
                j30Var.R.a(yf0.ON_CREATE);
            }
        }
        j30Var.c = null;
        y30 y30Var = j30Var.v;
        y30Var.E = false;
        y30Var.F = false;
        y30Var.L.h = false;
        y30Var.u(4);
        this.a.g(false);
    }

    public final void b() {
        View view;
        View view2;
        ArrayList arrayList = (ArrayList) this.b.c;
        j30 j30Var = this.c;
        ViewGroup viewGroup = j30Var.G;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(j30Var);
            int i = iIndexOf - 1;
            while (true) {
                if (i < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        j30 j30Var2 = (j30) arrayList.get(iIndexOf);
                        if (j30Var2.G == viewGroup && (view = j30Var2.H) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    j30 j30Var3 = (j30) arrayList.get(i);
                    if (j30Var3.G == viewGroup && (view2 = j30Var3.H) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i--;
                }
            }
        }
        j30Var.G.addView(j30Var.H, iIndexOfChild);
    }

    public final void c() {
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "moveto ATTACHED: " + j30Var);
        }
        j30 j30Var2 = j30Var.i;
        a aVar = null;
        g7 g7Var = this.b;
        if (j30Var2 != null) {
            a aVar2 = (a) ((HashMap) g7Var.d).get(j30Var2.g);
            if (aVar2 == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(j30Var);
                j30 j30Var3 = j30Var.i;
                sb.append(" declared target fragment ");
                sb.append(j30Var3);
                sb.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb.toString());
            }
            j30Var.j = j30Var.i.g;
            j30Var.i = null;
            aVar = aVar2;
        } else {
            String str = j30Var.j;
            if (str != null && (aVar = (a) ((HashMap) g7Var.d).get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(j30Var);
                sb2.append(" declared target fragment ");
                s1.f(l11.k(sb2, j30Var.j, " that does not belong to this FragmentManager!"));
                return;
            }
        }
        if (aVar != null) {
            aVar.k();
        }
        y30 y30Var = j30Var.t;
        j30Var.u = y30Var.t;
        j30Var.w = y30Var.v;
        i9 i9Var = this.a;
        i9Var.o(false);
        ArrayList arrayList = j30Var.V;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((i30) obj).a();
        }
        arrayList.clear();
        j30Var.v.b(j30Var.u, j30Var.r(), j30Var);
        j30Var.b = 0;
        j30Var.F = false;
        j30Var.I(j30Var.u.n);
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onAttach()"));
        }
        Iterator it = j30Var.t.m.iterator();
        while (it.hasNext()) {
            ((b40) it.next()).a();
        }
        y30 y30Var2 = j30Var.v;
        y30Var2.E = false;
        y30Var2.F = false;
        y30Var2.L.h = false;
        y30Var2.u(0);
        i9Var.h(false);
    }

    public final int d() {
        v11 v11Var;
        j30 j30Var = this.c;
        if (j30Var.t == null) {
            return j30Var.b;
        }
        int iMin = this.e;
        int iOrdinal = j30Var.P.ordinal();
        int i = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (j30Var.o) {
            boolean z = j30Var.p;
            int i2 = this.e;
            if (z) {
                iMin = Math.max(i2, 2);
                View view = j30Var.H;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = i2 < 4 ? Math.min(iMin, j30Var.b) : Math.min(iMin, 1);
            }
        }
        if (!j30Var.m) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = j30Var.G;
        if (viewGroup != null) {
            xs xsVarF = xs.f(viewGroup, j30Var.x().G());
            v11 v11VarD = xsVarF.d(j30Var);
            int i3 = v11VarD != null ? v11VarD.b : 0;
            ArrayList arrayList = xsVarF.c;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    v11Var = null;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                v11Var = (v11) obj;
                j30 j30Var2 = v11Var.c;
                j30Var2.getClass();
                if (j30Var2 == j30Var && !v11Var.f) {
                    break;
                }
            }
            i = (v11Var == null || !(i3 == 0 || i3 == 1)) ? i3 : v11Var.b;
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (j30Var.n) {
            iMin = j30Var.F() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (j30Var.I && j30Var.b < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + j30Var);
        }
        return iMin;
    }

    public final void e() {
        Parcelable parcelable;
        boolean zI = y30.I(3);
        final j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "moveto CREATED: " + j30Var);
        }
        boolean z = j30Var.N;
        Bundle bundle = j30Var.c;
        if (z) {
            if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
                j30Var.v.U(parcelable);
                j30Var.v.j();
            }
            j30Var.b = 1;
            return;
        }
        i9 i9Var = this.a;
        i9Var.p(false);
        Bundle bundle2 = j30Var.c;
        j30Var.v.O();
        j30Var.b = 1;
        j30Var.F = false;
        j30Var.Q.a(new dg0() { // from class: androidx.fragment.app.Fragment$6
            @Override // defpackage.dg0
            public final void c(gg0 gg0Var, yf0 yf0Var) {
                View view;
                if (yf0Var != yf0.ON_STOP || (view = j30Var.H) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        j30Var.T.c(bundle2);
        j30Var.J(bundle2);
        j30Var.N = true;
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onCreate()"));
        }
        j30Var.Q.d(yf0.ON_CREATE);
        i9Var.k(false);
    }

    public final void f() {
        String resourceName;
        j30 j30Var = this.c;
        if (j30Var.o) {
            return;
        }
        if (y30.I(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + j30Var);
        }
        LayoutInflater layoutInflaterO = j30Var.O(j30Var.c);
        j30Var.M = layoutInflaterO;
        ViewGroup viewGroup = j30Var.G;
        if (viewGroup == null) {
            int i = j30Var.y;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    zy.n(l11.i("Cannot create fragment ", j30Var, " for a container view with no id"));
                    return;
                }
                viewGroup = (ViewGroup) j30Var.t.u.F(i);
                if (viewGroup == null) {
                    if (!j30Var.q) {
                        try {
                            resourceName = j30Var.y().getResourceName(j30Var.y);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(j30Var.y) + " (" + resourceName + ") for fragment " + j30Var);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    f40 f40Var = g40.a;
                    g40.b(new c40(j30Var, "Attempting to add fragment " + j30Var + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    g40.a(j30Var).getClass();
                }
            }
        }
        j30Var.G = viewGroup;
        j30Var.X(layoutInflaterO, viewGroup, j30Var.c);
        View view = j30Var.H;
        int i2 = 2;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            j30Var.H.setTag(R.id.fragment_container_view_tag, j30Var);
            if (viewGroup != null) {
                b();
            }
            if (j30Var.A) {
                j30Var.H.setVisibility(8);
            }
            View view2 = j30Var.H;
            WeakHashMap weakHashMap = uf1.a;
            boolean zIsAttachedToWindow = view2.isAttachedToWindow();
            View view3 = j30Var.H;
            if (zIsAttachedToWindow) {
                jf1.c(view3);
            } else {
                view3.addOnAttachStateChangeListener(new si(i2, view3));
            }
            j30Var.V(j30Var.H, j30Var.c);
            j30Var.v.u(2);
            this.a.u(false);
            int visibility = j30Var.H.getVisibility();
            j30Var.s().k = j30Var.H.getAlpha();
            if (j30Var.G != null && visibility == 0) {
                View viewFindFocus = j30Var.H.findFocus();
                if (viewFindFocus != null) {
                    j30Var.s().l = viewFindFocus;
                    if (y30.I(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + j30Var);
                    }
                }
                j30Var.H.setAlpha(0.0f);
            }
        }
        j30Var.b = 2;
    }

    public final void g() {
        j30 j30VarG;
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "movefrom CREATED: " + j30Var);
        }
        boolean zIsChangingConfigurations = true;
        int i = 0;
        boolean z = j30Var.n && !j30Var.F();
        g7 g7Var = this.b;
        if (z) {
        }
        if (!z) {
            a40 a40Var = (a40) g7Var.e;
            if (!((a40Var.c.containsKey(j30Var.g) && a40Var.f) ? a40Var.g : true)) {
                String str = j30Var.j;
                if (str != null && (j30VarG = g7Var.g(str)) != null && j30VarG.C) {
                    j30Var.i = j30VarG;
                }
                j30Var.b = 0;
                return;
            }
        }
        l30 l30Var = j30Var.u;
        if (l30Var != null) {
            zIsChangingConfigurations = ((a40) g7Var.e).g;
        } else {
            z7 z7Var = l30Var.n;
            if (z7Var != null) {
                zIsChangingConfigurations = true ^ z7Var.isChangingConfigurations();
            }
        }
        if (z || zIsChangingConfigurations) {
            ((a40) g7Var.e).d(j30Var);
        }
        j30Var.v.l();
        j30Var.Q.d(yf0.ON_DESTROY);
        j30Var.b = 0;
        j30Var.F = false;
        j30Var.N = false;
        j30Var.L();
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onDestroy()"));
        }
        this.a.l(false);
        ArrayList arrayListK = g7Var.k();
        int size = arrayListK.size();
        while (i < size) {
            Object obj = arrayListK.get(i);
            i++;
            a aVar = (a) obj;
            if (aVar != null) {
                j30 j30Var2 = aVar.c;
                if (j30Var.g.equals(j30Var2.j)) {
                    j30Var2.i = j30Var;
                    j30Var2.j = null;
                }
            }
        }
        String str2 = j30Var.j;
        if (str2 != null) {
            j30Var.i = g7Var.g(str2);
        }
        g7Var.q(this);
    }

    public final void h() {
        View view;
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + j30Var);
        }
        ViewGroup viewGroup = j30Var.G;
        if (viewGroup != null && (view = j30Var.H) != null) {
            viewGroup.removeView(view);
        }
        j30Var.v.u(1);
        if (j30Var.H != null) {
            i40 i40Var = j30Var.R;
            i40Var.b();
            if (i40Var.d.c.compareTo(zf0.d) >= 0) {
                j30Var.R.a(yf0.ON_DESTROY);
            }
        }
        j30Var.b = 1;
        j30Var.F = false;
        j30Var.M();
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onDestroyView()"));
        }
        ra raVar = new ra(j30Var.m(), yh0.d);
        String canonicalName = yh0.class.getCanonicalName();
        if (canonicalName == null) {
            zy.n("Local and anonymous classes can not be ViewModels");
            return;
        }
        t11 t11Var = ((yh0) raVar.u(yh0.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).c;
        if (t11Var.d > 0) {
            t11Var.c[0].getClass();
            s1.d();
            return;
        }
        j30Var.r = false;
        this.a.v(false);
        j30Var.G = null;
        j30Var.H = null;
        j30Var.R = null;
        j30Var.S.e(null);
        j30Var.p = false;
    }

    public final void i() {
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + j30Var);
        }
        j30Var.b = -1;
        j30Var.F = false;
        j30Var.N();
        j30Var.M = null;
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onDetach()"));
        }
        y30 y30Var = j30Var.v;
        if (!y30Var.G) {
            y30Var.l();
            j30Var.v = new y30();
        }
        this.a.m(false);
        j30Var.b = -1;
        j30Var.u = null;
        j30Var.w = null;
        j30Var.t = null;
        if (!j30Var.n || j30Var.F()) {
            a40 a40Var = (a40) this.b.e;
            if (!((a40Var.c.containsKey(j30Var.g) && a40Var.f) ? a40Var.g : true)) {
                return;
            }
        }
        if (y30.I(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + j30Var);
        }
        j30Var.C();
    }

    public final void j() {
        j30 j30Var = this.c;
        if (j30Var.o && j30Var.p && !j30Var.r) {
            if (y30.I(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + j30Var);
            }
            LayoutInflater layoutInflaterO = j30Var.O(j30Var.c);
            j30Var.M = layoutInflaterO;
            j30Var.X(layoutInflaterO, null, j30Var.c);
            View view = j30Var.H;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                j30Var.H.setTag(R.id.fragment_container_view_tag, j30Var);
                if (j30Var.A) {
                    j30Var.H.setVisibility(8);
                }
                j30Var.V(j30Var.H, j30Var.c);
                j30Var.v.u(2);
                this.a.u(false);
                j30Var.b = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        g7 g7Var = this.b;
        boolean z = this.d;
        j30 j30Var = this.c;
        if (z) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + j30Var);
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z2 = false;
            while (true) {
                int iD = d();
                int i = j30Var.b;
                if (iD == i) {
                    if (!z2 && i == -1 && j30Var.n && !j30Var.F()) {
                        if (y30.I(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + j30Var);
                        }
                        ((a40) g7Var.e).d(j30Var);
                        g7Var.q(this);
                        if (y30.I(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + j30Var);
                        }
                        j30Var.C();
                    }
                    if (j30Var.L) {
                        if (j30Var.H != null && (viewGroup = j30Var.G) != null) {
                            xs xsVarF = xs.f(viewGroup, j30Var.x().G());
                            if (j30Var.A) {
                                if (y30.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + j30Var);
                                }
                                xsVarF.a(3, 1, this);
                            } else {
                                if (y30.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + j30Var);
                                }
                                xsVarF.a(2, 1, this);
                            }
                        }
                        y30 y30Var = j30Var.t;
                        if (y30Var != null && j30Var.m && y30.J(j30Var)) {
                            y30Var.D = true;
                        }
                        j30Var.L = false;
                        j30Var.v.o();
                    }
                    this.d = false;
                    return;
                }
                if (iD <= i) {
                    switch (i - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            j30Var.b = 1;
                            break;
                        case 2:
                            j30Var.p = false;
                            j30Var.b = 2;
                            break;
                        case 3:
                            if (y30.I(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + j30Var);
                            }
                            if (j30Var.H != null && j30Var.d == null) {
                                o();
                            }
                            if (j30Var.H != null && (viewGroup2 = j30Var.G) != null) {
                                xs xsVarF2 = xs.f(viewGroup2, j30Var.x().G());
                                if (y30.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + j30Var);
                                }
                                xsVarF2.a(1, 3, this);
                            }
                            j30Var.b = 3;
                            break;
                        case 4:
                            q();
                            break;
                        case 5:
                            j30Var.b = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (j30Var.H != null && (viewGroup3 = j30Var.G) != null) {
                                xs xsVarF3 = xs.f(viewGroup3, j30Var.x().G());
                                int iC = qq0.c(j30Var.H.getVisibility());
                                if (y30.I(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + j30Var);
                                }
                                xsVarF3.a(iC, 2, this);
                            }
                            j30Var.b = 4;
                            break;
                        case 5:
                            p();
                            break;
                        case 6:
                            j30Var.b = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
                z2 = true;
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public final void l() {
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "movefrom RESUMED: " + j30Var);
        }
        j30Var.v.u(5);
        if (j30Var.H != null) {
            j30Var.R.a(yf0.ON_PAUSE);
        }
        j30Var.Q.d(yf0.ON_PAUSE);
        j30Var.b = 6;
        j30Var.F = false;
        j30Var.P();
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onPause()"));
        }
        this.a.n(false);
    }

    public final void m(ClassLoader classLoader) {
        j30 j30Var = this.c;
        Bundle bundle = j30Var.c;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        j30Var.d = j30Var.c.getSparseParcelableArray("android:view_state");
        j30Var.e = j30Var.c.getBundle("android:view_registry_state");
        j30Var.j = j30Var.c.getString("android:target_state");
        if (j30Var.j != null) {
            j30Var.k = j30Var.c.getInt("android:target_req_state", 0);
        }
        Boolean bool = j30Var.f;
        if (bool != null) {
            j30Var.J = bool.booleanValue();
            j30Var.f = null;
        } else {
            j30Var.J = j30Var.c.getBoolean("android:user_visible_hint", true);
        }
        if (j30Var.J) {
            return;
        }
        j30Var.I = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.n():void");
    }

    public final void o() {
        j30 j30Var = this.c;
        if (j30Var.H == null) {
            return;
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + j30Var + " with view " + j30Var.H);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        j30Var.H.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            j30Var.d = sparseArray;
        }
        Bundle bundle = new Bundle();
        j30Var.R.e.d(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        j30Var.e = bundle;
    }

    public final void p() {
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "moveto STARTED: " + j30Var);
        }
        j30Var.v.O();
        j30Var.v.z(true);
        j30Var.b = 5;
        j30Var.F = false;
        j30Var.T();
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.a aVar = j30Var.Q;
        yf0 yf0Var = yf0.ON_START;
        aVar.d(yf0Var);
        if (j30Var.H != null) {
            j30Var.R.d.d(yf0Var);
        }
        y30 y30Var = j30Var.v;
        y30Var.E = false;
        y30Var.F = false;
        y30Var.L.h = false;
        y30Var.u(5);
        this.a.s(false);
    }

    public final void q() {
        boolean zI = y30.I(3);
        j30 j30Var = this.c;
        if (zI) {
            Log.d("FragmentManager", "movefrom STARTED: " + j30Var);
        }
        y30 y30Var = j30Var.v;
        y30Var.F = true;
        y30Var.L.h = true;
        y30Var.u(4);
        if (j30Var.H != null) {
            j30Var.R.a(yf0.ON_STOP);
        }
        j30Var.Q.d(yf0.ON_STOP);
        j30Var.b = 4;
        j30Var.F = false;
        j30Var.U();
        if (!j30Var.F) {
            throw new h31(l11.i("Fragment ", j30Var, " did not call through to super.onStop()"));
        }
        this.a.t(false);
    }

    public a(i9 i9Var, g7 g7Var, j30 j30Var) {
        this.a = i9Var;
        this.b = g7Var;
        this.c = j30Var;
    }

    public a(i9 i9Var, g7 g7Var, j30 j30Var, e40 e40Var) {
        this.a = i9Var;
        this.b = g7Var;
        this.c = j30Var;
        j30Var.d = null;
        j30Var.e = null;
        j30Var.s = 0;
        j30Var.p = false;
        j30Var.m = false;
        j30 j30Var2 = j30Var.i;
        j30Var.j = j30Var2 != null ? j30Var2.g : null;
        j30Var.i = null;
        Bundle bundle = e40Var.n;
        if (bundle != null) {
            j30Var.c = bundle;
        } else {
            j30Var.c = new Bundle();
        }
    }
}
