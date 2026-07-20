package com.quickcursor.android.activities.settings;

import android.os.Bundle;
import com.quickcursor.R;
import defpackage.bk;
import defpackage.ir;
import defpackage.lc1;
import defpackage.ld;
import defpackage.oq0;
import defpackage.ra;
import defpackage.s1;
import defpackage.ur;
import defpackage.wj;
import defpackage.y30;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class DebugSettings extends wj {
    public static final /* synthetic */ int C = 0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class a extends ir {
        public final bk h0 = new bk(100);
        public final bk i0 = new bk(250);
        public ra j0;

        @Override // defpackage.gq0
        public final void i0(String str, Bundle bundle) {
            k0(str, R.xml.preferences_debug_settings);
            this.j0 = ra.n(Z());
            int i = 0;
            h0(oq0.e.name()).f = new ur(this, i);
            h0(oq0.f.name()).f = new ur(this, i);
            h0(oq0.X0.name()).f = new s1(this, 24);
            int i2 = 1;
            h0(oq0.Y0.name()).f = new ur(this, i2);
            h0(oq0.R.name()).f = new ur(this, i2);
            h0("viewLogs").g = new ur(this, 2);
            h0("clearLogs").g = new ur(this, 3);
            h0("reset").g = new ur(this, 4);
            o();
        }
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
        Optional.ofNullable(v()).ifPresent(new defpackage.a(7));
    }
}
