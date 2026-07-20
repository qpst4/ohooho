package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ro0 extends px {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ro0(zt0 zt0Var, int i) {
        super(zt0Var);
        this.d = i;
    }

    @Override // defpackage.px
    public final int b(View view) {
        int iD;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                au0 au0Var = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iD = zt0.D(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var).rightMargin;
                break;
            default:
                au0 au0Var2 = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iD = zt0.y(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var2).bottomMargin;
                break;
        }
        return iD + i;
    }

    @Override // defpackage.px
    public final int c(View view) {
        int iC;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                au0 au0Var = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iC = zt0.C(view) + ((ViewGroup.MarginLayoutParams) au0Var).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) au0Var).rightMargin;
                break;
            default:
                au0 au0Var2 = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iC = zt0.B(view) + ((ViewGroup.MarginLayoutParams) au0Var2).topMargin;
                i = ((ViewGroup.MarginLayoutParams) au0Var2).bottomMargin;
                break;
        }
        return iC + i;
    }

    @Override // defpackage.px
    public final int d(View view) {
        int iB;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                au0 au0Var = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iB = zt0.B(view) + ((ViewGroup.MarginLayoutParams) au0Var).topMargin;
                i = ((ViewGroup.MarginLayoutParams) au0Var).bottomMargin;
                break;
            default:
                au0 au0Var2 = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iB = zt0.C(view) + ((ViewGroup.MarginLayoutParams) au0Var2).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) au0Var2).rightMargin;
                break;
        }
        return iB + i;
    }

    @Override // defpackage.px
    public final int e(View view) {
        int iA;
        int i;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                au0 au0Var = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iA = zt0.A(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var).leftMargin;
                break;
            default:
                au0 au0Var2 = (au0) view.getLayoutParams();
                ((zt0) obj).getClass();
                iA = zt0.E(view);
                i = ((ViewGroup.MarginLayoutParams) au0Var2).topMargin;
                break;
        }
        return iA - i;
    }

    @Override // defpackage.px
    public final int f() {
        switch (this.d) {
            case 0:
                return ((zt0) this.b).n;
            default:
                return ((zt0) this.b).o;
        }
    }

    @Override // defpackage.px
    public final int g() {
        int i;
        int iJ;
        int i2 = this.d;
        Object obj = this.b;
        switch (i2) {
            case 0:
                zt0 zt0Var = (zt0) obj;
                i = zt0Var.n;
                iJ = zt0Var.J();
                break;
            default:
                zt0 zt0Var2 = (zt0) obj;
                i = zt0Var2.o;
                iJ = zt0Var2.H();
                break;
        }
        return i - iJ;
    }

    @Override // defpackage.px
    public final int h() {
        switch (this.d) {
            case 0:
                return ((zt0) this.b).J();
            default:
                return ((zt0) this.b).H();
        }
    }

    @Override // defpackage.px
    public final int i() {
        switch (this.d) {
            case 0:
                return ((zt0) this.b).l;
            default:
                return ((zt0) this.b).m;
        }
    }

    @Override // defpackage.px
    public final int j() {
        switch (this.d) {
            case 0:
                return ((zt0) this.b).m;
            default:
                return ((zt0) this.b).l;
        }
    }

    @Override // defpackage.px
    public final int k() {
        switch (this.d) {
            case 0:
                return ((zt0) this.b).I();
            default:
                return ((zt0) this.b).K();
        }
    }

    @Override // defpackage.px
    public final int l() {
        int I;
        int iJ;
        int i = this.d;
        Object obj = this.b;
        switch (i) {
            case 0:
                zt0 zt0Var = (zt0) obj;
                I = zt0Var.n - zt0Var.I();
                iJ = zt0Var.J();
                break;
            default:
                zt0 zt0Var2 = (zt0) obj;
                I = zt0Var2.o - zt0Var2.K();
                iJ = zt0Var2.H();
                break;
        }
        return I - iJ;
    }

    @Override // defpackage.px
    public final int m(View view) {
        int i = this.d;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                Rect rect = (Rect) obj;
                ((zt0) obj2).O(rect, view);
                return rect.right;
            default:
                Rect rect2 = (Rect) obj;
                ((zt0) obj2).O(rect2, view);
                return rect2.bottom;
        }
    }

    @Override // defpackage.px
    public final int n(View view) {
        int i = this.d;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                Rect rect = (Rect) obj;
                ((zt0) obj2).O(rect, view);
                return rect.left;
            default:
                Rect rect2 = (Rect) obj;
                ((zt0) obj2).O(rect2, view);
                return rect2.top;
        }
    }

    @Override // defpackage.px
    public final void o(int i) {
        switch (this.d) {
            case 0:
                ((zt0) this.b).S(i);
                break;
            default:
                ((zt0) this.b).T(i);
                break;
        }
    }
}
