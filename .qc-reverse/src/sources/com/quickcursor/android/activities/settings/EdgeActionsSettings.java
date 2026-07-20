package com.quickcursor.android.activities.settings;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.quickcursor.R;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;
import com.quickcursor.android.views.settings.EdgeBarLinearLayout;
import defpackage.ax;
import defpackage.bk;
import defpackage.bx;
import defpackage.dx;
import defpackage.lc1;
import defpackage.ld;
import defpackage.lw;
import defpackage.nw;
import defpackage.rc;
import defpackage.rw;
import defpackage.s4;
import defpackage.uw;
import defpackage.wj;
import defpackage.x81;
import defpackage.xw;
import defpackage.y30;
import defpackage.yw;
import defpackage.zw;
import java.util.Iterator;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class EdgeActionsSettings extends wj {
    public static final /* synthetic */ int S = 0;
    public View D;
    public View E;
    public View F;
    public View G;
    public dx H;
    public dx I;
    public dx J;
    public dx K;
    public EdgeBarConstraintLayout L;
    public EdgeBarConstraintLayout M;
    public EdgeBarConstraintLayout N;
    public EdgeBarConstraintLayout O;
    public ax P;
    public final bk C = new bk(500);
    public final bk Q = new bk(2000);
    public Boolean R = Boolean.FALSE;

    public final void G(bx bxVar) {
        bxVar.b().s().j = Boolean.TRUE;
        y30 y30VarW = w();
        y30VarW.getClass();
        ld ldVar = new ld(y30VarW);
        ldVar.j(0, 0);
        ldVar.i(R.id.settings, bxVar.b());
        ldVar.e(false);
        Optional.ofNullable(v()).ifPresent(new yw(0, bxVar));
    }

    public final void H() {
        Iterator<E> it = this.P.iterator();
        while (it.hasNext()) {
            ((EdgeBarConstraintLayout) it.next()).o(Boolean.FALSE, null);
        }
        G(new uw(false));
    }

    public final void I() {
        this.C.a(new s4(15));
    }

    public final EdgeBarConstraintLayout J(dx dxVar) {
        return dxVar == this.H ? this.L : dxVar == this.J ? this.N : dxVar == this.K ? this.O : this.M;
    }

    public final void K() {
        if (this.L.isEnabled()) {
            this.L.animate().alpha(1.0f);
        }
        if (this.M.isEnabled()) {
            this.M.animate().alpha(1.0f);
        }
        if (this.O.isEnabled()) {
            this.O.animate().alpha(1.0f);
        }
        if (this.N.isEnabled()) {
            this.N.animate().alpha(1.0f);
        }
        this.E.animate().alpha(0.0f);
        this.D.animate().alpha(0.0f);
        this.G.animate().alpha(0.0f);
        this.F.animate().alpha(0.0f);
        this.R = Boolean.FALSE;
    }

    public final void L(dx dxVar) {
        xw.e.g();
        EdgeBarLinearLayout edgeBarLinearLayout = J(dxVar).E;
        edgeBarLinearLayout.getClass();
        x81.a(edgeBarLinearLayout, new rc());
        int iC = edgeBarLinearLayout.d.c();
        int childCount = edgeBarLinearLayout.getChildCount();
        dx dxVar2 = edgeBarLinearLayout.d;
        int i = 0;
        if (iC == childCount) {
            for (lw lwVar : dxVar2.d()) {
                int i2 = i + 1;
                nw nwVar = (nw) edgeBarLinearLayout.getChildAt(i);
                nwVar.g = lwVar;
                nwVar.a();
                i = i2;
            }
        } else {
            boolean z = dxVar2.c() > edgeBarLinearLayout.getChildCount();
            int iC2 = z ? edgeBarLinearLayout.d.c() : edgeBarLinearLayout.getChildCount();
            while (i < iC2) {
                nw nwVar2 = (nw) edgeBarLinearLayout.getChildAt(i);
                lw lwVarF = edgeBarLinearLayout.d.f(i);
                if (lwVarF != null || nwVar2 != null) {
                    if (nwVar2 == null) {
                        edgeBarLinearLayout.addView(new nw(edgeBarLinearLayout.getContext(), lwVarF, Boolean.valueOf(edgeBarLinearLayout.j)), i);
                    } else if (lwVarF == null) {
                        edgeBarLinearLayout.removeViewAt(i);
                    } else if (nwVar2.getEdgeAction() != lwVarF) {
                        if (z) {
                            edgeBarLinearLayout.addView(new nw(edgeBarLinearLayout.getContext(), lwVarF, Boolean.valueOf(edgeBarLinearLayout.j)), i);
                        } else {
                            edgeBarLinearLayout.removeViewAt(i);
                        }
                    }
                }
                i++;
            }
        }
        edgeBarLinearLayout.setWeightSum(edgeBarLinearLayout.d.e());
        I();
    }

    public final void M(EdgeBarConstraintLayout edgeBarConstraintLayout) {
        N(edgeBarConstraintLayout);
        G(new rw(edgeBarConstraintLayout.getLocation(), edgeBarConstraintLayout.getEdgeBar(), new zw(this, 0)));
    }

    public final void N(EdgeBarConstraintLayout edgeBarConstraintLayout) {
        for (EdgeBarConstraintLayout edgeBarConstraintLayout2 : this.P) {
            edgeBarConstraintLayout2.o(Boolean.valueOf(edgeBarConstraintLayout2 == edgeBarConstraintLayout), edgeBarConstraintLayout);
        }
        K();
    }

    @Override // defpackage.pm, android.app.Activity
    public final void onBackPressed() {
        Runnable runnableF;
        try {
            runnableF = ((bx) w().C(R.id.settings)).f();
        } catch (Exception unused) {
            runnableF = null;
        }
        if (runnableF != null) {
            runnableF.run();
        } else {
            super.onBackPressed();
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle = null;
        }
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.edge_actions_settings_activity);
        this.D = findViewById(R.id.thresholdPreviewTop);
        this.E = findViewById(R.id.thresholdPreviewLeft);
        this.F = findViewById(R.id.thresholdPreviewRight);
        this.G = findViewById(R.id.thresholdPreviewBottom);
        this.L = (EdgeBarConstraintLayout) findViewById(R.id.leftEdgeBarLayout);
        this.M = (EdgeBarConstraintLayout) findViewById(R.id.topEdgeBarLayout);
        this.N = (EdgeBarConstraintLayout) findViewById(R.id.rightEdgeBarLayout);
        this.O = (EdgeBarConstraintLayout) findViewById(R.id.bottomEdgeBarLayout);
        ax axVar = new ax();
        axVar.add(this.L);
        axVar.add(this.M);
        axVar.add(this.N);
        axVar.add(this.O);
        this.P = axVar;
        xw xwVar = xw.e;
        this.H = xwVar.d("leftEdgeBar");
        this.I = xwVar.d("topEdgeBar");
        this.J = xwVar.d("rightEdgeBar");
        this.K = xwVar.d("bottomEdgeBar");
        this.L.n(this.H);
        this.M.n(this.I);
        this.N.n(this.J);
        this.O.n(this.K);
        Optional.ofNullable(v()).ifPresent(new defpackage.a(8));
        if (bundle == null) {
            Bundle extras = getIntent().getExtras();
            G(new uw(extras != null ? extras.getBoolean("feedbackHighlight", false) : false));
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
