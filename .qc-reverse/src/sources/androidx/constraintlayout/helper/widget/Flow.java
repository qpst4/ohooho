package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import defpackage.eh1;
import defpackage.h20;
import defpackage.rs0;
import defpackage.se;
import defpackage.vn;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class Flow extends eh1 {
    public final h20 k;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new int[32];
        this.h = new HashMap();
        this.d = context;
        super.g(attributeSet);
        h20 h20Var = new h20();
        h20Var.s0 = 0;
        h20Var.t0 = 0;
        h20Var.u0 = 0;
        h20Var.v0 = 0;
        h20Var.w0 = 0;
        h20Var.x0 = 0;
        h20Var.y0 = false;
        h20Var.z0 = 0;
        h20Var.A0 = 0;
        h20Var.B0 = new se();
        h20Var.C0 = null;
        h20Var.D0 = -1;
        h20Var.E0 = -1;
        h20Var.F0 = -1;
        h20Var.G0 = -1;
        h20Var.H0 = -1;
        h20Var.I0 = -1;
        h20Var.J0 = 0.5f;
        h20Var.K0 = 0.5f;
        h20Var.L0 = 0.5f;
        h20Var.M0 = 0.5f;
        h20Var.N0 = 0.5f;
        h20Var.O0 = 0.5f;
        h20Var.P0 = 0;
        h20Var.Q0 = 0;
        h20Var.R0 = 2;
        h20Var.S0 = 2;
        h20Var.T0 = 0;
        h20Var.U0 = -1;
        h20Var.V0 = 0;
        h20Var.W0 = new ArrayList();
        h20Var.X0 = null;
        h20Var.Y0 = null;
        h20Var.Z0 = null;
        h20Var.b1 = 0;
        this.k = h20Var;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, rs0.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.k.V0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    h20 h20Var2 = this.k;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    h20Var2.s0 = dimensionPixelSize;
                    h20Var2.t0 = dimensionPixelSize;
                    h20Var2.u0 = dimensionPixelSize;
                    h20Var2.v0 = dimensionPixelSize;
                } else if (index == 18) {
                    h20 h20Var3 = this.k;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    h20Var3.u0 = dimensionPixelSize2;
                    h20Var3.w0 = dimensionPixelSize2;
                    h20Var3.x0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.k.v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.k.w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.k.s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.k.x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.k.t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.k.T0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.k.D0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.k.E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.k.F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.k.H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.k.G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.k.I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.k.J0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.k.L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.k.N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.k.M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.k.O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.k.K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.k.R0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.k.S0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.k.P0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.k.Q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.k.U0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.e = this.k;
        i();
    }

    @Override // defpackage.in
    public final void h(vn vnVar, boolean z) {
        h20 h20Var = this.k;
        int i = h20Var.u0;
        if (i > 0 || h20Var.v0 > 0) {
            if (z) {
                h20Var.w0 = h20Var.v0;
                h20Var.x0 = i;
            } else {
                h20Var.w0 = i;
                h20Var.x0 = h20Var.v0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x074e  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0108 A[EDGE_INSN: B:426:0x0108->B:61:0x0108 BREAK  A[LOOP:1: B:55:0x00f1->B:60:0x0103], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0139  */
    @Override // defpackage.eh1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(defpackage.h20 r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 1892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(h20, int, int):void");
    }

    @Override // defpackage.in, android.view.View
    public final void onMeasure(int i, int i2) {
        j(this.k, i, i2);
    }

    public void setFirstHorizontalBias(float f) {
        this.k.L0 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.k.F0 = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.k.M0 = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.k.G0 = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.k.R0 = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.k.J0 = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.k.P0 = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.k.D0 = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.k.N0 = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.k.H0 = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.k.O0 = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.k.I0 = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.k.U0 = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.k.V0 = i;
        requestLayout();
    }

    public void setPadding(int i) {
        h20 h20Var = this.k;
        h20Var.s0 = i;
        h20Var.t0 = i;
        h20Var.u0 = i;
        h20Var.v0 = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.k.t0 = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.k.w0 = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.k.x0 = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.k.s0 = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.k.S0 = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.k.K0 = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.k.Q0 = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.k.E0 = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.k.T0 = i;
        requestLayout();
    }
}
