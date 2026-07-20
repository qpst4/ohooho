package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m21 extends hl0 implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public final Context c;
    public final zk0 d;
    public final wk0 e;
    public final boolean f;
    public final int g;
    public final int h;
    public final nl0 i;
    public final p9 j;
    public final si k;
    public PopupWindow.OnDismissListener l;
    public View m;
    public View n;
    public ol0 o;
    public ViewTreeObserver p;
    public boolean q;
    public boolean r;
    public int s;
    public int t = 0;
    public boolean u;

    public m21(Context context, zk0 zk0Var, View view, int i, boolean z) {
        int i2 = 3;
        this.j = new p9(i2, this);
        this.k = new si(i2, this);
        this.c = context;
        this.d = zk0Var;
        this.f = z;
        this.e = new wk0(zk0Var, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.h = i;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.i = new nl0(context, null, i, 0);
        zk0Var.b(this, context);
    }

    @Override // defpackage.pl0
    public final void a(zk0 zk0Var, boolean z) {
        if (zk0Var != this.d) {
            return;
        }
        dismiss();
        ol0 ol0Var = this.o;
        if (ol0Var != null) {
            ol0Var.a(zk0Var, z);
        }
    }

    @Override // defpackage.n01
    public final boolean b() {
        return !this.q && this.i.A.isShowing();
    }

    @Override // defpackage.n01
    public final void d() {
        View view;
        if (b()) {
            return;
        }
        if (this.q || (view = this.m) == null) {
            s1.f("StandardMenuPopup cannot be used without an anchor");
            return;
        }
        this.n = view;
        nl0 nl0Var = this.i;
        h9 h9Var = nl0Var.A;
        h9 h9Var2 = nl0Var.A;
        h9Var.setOnDismissListener(this);
        nl0Var.q = this;
        nl0Var.z = true;
        h9Var2.setFocusable(true);
        View view2 = this.n;
        boolean z = this.p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.j);
        }
        view2.addOnAttachStateChangeListener(this.k);
        nl0Var.p = view2;
        nl0Var.m = this.t;
        boolean z2 = this.r;
        Context context = this.c;
        wk0 wk0Var = this.e;
        if (!z2) {
            this.s = hl0.m(wk0Var, context, this.g);
            this.r = true;
        }
        nl0Var.r(this.s);
        h9Var2.setInputMethodMode(2);
        Rect rect = this.b;
        nl0Var.y = rect != null ? new Rect(rect) : null;
        nl0Var.d();
        bv bvVar = nl0Var.d;
        bvVar.setOnKeyListener(this);
        if (this.u) {
            zk0 zk0Var = this.d;
            if (zk0Var.m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) bvVar, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(zk0Var.m);
                }
                frameLayout.setEnabled(false);
                bvVar.addHeaderView(frameLayout, null, false);
            }
        }
        nl0Var.p(wk0Var);
        nl0Var.d();
    }

    @Override // defpackage.n01
    public final void dismiss() {
        if (b()) {
            this.i.dismiss();
        }
    }

    @Override // defpackage.pl0
    public final void e(ol0 ol0Var) {
        this.o = ol0Var;
    }

    @Override // defpackage.pl0
    public final void g() {
        this.r = false;
        wk0 wk0Var = this.e;
        if (wk0Var != null) {
            wk0Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.n01
    public final bv h() {
        return this.i.d;
    }

    @Override // defpackage.pl0
    public final boolean j(g31 g31Var) {
        boolean z;
        if (g31Var.hasVisibleItems()) {
            jl0 jl0Var = new jl0(this.c, g31Var, this.n, this.f, this.h, 0);
            ol0 ol0Var = this.o;
            jl0Var.h = ol0Var;
            hl0 hl0Var = jl0Var.i;
            if (hl0Var != null) {
                hl0Var.e(ol0Var);
            }
            int size = g31Var.f.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    break;
                }
                MenuItem item = g31Var.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            jl0Var.g = z;
            hl0 hl0Var2 = jl0Var.i;
            if (hl0Var2 != null) {
                hl0Var2.o(z);
            }
            jl0Var.j = this.l;
            this.l = null;
            this.d.c(false);
            nl0 nl0Var = this.i;
            int width = nl0Var.g;
            int iN = nl0Var.n();
            if ((Gravity.getAbsoluteGravity(this.t, this.m.getLayoutDirection()) & 7) == 5) {
                width += this.m.getWidth();
            }
            if (!jl0Var.b()) {
                if (jl0Var.e != null) {
                    jl0Var.d(width, iN, true, true);
                }
            }
            ol0 ol0Var2 = this.o;
            if (ol0Var2 != null) {
                ol0Var2.s(g31Var);
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.pl0
    public final boolean k() {
        return false;
    }

    @Override // defpackage.hl0
    public final void n(View view) {
        this.m = view;
    }

    @Override // defpackage.hl0
    public final void o(boolean z) {
        this.e.c = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.q = true;
        this.d.c(true);
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.hl0
    public final void p(int i) {
        this.t = i;
    }

    @Override // defpackage.hl0
    public final void q(int i) {
        this.i.g = i;
    }

    @Override // defpackage.hl0
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // defpackage.hl0
    public final void s(boolean z) {
        this.u = z;
    }

    @Override // defpackage.hl0
    public final void t(int i) {
        this.i.j(i);
    }

    @Override // defpackage.hl0
    public final void l(zk0 zk0Var) {
    }
}
