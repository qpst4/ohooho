package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.f01;
import defpackage.gg1;
import defpackage.qo;
import defpackage.uf1;
import defpackage.ys0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends gg1 {
    public final int b;

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        new Rect();
        new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.y);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void s(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
        }
    }

    @Override // defpackage.no
    public final boolean b(View view, View view2) {
        return false;
    }

    @Override // defpackage.no
    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (((qo) view2.getLayoutParams()).a instanceof AppBarLayout$BaseBehavior) {
            int bottom = view2.getBottom() - view.getTop();
            int i = this.b;
            int iO = bottom - (i == 0 ? 0 : f01.o((int) (0.0f * i), 0, i));
            WeakHashMap weakHashMap = uf1.a;
            view.offsetTopAndBottom(iO);
        }
        return false;
    }

    @Override // defpackage.no
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int i4 = view.getLayoutParams().height;
        if (i4 != -1 && i4 != -2) {
            return false;
        }
        s(coordinatorLayout.j(view));
        return false;
    }

    @Override // defpackage.no
    public final void l(CoordinatorLayout coordinatorLayout, View view) {
        s(coordinatorLayout.j(view));
    }

    @Override // defpackage.gg1
    public final void r(CoordinatorLayout coordinatorLayout, View view, int i) {
        s(coordinatorLayout.j(view));
        coordinatorLayout.q(view, i);
    }

    public AppBarLayout$ScrollingViewBehavior() {
        new Rect();
        new Rect();
    }
}
