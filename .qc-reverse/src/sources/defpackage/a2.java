package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.quickcursor.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 implements pl0 {
    public final Context b;
    public Context c;
    public zk0 d;
    public final LayoutInflater e;
    public ol0 f;
    public rl0 i;
    public z1 j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public x1 t;
    public x1 u;
    public vn1 v;
    public y1 w;
    public final int g = R.layout.abc_action_menu_layout;
    public final int h = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray s = new SparseBooleanArray();
    public final sp1 x = new sp1(2, this);

    public a2(Context context) {
        this.b = context;
        this.e = LayoutInflater.from(context);
    }

    @Override // defpackage.pl0
    public final void a(zk0 zk0Var, boolean z) {
        d();
        x1 x1Var = this.u;
        if (x1Var != null && x1Var.b()) {
            x1Var.i.dismiss();
        }
        ol0 ol0Var = this.f;
        if (ol0Var != null) {
            ol0Var.a(zk0Var, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(cl0 cl0Var, View view, ViewGroup viewGroup) {
        View actionView = cl0Var.getActionView();
        if (actionView == null || cl0Var.e()) {
            ql0 ql0Var = view instanceof ql0 ? (ql0) view : (ql0) this.e.inflate(this.h, viewGroup, false);
            ql0Var.c(cl0Var);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) ql0Var;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
            if (this.w == null) {
                this.w = new y1(this);
            }
            actionMenuItemView.setPopupCallback(this.w);
            actionView = (View) ql0Var;
        }
        actionView.setVisibility(cl0Var.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof c2)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.pl0
    public final boolean c(cl0 cl0Var) {
        return false;
    }

    public final boolean d() {
        Object obj;
        vn1 vn1Var = this.v;
        if (vn1Var != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(vn1Var);
            this.v = null;
            return true;
        }
        x1 x1Var = this.t;
        if (x1Var == null) {
            return false;
        }
        if (x1Var.b()) {
            x1Var.i.dismiss();
        }
        return true;
    }

    @Override // defpackage.pl0
    public final void e(ol0 ol0Var) {
        throw null;
    }

    @Override // defpackage.pl0
    public final boolean f(cl0 cl0Var) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.pl0
    public final void g() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.i;
        ArrayList arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            zk0 zk0Var = this.d;
            if (zk0Var != null) {
                zk0Var.i();
                ArrayList arrayListL = this.d.l();
                int size = arrayListL.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    cl0 cl0Var = (cl0) arrayListL.get(i2);
                    if ((cl0Var.x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        cl0 itemData = childAt instanceof ql0 ? ((ql0) childAt).getItemData() : null;
                        View viewB = b(cl0Var, childAt, viewGroup);
                        if (cl0Var != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewB);
                            }
                            ((ViewGroup) this.i).addView(viewB, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.j) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.i).requestLayout();
        zk0 zk0Var2 = this.d;
        if (zk0Var2 != null) {
            zk0Var2.i();
            ArrayList arrayList2 = zk0Var2.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                dl0 dl0Var = ((cl0) arrayList2.get(i3)).A;
            }
        }
        zk0 zk0Var3 = this.d;
        if (zk0Var3 != null) {
            zk0Var3.i();
            arrayList = zk0Var3.j;
        }
        if (this.m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((cl0) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z = true;
            }
        }
        z1 z1Var = this.j;
        if (z) {
            if (z1Var == null) {
                this.j = new z1(this, this.b);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.j.getParent();
            if (viewGroup3 != this.i) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                z1 z1Var2 = this.j;
                actionMenuView.getClass();
                c2 c2VarJ = ActionMenuView.j();
                c2VarJ.a = true;
                actionMenuView.addView(z1Var2, c2VarJ);
            }
        } else if (z1Var != null) {
            Object parent = z1Var.getParent();
            Object obj = this.i;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.j);
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    public final boolean h() {
        x1 x1Var = this.t;
        return x1Var != null && x1Var.b();
    }

    @Override // defpackage.pl0
    public final void i(Context context, zk0 zk0Var) {
        this.c = context;
        LayoutInflater.from(context);
        this.d = zk0Var;
        Resources resources = context.getResources();
        if (!this.n) {
            this.m = true;
        }
        int i = 2;
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.q = i;
        int measuredWidth = this.o;
        if (this.m) {
            if (this.j == null) {
                z1 z1Var = new z1(this, this.b);
                this.j = z1Var;
                if (this.l) {
                    z1Var.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.pl0
    public final boolean j(g31 g31Var) {
        boolean z;
        if (g31Var.hasVisibleItems()) {
            g31 g31Var2 = g31Var;
            while (true) {
                zk0 zk0Var = g31Var2.z;
                if (zk0Var == this.d) {
                    break;
                }
                g31Var2 = (g31) zk0Var;
            }
            cl0 cl0Var = g31Var2.A;
            ViewGroup viewGroup = (ViewGroup) this.i;
            View view = null;
            view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof ql0) && ((ql0) childAt).getItemData() == cl0Var) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                g31Var.A.getClass();
                int size = g31Var.f.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = g31Var.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                x1 x1Var = new x1(this, this.c, g31Var, view);
                this.u = x1Var;
                x1Var.g = z;
                hl0 hl0Var = x1Var.i;
                if (hl0Var != null) {
                    hl0Var.o(z);
                }
                x1 x1Var2 = this.u;
                if (!x1Var2.b()) {
                    if (x1Var2.e == null) {
                        s1.f("MenuPopupHelper cannot be used without an anchor");
                        return false;
                    }
                    x1Var2.d(0, 0, false, false);
                }
                ol0 ol0Var = this.f;
                if (ol0Var != null) {
                    ol0Var.s(g31Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.pl0
    public final boolean k() {
        int size;
        ArrayList arrayListL;
        int i;
        boolean z;
        a2 a2Var = this;
        zk0 zk0Var = a2Var.d;
        if (zk0Var != null) {
            arrayListL = zk0Var.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i2 = a2Var.q;
        int i3 = a2Var.p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) a2Var.i;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = true;
            if (i4 >= size) {
                break;
            }
            cl0 cl0Var = (cl0) arrayListL.get(i4);
            int i7 = cl0Var.y;
            if ((i7 & 2) == 2) {
                i5++;
            } else if ((i7 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (a2Var.r && cl0Var.C) {
                i2 = 0;
            }
            i4++;
        }
        if (a2Var.m && (z2 || i6 + i5 > i2)) {
            i2--;
        }
        int i8 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = a2Var.s;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            cl0 cl0Var2 = (cl0) arrayListL.get(i9);
            int i11 = cl0Var2.y;
            boolean z3 = (i11 & 2) == i ? z : false;
            int i12 = cl0Var2.b;
            if (z3) {
                View viewB = a2Var.b(cl0Var2, null, viewGroup);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                cl0Var2.f(z);
            } else if ((i11 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i12);
                boolean z5 = ((i8 > 0 || z4) && i3 > 0) ? z : false;
                if (z5) {
                    View viewB2 = a2Var.b(cl0Var2, null, viewGroup);
                    viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewB2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i10 == 0) {
                        i10 = measuredWidth2;
                    }
                    z5 &= i3 + i10 > 0;
                }
                if (z5 && i12 != 0) {
                    sparseBooleanArray.put(i12, true);
                } else if (z4) {
                    sparseBooleanArray.put(i12, false);
                    for (int i13 = 0; i13 < i9; i13++) {
                        cl0 cl0Var3 = (cl0) arrayListL.get(i13);
                        if (cl0Var3.b == i12) {
                            if ((cl0Var3.x & 32) == 32) {
                                i8++;
                            }
                            cl0Var3.f(false);
                        }
                    }
                }
                if (z5) {
                    i8--;
                }
                cl0Var2.f(z5);
            } else {
                cl0Var2.f(false);
                i9++;
                i = 2;
                a2Var = this;
                z = true;
            }
            i9++;
            i = 2;
            a2Var = this;
            z = true;
        }
        return z;
    }

    public final boolean l() {
        zk0 zk0Var;
        boolean z = false;
        if (this.m && !h() && (zk0Var = this.d) != null && this.i != null && this.v == null) {
            zk0Var.i();
            if (!zk0Var.j.isEmpty()) {
                vn1 vn1Var = new vn1(this, new x1(this, this.c, this.d, this.j), 1, z);
                this.v = vn1Var;
                ((View) this.i).post(vn1Var);
                return true;
            }
        }
        return false;
    }
}
