package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 extends du0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.du0
    public void a(RecyclerView recyclerView, int i) {
        switch (this.a) {
            case 0:
                r2 r2Var = (r2) this.b;
                if (i == 2 && r2Var.z0 == 0) {
                    r2Var.B0 = true;
                } else if (i == 0) {
                    r2Var.B0 = false;
                }
                r2Var.z0 = i;
                break;
        }
    }

    @Override // defpackage.du0
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.a;
        Object obj = this.b;
        switch (i3) {
            case 0:
                r2 r2Var = (r2) obj;
                if (!r2Var.B0) {
                    LinearLayoutManager linearLayoutManager = r2Var.s0;
                    View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), true, false);
                    int i4 = -1;
                    int iL = viewQ0 == null ? -1 : zt0.L(viewQ0);
                    LinearLayoutManager linearLayoutManager2 = r2Var.s0;
                    View viewQ02 = linearLayoutManager2.Q0(linearLayoutManager2.v() - 1, -1, true, false);
                    int iL2 = viewQ02 == null ? -1 : zt0.L(viewQ02);
                    if (iL != r2Var.x0 || iL2 != r2Var.y0) {
                        int i5 = 0;
                        for (int i6 = 0; i6 < iL; i6++) {
                            if (((p2) r2Var.r0.d.get(i6)).b != i5) {
                                i4++;
                                i5 = ((p2) r2Var.r0.d.get(i6)).b;
                            }
                        }
                        if (r2Var.p0.getSelectedTabPosition() != i4) {
                            r2Var.A0 = true;
                            TabLayout tabLayout = r2Var.p0;
                            tabLayout.m(tabLayout.i(i4), true);
                            r2Var.A0 = false;
                        }
                        r2Var.x0 = iL;
                        r2Var.y0 = iL2;
                    }
                }
                break;
            default:
                k10 k10Var = (k10) obj;
                int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int i7 = k10Var.a;
                int iComputeVerticalScrollRange = k10Var.s.computeVerticalScrollRange();
                int i8 = k10Var.r;
                k10Var.t = iComputeVerticalScrollRange - i8 > 0 && i8 >= i7;
                int iComputeHorizontalScrollRange = k10Var.s.computeHorizontalScrollRange();
                int i9 = k10Var.q;
                boolean z = iComputeHorizontalScrollRange - i9 > 0 && i9 >= i7;
                k10Var.u = z;
                boolean z2 = k10Var.t;
                if (z2 || z) {
                    if (z2) {
                        float f = i8;
                        k10Var.l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
                        k10Var.k = Math.min(i8, (i8 * i8) / iComputeVerticalScrollRange);
                    }
                    if (k10Var.u) {
                        float f2 = iComputeHorizontalScrollOffset;
                        float f3 = i9;
                        k10Var.o = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
                        k10Var.n = Math.min(i9, (i9 * i9) / iComputeHorizontalScrollRange);
                    }
                    int i10 = k10Var.v;
                    if (i10 == 0 || i10 == 1) {
                        k10Var.j(1);
                    }
                } else if (k10Var.v != 0) {
                    k10Var.j(0);
                }
                break;
        }
    }
}
