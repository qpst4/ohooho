package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class jl0 {
    public final Context a;
    public final zk0 b;
    public final boolean c;
    public final int d;
    public View e;
    public boolean g;
    public ol0 h;
    public hl0 i;
    public PopupWindow.OnDismissListener j;
    public int f = 8388611;
    public final il0 k = new il0(this);

    public jl0(Context context, zk0 zk0Var, View view, boolean z, int i, int i2) {
        this.a = context;
        this.b = zk0Var;
        this.e = view;
        this.c = z;
        this.d = i;
    }

    public final hl0 a() {
        hl0 m21Var;
        if (this.i == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int iMin = Math.min(point.x, point.y);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width);
            Context context2 = this.a;
            if (iMin >= dimensionPixelSize) {
                m21Var = new vi(context2, this.e, this.d, this.c);
            } else {
                m21Var = new m21(context2, this.b, this.e, this.d, this.c);
            }
            m21Var.l(this.b);
            m21Var.r(this.k);
            m21Var.n(this.e);
            m21Var.e(this.h);
            m21Var.o(this.g);
            m21Var.p(this.f);
            this.i = m21Var;
        }
        return this.i;
    }

    public final boolean b() {
        hl0 hl0Var = this.i;
        return hl0Var != null && hl0Var.b();
    }

    public void c() {
        this.i = null;
        PopupWindow.OnDismissListener onDismissListener = this.j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        hl0 hl0VarA = a();
        hl0VarA.s(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f, this.e.getLayoutDirection()) & 7) == 5) {
                i -= this.e.getWidth();
            }
            hl0VarA.q(i);
            hl0VarA.t(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            hl0VarA.b = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        hl0VarA.d();
    }
}
