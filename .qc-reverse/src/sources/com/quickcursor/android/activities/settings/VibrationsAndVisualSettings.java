package com.quickcursor.android.activities.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.activities.settings.VibrationsAndVisualSettings;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import defpackage.aq0;
import defpackage.bk;
import defpackage.ey0;
import defpackage.fp1;
import defpackage.ir;
import defpackage.lc1;
import defpackage.ld;
import defpackage.lk0;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.s4;
import defpackage.wj;
import defpackage.y30;
import defpackage.zp0;
import java.util.Arrays;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class VibrationsAndVisualSettings extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir implements zp0 {
        public final bk h0 = new bk(200);

        @Override // defpackage.zp0
        public final boolean a(Preference preference, Object obj) {
            String str = preference.m;
            boolean zEquals = str.equals(oq0.R.name());
            bk bkVar = this.h0;
            if (zEquals) {
                bkVar.a(new s4(5));
            }
            if (str.equals(oq0.S.name())) {
                bkVar.a(new s4(27, this));
            }
            if (str.equals(oq0.T.name())) {
                bkVar.a(new s4(28, this));
            }
            if (str.equals(oq0.W.name()) || str.equals(oq0.Z.name())) {
                bkVar.a(new lk0(this, obj));
            }
            if (!str.equals(oq0.G0.name())) {
                return true;
            }
            bkVar.a(new s4(15));
            return true;
        }

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_vibrations_and_visual_settings);
            oq0 oq0Var = oq0.T;
            SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) h0(oq0Var.name());
            seekBarDialogPreference.getClass();
            seekBarDialogPreference.c0 = ey0.c();
            seekBarDialogPreference.L((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var));
            h0(oq0.R.name()).f = this;
            h0(oq0.S.name()).f = this;
            seekBarDialogPreference.f = this;
            h0(oq0.V.name()).f = this;
            h0(oq0.W.name()).f = this;
            h0(oq0.Y.name()).f = this;
            h0(oq0.Z.name()).f = this;
            h0(oq0.G0.name()).f = this;
            fp1.o(this, Arrays.asList("vibrationDuration", "rippleSize", "vibrationOnTriggerStart"));
            final int i = 0;
            h0("vibrations_and_visual_reset_default").g = new aq0(this) { // from class: df1
                public final /* synthetic */ VibrationsAndVisualSettings.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i2 = i;
                    VibrationsAndVisualSettings.a aVar = this.c;
                    switch (i2) {
                        case 0:
                            jl1 jl1Var = new jl1(aVar.o());
                            jl1Var.m(R.string.are_you_sure);
                            jl1Var.g(R.string.confirmation_reset_vibrations_and_visuals_settings);
                            ((x6) jl1Var.c).c = R.drawable.icon_warning;
                            jl1Var.k(android.R.string.yes, new z2(21, aVar));
                            jl1Var.h(android.R.string.no, null);
                            jl1Var.n();
                            break;
                        default:
                            Intent intent = new Intent(aVar.Z(), (Class<?>) EdgeActionsSettings.class);
                            intent.putExtra("feedbackHighlight", true);
                            aVar.f0(intent);
                            break;
                    }
                    return true;
                }
            };
            final int i2 = 1;
            h0("edge_action_feedback").g = new aq0(this) { // from class: df1
                public final /* synthetic */ VibrationsAndVisualSettings.a c;

                {
                    this.c = this;
                }

                @Override // defpackage.aq0
                public final boolean c(Preference preference) {
                    int i22 = i2;
                    VibrationsAndVisualSettings.a aVar = this.c;
                    switch (i22) {
                        case 0:
                            jl1 jl1Var = new jl1(aVar.o());
                            jl1Var.m(R.string.are_you_sure);
                            jl1Var.g(R.string.confirmation_reset_vibrations_and_visuals_settings);
                            ((x6) jl1Var.c).c = R.drawable.icon_warning;
                            jl1Var.k(android.R.string.yes, new z2(21, aVar));
                            jl1Var.h(android.R.string.no, null);
                            jl1Var.n();
                            break;
                        default:
                            Intent intent = new Intent(aVar.Z(), (Class<?>) EdgeActionsSettings.class);
                            intent.putExtra("feedbackHighlight", true);
                            aVar.f0(intent);
                            break;
                    }
                    return true;
                }
            };
        }
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.preferences_activity_with_pro_overlay);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(25));
    }
}
