package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.quickcursor.R;
import defpackage.bm0;
import defpackage.c70;
import defpackage.i9;
import defpackage.qo;
import defpackage.uf1;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public HashMap i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void r(View view, View view2, boolean z, boolean z2) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.i = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z3 = (childAt.getLayoutParams() instanceof qo) && (((qo) childAt.getLayoutParams()).a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z3) {
                    HashMap map = this.i;
                    if (z) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = uf1.a;
                        childAt.setImportantForAccessibility(4);
                    } else if (map != null && map.containsKey(childAt)) {
                        int iIntValue = ((Integer) this.i.get(childAt)).intValue();
                        WeakHashMap weakHashMap2 = uf1.a;
                        childAt.setImportantForAccessibility(iIntValue);
                    }
                }
            }
            if (!z) {
                this.i = null;
            }
        }
        super.r(view, view2, z, z2);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final i9 y(Context context, boolean z) {
        int i = z ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        i9 i9Var = new i9(17);
        i9Var.c = bm0.b(context, i);
        i9Var.d = new c70(22);
        return i9Var;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
