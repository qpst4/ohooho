package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.quickcursor.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vi extends hl0 implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public boolean A;
    public final Context c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Handler g;
    public View o;
    public View p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean w;
    public ol0 x;
    public ViewTreeObserver y;
    public PopupWindow.OnDismissListener z;
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final p9 j = new p9(2, this);
    public final si k = new si(0, this);
    public final sp1 l = new sp1(9, this);
    public int m = 0;
    public int n = 0;
    public boolean v = false;

    public vi(Context context, View view, int i, boolean z) {
        this.c = context;
        this.o = view;
        this.e = i;
        this.f = z;
        this.q = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.g = new Handler();
    }

    @Override // defpackage.pl0
    public final void a(zk0 zk0Var, boolean z) {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (zk0Var == ((ui) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((ui) arrayList.get(i2)).b.c(false);
        }
        ui uiVar = (ui) arrayList.remove(i);
        zk0 zk0Var2 = uiVar.b;
        nl0 nl0Var = uiVar.a;
        h9 h9Var = nl0Var.A;
        zk0Var2.r(this);
        if (this.A) {
            kl0.b(h9Var, null);
            h9Var.setAnimationStyle(0);
        }
        nl0Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.q = ((ui) arrayList.get(size2 - 1)).c;
        } else {
            this.q = this.o.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((ui) arrayList.get(0)).b.c(false);
                return;
            }
            return;
        }
        dismiss();
        ol0 ol0Var = this.x;
        if (ol0Var != null) {
            ol0Var.a(zk0Var, true);
        }
        ViewTreeObserver viewTreeObserver = this.y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.y.removeGlobalOnLayoutListener(this.j);
            }
            this.y = null;
        }
        this.p.removeOnAttachStateChangeListener(this.k);
        this.z.onDismiss();
    }

    @Override // defpackage.n01
    public final boolean b() {
        ArrayList arrayList = this.i;
        return arrayList.size() > 0 && ((ui) arrayList.get(0)).a.A.isShowing();
    }

    @Override // defpackage.n01
    public final void d() {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            u((zk0) obj);
        }
        arrayList.clear();
        View view = this.o;
        this.p = view;
        if (view != null) {
            boolean z = this.y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.y = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.j);
            }
            this.p.addOnAttachStateChangeListener(this.k);
        }
    }

    @Override // defpackage.n01
    public final void dismiss() {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        if (size > 0) {
            ui[] uiVarArr = (ui[]) arrayList.toArray(new ui[size]);
            for (int i = size - 1; i >= 0; i--) {
                ui uiVar = uiVarArr[i];
                if (uiVar.a.A.isShowing()) {
                    uiVar.a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.pl0
    public final void e(ol0 ol0Var) {
        this.x = ol0Var;
    }

    @Override // defpackage.pl0
    public final void g() {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((ui) obj).a.d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((wk0) adapter).notifyDataSetChanged();
        }
    }

    @Override // defpackage.n01
    public final bv h() {
        ArrayList arrayList = this.i;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((ui) arrayList.get(arrayList.size() - 1)).a.d;
    }

    @Override // defpackage.pl0
    public final boolean j(g31 g31Var) {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ui uiVar = (ui) obj;
            if (g31Var == uiVar.b) {
                uiVar.a.d.requestFocus();
                return true;
            }
        }
        if (!g31Var.hasVisibleItems()) {
            return false;
        }
        l(g31Var);
        ol0 ol0Var = this.x;
        if (ol0Var != null) {
            ol0Var.s(g31Var);
        }
        return true;
    }

    @Override // defpackage.pl0
    public final boolean k() {
        return false;
    }

    @Override // defpackage.hl0
    public final void l(zk0 zk0Var) {
        zk0Var.b(this, this.c);
        if (b()) {
            u(zk0Var);
        } else {
            this.h.add(zk0Var);
        }
    }

    @Override // defpackage.hl0
    public final void n(View view) {
        if (this.o != view) {
            this.o = view;
            this.n = Gravity.getAbsoluteGravity(this.m, view.getLayoutDirection());
        }
    }

    @Override // defpackage.hl0
    public final void o(boolean z) {
        this.v = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ui uiVar;
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                uiVar = null;
                break;
            }
            uiVar = (ui) arrayList.get(i);
            if (!uiVar.a.A.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (uiVar != null) {
            uiVar.b.c(false);
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
        if (this.m != i) {
            this.m = i;
            this.n = Gravity.getAbsoluteGravity(i, this.o.getLayoutDirection());
        }
    }

    @Override // defpackage.hl0
    public final void q(int i) {
        this.r = true;
        this.t = i;
    }

    @Override // defpackage.hl0
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // defpackage.hl0
    public final void s(boolean z) {
        this.w = z;
    }

    @Override // defpackage.hl0
    public final void t(int i) {
        this.s = true;
        this.u = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(defpackage.zk0 r20) {
        /*
            Method dump skipped, instruction units count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vi.u(zk0):void");
    }
}
