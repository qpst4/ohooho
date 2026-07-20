package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g31 extends zk0 implements SubMenu {
    public final cl0 A;
    public final zk0 z;

    public g31(Context context, zk0 zk0Var, cl0 cl0Var) {
        super(context);
        this.z = zk0Var;
        this.A = cl0Var;
    }

    @Override // defpackage.zk0
    public final boolean d(cl0 cl0Var) {
        return this.z.d(cl0Var);
    }

    @Override // defpackage.zk0
    public final boolean e(zk0 zk0Var, MenuItem menuItem) {
        return super.e(zk0Var, menuItem) || this.z.e(zk0Var, menuItem);
    }

    @Override // defpackage.zk0
    public final boolean f(cl0 cl0Var) {
        return this.z.f(cl0Var);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // defpackage.zk0
    public final String j() {
        cl0 cl0Var = this.A;
        int i = cl0Var != null ? cl0Var.a : 0;
        if (i == 0) {
            return null;
        }
        return qq0.i("android:menu:actionviewstates:", i);
    }

    @Override // defpackage.zk0
    public final zk0 k() {
        return this.z.k();
    }

    @Override // defpackage.zk0
    public final boolean m() {
        return this.z.m();
    }

    @Override // defpackage.zk0
    public final boolean n() {
        return this.z.n();
    }

    @Override // defpackage.zk0
    public final boolean o() {
        return this.z.o();
    }

    @Override // defpackage.zk0, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.z.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // defpackage.zk0, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.z.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }
}
