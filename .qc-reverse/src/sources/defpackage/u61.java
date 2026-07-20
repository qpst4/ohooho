package defpackage;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u61 implements pl0 {
    public zk0 b;
    public cl0 c;
    public final /* synthetic */ Toolbar d;

    public u61(Toolbar toolbar) {
        this.d = toolbar;
    }

    @Override // defpackage.pl0
    public final boolean c(cl0 cl0Var) {
        Toolbar toolbar = this.d;
        KeyEvent.Callback callback = toolbar.j;
        if (callback instanceof fl) {
            ((el0) ((fl) callback)).b.onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.j);
        toolbar.removeView(toolbar.i);
        toolbar.j = null;
        ArrayList arrayList = toolbar.F;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.c = null;
        toolbar.requestLayout();
        cl0Var.C = false;
        cl0Var.n.p(false);
        toolbar.w();
        return true;
    }

    @Override // defpackage.pl0
    public final boolean f(cl0 cl0Var) {
        Toolbar toolbar = this.d;
        toolbar.c();
        ViewParent parent = toolbar.i.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.i);
            }
            toolbar.addView(toolbar.i);
        }
        View actionView = cl0Var.getActionView();
        toolbar.j = actionView;
        this.c = cl0Var;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.j);
            }
            v61 v61VarH = Toolbar.h();
            v61VarH.a = (toolbar.o & 112) | 8388611;
            v61VarH.b = 2;
            toolbar.j.setLayoutParams(v61VarH);
            toolbar.addView(toolbar.j);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((v61) childAt.getLayoutParams()).b != 2 && childAt != toolbar.b) {
                toolbar.removeViewAt(childCount);
                toolbar.F.add(childAt);
            }
        }
        toolbar.requestLayout();
        cl0Var.C = true;
        cl0Var.n.p(false);
        KeyEvent.Callback callback = toolbar.j;
        if (callback instanceof fl) {
            ((el0) ((fl) callback)).b.onActionViewExpanded();
        }
        toolbar.w();
        return true;
    }

    @Override // defpackage.pl0
    public final void g() {
        if (this.c != null) {
            zk0 zk0Var = this.b;
            if (zk0Var != null) {
                int size = zk0Var.f.size();
                for (int i = 0; i < size; i++) {
                    if (this.b.getItem(i) == this.c) {
                        return;
                    }
                }
            }
            c(this.c);
        }
    }

    @Override // defpackage.pl0
    public final void i(Context context, zk0 zk0Var) {
        cl0 cl0Var;
        zk0 zk0Var2 = this.b;
        if (zk0Var2 != null && (cl0Var = this.c) != null) {
            zk0Var2.d(cl0Var);
        }
        this.b = zk0Var;
    }

    @Override // defpackage.pl0
    public final boolean j(g31 g31Var) {
        return false;
    }

    @Override // defpackage.pl0
    public final boolean k() {
        return false;
    }

    @Override // defpackage.pl0
    public final void a(zk0 zk0Var, boolean z) {
    }
}
