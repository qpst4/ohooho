package defpackage;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k21 extends e2 implements xk0 {
    public Context d;
    public ActionBarContextView e;
    public i9 f;
    public WeakReference g;
    public boolean h;
    public zk0 i;

    @Override // defpackage.e2
    public final void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f.C(this);
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
        return this.i;
    }

    @Override // defpackage.e2
    public final MenuInflater d() {
        return new m31(this.e.getContext());
    }

    @Override // defpackage.xk0
    public final boolean e(zk0 zk0Var, MenuItem menuItem) {
        return ((g7) this.f.c).s(this, menuItem);
    }

    @Override // defpackage.e2
    public final CharSequence f() {
        return this.e.getSubtitle();
    }

    @Override // defpackage.e2
    public final CharSequence g() {
        return this.e.getTitle();
    }

    @Override // defpackage.e2
    public final void h() {
        this.f.D(this, this.i);
    }

    @Override // defpackage.e2
    public final boolean i() {
        return this.e.t;
    }

    @Override // defpackage.e2
    public final void j(View view) {
        this.e.setCustomView(view);
        this.g = view != null ? new WeakReference(view) : null;
    }

    @Override // defpackage.e2
    public final void k(int i) {
        l(this.d.getString(i));
    }

    @Override // defpackage.e2
    public final void l(CharSequence charSequence) {
        this.e.setSubtitle(charSequence);
    }

    @Override // defpackage.e2
    public final void m(int i) {
        o(this.d.getString(i));
    }

    @Override // defpackage.xk0
    public final void n(zk0 zk0Var) {
        h();
        a2 a2Var = this.e.e;
        if (a2Var != null) {
            a2Var.l();
        }
    }

    @Override // defpackage.e2
    public final void o(CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    @Override // defpackage.e2
    public final void p(boolean z) {
        this.c = z;
        this.e.setTitleOptional(z);
    }
}
