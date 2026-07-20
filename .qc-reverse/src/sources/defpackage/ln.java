package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ln {
    public final ConstraintLayout a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final /* synthetic */ ConstraintLayout h;

    public ln(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.h = constraintLayout;
        this.a = constraintLayout2;
    }

    public static boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
        }
        return false;
    }

    public final void b(vn vnVar, se seVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int iMax2;
        boolean z;
        int baseline;
        int i;
        if (vnVar == null) {
            return;
        }
        gn gnVar = vnVar.K;
        gn gnVar2 = vnVar.I;
        if (vnVar.g0 == 8) {
            seVar.e = 0;
            seVar.f = 0;
            seVar.g = 0;
            return;
        }
        if (vnVar.T == null) {
            return;
        }
        yz0 yz0Var = ConstraintLayout.q;
        int i2 = seVar.a;
        int i3 = seVar.b;
        int i4 = seVar.c;
        int i5 = seVar.d;
        int i6 = this.b + this.c;
        int i7 = this.d;
        View view = vnVar.f0;
        int iR = l11.r(i2);
        if (iR == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else if (iR == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i7, -2);
        } else if (iR == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i7, -2);
            boolean z2 = vnVar.r == 1;
            int i8 = seVar.j;
            if (i8 == 1 || i8 == 2) {
                boolean z3 = view.getMeasuredHeight() == vnVar.k();
                if (seVar.j == 2 || !z2 || ((z2 && z3) || vnVar.A())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(vnVar.q(), 1073741824);
                }
            }
        } else if (iR != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i9 = this.f;
            int i10 = gnVar2 != null ? gnVar2.g : 0;
            if (gnVar != null) {
                i10 += gnVar.g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i9, i7 + i10, -1);
        }
        int iR2 = l11.r(i3);
        if (iR2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else if (iR2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i6, -2);
        } else if (iR2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i6, -2);
            boolean z4 = vnVar.s == 1;
            int i11 = seVar.j;
            if (i11 == 1 || i11 == 2) {
                boolean z5 = view.getMeasuredWidth() == vnVar.q();
                if (seVar.j == 2 || !z4 || ((z4 && z5) || vnVar.B())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(vnVar.k(), 1073741824);
                }
            }
        } else if (iR2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i12 = this.g;
            int i13 = gnVar2 != null ? vnVar.J.g : 0;
            if (gnVar != null) {
                i13 += vnVar.L.g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, i6 + i13, -1);
        }
        wn wnVar = (wn) vnVar.T;
        ConstraintLayout constraintLayout = this.h;
        if (wnVar != null && lc1.s(constraintLayout.j, 256) && view.getMeasuredWidth() == vnVar.q() && view.getMeasuredWidth() < wnVar.q() && view.getMeasuredHeight() == vnVar.k() && view.getMeasuredHeight() < wnVar.k() && view.getBaseline() == vnVar.a0 && !vnVar.z() && a(vnVar.G, iMakeMeasureSpec, vnVar.q()) && a(vnVar.H, iMakeMeasureSpec2, vnVar.k())) {
            seVar.e = vnVar.q();
            seVar.f = vnVar.k();
            seVar.g = vnVar.a0;
            return;
        }
        boolean z6 = i2 == 3;
        boolean z7 = i3 == 3;
        boolean z8 = i3 == 4 || i3 == 1;
        boolean z9 = i2 == 4 || i2 == 1;
        boolean z10 = z6 && vnVar.W > 0.0f;
        boolean z11 = z7 && vnVar.W > 0.0f;
        if (view == null) {
            return;
        }
        kn knVar = (kn) view.getLayoutParams();
        int i14 = seVar.j;
        if (i14 != 1 && i14 != 2 && z6 && vnVar.r == 0 && z7 && vnVar.s == 0) {
            i = -1;
            z = false;
            baseline = 0;
            iMax2 = 0;
            iMax = 0;
        } else {
            if ((view instanceof eh1) && (vnVar instanceof h20)) {
                ((eh1) view).j((h20) vnVar, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            vnVar.G = iMakeMeasureSpec;
            vnVar.H = iMakeMeasureSpec2;
            vnVar.g = false;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i15 = vnVar.u;
            iMax = i15 > 0 ? Math.max(i15, measuredWidth) : measuredWidth;
            int i16 = vnVar.v;
            if (i16 > 0) {
                iMax = Math.min(i16, iMax);
            }
            int i17 = vnVar.x;
            iMax2 = i17 > 0 ? Math.max(i17, measuredHeight) : measuredHeight;
            int i18 = iMakeMeasureSpec2;
            int i19 = vnVar.y;
            if (i19 > 0) {
                iMax2 = Math.min(i19, iMax2);
            }
            if (!lc1.s(constraintLayout.j, 1)) {
                if (z10 && z8) {
                    iMax = (int) ((iMax2 * vnVar.W) + 0.5f);
                } else if (z11 && z9) {
                    iMax2 = (int) ((iMax / vnVar.W) + 0.5f);
                }
            }
            if (measuredWidth == iMax && measuredHeight == iMax2) {
                baseline = baseline2;
                i = -1;
                z = false;
            } else {
                if (measuredWidth != iMax) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax2 ? View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824) : i18;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                vnVar.G = iMakeMeasureSpec;
                vnVar.H = iMakeMeasureSpec3;
                z = false;
                vnVar.g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredWidth2;
                iMax2 = measuredHeight2;
                i = -1;
            }
        }
        boolean z12 = baseline != i ? true : z;
        seVar.i = (iMax == seVar.c && iMax2 == seVar.d) ? z : true;
        boolean z13 = knVar.c0 ? true : z12;
        if (z13 && baseline != -1 && vnVar.a0 != baseline) {
            seVar.i = true;
        }
        seVar.e = iMax;
        seVar.f = iMax2;
        seVar.h = z13;
        seVar.g = baseline;
    }
}
