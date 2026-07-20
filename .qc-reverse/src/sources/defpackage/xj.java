package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xj extends y {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ xj(int i, Object obj) {
        this.d = i;
        this.e = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // defpackage.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            int r0 = r2.d
            java.lang.Object r1 = r2.e
            switch(r0) {
                case 0: goto L47;
                case 5: goto Lb;
                default: goto L7;
            }
        L7:
            super.c(r3, r4)
            return
        Lb:
            mg1 r1 = (defpackage.mg1) r1
            super.c(r3, r4)
            java.lang.Class<mg1> r2 = defpackage.mg1.class
            java.lang.String r2 = r2.getName()
            r4.setClassName(r2)
            xo0 r2 = r1.f
            if (r2 == 0) goto L25
            int r2 = r2.c()
            r3 = 1
            if (r2 <= r3) goto L25
            goto L26
        L25:
            r3 = 0
        L26:
            r4.setScrollable(r3)
            int r2 = r4.getEventType()
            r3 = 4096(0x1000, float:5.74E-42)
            if (r2 != r3) goto L46
            xo0 r2 = r1.f
            if (r2 == 0) goto L46
            int r2 = r2.c()
            r4.setItemCount(r2)
            int r2 = r1.g
            r4.setFromIndex(r2)
            int r2 = r1.g
            r4.setToIndex(r2)
        L46:
            return
        L47:
            super.c(r3, r4)
            com.google.android.material.internal.CheckableImageButton r1 = (com.google.android.material.internal.CheckableImageButton) r1
            boolean r2 = r1.e
            r4.setChecked(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xj.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // defpackage.y
    public final void d(View view, n0 n0Var) {
        int i = this.d;
        boolean z = false;
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        Object obj = this.e;
        switch (i) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = n0Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f);
                accessibilityNodeInfo.setChecked(checkableImageButton.e);
                break;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, n0Var.a);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i2 = MaterialButtonToggleGroup.l;
                if (view instanceof MaterialButton) {
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i3 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i3) == view) {
                                iB = i4;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i3) instanceof MaterialButton) && materialButtonToggleGroup.c(i3)) {
                                    i4++;
                                }
                                i3++;
                            }
                        }
                    }
                }
                n0Var.j(m0.a(((MaterialButton) view).p, 0, 1, iB, 1));
                break;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, n0Var.a);
                zj0 zj0Var = (zj0) obj;
                n0Var.k(zj0Var.j0.getVisibility() == 0 ? zj0Var.z(R.string.mtrl_picker_toggle_to_year_selection) : zj0Var.z(R.string.mtrl_picker_toggle_to_day_selection));
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo2 = n0Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).y);
                break;
            case 4:
                mq0 mq0Var = (mq0) obj;
                mq0Var.g.d(view, n0Var);
                RecyclerView recyclerView = mq0Var.f;
                recyclerView.getClass();
                pu0 pu0VarJ = RecyclerView.J(view);
                iB = pu0VarJ != null ? pu0VarJ.b() : -1;
                qt0 adapter = recyclerView.getAdapter();
                if (adapter instanceof jq0) {
                    ((jq0) adapter).j(iB);
                    break;
                }
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo3 = n0Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                n0Var.i(mg1.class.getName());
                mg1 mg1Var = (mg1) obj;
                xo0 xo0Var = mg1Var.f;
                if (xo0Var != null && xo0Var.c() > 1) {
                    z = true;
                }
                accessibilityNodeInfo3.setScrollable(z);
                if (mg1Var.canScrollHorizontally(1)) {
                    n0Var.a(4096);
                }
                if (mg1Var.canScrollHorizontally(-1)) {
                    n0Var.a(8192);
                }
                break;
        }
    }

    @Override // defpackage.y
    public boolean g(View view, int i, Bundle bundle) {
        int i2 = this.d;
        Object obj = this.e;
        switch (i2) {
            case 4:
                return ((mq0) obj).g.g(view, i, bundle);
            case 5:
                mg1 mg1Var = (mg1) obj;
                if (super.g(view, i, bundle)) {
                    return true;
                }
                if (i != 4096) {
                    if (i == 8192 && mg1Var.canScrollHorizontally(-1)) {
                        mg1Var.setCurrentItem(mg1Var.g - 1);
                        return true;
                    }
                } else if (mg1Var.canScrollHorizontally(1)) {
                    mg1Var.setCurrentItem(mg1Var.g + 1);
                    return true;
                }
                return false;
            default:
                return super.g(view, i, bundle);
        }
    }
}
