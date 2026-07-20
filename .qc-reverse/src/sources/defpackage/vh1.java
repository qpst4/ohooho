package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vh1 extends j1 implements o1 {
    public static final AccelerateInterpolator y = new AccelerateInterpolator();
    public static final DecelerateInterpolator z = new DecelerateInterpolator();
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;
    public ActionBarContainer d;
    public yr e;
    public ActionBarContextView f;
    public final View g;
    public boolean h;
    public uh1 i;
    public uh1 j;
    public i9 k;
    public boolean l;
    public final ArrayList m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public og1 s;
    public boolean t;
    public boolean u;
    public final th1 v;
    public final th1 w;
    public final tb0 x;

    public vh1(Activity activity, boolean z2) {
        new ArrayList();
        this.m = new ArrayList();
        this.n = 0;
        this.o = true;
        this.r = true;
        this.v = new th1(this, 0);
        this.w = new th1(this, 1);
        this.x = new tb0(21, this);
        View decorView = activity.getWindow().getDecorView();
        z(decorView);
        if (z2) {
            return;
        }
        this.g = decorView.findViewById(R.id.content);
    }

    public final void A(int i, int i2) {
        b71 b71Var = (b71) this.e;
        int i3 = b71Var.b;
        if ((i2 & 4) != 0) {
            this.h = true;
        }
        b71Var.b((i & i2) | ((~i2) & i3));
    }

    public final void B(boolean z2) {
        if (z2) {
            this.d.setTabContainer(null);
            ((b71) this.e).getClass();
        } else {
            ((b71) this.e).getClass();
            this.d.setTabContainer(null);
        }
        this.e.getClass();
        ((b71) this.e).a.setCollapsible(false);
        this.c.setHasNonEmbeddedTabs(false);
    }

    public final void C(boolean z2) {
        boolean z3 = this.q || !this.p;
        boolean z4 = this.r;
        tb0 tb0Var = this.x;
        View view = this.g;
        if (!z3) {
            if (z4) {
                this.r = false;
                og1 og1Var = this.s;
                if (og1Var != null) {
                    og1Var.a();
                }
                int i = this.n;
                th1 th1Var = this.v;
                if (i != 0 || (!this.t && !z2)) {
                    th1Var.a();
                    return;
                }
                this.d.setAlpha(1.0f);
                this.d.setTransitioning(true);
                og1 og1Var2 = new og1();
                float f = -this.d.getHeight();
                if (z2) {
                    this.d.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                ng1 ng1VarA = uf1.a(this.d);
                ng1VarA.e(f);
                View view2 = (View) ng1VarA.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(tb0Var != null ? new o3(tb0Var, view2) : null);
                }
                boolean z5 = og1Var2.e;
                ArrayList arrayList = og1Var2.a;
                if (!z5) {
                    arrayList.add(ng1VarA);
                }
                if (this.o && view != null) {
                    ng1 ng1VarA2 = uf1.a(view);
                    ng1VarA2.e(f);
                    if (!og1Var2.e) {
                        arrayList.add(ng1VarA2);
                    }
                }
                boolean z6 = og1Var2.e;
                if (!z6) {
                    og1Var2.c = y;
                }
                if (!z6) {
                    og1Var2.b = 250L;
                }
                if (!z6) {
                    og1Var2.d = th1Var;
                }
                this.s = og1Var2;
                og1Var2.b();
                return;
            }
            return;
        }
        if (z4) {
            return;
        }
        this.r = true;
        og1 og1Var3 = this.s;
        if (og1Var3 != null) {
            og1Var3.a();
        }
        this.d.setVisibility(0);
        int i2 = this.n;
        th1 th1Var2 = this.w;
        if (i2 == 0 && (this.t || z2)) {
            this.d.setTranslationY(0.0f);
            float f2 = -this.d.getHeight();
            if (z2) {
                this.d.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.d.setTranslationY(f2);
            og1 og1Var4 = new og1();
            ng1 ng1VarA3 = uf1.a(this.d);
            ng1VarA3.e(0.0f);
            View view3 = (View) ng1VarA3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(tb0Var != null ? new o3(tb0Var, view3) : null);
            }
            boolean z7 = og1Var4.e;
            ArrayList arrayList2 = og1Var4.a;
            if (!z7) {
                arrayList2.add(ng1VarA3);
            }
            if (this.o && view != null) {
                view.setTranslationY(f2);
                ng1 ng1VarA4 = uf1.a(view);
                ng1VarA4.e(0.0f);
                if (!og1Var4.e) {
                    arrayList2.add(ng1VarA4);
                }
            }
            boolean z8 = og1Var4.e;
            if (!z8) {
                og1Var4.c = z;
            }
            if (!z8) {
                og1Var4.b = 250L;
            }
            if (!z8) {
                og1Var4.d = th1Var2;
            }
            this.s = og1Var4;
            og1Var4.b();
        } else {
            this.d.setAlpha(1.0f);
            this.d.setTranslationY(0.0f);
            if (this.o && view != null) {
                view.setTranslationY(0.0f);
            }
            th1Var2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = uf1.a;
            jf1.c(actionBarOverlayLayout);
        }
    }

    @Override // defpackage.j1
    public final boolean b() {
        u61 u61Var;
        yr yrVar = this.e;
        if (yrVar == null || (u61Var = ((b71) yrVar).a.N) == null || u61Var.c == null) {
            return false;
        }
        u61 u61Var2 = ((b71) yrVar).a.N;
        cl0 cl0Var = u61Var2 == null ? null : u61Var2.c;
        if (cl0Var == null) {
            return true;
        }
        cl0Var.collapseActionView();
        return true;
    }

    @Override // defpackage.j1
    public final void c(boolean z2) {
        if (z2 == this.l) {
            return;
        }
        this.l = z2;
        ArrayList arrayList = this.m;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        s1.d();
    }

    @Override // defpackage.j1
    public final int d() {
        return ((b71) this.e).b;
    }

    @Override // defpackage.j1
    public final Context e() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(com.quickcursor.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // defpackage.j1
    public final void g() {
        B(this.a.getResources().getBoolean(com.quickcursor.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // defpackage.j1
    public final boolean i(int i, KeyEvent keyEvent) {
        zk0 zk0Var;
        uh1 uh1Var = this.i;
        if (uh1Var == null || (zk0Var = uh1Var.e) == null) {
            return false;
        }
        zk0Var.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return zk0Var.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.j1
    public final void l(ColorDrawable colorDrawable) {
        this.d.setPrimaryBackground(colorDrawable);
    }

    @Override // defpackage.j1
    public final void m(View view) {
        ((b71) this.e).a(view);
    }

    @Override // defpackage.j1
    public final void n(boolean z2) {
        if (this.h) {
            return;
        }
        o(z2);
    }

    @Override // defpackage.j1
    public final void o(boolean z2) {
        A(z2 ? 4 : 0, 4);
    }

    @Override // defpackage.j1
    public final void p() {
        A(16, 16);
    }

    @Override // defpackage.j1
    public final void q() {
        A(0, 8);
    }

    @Override // defpackage.j1
    public final void r(Drawable drawable) {
        b71 b71Var = (b71) this.e;
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
    public final void s(boolean z2) {
        og1 og1Var;
        this.t = z2;
        if (z2 || (og1Var = this.s) == null) {
            return;
        }
        og1Var.a();
    }

    @Override // defpackage.j1
    public final void t(int i) {
        u(this.a.getString(i));
    }

    @Override // defpackage.j1
    public final void u(CharSequence charSequence) {
        ((b71) this.e).c(charSequence);
    }

    @Override // defpackage.j1
    public final void v(String str) {
        b71 b71Var = (b71) this.e;
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
        b71 b71Var = (b71) this.e;
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

    @Override // defpackage.j1
    public final e2 x(i9 i9Var) {
        uh1 uh1Var = this.i;
        if (uh1Var != null) {
            uh1Var.a();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.e();
        uh1 uh1Var2 = new uh1(this, this.f.getContext(), i9Var);
        zk0 zk0Var = uh1Var2.e;
        zk0Var.w();
        try {
            if (!((g7) uh1Var2.f.c).t(uh1Var2, zk0Var)) {
                return null;
            }
            this.i = uh1Var2;
            uh1Var2.h();
            this.f.c(uh1Var2);
            y(true);
            return uh1Var2;
        } finally {
            zk0Var.v();
        }
    }

    public final void y(boolean z2) {
        ng1 ng1VarI;
        ng1 ng1VarI2;
        boolean z3 = this.q;
        if (z2) {
            if (!z3) {
                this.q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                C(false);
            }
        } else if (z3) {
            this.q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            C(false);
        }
        boolean zIsLaidOut = this.d.isLaidOut();
        yr yrVar = this.e;
        if (!zIsLaidOut) {
            if (z2) {
                ((b71) yrVar).a.setVisibility(4);
                this.f.setVisibility(0);
                return;
            } else {
                ((b71) yrVar).a.setVisibility(0);
                this.f.setVisibility(8);
                return;
            }
        }
        if (z2) {
            b71 b71Var = (b71) yrVar;
            ng1VarI = uf1.a(b71Var.a);
            ng1VarI.a(0.0f);
            ng1VarI.c(100L);
            ng1VarI.d(new a71(b71Var, 4));
            ng1VarI2 = this.f.i(0, 200L);
        } else {
            b71 b71Var2 = (b71) yrVar;
            ng1 ng1VarA = uf1.a(b71Var2.a);
            ng1VarA.a(1.0f);
            ng1VarA.c(200L);
            ng1VarA.d(new a71(b71Var2, 0));
            ng1VarI = this.f.i(8, 100L);
            ng1VarI2 = ng1VarA;
        }
        og1 og1Var = new og1();
        ArrayList arrayList = og1Var.a;
        arrayList.add(ng1VarI);
        View view = (View) ng1VarI.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) ng1VarI2.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(ng1VarI2);
        og1Var.b();
    }

    public final void z(View view) {
        yr wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.quickcursor.R.id.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.quickcursor.R.id.action_bar);
        if (callbackFindViewById instanceof yr) {
            wrapper = (yr) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.e = wrapper;
        this.f = (ActionBarContextView) view.findViewById(com.quickcursor.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.quickcursor.R.id.action_bar_container);
        this.d = actionBarContainer;
        yr yrVar = this.e;
        if (yrVar == null || this.f == null || actionBarContainer == null) {
            s1.f(vh1.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
            return;
        }
        Context context = ((b71) yrVar).a.getContext();
        this.a = context;
        if ((((b71) this.e).b & 4) != 0) {
            this.h = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.e.getClass();
        B(context.getResources().getBoolean(com.quickcursor.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, zs0.a, com.quickcursor.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (!actionBarOverlayLayout2.h) {
                s1.f("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                return;
            } else {
                this.u = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.d;
            WeakHashMap weakHashMap = uf1.a;
            lf1.k(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public vh1(Dialog dialog) {
        new ArrayList();
        this.m = new ArrayList();
        this.n = 0;
        this.o = true;
        this.r = true;
        this.v = new th1(this, 0);
        this.w = new th1(this, 1);
        this.x = new tb0(21, this);
        z(dialog.getWindow().getDecorView());
    }
}
