package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mg0 {
    public px a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public mg0() {
        c();
    }

    public final void a() {
        boolean z = this.d;
        px pxVar = this.a;
        this.c = z ? pxVar.g() : pxVar.k();
    }

    public final void b(View view, int i) {
        px pxVar = this.a;
        int iL = Integer.MIN_VALUE == pxVar.a ? 0 : pxVar.l() - pxVar.a;
        if (iL >= 0) {
            boolean z = this.d;
            px pxVar2 = this.a;
            if (z) {
                int iB = pxVar2.b(view);
                px pxVar3 = this.a;
                this.c = (Integer.MIN_VALUE != pxVar3.a ? pxVar3.l() - pxVar3.a : 0) + iB;
            } else {
                this.c = pxVar2.e(view);
            }
            this.b = i;
            return;
        }
        this.b = i;
        boolean z2 = this.d;
        px pxVar4 = this.a;
        if (!z2) {
            int iE = pxVar4.e(view);
            int iK = iE - this.a.k();
            this.c = iE;
            if (iK > 0) {
                int iG = (this.a.g() - Math.min(0, (this.a.g() - iL) - this.a.b(view))) - (this.a.c(view) + iE);
                if (iG < 0) {
                    this.c -= Math.min(iK, -iG);
                    return;
                }
                return;
            }
            return;
        }
        int iG2 = (pxVar4.g() - iL) - this.a.b(view);
        this.c = this.a.g() - iG2;
        if (iG2 > 0) {
            int iC = this.c - this.a.c(view);
            int iK2 = this.a.k();
            int iMin = iC - (Math.min(this.a.e(view) - iK2, 0) + iK2);
            if (iMin < 0) {
                this.c = Math.min(iG2, -iMin) + this.c;
            }
        }
    }

    public final void c() {
        this.b = -1;
        this.c = Integer.MIN_VALUE;
        this.d = false;
        this.e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
    }
}
