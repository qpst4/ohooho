package com.quickcursor.android.activities.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.quickcursor.android.activities.settings.TapBehaviourSettings;
import com.quickcursor.android.preferences.ActionPickerPreference;
import defpackage.e4;
import defpackage.i;
import defpackage.i70;
import defpackage.j71;
import defpackage.m3;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.qs;
import defpackage.s4;
import defpackage.y30;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements m3 {
    public final ActionPickerPreference b;
    public final /* synthetic */ TapBehaviourSettings.a c;

    public c(TapBehaviourSettings.a aVar, ActionPickerPreference actionPickerPreference) {
        this.c = aVar;
        this.b = actionPickerPreference;
    }

    @Override // defpackage.m3
    public final y30 l() {
        return this.c.l();
    }

    @Override // defpackage.m3
    public final void n(Intent intent, e4 e4Var) {
        TapBehaviourSettings.a aVar = this.c;
        aVar.n0 = (qs) e4Var;
        aVar.o0.a(intent);
    }

    @Override // defpackage.m3
    public final Context o() {
        return this.c.o();
    }

    @Override // defpackage.m3
    public final void q(i iVar) {
        TapBehaviourSettings.a aVar = this.c;
        ActionPickerPreference actionPickerPreference = aVar.k0;
        ActionPickerPreference actionPickerPreference2 = this.b;
        if (actionPickerPreference2 == actionPickerPreference) {
            pn0.t().S(new j71(iVar));
            aVar.k0.K(pn0.t().w());
        } else if (actionPickerPreference2 == aVar.l0) {
            pn0 pn0VarT = pn0.t();
            ((SharedPreferences) pn0VarT.d).edit().putString(oq0.P0.name(), ((i70) pn0VarT.c).i(new j71(iVar))).apply();
            aVar.l0.K(pn0.t().s());
        } else if (actionPickerPreference2 == aVar.m0) {
            pn0 pn0VarT2 = pn0.t();
            ((SharedPreferences) pn0VarT2.d).edit().putString(oq0.R0.name(), ((i70) pn0VarT2.c).i(new j71(iVar))).apply();
            aVar.m0.K(pn0.t().y());
        }
        aVar.h0.a(new s4(15));
    }
}
