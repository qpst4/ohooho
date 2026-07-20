package defpackage;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.a;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v11 {
    public int a;
    public int b;
    public final j30 c;
    public final ArrayList d;
    public final HashSet e;
    public boolean f;
    public boolean g;
    public final a h;

    public v11(int i, int i2, a aVar, oi oiVar) {
        j30 j30Var = aVar.c;
        this.d = new ArrayList();
        this.e = new HashSet();
        this.f = false;
        this.g = false;
        this.a = i;
        this.b = i2;
        this.c = j30Var;
        oiVar.a(new tb0(16, this));
        this.h = aVar;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.e.isEmpty()) {
            b();
            return;
        }
        ArrayList arrayList = new ArrayList(this.e);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            oi oiVar = (oi) obj;
            synchronized (oiVar) {
                try {
                    if (!oiVar.a) {
                        oiVar.a = true;
                        oiVar.c = true;
                        ni niVar = oiVar.b;
                        if (niVar != null) {
                            try {
                                niVar.onCancel();
                            } catch (Throwable th) {
                                synchronized (oiVar) {
                                    oiVar.c = false;
                                    oiVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (oiVar) {
                            oiVar.c = false;
                            oiVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.g) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.h.k();
    }

    public final void c(int i, int i2) {
        int iR = l11.r(i2);
        j30 j30Var = this.c;
        if (iR == 0) {
            if (this.a != 1) {
                if (y30.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + j30Var + " mFinalState = " + qq0.n(this.a) + " -> " + qq0.n(i) + ". ");
                }
                this.a = i;
                return;
            }
            return;
        }
        if (iR == 1) {
            if (this.a == 1) {
                if (y30.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + j30Var + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + qq0.m(this.b) + " to ADDING.");
                }
                this.a = 2;
                this.b = 2;
                return;
            }
            return;
        }
        if (iR != 2) {
            return;
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + j30Var + " mFinalState = " + qq0.n(this.a) + " -> REMOVED. mLifecycleImpact  = " + qq0.m(this.b) + " to REMOVING.");
        }
        this.a = 1;
        this.b = 3;
    }

    public final void d() {
        int i = this.b;
        a aVar = this.h;
        if (i != 2) {
            if (i == 3) {
                j30 j30Var = aVar.c;
                View viewA0 = j30Var.a0();
                if (y30.I(2)) {
                    Log.v("FragmentManager", "Clearing focus " + viewA0.findFocus() + " on view " + viewA0 + " for Fragment " + j30Var);
                }
                viewA0.clearFocus();
                return;
            }
            return;
        }
        j30 j30Var2 = aVar.c;
        View viewFindFocus = j30Var2.H.findFocus();
        if (viewFindFocus != null) {
            j30Var2.s().l = viewFindFocus;
            if (y30.I(2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + j30Var2);
            }
        }
        View viewA02 = this.c.a0();
        if (viewA02.getParent() == null) {
            aVar.b();
            viewA02.setAlpha(0.0f);
        }
        if (viewA02.getAlpha() == 0.0f && viewA02.getVisibility() == 0) {
            viewA02.setVisibility(4);
        }
        h30 h30Var = j30Var2.K;
        viewA02.setAlpha(h30Var == null ? 1.0f : h30Var.k);
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + qq0.n(this.a) + "} {mLifecycleImpact = " + qq0.m(this.b) + "} {mFragment = " + this.c + "}";
    }
}
