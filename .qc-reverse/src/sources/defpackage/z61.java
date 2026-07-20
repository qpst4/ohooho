package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z61 extends j1 {
    public final b71 a;
    public final Window.Callback b;
    public final y61 c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final ArrayList g = new ArrayList();
    public final nc h = new nc(19, this);

    public z61(Toolbar toolbar, CharSequence charSequence, s8 s8Var) {
        y61 y61Var = new y61(this);
        toolbar.getClass();
        b71 b71Var = new b71(toolbar, false);
        this.a = b71Var;
        s8Var.getClass();
        this.b = s8Var;
        b71Var.k = s8Var;
        toolbar.setOnMenuItemClickListener(y61Var);
        if (!b71Var.g) {
            b71Var.h = charSequence;
            if ((b71Var.b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (b71Var.g) {
                    uf1.o(toolbar.getRootView(), charSequence);
                }
            }
        }
        this.c = new y61(this);
    }

    @Override // defpackage.j1
    public final boolean a() {
        a2 a2Var;
        ActionMenuView actionMenuView = this.a.a.b;
        return (actionMenuView == null || (a2Var = actionMenuView.u) == null || !a2Var.d()) ? false : true;
    }

    @Override // defpackage.j1
    public final boolean b() {
        cl0 cl0Var;
        u61 u61Var = this.a.a.N;
        if (u61Var == null || (cl0Var = u61Var.c) == null) {
            return false;
        }
        if (u61Var == null) {
            cl0Var = null;
        }
        if (cl0Var == null) {
            return true;
        }
        cl0Var.collapseActionView();
        return true;
    }

    @Override // defpackage.j1
    public final void c(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        ArrayList arrayList = this.g;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        s1.d();
    }

    @Override // defpackage.j1
    public final int d() {
        return this.a.b;
    }

    @Override // defpackage.j1
    public final Context e() {
        return this.a.a.getContext();
    }

    @Override // defpackage.j1
    public final boolean f() {
        b71 b71Var = this.a;
        Toolbar toolbar = b71Var.a;
        nc ncVar = this.h;
        toolbar.removeCallbacks(ncVar);
        Toolbar toolbar2 = b71Var.a;
        WeakHashMap weakHashMap = uf1.a;
        toolbar2.postOnAnimation(ncVar);
        return true;
    }

    @Override // defpackage.j1
    public final void h() {
        this.a.a.removeCallbacks(this.h);
    }

    @Override // defpackage.j1
    public final boolean i(int i, KeyEvent keyEvent) {
        Menu menuY = y();
        if (menuY == null) {
            return false;
        }
        menuY.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menuY.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.j1
    public final boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // defpackage.j1
    public final boolean k() {
        return this.a.a.v();
    }

    @Override // defpackage.j1
    public final void l(ColorDrawable colorDrawable) {
        this.a.a.setBackground(colorDrawable);
    }

    @Override // defpackage.j1
    public final void m(View view) {
        h1 h1Var = new h1();
        if (view != null) {
            view.setLayoutParams(h1Var);
        }
        this.a.a(view);
    }

    @Override // defpackage.j1
    public final void o(boolean z) {
        z(4, 4);
    }

    @Override // defpackage.j1
    public final void p() {
        z(16, 16);
    }

    @Override // defpackage.j1
    public final void q() {
        z(0, 8);
    }

    @Override // defpackage.j1
    public final void r(Drawable drawable) {
        b71 b71Var = this.a;
        b71Var.f = drawable;
        int i = b71Var.b & 4;
        Toolbar toolbar = b71Var.a;
        if (i == 0) {
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        if (drawable == null) {
            drawable = b71Var.o;
        }
        toolbar.setNavigationIcon(drawable);
    }

    @Override // defpackage.j1
    public final void t(int i) {
        b71 b71Var = this.a;
        b71Var.c(i != 0 ? b71Var.a.getContext().getText(i) : null);
    }

    @Override // defpackage.j1
    public final void u(CharSequence charSequence) {
        this.a.c(charSequence);
    }

    @Override // defpackage.j1
    public final void v(String str) {
        b71 b71Var = this.a;
        b71Var.g = true;
        Toolbar toolbar = b71Var.a;
        b71Var.h = str;
        if ((b71Var.b & 8) != 0) {
            toolbar.setTitle(str);
            if (b71Var.g) {
                uf1.o(toolbar.getRootView(), str);
            }
        }
    }

    @Override // defpackage.j1
    public final void w(CharSequence charSequence) {
        b71 b71Var = this.a;
        if (b71Var.g) {
            return;
        }
        Toolbar toolbar = b71Var.a;
        b71Var.h = charSequence;
        if ((b71Var.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (b71Var.g) {
                uf1.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final Menu y() {
        boolean z = this.e;
        b71 b71Var = this.a;
        if (!z) {
            xg xgVar = new xg(this);
            y61 y61Var = new y61(this);
            Toolbar toolbar = b71Var.a;
            toolbar.O = xgVar;
            toolbar.P = y61Var;
            ActionMenuView actionMenuView = toolbar.b;
            if (actionMenuView != null) {
                actionMenuView.v = xgVar;
                actionMenuView.w = y61Var;
            }
            this.e = true;
        }
        return b71Var.a.getMenu();
    }

    public final void z(int i, int i2) {
        b71 b71Var = this.a;
        b71Var.b((i & i2) | ((~i2) & b71Var.b));
    }

    @Override // defpackage.j1
    public final void g() {
    }

    @Override // defpackage.j1
    public final void n(boolean z) {
    }

    @Override // defpackage.j1
    public final void s(boolean z) {
    }
}
