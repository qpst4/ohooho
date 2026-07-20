package defpackage;

import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.SwitchPreference;
import com.quickcursor.android.preferences.DetailedListPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ly0 extends d3 {
    public SwitchPreference j0;
    public DetailedListPreference k0;
    public SwitchPreference l0;
    public SwitchPreference m0;
    public SwitchPreference n0;
    public PreferenceCategory o0;

    @Override // defpackage.d3, defpackage.gq0, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        this.j0 = (SwitchPreference) h0("saveFile");
        this.k0 = (DetailedListPreference) h0("executeAfter");
        this.l0 = (SwitchPreference) h0("afterCrop");
        this.m0 = (SwitchPreference) h0("afterSave");
        this.n0 = (SwitchPreference) h0("afterDelete");
        this.o0 = (PreferenceCategory) h0("extraOptions");
        SwitchPreference switchPreference = this.j0;
        final int i = 0;
        switchPreference.f = new zp0(this) { // from class: ky0
            public final /* synthetic */ ly0 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i2 = i;
                ly0 ly0Var = this.c;
                switch (i2) {
                    case 0:
                        ly0Var.m0(((Boolean) obj).booleanValue());
                        break;
                    default:
                        ly0Var.l0(hy0.valueOf((String) obj));
                        break;
                }
                return true;
            }
        };
        final int i2 = 1;
        this.k0.f = new zp0(this) { // from class: ky0
            public final /* synthetic */ ly0 c;

            {
                this.c = this;
            }

            @Override // defpackage.zp0
            public final boolean a(Preference preference, Object obj) {
                int i22 = i2;
                ly0 ly0Var = this.c;
                switch (i22) {
                    case 0:
                        ly0Var.m0(((Boolean) obj).booleanValue());
                        break;
                    default:
                        ly0Var.l0(hy0.valueOf((String) obj));
                        break;
                }
                return true;
            }
        };
        m0(switchPreference.O);
        l0(hy0.valueOf(this.k0.W));
    }

    public final void l0(hy0 hy0Var) {
        this.o0.F(hy0Var == hy0.extraOptions || hy0Var == hy0.crop);
        SwitchPreference switchPreference = this.l0;
        hy0 hy0Var2 = hy0.crop;
        switchPreference.B(hy0Var != hy0Var2);
        SwitchPreference switchPreference2 = this.l0;
        if (switchPreference2.O || hy0Var != hy0Var2) {
            return;
        }
        switchPreference2.J(true);
    }

    public final void m0(boolean z) {
        this.m0.B(!z);
        this.n0.B(z);
        if (z) {
            SwitchPreference switchPreference = this.m0;
            if (switchPreference.O) {
                switchPreference.J(false);
            }
        }
        if (z) {
            return;
        }
        SwitchPreference switchPreference2 = this.n0;
        if (switchPreference2.O) {
            switchPreference2.J(false);
        }
    }
}
