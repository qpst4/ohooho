package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tf0 extends lc1 {
    public final /* synthetic */ int n;
    public final SideSheetBehavior o;

    public /* synthetic */ tf0(SideSheetBehavior sideSheetBehavior, int i) {
        this.n = i;
        this.o = sideSheetBehavior;
    }

    @Override // defpackage.lc1
    public final int B() {
        int i = this.n;
        SideSheetBehavior sideSheetBehavior = this.o;
        switch (i) {
            case 0:
                return Math.max(0, sideSheetBehavior.n + sideSheetBehavior.o);
            default:
                return Math.max(0, (sideSheetBehavior.m - sideSheetBehavior.l) - sideSheetBehavior.o);
        }
    }

    @Override // defpackage.lc1
    public final int C() {
        int i = this.n;
        SideSheetBehavior sideSheetBehavior = this.o;
        switch (i) {
            case 0:
                return (-sideSheetBehavior.l) - sideSheetBehavior.o;
            default:
                return sideSheetBehavior.m;
        }
    }

    @Override // defpackage.lc1
    public final int E() {
        int i = this.n;
        SideSheetBehavior sideSheetBehavior = this.o;
        switch (i) {
            case 0:
                return sideSheetBehavior.o;
            default:
                return sideSheetBehavior.m;
        }
    }

    @Override // defpackage.lc1
    public final int F() {
        switch (this.n) {
            case 0:
                return -this.o.l;
            default:
                return B();
        }
    }

    @Override // defpackage.lc1
    public final int H(View view) {
        int i = this.n;
        SideSheetBehavior sideSheetBehavior = this.o;
        switch (i) {
            case 0:
                return view.getRight() + sideSheetBehavior.o;
            default:
                return view.getLeft() - sideSheetBehavior.o;
        }
    }

    @Override // defpackage.lc1
    public final int I(CoordinatorLayout coordinatorLayout) {
        switch (this.n) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // defpackage.lc1
    public final int J() {
        switch (this.n) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // defpackage.lc1
    public final boolean S(float f) {
        switch (this.n) {
            case 0:
                if (f > 0.0f) {
                }
                break;
            default:
                if (f < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // defpackage.lc1
    public final boolean T(View view) {
        switch (this.n) {
            case 0:
                if (view.getRight() < (B() - C()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (B() + this.o.m) / 2) {
                }
                break;
        }
        return true;
    }

    @Override // defpackage.lc1
    public final boolean U(float f, float f2) {
        switch (this.n) {
            case 0:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500.0f) {
                }
                break;
            default:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500.0f) {
                }
                break;
        }
        return false;
    }

    @Override // defpackage.lc1
    public final int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.n) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // defpackage.lc1
    public final float c(int i) {
        switch (this.n) {
            case 0:
                float fC = C();
                return (i - fC) / (B() - fC);
            default:
                float f = this.o.m;
                return (f - i) / (f - B());
        }
    }

    @Override // defpackage.lc1
    public final boolean k0(View view, float f) {
        int i = this.n;
        SideSheetBehavior sideSheetBehavior = this.o;
        switch (i) {
            case 0:
                if (Math.abs((f * sideSheetBehavior.k) + view.getLeft()) > 0.5f) {
                }
                break;
            default:
                if (Math.abs((f * sideSheetBehavior.k) + view.getRight()) > 0.5f) {
                }
                break;
        }
        return true;
    }

    @Override // defpackage.lc1
    public final void t0(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        int i3 = this.n;
        SideSheetBehavior sideSheetBehavior = this.o;
        switch (i3) {
            case 0:
                if (i <= sideSheetBehavior.m) {
                    marginLayoutParams.leftMargin = i2;
                }
                break;
            default:
                int i4 = sideSheetBehavior.m;
                if (i <= i4) {
                    marginLayoutParams.rightMargin = i4 - i;
                }
                break;
        }
    }
}
