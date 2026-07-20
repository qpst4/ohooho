package com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.quickcursor.R;
import com.quickcursor.android.views.ProOverlayView;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import defpackage.a3;
import defpackage.bk;
import defpackage.f91;
import defpackage.lc1;
import defpackage.n3;
import defpackage.o01;
import defpackage.r2;
import defpackage.r60;
import defpackage.s4;
import defpackage.wj;
import defpackage.xr;
import defpackage.xv0;
import defpackage.yb0;
import defpackage.yw;
import defpackage.z3;
import defpackage.zq0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TriggerActionsListActivity extends wj implements z3 {
    public static final bk G = new bk(500);
    public f91 C;
    public List D;
    public View E;
    public ActionsRecyclerView F;

    public final void G(int i) {
        Intent intent = new Intent(this, (Class<?>) TriggerActionEditActivity.class);
        intent.putExtra("actionsList", getIntent().getStringExtra("actionsList"));
        intent.putExtra("triggerIndex", getIntent().getIntExtra("triggerIndex", -1));
        intent.putExtra("actionIndex", i);
        startActivity(intent);
    }

    public final void H() {
        if (this.D.size() >= 10 || !zq0.b.c()) {
            this.E.setOnClickListener(null);
            xr.I(this.E, false);
        } else {
            this.E.setOnClickListener(new a3(16, this));
            xr.I(this.E, true);
        }
    }

    @Override // defpackage.z3
    public final void e() {
        H();
        xv0.d.c();
        r60.i(this.C);
        G.a(new s4(15));
    }

    @Override // defpackage.z3
    public final void g(int i) {
        G(i);
    }

    @Override // defpackage.z3
    public final void h(int i) {
        r2.o0(w(), n3.b(128), new ArrayList(), Arrays.asList(n3.nothing, n3.grabCursor, n3.expandNotifications, n3.expandQuickSettings, n3.backButton, n3.homeButton, n3.recentsButton, n3.launchApp, n3.launchShortcut, n3.temporarilyDisable, n3.openQuickSettings), new o01(i, 3, this));
    }

    @Override // defpackage.z3
    public final void j(int i) {
        G(i);
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        f91 f91VarB;
        List listF = null;
        super.onCreate(null);
        if (bundle != null) {
            finish();
            return;
        }
        lc1.h0(this);
        ProOverlayView proOverlayView = new ProOverlayView(this);
        proOverlayView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        proOverlayView.setFitsSystemWindows(true);
        proOverlayView.addView((NestedScrollView) getLayoutInflater().inflate(R.layout.actions_recycler_list_fragment, (ViewGroup) proOverlayView, false));
        setContentView(proOverlayView);
        proOverlayView.a();
        int intExtra = getIntent().getIntExtra("triggerIndex", -1);
        if (intExtra == -1) {
            List listL = xv0.d.a().l().l();
            f91VarB = (f91) listL.get(listL.size() - 1);
        } else {
            f91VarB = xv0.d.a().d().b(intExtra);
        }
        this.C = f91VarB;
        String stringExtra = getIntent().getStringExtra("actionsList");
        if ("shortActions".equals(stringExtra)) {
            listF = this.C.b().k();
        } else if ("longActions".equals(stringExtra)) {
            listF = this.C.b().f();
        }
        this.D = listF;
        if (this.C == null || listF == null) {
            yb0.z("Something went wrong.", 1);
            finish();
        }
        String strK = lc1.K("shortActions".equals(getIntent().getStringExtra("actionsList")) ? R.string.activity_swipe_actions_edit_title_short_actions : R.string.activity_swipe_actions_edit_title_long_actions);
        ((TextView) findViewById(android.R.id.title)).setText(strK);
        Optional.ofNullable(v()).ifPresent(new yw(2, strK));
        ActionsRecyclerView actionsRecyclerView = (ActionsRecyclerView) findViewById(R.id.recycler_view);
        this.F = actionsRecyclerView;
        actionsRecyclerView.i0(this.D, this);
        this.E = findViewById(R.id.add_action);
        H();
        xr.I(this.E, zq0.b.c());
    }

    @Override // defpackage.wj, defpackage.z7, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        r60.o = null;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.F.getAdapter().d();
    }
}
