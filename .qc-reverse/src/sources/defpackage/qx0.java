package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import androidx.lifecycle.a;
import androidx.savedstate.Recreator;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qx0 {
    public boolean a;
    public final Object b;
    public Object c;

    public qx0(rx0 rx0Var) {
        this.b = rx0Var;
        this.c = new e8();
    }

    public void a(t7 t7Var, l41 l41Var) {
        tb0 tb0Var = (tb0) ((tb0) this.c).c;
        tb0Var.getClass();
        ek1 ek1Var = (ek1) ((ik1) t7Var).p();
        q41 q41Var = (q41) tb0Var.c;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(ek1Var.d);
        int i = qj1.a;
        if (q41Var == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            q41Var.writeToParcel(parcelObtain, 0);
        }
        try {
            ek1Var.c.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            xa1 xa1Var = l41Var.a;
            synchronized (xa1Var.b) {
                xa1Var.k();
                xa1Var.a = true;
                xa1Var.d = null;
            }
            ((qx0) xa1Var.c).e(xa1Var);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public void b() {
        rx0 rx0Var = (rx0) this.b;
        a aVarP = rx0Var.p();
        if (aVarP.c != zf0.c) {
            s1.f("Restarter must be created only during owner's initialization stage");
            return;
        }
        aVarP.a(new Recreator(rx0Var));
        e8 e8Var = (e8) this.c;
        e8Var.getClass();
        if (e8Var.c) {
            s1.f("SavedStateRegistry was already attached.");
            return;
        }
        aVarP.a(new em(2, e8Var));
        e8Var.c = true;
        this.a = true;
    }

    public void c(Bundle bundle) {
        if (!this.a) {
            b();
        }
        a aVarP = ((rx0) this.b).p();
        if (aVarP.c.compareTo(zf0.e) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + aVarP.c).toString());
        }
        e8 e8Var = (e8) this.c;
        if (!e8Var.c) {
            s1.f("You must call performAttach() before calling performRestore(Bundle).");
        } else if (e8Var.d) {
            s1.f("SavedStateRegistry was already restored.");
        } else {
            e8Var.a = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
            e8Var.d = true;
        }
    }

    public void d(Bundle bundle) {
        e8 e8Var = (e8) this.c;
        e8Var.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) e8Var.a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        ix0 ix0Var = (ix0) e8Var.f;
        ix0Var.getClass();
        gx0 gx0Var = new gx0(ix0Var);
        ix0Var.d.put(gx0Var, Boolean.FALSE);
        while (gx0Var.hasNext()) {
            Map.Entry entry = (Map.Entry) gx0Var.next();
            bundle2.putBundle((String) entry.getKey(), ((px0) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void e(xa1 xa1Var) {
        gq1 gq1Var;
        boolean z;
        synchronized (this.b) {
            if (((ArrayDeque) this.c) != null && !this.a) {
                this.a = true;
                while (true) {
                    synchronized (this.b) {
                        try {
                            gq1Var = (gq1) ((ArrayDeque) this.c).poll();
                            z = false;
                            if (gq1Var == null) {
                                this.a = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    synchronized (gq1Var.b) {
                    }
                    gq1Var.a.execute(new vn1(gq1Var, xa1Var, 18, z));
                }
            }
        }
    }

    public qx0(tb0 tb0Var, l10[] l10VarArr) {
        this.c = tb0Var;
        this.b = l10VarArr;
        this.a = false;
    }

    public qx0() {
        this.b = new Object();
    }
}
