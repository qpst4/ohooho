package com.quickcursor.android.activities.settings.fragments.triggermode.tabs;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.quickcursor.R;
import com.quickcursor.android.views.ProOverlayView;
import com.quickcursor.android.views.VerticalTabLayout;
import defpackage.a;
import defpackage.b41;
import defpackage.f91;
import defpackage.j30;
import defpackage.lc1;
import defpackage.ld;
import defpackage.p4;
import defpackage.q4;
import defpackage.si0;
import defpackage.t4;
import defpackage.ua1;
import defpackage.w4;
import defpackage.wa1;
import defpackage.wj;
import defpackage.wq0;
import defpackage.xv0;
import defpackage.y30;
import defpackage.ze1;
import java.util.ArrayList;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AdvancedTriggerActivity extends wj implements wq0 {
    public static final /* synthetic */ int H = 0;
    public ProOverlayView C;
    public w4 D;
    public TabLayout E;
    public VerticalTabLayout F;
    public f91 G;

    public final void G(int i) {
        j30 wa1Var;
        if (i == 1) {
            f();
            wa1Var = new wa1(this.G);
        } else if (i != 2) {
            i();
            wa1Var = new t4(this.G);
        } else {
            i();
            wa1Var = new ua1(this.G);
        }
        y30 y30VarW = w();
        y30VarW.getClass();
        ld ldVar = new ld(y30VarW);
        ldVar.j(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
        ldVar.i(R.id.tabFragment, wa1Var);
        ldVar.e(false);
    }

    @Override // defpackage.wq0
    public final void f() {
        this.C.a();
    }

    @Override // defpackage.wq0
    public final void i() {
        ProOverlayView proOverlayView = this.C;
        View viewFindViewById = proOverlayView.findViewById(R.id.overlayPro);
        if (viewFindViewById != null) {
            proOverlayView.removeView(viewFindViewById);
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(null);
        if (bundle != null) {
            finish();
            return;
        }
        lc1.h0(this);
        setContentView(R.layout.advanced_trigger_activity_layout);
        ProOverlayView proOverlayView = (ProOverlayView) findViewById(R.id.proOverlayView);
        this.C = proOverlayView;
        View viewFindViewById = proOverlayView.findViewById(R.id.overlayPro);
        if (viewFindViewById != null) {
            proOverlayView.removeView(viewFindViewById);
        }
        this.D = xv0.d.a().d();
        int intExtra = getIntent().getIntExtra("triggerIndex", -1);
        if (intExtra == -1) {
            si0.b("Error on param: triggerIndex");
            finish();
        }
        this.G = this.D.b(intExtra);
        Optional.ofNullable(v()).ifPresent(new a(1));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.portraitTabLayout);
        this.E = tabLayout;
        if (tabLayout != null) {
            b41 b41VarJ = tabLayout.j();
            b41VarJ.a(R.string.trigger_tab_general_tab_title);
            b41 b41VarJ2 = this.E.j();
            b41VarJ2.a(R.string.trigger_tab_design_tab_title);
            b41 b41VarJ3 = this.E.j();
            b41VarJ3.a(R.string.trigger_tab_actions_tab_title);
            this.E.b(b41VarJ);
            this.E.b(b41VarJ2);
            this.E.b(b41VarJ3);
            this.E.a(new p4(0, this));
        }
        VerticalTabLayout verticalTabLayout = (VerticalTabLayout) findViewById(R.id.landscapeTabLayout);
        this.F = verticalTabLayout;
        if (verticalTabLayout != null) {
            ze1 ze1VarH = verticalTabLayout.h();
            ze1VarH.a(R.string.trigger_tab_general_tab_title);
            ze1 ze1VarH2 = this.F.h();
            ze1VarH2.a(R.string.trigger_tab_design_tab_title);
            ze1 ze1VarH3 = this.F.h();
            ze1VarH3.a(R.string.trigger_tab_actions_tab_title);
            this.F.a(ze1VarH);
            this.F.a(ze1VarH2);
            this.F.a(ze1VarH3);
            VerticalTabLayout verticalTabLayout2 = this.F;
            q4 q4Var = new q4(0, this);
            ArrayList arrayList = verticalTabLayout2.E;
            if (!arrayList.contains(q4Var)) {
                arrayList.add(q4Var);
            }
        }
        G(0);
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
