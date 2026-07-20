package defpackage;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.a;
import androidx.lifecycle.b;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j30 implements ComponentCallbacks, View.OnCreateContextMenuListener, gg0, fg1, u70, rx0 {
    public static final Object X = new Object();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean F;
    public ViewGroup G;
    public View H;
    public boolean I;
    public h30 K;
    public boolean L;
    public LayoutInflater M;
    public boolean N;
    public String O;
    public a Q;
    public i40 R;
    public qx0 T;
    public Bundle c;
    public SparseArray d;
    public Bundle e;
    public Boolean f;
    public Bundle h;
    public j30 i;
    public int k;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public y30 t;
    public l30 u;
    public j30 w;
    public int x;
    public int y;
    public String z;
    public int b = -1;
    public String g = UUID.randomUUID().toString();
    public String j = null;
    public Boolean l = null;
    public y30 v = new y30();
    public boolean E = true;
    public boolean J = true;
    public zf0 P = zf0.f;
    public final b S = new b();
    public final AtomicInteger U = new AtomicInteger();
    public final ArrayList V = new ArrayList();
    public final e30 W = new e30(this);

    public j30() {
        B();
    }

    public final j30 A(boolean z) {
        String str;
        if (z) {
            f40 f40Var = g40.a;
            g40.b(new q60(this, "Attempting to get target fragment from fragment " + this));
            g40.a(this).getClass();
        }
        j30 j30Var = this.i;
        if (j30Var != null) {
            return j30Var;
        }
        y30 y30Var = this.t;
        if (y30Var == null || (str = this.j) == null) {
            return null;
        }
        return y30Var.c.g(str);
    }

    public final void B() {
        this.Q = new a(this);
        this.T = new qx0(this);
        ArrayList arrayList = this.V;
        e30 e30Var = this.W;
        if (arrayList.contains(e30Var)) {
            return;
        }
        if (this.b >= 0) {
            e30Var.a();
        } else {
            arrayList.add(e30Var);
        }
    }

    public final void C() {
        B();
        this.O = this.g;
        this.g = UUID.randomUUID().toString();
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = 0;
        this.t = null;
        this.v = new y30();
        this.u = null;
        this.x = 0;
        this.y = 0;
        this.z = null;
        this.A = false;
        this.B = false;
    }

    public final boolean D() {
        return this.u != null && this.m;
    }

    public final boolean E() {
        if (this.A) {
            return true;
        }
        y30 y30Var = this.t;
        if (y30Var != null) {
            j30 j30Var = this.w;
            y30Var.getClass();
            if (j30Var == null ? false : j30Var.E()) {
                return true;
            }
        }
        return false;
    }

    public final boolean F() {
        return this.s > 0;
    }

    public void G() {
        this.F = true;
    }

    public void H(int i, int i2, Intent intent) {
        if (y30.I(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    public void I(Context context) {
        this.F = true;
        l30 l30Var = this.u;
        if ((l30Var == null ? null : l30Var.m) != null) {
            this.F = true;
        }
    }

    public void J(Bundle bundle) {
        Parcelable parcelable;
        this.F = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.v.U(parcelable);
            this.v.j();
        }
        y30 y30Var = this.v;
        if (y30Var.s >= 1) {
            return;
        }
        y30Var.j();
    }

    public View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void L() {
        this.F = true;
    }

    public void M() {
        this.F = true;
    }

    public void N() {
        this.F = true;
    }

    public LayoutInflater O(Bundle bundle) {
        l30 l30Var = this.u;
        if (l30Var == null) {
            s1.f("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
            return null;
        }
        z7 z7Var = l30Var.q;
        LayoutInflater layoutInflaterCloneInContext = z7Var.getLayoutInflater().cloneInContext(z7Var);
        layoutInflaterCloneInContext.setFactory2(this.v.f);
        return layoutInflaterCloneInContext;
    }

    public void P() {
        this.F = true;
    }

    public void R() {
        this.F = true;
    }

    public void T() {
        this.F = true;
    }

    public void U() {
        this.F = true;
    }

    public void W(Bundle bundle) {
        this.F = true;
    }

    public void X(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.v.O();
        this.r = true;
        this.R = new i40(this, m());
        View viewK = K(layoutInflater, viewGroup);
        this.H = viewK;
        i40 i40Var = this.R;
        if (viewK == null) {
            if (i40Var.d == null) {
                this.R = null;
                return;
            } else {
                s1.f("Called getViewLifecycleOwner() but onCreateView() returned null");
                return;
            }
        }
        i40Var.b();
        View view = this.H;
        i40 i40Var2 = this.R;
        view.getClass();
        view.setTag(R.id.view_tree_lifecycle_owner, i40Var2);
        View view2 = this.H;
        i40 i40Var3 = this.R;
        view2.getClass();
        view2.setTag(R.id.view_tree_view_model_store_owner, i40Var3);
        View view3 = this.H;
        i40 i40Var4 = this.R;
        view3.getClass();
        view3.setTag(R.id.view_tree_saved_state_registry_owner, i40Var4);
        this.S.e(this.R);
    }

    public final g4 Y(e4 e4Var, f01 f01Var) {
        sp1 sp1Var = new sp1(23, this);
        if (this.b > 1) {
            s1.f(l11.i("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
            return null;
        }
        AtomicReference atomicReference = new AtomicReference();
        g30 g30Var = new g30(this, sp1Var, atomicReference, (f4) f01Var, e4Var);
        if (this.b >= 0) {
            g30Var.a();
        } else {
            this.V.add(g30Var);
        }
        return new d30(atomicReference);
    }

    public final z7 Z() {
        z7 z7VarT = t();
        if (z7VarT != null) {
            return z7VarT;
        }
        s1.f(l11.i("Fragment ", this, " not attached to an activity."));
        return null;
    }

    public final View a0() {
        View view = this.H;
        if (view != null) {
            return view;
        }
        s1.f(l11.i("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
        return null;
    }

    public final void b0(int i, int i2, int i3, int i4) {
        if (this.K == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        s().b = i;
        s().c = i2;
        s().d = i3;
        s().e = i4;
    }

    @Override // defpackage.rx0
    public final e8 c() {
        return (e8) this.T.c;
    }

    public final void c0(Bundle bundle) {
        y30 y30Var = this.t;
        if (y30Var == null || !(y30Var.E || y30Var.F)) {
            this.h = bundle;
        } else {
            s1.f("Fragment already added and state has been saved");
        }
    }

    public final void d0(j30 j30Var) {
        if (j30Var != null) {
            f40 f40Var = g40.a;
            g40.b(new q60(this, "Attempting to set target fragment " + j30Var + " with request code 0 for fragment " + this));
            g40.a(this).getClass();
        }
        y30 y30Var = this.t;
        y30 y30Var2 = j30Var != null ? j30Var.t : null;
        if (y30Var != null && y30Var2 != null && y30Var != y30Var2) {
            zy.n(l11.i("Fragment ", j30Var, " must share the same FragmentManager to be set as a target fragment"));
            return;
        }
        for (j30 j30VarA = j30Var; j30VarA != null; j30VarA = j30VarA.A(false)) {
            if (j30VarA == this) {
                throw new IllegalArgumentException("Setting " + j30Var + " as the target of " + this + " would create a target cycle");
            }
        }
        if (j30Var == null) {
            this.j = null;
            this.i = null;
        } else if (this.t == null || j30Var.t == null) {
            this.j = null;
            this.i = j30Var;
        } else {
            this.j = j30Var.g;
            this.i = null;
        }
        this.k = 0;
    }

    public final void e0(boolean z) {
        f40 f40Var = g40.a;
        g40.b(new c40(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        g40.a(this).getClass();
        boolean z2 = false;
        if (!this.J && z && this.b < 5 && this.t != null && D() && this.N) {
            y30 y30Var = this.t;
            androidx.fragment.app.a aVarF = y30Var.f(this);
            j30 j30Var = aVarF.c;
            if (j30Var.I) {
                if (y30Var.b) {
                    y30Var.H = true;
                } else {
                    j30Var.I = false;
                    aVarF.k();
                }
            }
        }
        this.J = z;
        if (this.b < 5 && !z) {
            z2 = true;
        }
        this.I = z2;
        if (this.c != null) {
            this.f = Boolean.valueOf(z);
        }
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final void f0(Intent intent) {
        l30 l30Var = this.u;
        if (l30Var != null) {
            l30Var.n.startActivity(intent, null);
        } else {
            s1.f(l11.i("Fragment ", this, " not attached to Activity"));
        }
    }

    public final void g0(Intent intent, int i) {
        if (this.u == null) {
            s1.f(l11.i("Fragment ", this, " not attached to Activity"));
            return;
        }
        y30 y30VarX = x();
        if (y30VarX.z != null) {
            String str = this.g;
            v30 v30Var = new v30();
            v30Var.b = str;
            v30Var.c = i;
            y30VarX.C.addLast(v30Var);
            y30VarX.z.a(intent);
            return;
        }
        l30 l30Var = y30VarX.t;
        if (i == -1) {
            l30Var.n.startActivity(intent, null);
        } else {
            l30Var.getClass();
            s1.f("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    @Override // defpackage.u70
    public final jm0 k() {
        Application application;
        Context applicationContext = o().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && y30.I(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + o().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        jm0 jm0Var = new jm0(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) jm0Var.a;
        if (application != null) {
            linkedHashMap.put(ix.g, application);
        }
        linkedHashMap.put(tk0.g, this);
        linkedHashMap.put(tk0.h, this);
        Bundle bundle = this.h;
        if (bundle != null) {
            linkedHashMap.put(tk0.i, bundle);
        }
        return jm0Var;
    }

    public final y30 l() {
        if (this.u != null) {
            return this.v;
        }
        s1.f(l11.i("Fragment ", this, " has not been attached yet."));
        return null;
    }

    @Override // defpackage.fg1
    public final eg1 m() {
        if (this.t == null) {
            s1.f("Can't access ViewModels from detached fragment");
            return null;
        }
        if (w() == 1) {
            s1.f("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
            return null;
        }
        HashMap map = this.t.L.e;
        eg1 eg1Var = (eg1) map.get(this.g);
        if (eg1Var != null) {
            return eg1Var;
        }
        eg1 eg1Var2 = new eg1();
        map.put(this.g, eg1Var2);
        return eg1Var2;
    }

    public final Context o() {
        Context contextU = u();
        if (contextU != null) {
            return contextU;
        }
        s1.f(l11.i("Fragment ", this, " not attached to a context."));
        return null;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.F = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Z().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.F = true;
    }

    @Override // defpackage.gg0
    public final a p() {
        return this.Q;
    }

    public f01 r() {
        return new f30(this);
    }

    public final h30 s() {
        if (this.K == null) {
            h30 h30Var = new h30();
            Object obj = X;
            h30Var.g = obj;
            h30Var.h = obj;
            h30Var.i = obj;
            h30Var.k = 1.0f;
            h30Var.l = null;
            this.K = h30Var;
        }
        return this.K;
    }

    public final z7 t() {
        l30 l30Var = this.u;
        if (l30Var == null) {
            return null;
        }
        return l30Var.m;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.g);
        if (this.x != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.x));
        }
        if (this.z != null) {
            sb.append(" tag=");
            sb.append(this.z);
        }
        sb.append(")");
        return sb.toString();
    }

    public final Context u() {
        l30 l30Var = this.u;
        if (l30Var == null) {
            return null;
        }
        return l30Var.n;
    }

    public final LayoutInflater v() {
        LayoutInflater layoutInflater = this.M;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater layoutInflaterO = O(null);
        this.M = layoutInflaterO;
        return layoutInflaterO;
    }

    public final int w() {
        zf0 zf0Var = this.P;
        return (zf0Var == zf0.c || this.w == null) ? zf0Var.ordinal() : Math.min(zf0Var.ordinal(), this.w.w());
    }

    public final y30 x() {
        y30 y30Var = this.t;
        if (y30Var != null) {
            return y30Var;
        }
        s1.f(l11.i("Fragment ", this, " not associated with a fragment manager."));
        return null;
    }

    public final Resources y() {
        return o().getResources();
    }

    public final String z(int i) {
        return y().getString(i);
    }

    public void S(Bundle bundle) {
    }

    public void V(View view, Bundle bundle) {
    }

    public void Q(int i, String[] strArr, int[] iArr) {
    }
}
