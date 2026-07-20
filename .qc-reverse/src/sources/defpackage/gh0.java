package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gh0 implements pl0, AdapterView.OnItemClickListener {
    public Context b;
    public LayoutInflater c;
    public zk0 d;
    public ExpandedMenuView e;
    public ol0 f;
    public fh0 g;

    public gh0(ContextWrapper contextWrapper) {
        this.b = contextWrapper;
        this.c = LayoutInflater.from(contextWrapper);
    }

    @Override // defpackage.pl0
    public final void a(zk0 zk0Var, boolean z) {
        ol0 ol0Var = this.f;
        if (ol0Var != null) {
            ol0Var.a(zk0Var, z);
        }
    }

    @Override // defpackage.pl0
    public final boolean c(cl0 cl0Var) {
        return false;
    }

    @Override // defpackage.pl0
    public final void e(ol0 ol0Var) {
        throw null;
    }

    @Override // defpackage.pl0
    public final boolean f(cl0 cl0Var) {
        return false;
    }

    @Override // defpackage.pl0
    public final void g() {
        fh0 fh0Var = this.g;
        if (fh0Var != null) {
            fh0Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.pl0
    public final void i(Context context, zk0 zk0Var) {
        if (this.b != null) {
            this.b = context;
            if (this.c == null) {
                this.c = LayoutInflater.from(context);
            }
        }
        this.d = zk0Var;
        fh0 fh0Var = this.g;
        if (fh0Var != null) {
            fh0Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.pl0
    public final boolean j(g31 g31Var) {
        boolean zHasVisibleItems = g31Var.hasVisibleItems();
        Context context = g31Var.a;
        if (!zHasVisibleItems) {
            return false;
        }
        al0 al0Var = new al0();
        al0Var.b = g31Var;
        jl1 jl1Var = new jl1(context);
        x6 x6Var = (x6) jl1Var.c;
        gh0 gh0Var = new gh0(x6Var.a);
        al0Var.d = gh0Var;
        gh0Var.f = al0Var;
        g31Var.b(gh0Var, context);
        gh0 gh0Var2 = al0Var.d;
        if (gh0Var2.g == null) {
            gh0Var2.g = new fh0(gh0Var2);
        }
        jl1Var.f(gh0Var2.g, al0Var);
        View view = g31Var.o;
        if (view != null) {
            x6Var.f = view;
        } else {
            x6Var.d = g31Var.n;
            x6Var.e = g31Var.m;
        }
        x6Var.q = al0Var;
        b7 b7VarC = jl1Var.c();
        al0Var.c = b7VarC;
        b7VarC.setOnDismissListener(al0Var);
        WindowManager.LayoutParams attributes = al0Var.c.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        al0Var.c.show();
        ol0 ol0Var = this.f;
        if (ol0Var == null) {
            return true;
        }
        ol0Var.s(g31Var);
        return true;
    }

    @Override // defpackage.pl0
    public final boolean k() {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.d.q(this.g.getItem(i), this, 0);
    }
}
