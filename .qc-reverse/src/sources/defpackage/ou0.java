package defpackage;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ou0 implements Runnable {
    public int b;
    public int c;
    public OverScroller d;
    public Interpolator e;
    public boolean f;
    public boolean g;
    public final /* synthetic */ RecyclerView h;

    public ou0(RecyclerView recyclerView) {
        this.h = recyclerView;
        qc0 qc0Var = RecyclerView.y0;
        this.e = qc0Var;
        this.f = false;
        this.g = false;
        this.d = new OverScroller(recyclerView.getContext(), qc0Var);
    }

    public final void a() {
        if (this.f) {
            this.g = true;
            return;
        }
        RecyclerView recyclerView = this.h;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = uf1.a;
        recyclerView.postOnAnimation(this);
    }

    public final void b(int i, int i2, int i3, Interpolator interpolator) {
        int iRound;
        RecyclerView recyclerView = this.h;
        if (i3 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt(0.0d);
            int iSqrt2 = (int) Math.sqrt((i2 * i2) + (i * i));
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i4 = width / 2;
            float f = width;
            float f2 = i4;
            float fSin = (((float) Math.sin((Math.min(1.0f, (iSqrt2 * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fSin / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            i3 = Math.min(iRound, 2000);
        }
        int i5 = i3;
        if (interpolator == null) {
            interpolator = RecyclerView.y0;
        }
        if (this.e != interpolator) {
            this.e = interpolator;
            this.d = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.c = 0;
        this.b = 0;
        recyclerView.setScrollState(2);
        this.d.startScroll(0, 0, i, i2, i5);
        a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        RecyclerView recyclerView = this.h;
        int[] iArr = recyclerView.s0;
        if (recyclerView.n == null) {
            recyclerView.removeCallbacks(this);
            this.d.abortAnimation();
            return;
        }
        this.g = false;
        this.f = true;
        recyclerView.m();
        OverScroller overScroller = this.d;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i5 = currX - this.b;
            int i6 = currY - this.c;
            this.b = currX;
            this.c = currY;
            int[] iArr2 = recyclerView.s0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.s(i5, i6, 1, iArr2, null)) {
                i = i5 - iArr[0];
                i2 = i6 - iArr[1];
            } else {
                i = i5;
                i2 = i6;
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.l(i, i2);
            }
            if (recyclerView.m != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                recyclerView.c0(i, i2, iArr);
                i3 = iArr[0];
                i4 = iArr[1];
                i -= i3;
                i2 -= i4;
                qg0 qg0Var = recyclerView.n.e;
                if (qg0Var != null && !qg0Var.d && qg0Var.e) {
                    int iB = recyclerView.g0.b();
                    if (iB == 0) {
                        qg0Var.j();
                    } else if (qg0Var.a >= iB) {
                        qg0Var.a = iB - 1;
                        qg0Var.h(i3, i4);
                    } else {
                        qg0Var.h(i3, i4);
                    }
                }
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (!recyclerView.o.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.s0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            recyclerView.t(i3, i4, i, i2, null, 1, iArr3);
            int i7 = i - iArr[0];
            int i8 = i2 - iArr[1];
            if (i3 != 0 || i4 != 0) {
                recyclerView.u(i3, i4);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i7 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i8 != 0));
            qg0 qg0Var2 = recyclerView.n.e;
            if ((qg0Var2 == null || !qg0Var2.d) && z) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i9 = i7 < 0 ? -currVelocity : i7 > 0 ? currVelocity : 0;
                    if (i8 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i8 <= 0) {
                        currVelocity = 0;
                    }
                    if (i9 < 0) {
                        recyclerView.w();
                        if (recyclerView.H.isFinished()) {
                            recyclerView.H.onAbsorb(-i9);
                        }
                    } else if (i9 > 0) {
                        recyclerView.x();
                        if (recyclerView.J.isFinished()) {
                            recyclerView.J.onAbsorb(i9);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.y();
                        if (recyclerView.I.isFinished()) {
                            recyclerView.I.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.v();
                        if (recyclerView.K.isFinished()) {
                            recyclerView.K.onAbsorb(currVelocity);
                        }
                    }
                    if (i9 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = uf1.a;
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                l50 l50Var = recyclerView.f0;
                int[] iArr4 = l50Var.c;
                if (iArr4 != null) {
                    Arrays.fill(iArr4, -1);
                }
                l50Var.d = 0;
            } else {
                a();
                n50 n50Var = recyclerView.e0;
                if (n50Var != null) {
                    n50Var.a(recyclerView, i3, i4);
                }
            }
        }
        qg0 qg0Var3 = recyclerView.n.e;
        if (qg0Var3 != null && qg0Var3.d) {
            qg0Var3.h(0, 0);
        }
        this.f = false;
        if (!this.g) {
            recyclerView.setScrollState(0);
            recyclerView.h0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = uf1.a;
            recyclerView.postOnAnimation(this);
        }
    }
}
