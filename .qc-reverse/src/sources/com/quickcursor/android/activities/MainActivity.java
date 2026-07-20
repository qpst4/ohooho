package com.quickcursor.android.activities;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.InputDispatcherBug;
import com.quickcursor.android.activities.settings.MissingPermissions;
import com.quickcursor.android.services.CursorAccessibilityService;
import defpackage.af;
import defpackage.b61;
import defpackage.bj0;
import defpackage.cj0;
import defpackage.ir;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.sf;
import defpackage.wj;
import defpackage.xg;
import defpackage.y30;
import defpackage.zq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends wj {

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public SwitchPreference h0;
        public sf i0;
        public Preference j0;
        public Preference k0;

        @Override // defpackage.j30
        public final void L() {
            this.F = true;
            sf sfVar = this.i0;
            if (sfVar != null) {
                af afVar = sfVar.c;
                if (afVar != null) {
                    afVar.b();
                }
                this.i0 = null;
            }
        }

        @Override // defpackage.j30
        public final void R() {
            this.F = true;
            h0("permissions").F(true ^ MissingPermissions.H().isEmpty());
            int i = 0;
            b61.b(new cj0(this, i), 100L);
            b61.b(new cj0(this, i), 200L);
            b61.b(new cj0(this, i), 300L);
            n0();
            l0();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_main_activity);
            this.k0 = h0("proFeatures");
            this.j0 = h0("thanksPro");
            SwitchPreference switchPreference = (SwitchPreference) h0("toggleQuickCursor");
            this.h0 = switchPreference;
            switchPreference.g = new bj0(this, 0 == true ? 1 : 0);
            o0();
            h0("faq").g = new bj0(this, 1);
            h0("disableAccessibility").g = new bj0(this, 2);
            Preference preferenceH0 = h0("inputDispatcherBug");
            int i = InputDispatcherBug.C;
            preferenceH0.F(Build.VERSION.SDK_INT == 35 || oq0.a((SharedPreferences) pn0.t().d, oq0.c1) || oq0.a((SharedPreferences) pn0.t().d, oq0.d1) || oq0.a((SharedPreferences) pn0.t().d, oq0.e1));
            n0();
            m0(1);
            l0();
        }

        public final void l0() {
            sf sfVar = this.i0;
            if (sfVar != null) {
                af afVar = sfVar.c;
                if (afVar != null) {
                    afVar.b();
                }
                this.i0 = null;
            }
            sf sfVar2 = new sf(Z(), null);
            this.i0 = sfVar2;
            sfVar2.i(new xg((Runnable) new cj0(this, 1)));
        }

        public final void m0(int i) {
            Preference preference = this.j0;
            if (i == 1) {
                preference.D(R.drawable.icon_premium);
                Preference preference2 = this.j0;
                preference2.E(preference2.b.getString(R.string.main_screen_thanks_pro_summary_no_subscription));
            } else if (i == 2) {
                preference.D(R.drawable.icon_subscription);
                Preference preference3 = this.j0;
                preference3.E(preference3.b.getString(R.string.main_screen_thanks_pro_summary_subscription_active_renewing));
            } else {
                preference.D(R.drawable.icon_subscription_canceled);
                Preference preference4 = this.j0;
                preference4.E(preference4.b.getString(R.string.main_screen_thanks_pro_summary_subscription_active_no_renewing));
            }
        }

        public final void n0() {
            boolean zC = zq0.b.c();
            this.k0.B(!zC);
            this.k0.F(!zC);
            this.j0.B(zC);
            this.j0.F(zC);
        }

        public final void o0() {
            if (this.h0 == null) {
                return;
            }
            boolean zE = CursorAccessibilityService.e();
            SwitchPreference switchPreference = this.h0;
            if (zE) {
                switchPreference.D(R.drawable.icon_stop);
                SwitchPreference switchPreference2 = this.h0;
                String string = switchPreference2.b.getString(R.string.main_screen_stop_app);
                if (!TextUtils.equals(string, switchPreference2.i)) {
                    switchPreference2.i = string;
                    switchPreference2.k();
                }
                this.h0.E("");
                this.h0.J(true);
                return;
            }
            switchPreference.D(R.drawable.icon_start);
            SwitchPreference switchPreference3 = this.h0;
            String string2 = switchPreference3.b.getString(R.string.main_screen_start_app);
            if (!TextUtils.equals(string2, switchPreference3.i)) {
                switchPreference3.i = string2;
                switchPreference3.k();
            }
            this.h0.E("");
            this.h0.J(false);
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.main_activity);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
    }
}
