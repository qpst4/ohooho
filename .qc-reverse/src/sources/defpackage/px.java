package defpackage;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class px {
    public int a;
    public final Object b;
    public final Object c;

    public px(zt0 zt0Var) {
        this.a = Integer.MIN_VALUE;
        this.c = new Rect();
        this.b = zt0Var;
    }

    public static px a(zt0 zt0Var, int i) {
        if (i == 0) {
            return new ro0(zt0Var, 0);
        }
        int i2 = 1;
        if (i == 1) {
            return new ro0(zt0Var, i2);
        }
        zy.n("invalid orientation");
        return null;
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i);

    public px(rx rxVar) {
        this.a = 0;
        this.c = new fs();
        this.b = rxVar;
    }
}
