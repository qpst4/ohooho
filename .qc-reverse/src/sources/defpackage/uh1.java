package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uh1 extends e2 implements xk0 {
    public final Context d;
    public final zk0 e;
    public i9 f;
    public WeakReference g;
    public final /* synthetic */ vh1 h;

    public uh1(vh1 vh1Var, Context context, i9 i9Var) {
        this.h = vh1Var;
        this.d = context;
        this.f = i9Var;
        zk0 zk0Var = new zk0(context);
        zk0Var.l = 1;
        this.e = zk0Var;
        zk0Var.e = this;
    }

    @Override // defpackage.e2
    public final void a() {
        vh1 vh1Var = this.h;
        if (vh1Var.i != this) {
            return;
        }
        if (vh1Var.p) {
            vh1Var.j = this;
            vh1Var.k = this.f;
        } else {
            this.f.C(this);
        }
        this.f = null;
        vh1Var.y(false);
        ActionBarContextView actionBarContextView = vh1Var.f;
        if (actionBarContextView.l == null) {
            actionBarContextView.e();
        }
        vh1Var.c.setHideOnContentScrollEnabled(vh1Var.u);
        vh1Var.i = null;
    }

    @Override // defpackage.e2
    public final View b() {
        WeakReference weakReference = this.g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // defpackage.e2
    public final zk0 c() {
        return this.e;
    }

    @Override // defpackage.e2
    public final MenuInflater d() {
        return new m31(this.d);
    }

    @Override // defpackage.xk0
    public final boolean e(zk0 zk0Var, MenuItem menuItem) {
        i9 i9Var = this.f;
        if (i9Var != null) {
            return ((g7) i9Var.c).s(this, menuItem);
        }
        return false;
    }

    @Override // defpackage.e2
    public final CharSequence f() {
        return this.h.f.getSubtitle();
    }

    @Override // defpackage.e2
    public final CharSequence g() {
        return this.h.f.getTitle();
    }

    @Override // defpackage.e2
    public final void h() {
        if (this.h.i != this) {
            return;
        }
        zk0 zk0Var = this.e;
        zk0Var.w();
        try {
            this.f.D(this, zk0Var);
        } finally {
            zk0Var.v();
        }
    }

    @Override // defpackage.e2
    public final boolean i() {
        return this.h.f.t;
    }

    @Override // defpackage.e2
    public final void j(View view) {
        this.h.f.setCustomView(view);
        this.g = new WeakReference(view);
    }

    @Override // defpackage.e2
    public final void k(int i) {
        l(this.h.a.getResources().getString(i));
    }

    @Override // defpackage.e2
    public final void l(CharSequence charSequence) {
        this.h.f.setSubtitle(charSequence);
    }

    @Override // defpackage.e2
    public final void m(int i) {
        o(this.h.a.getResources().getString(i));
    }

    @Override // defpackage.xk0
    public final void n(zk0 zk0Var) {
        if (this.f == null) {
            return;
        }
        h();
        a2 a2Var = this.h.f.e;
        if (a2Var != null) {
            a2Var.l();
        }
    }

    @Override // defpackage.e2
    public final void o(CharSequence charSequence) {
        this.h.f.setTitle(charSequence);
    }

    @Override // defpackage.e2
    public final void p(boolean z) {
        this.c = z;
        this.h.f.setTitleOptional(z);
    }
}
