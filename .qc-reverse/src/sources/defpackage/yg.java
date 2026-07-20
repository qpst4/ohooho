package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yg extends lc1 {
    public final /* synthetic */ int n;
    public final /* synthetic */ no o;

    public /* synthetic */ yg(no noVar, int i) {
        this.n = i;
        this.o = noVar;
    }

    @Override // defpackage.lc1
    public int P(View view) {
        switch (this.n) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.o;
                return sideSheetBehavior.l + sideSheetBehavior.o;
            default:
                return super.P(view);
        }
    }

    @Override // defpackage.lc1
    public int Q() {
        switch (this.n) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.o;
                return bottomSheetBehavior.I ? bottomSheetBehavior.T : bottomSheetBehavior.G;
            default:
                return super.Q();
        }
    }

    @Override // defpackage.lc1
    public final void Y(int i) {
        int i2 = this.n;
        no noVar = this.o;
        switch (i2) {
            case 0:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) noVar;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.C(1);
                    }
                }
                break;
            default:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) noVar;
                    if (sideSheetBehavior.g) {
                        sideSheetBehavior.r(1);
                    }
                }
                break;
        }
    }

    @Override // defpackage.lc1
    public final void Z(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3 = this.n;
        no noVar = this.o;
        switch (i3) {
            case 0:
                ((BottomSheetBehavior) noVar).u(i2);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) noVar;
                WeakReference weakReference = sideSheetBehavior.q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.a.t0(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.a.c(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw l11.h(it);
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e6  */
    @Override // defpackage.lc1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(android.view.View r7, float r8, float r9) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yg.a0(android.view.View, float, float):void");
    }

    @Override // defpackage.lc1
    public final int g(View view, int i) {
        switch (this.n) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.o;
                return f01.o(i, sideSheetBehavior.a.F(), sideSheetBehavior.a.E());
        }
    }

    @Override // defpackage.lc1
    public final int h(View view, int i) {
        switch (this.n) {
            case 0:
                return f01.o(i, ((BottomSheetBehavior) this.o).x(), Q());
            default:
                return view.getTop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0046  */
    @Override // defpackage.lc1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s0(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.n
            r1 = 1
            no r4 = r4.o
            r2 = 0
            switch(r0) {
                case 0: goto L1d;
                default: goto L9;
            }
        L9:
            com.google.android.material.sidesheet.SideSheetBehavior r4 = (com.google.android.material.sidesheet.SideSheetBehavior) r4
            int r6 = r4.h
            if (r6 != r1) goto L10
            goto L1b
        L10:
            java.lang.ref.WeakReference r4 = r4.p
            if (r4 == 0) goto L1b
            java.lang.Object r4 = r4.get()
            if (r4 != r5) goto L1b
            goto L1c
        L1b:
            r1 = r2
        L1c:
            return r1
        L1d:
            com.google.android.material.bottomsheet.BottomSheetBehavior r4 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r4
            int r0 = r4.L
            if (r0 != r1) goto L24
            goto L54
        L24:
            boolean r3 = r4.a0
            if (r3 == 0) goto L29
            goto L54
        L29:
            r3 = 3
            if (r0 != r3) goto L46
            int r0 = r4.Y
            if (r0 != r6) goto L46
            java.lang.ref.WeakReference r6 = r4.V
            if (r6 == 0) goto L3b
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L3c
        L3b:
            r6 = 0
        L3c:
            if (r6 == 0) goto L46
            r0 = -1
            boolean r6 = r6.canScrollVertically(r0)
            if (r6 == 0) goto L46
            goto L54
        L46:
            java.lang.System.currentTimeMillis()
            java.lang.ref.WeakReference r4 = r4.U
            if (r4 == 0) goto L54
            java.lang.Object r4 = r4.get()
            if (r4 != r5) goto L54
            goto L55
        L54:
            r1 = r2
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yg.s0(android.view.View, int):boolean");
    }
}
