package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.h0;
import defpackage.no;
import defpackage.q31;
import defpackage.tb0;
import defpackage.uf1;
import defpackage.wf1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends no {
    public wf1 a;
    public boolean b;
    public boolean c;
    public int d = 2;
    public float e = 0.0f;
    public float f = 0.5f;
    public final q31 g = new q31(this);

    @Override // defpackage.no
    public boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zO = this.b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zO = coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.b = zO;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b = false;
        }
        if (zO) {
            if (this.a == null) {
                this.a = new wf1(coordinatorLayout.getContext(), coordinatorLayout, this.g);
            }
            if (!this.c && this.a.p(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.no
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = uf1.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            uf1.k(view, 1048576);
            uf1.h(view, 0);
            if (r(view)) {
                uf1.l(view, h0.j, new tb0(17, this));
            }
        }
        return false;
    }

    @Override // defpackage.no
    public final boolean q(View view, MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        if (this.c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.a.j(motionEvent);
        return true;
    }

    public boolean r(View view) {
        return true;
    }
}
