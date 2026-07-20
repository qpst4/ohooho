package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xt0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ zt0 b;

    public /* synthetic */ xt0(zt0 zt0Var, int i) {
        this.a = i;
        this.b = zt0Var;
    }

    public final int a(View view) {
        int iD;
        int i;
        switch (this.a) {
            case 0:
                au0 au0Var = (au0) view.getLayoutParams();
                iD = zt0.D(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var).rightMargin;
                break;
            default:
                au0 au0Var2 = (au0) view.getLayoutParams();
                iD = zt0.y(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var2).bottomMargin;
                break;
        }
        return iD + i;
    }

    public final int b(View view) {
        int iA;
        int i;
        switch (this.a) {
            case 0:
                au0 au0Var = (au0) view.getLayoutParams();
                iA = zt0.A(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var).leftMargin;
                break;
            default:
                au0 au0Var2 = (au0) view.getLayoutParams();
                iA = zt0.E(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var2).topMargin;
                break;
        }
        return iA - i;
    }

    public final int c() {
        int i;
        int iJ;
        int i2 = this.a;
        zt0 zt0Var = this.b;
        switch (i2) {
            case 0:
                i = zt0Var.n;
                iJ = zt0Var.J();
                break;
            default:
                i = zt0Var.o;
                iJ = zt0Var.H();
                break;
        }
        return i - iJ;
    }

    public final int d() {
        int i = this.a;
        zt0 zt0Var = this.b;
        switch (i) {
            case 0:
                return zt0Var.I();
            default:
                return zt0Var.K();
        }
    }
}
