package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.m00;
import defpackage.n00;
import defpackage.no;
import defpackage.uf1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends no {
    public int a = 0;

    public ExpandableBehavior() {
    }

    @Override // defpackage.no
    public abstract boolean b(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.no
    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object obj = (n00) view2;
        boolean z = ((FloatingActionButton) obj).p.a;
        int i = this.a;
        if (z) {
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (i != 1) {
            return false;
        }
        boolean z2 = ((FloatingActionButton) obj).p.a;
        this.a = z2 ? 1 : 2;
        r((View) obj, view, z2, true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.no
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        n00 n00Var;
        WeakHashMap weakHashMap = uf1.a;
        if (!view.isLaidOut()) {
            ArrayList arrayListJ = coordinatorLayout.j(view);
            int size = arrayListJ.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    n00Var = null;
                    break;
                }
                View view2 = (View) arrayListJ.get(i2);
                if (b(view, view2)) {
                    n00Var = (n00) view2;
                    break;
                }
                i2++;
            }
            if (n00Var != null) {
                boolean z = ((FloatingActionButton) n00Var).p.a;
                int i3 = this.a;
                if (!z ? i3 == 1 : !(i3 != 0 && i3 != 2)) {
                    int i4 = z ? 1 : 2;
                    this.a = i4;
                    view.getViewTreeObserver().addOnPreDrawListener(new m00(this, view, i4, n00Var));
                }
            }
        }
        return false;
    }

    public abstract void r(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
