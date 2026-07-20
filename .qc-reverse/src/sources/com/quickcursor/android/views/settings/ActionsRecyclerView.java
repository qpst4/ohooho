package com.quickcursor.android.views.settings;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import defpackage.mu;
import defpackage.oc0;
import defpackage.pc0;
import defpackage.pu0;
import defpackage.q3;
import defpackage.rc0;
import defpackage.sc0;
import defpackage.sp1;
import defpackage.t3;
import defpackage.x3;
import defpackage.z3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionsRecyclerView extends RecyclerView {
    public ActionsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void i0(List list, z3 z3Var) {
        getContext();
        setLayoutManager(new LinearLayoutManager(1));
        g(new mu(getContext()));
        setItemAnimator(new q3(this));
        sc0 sc0Var = new sc0(new t3(this, list, z3Var));
        ActionsRecyclerView actionsRecyclerView = sc0Var.r;
        if (actionsRecyclerView != this) {
            oc0 oc0Var = sc0Var.z;
            if (actionsRecyclerView != null) {
                actionsRecyclerView.Y(sc0Var);
                ActionsRecyclerView actionsRecyclerView2 = sc0Var.r;
                actionsRecyclerView2.p.remove(oc0Var);
                if (actionsRecyclerView2.q == oc0Var) {
                    actionsRecyclerView2.q = null;
                }
                ArrayList arrayList = sc0Var.r.B;
                if (arrayList != null) {
                    arrayList.remove(sc0Var);
                }
                ArrayList arrayList2 = sc0Var.p;
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    pu0 pu0Var = ((pc0) arrayList2.get(0)).e;
                    sc0Var.m.getClass();
                    t3.a(pu0Var);
                }
                arrayList2.clear();
                sc0Var.w = null;
                VelocityTracker velocityTracker = sc0Var.t;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    sc0Var.t = null;
                }
                rc0 rc0Var = sc0Var.y;
                if (rc0Var != null) {
                    rc0Var.a = false;
                    sc0Var.y = null;
                }
                if (sc0Var.x != null) {
                    sc0Var.x = null;
                }
            }
            sc0Var.r = this;
            Resources resources = getResources();
            sc0Var.f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            sc0Var.g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            sc0Var.q = ViewConfiguration.get(sc0Var.r.getContext()).getScaledTouchSlop();
            sc0Var.r.g(sc0Var);
            sc0Var.r.p.add(oc0Var);
            ActionsRecyclerView actionsRecyclerView3 = sc0Var.r;
            if (actionsRecyclerView3.B == null) {
                actionsRecyclerView3.B = new ArrayList();
            }
            actionsRecyclerView3.B.add(sc0Var);
            sc0Var.y = new rc0(sc0Var);
            sc0Var.x = new sp1(sc0Var.r.getContext(), sc0Var.y);
        }
        setAdapter(new x3(list, z3Var, sc0Var));
    }
}
