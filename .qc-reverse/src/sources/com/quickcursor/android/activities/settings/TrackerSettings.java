package com.quickcursor.android.activities.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.quickcursor.R;
import com.quickcursor.android.drawables.globals.trackers.TrackerDrawable;
import com.quickcursor.android.preferences.CustomSwitchPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import defpackage.b61;
import defpackage.bk;
import defpackage.d30;
import defpackage.dn;
import defpackage.f4;
import defpackage.f81;
import defpackage.fp1;
import defpackage.ir;
import defpackage.lc1;
import defpackage.ld;
import defpackage.lk0;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.qq0;
import defpackage.s4;
import defpackage.wj;
import defpackage.y30;
import defpackage.zp0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class TrackerSettings extends wj {
    public static final /* synthetic */ int D = 0;
    public ImageView C;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir implements zp0 {
        public TrackerSettings i0;
        public final bk h0 = new bk(200);
        public final d30 j0 = (d30) Y(new f81(this, 0), new f4(2));

        @Override // defpackage.gq0, defpackage.j30
        public final void T() {
            super.T();
            l0(pn0.t().z());
        }

        @Override // defpackage.zp0
        public final boolean a(Preference preference, Object obj) {
            TrackerSettings trackerSettings = this.i0;
            Objects.requireNonNull(trackerSettings);
            b61.b(new lk0(17, trackerSettings), 0L);
            this.h0.a(new s4(15));
            return true;
        }

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_tracker_settings);
            this.i0 = (TrackerSettings) t();
            oq0 oq0Var = oq0.D;
            SeekBarDialogPreference seekBarDialogPreference = (SeekBarDialogPreference) h0(oq0Var.name());
            ((CustomSwitchPreference) h0("hideTimeoutEnabled")).X = new lk0(16, this);
            h0(oq0.B.name()).f = new f81(this, 1);
            oq0 oq0Var2 = oq0.N;
            String strName = oq0Var2.name();
            oq0 oq0Var3 = oq0.H;
            String strName2 = oq0Var3.name();
            oq0 oq0Var4 = oq0.G;
            String strName3 = oq0Var4.name();
            oq0 oq0Var5 = oq0.K;
            fp1.o(this, Arrays.asList("trackerDesign", "trackerSize", strName, strName2, strName3, oq0Var5.name()));
            seekBarDialogPreference.c0 = dn.C0;
            seekBarDialogPreference.L((int) oq0.b((SharedPreferences) pn0.t().d, oq0Var));
            Iterator it = Arrays.asList(oq0Var, oq0.E, oq0.F, oq0Var2, oq0.O, oq0.P, oq0.Q, oq0.L0, oq0Var4, oq0.I, oq0Var3, oq0.J, oq0Var5).iterator();
            while (it.hasNext()) {
                h0(((oq0) it.next()).name()).f = this;
            }
            h0("trackerDesignCustomImagePicker").g = new f81(this, 2);
            h0("tracker_reset_visual").g = new f81(this, 3);
            h0("tracker_reset_behaviour").g = new f81(this, 4);
        }

        public final void l0(int i) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) this.Z.g.J("tracker_settings_visual");
            for (int i2 = 0; i2 < preferenceCategory.P.size(); i2++) {
                Preference preferenceK = preferenceCategory.K(i2);
                String string = preferenceK.d().getString("include", null);
                String string2 = preferenceK.d().getString("exclude", null);
                boolean z = true;
                boolean z2 = string == null || string.contains(qq0.k(i));
                boolean z3 = string2 != null && string2.contains(qq0.k(i));
                if (!z2 || z3) {
                    z = false;
                }
                preferenceK.F(z);
            }
            TrackerSettings trackerSettings = this.i0;
            TrackerDrawable trackerDrawableN = TrackerDrawable.n(i);
            int i3 = TrackerSettings.D;
            trackerSettings.C.setImageDrawable(trackerDrawableN);
            trackerSettings.G();
            this.h0.a(new s4(15));
        }
    }

    public final void G() {
        int paddingBottom = this.C.getPaddingBottom() * 2;
        int iB = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.D);
        TrackerDrawable trackerDrawable = (TrackerDrawable) this.C.getDrawable();
        trackerDrawable.o();
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        int i = paddingBottom + iB;
        layoutParams.width = i;
        layoutParams.height = i;
        this.C.setLayoutParams(layoutParams);
        int i2 = iB / 2;
        trackerDrawable.h = i2;
        TrackerDrawable.f(trackerDrawable.b);
        trackerDrawable.i = i2;
        trackerDrawable.j = i2;
        trackerDrawable.setAlphaAnimation(1.0f);
        trackerDrawable.h = i2;
    }

    @Override // defpackage.wj, defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lc1.h0(this);
        setContentView(R.layout.tracker_settings_activity);
        if (bundle == null) {
            y30 y30VarW = w();
            y30VarW.getClass();
            ld ldVar = new ld(y30VarW);
            ldVar.i(R.id.settings, new a());
            ldVar.e(false);
        }
        Optional.ofNullable(v()).ifPresent(new defpackage.a(17));
        this.C = (ImageView) findViewById(R.id.imageViewTrackerPreview);
        this.C.setImageDrawable(TrackerDrawable.n(pn0.t().z()));
        G();
    }
}
