package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ru0 extends y {
    public final RecyclerView d;
    public final qu0 e;

    public ru0(RecyclerView recyclerView) {
        this.d = recyclerView;
        y yVarJ = j();
        if (yVarJ == null || !(yVarJ instanceof qu0)) {
            this.e = new qu0(this);
        } else {
            this.e = (qu0) yVarJ;
        }
    }

    @Override // defpackage.y
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.d.M()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().X(accessibilityEvent);
        }
    }

    @Override // defpackage.y
    public final void d(View view, n0 n0Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = n0Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        RecyclerView recyclerView = this.d;
        if (recyclerView.M() || recyclerView.getLayoutManager() == null) {
            return;
        }
        zt0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.b;
        gu0 gu0Var = recyclerView2.c;
        mu0 mu0Var = recyclerView2.g0;
        if (recyclerView2.canScrollVertically(-1) || layoutManager.b.canScrollHorizontally(-1)) {
            n0Var.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (layoutManager.b.canScrollVertically(1) || layoutManager.b.canScrollHorizontally(1)) {
            n0Var.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(layoutManager.N(gu0Var, mu0Var), layoutManager.x(gu0Var, mu0Var), false, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[PHI: r3
  0x0056: PHI (r3v11 int) = (r3v7 int), (r3v15 int) binds: [B:27:0x0072, B:19:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.View r3, int r4, android.os.Bundle r5) {
        /*
            r2 = this;
            boolean r3 = super.g(r3, r4, r5)
            r5 = 1
            if (r3 == 0) goto L8
            return r5
        L8:
            androidx.recyclerview.widget.RecyclerView r2 = r2.d
            boolean r3 = r2.M()
            r0 = 0
            if (r3 != 0) goto L8b
            zt0 r3 = r2.getLayoutManager()
            if (r3 == 0) goto L8b
            zt0 r2 = r2.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView r3 = r2.b
            gu0 r1 = r3.c
            r1 = 4096(0x1000, float:5.74E-42)
            if (r4 == r1) goto L58
            r1 = 8192(0x2000, float:1.148E-41)
            if (r4 == r1) goto L2a
            r3 = r0
            r4 = r3
            goto L80
        L2a:
            r4 = -1
            boolean r3 = r3.canScrollVertically(r4)
            if (r3 == 0) goto L3f
            int r3 = r2.o
            int r1 = r2.K()
            int r3 = r3 - r1
            int r1 = r2.H()
            int r3 = r3 - r1
            int r3 = -r3
            goto L40
        L3f:
            r3 = r0
        L40:
            androidx.recyclerview.widget.RecyclerView r1 = r2.b
            boolean r4 = r1.canScrollHorizontally(r4)
            if (r4 == 0) goto L56
            int r4 = r2.n
            int r1 = r2.I()
            int r4 = r4 - r1
            int r1 = r2.J()
            int r4 = r4 - r1
            int r4 = -r4
            goto L80
        L56:
            r4 = r0
            goto L80
        L58:
            boolean r3 = r3.canScrollVertically(r5)
            if (r3 == 0) goto L6b
            int r3 = r2.o
            int r4 = r2.K()
            int r3 = r3 - r4
            int r4 = r2.H()
            int r3 = r3 - r4
            goto L6c
        L6b:
            r3 = r0
        L6c:
            androidx.recyclerview.widget.RecyclerView r4 = r2.b
            boolean r4 = r4.canScrollHorizontally(r5)
            if (r4 == 0) goto L56
            int r4 = r2.n
            int r1 = r2.I()
            int r4 = r4 - r1
            int r1 = r2.J()
            int r4 = r4 - r1
        L80:
            if (r3 != 0) goto L85
            if (r4 != 0) goto L85
            goto L8b
        L85:
            androidx.recyclerview.widget.RecyclerView r2 = r2.b
            r2.e0(r4, r3, r5)
            return r5
        L8b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ru0.g(android.view.View, int, android.os.Bundle):boolean");
    }

    public y j() {
        return this.e;
    }
}
