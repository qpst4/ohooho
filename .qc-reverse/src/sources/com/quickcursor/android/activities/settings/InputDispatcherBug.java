package com.quickcursor.android.activities.settings;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import defpackage.bk;
import defpackage.ir;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.ub0;
import defpackage.wj;
import defpackage.y30;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class InputDispatcherBug extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public final bk h0 = new bk(100);

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_input_dispatcher_bug);
            SwitchPreference switchPreference = (SwitchPreference) h0("inputDispatcherBugOnDetected");
            int i = 1;
            int i2 = 0;
            if (oq0.a((SharedPreferences) pn0.t().d, oq0.c1) != InputDispatcherBug.G()) {
                switchPreference.s = false;
                switchPreference.J(InputDispatcherBug.G());
                switchPreference.s = true;
            }
            switchPreference.f = new ub0(this, i2);
            h0("email").g = new ub0(this, i);
            h0("github_issue").g = new ub0(this, 2);
            this.Z.g.K(2).g = new ub0(this, 3);
        }
    }

    public static boolean G() {
        SharedPreferences sharedPreferences = (SharedPreferences) pn0.e.d;
        oq0 oq0Var = oq0.c1;
        if (sharedPreferences.contains(oq0Var.name())) {
            return oq0.a((SharedPreferences) pn0.t().d, oq0Var);
        }
        if (Build.VERSION.SDK_INT != 35) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return str.equalsIgnoreCase("google") || str.equalsIgnoreCase("xiaomi");
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.preferences_activity);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(10));
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
