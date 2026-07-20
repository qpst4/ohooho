package com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.design;

import android.os.Bundle;
import android.view.MenuItem;
import com.quickcursor.R;
import defpackage.a;
import defpackage.f91;
import defpackage.lc1;
import defpackage.ld;
import defpackage.p91;
import defpackage.wj;
import defpackage.xv0;
import defpackage.y30;
import defpackage.yb0;
import java.util.List;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TriggerActionsDesignActionIconActivity extends wj {
    public static final /* synthetic */ int D = 0;
    public f91 C;

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        f91 f91VarB;
        super.onCreate(null);
        if (bundle != null) {
            finish();
            return;
        }
        lc1.h0(this);
        setContentView(R.layout.preferences_activity_with_pro_overlay);
        int intExtra = getIntent().getIntExtra("triggerIndex", -1);
        if (intExtra == -1) {
            List listL = xv0.d.a().l().l();
            f91VarB = (f91) listL.get(listL.size() - 1);
        } else {
            f91VarB = xv0.d.a().d().b(intExtra);
        }
        this.C = f91VarB;
        if (f91VarB == null) {
            yb0.z("Something went wrong.", 1);
            finish();
        }
        Optional.ofNullable(v()).ifPresent(new a(19));
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new p91(this.C));
            ldVar.e(false);
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
