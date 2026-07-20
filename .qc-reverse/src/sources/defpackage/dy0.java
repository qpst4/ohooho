package defpackage;

import android.os.Bundle;
import androidx.preference.SwitchPreference;
import com.quickcursor.android.preferences.DetailedListPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dy0 extends d3 {
    public DetailedListPreference j0;
    public SwitchPreference k0;

    @Override // defpackage.d3, defpackage.gq0, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        this.j0 = (DetailedListPreference) h0("rotationMode");
        this.k0 = (SwitchPreference) h0("rotation-1");
        DetailedListPreference detailedListPreference = this.j0;
        detailedListPreference.f = new r1(16, this);
        this.k0.F(by0.valueOf(detailedListPreference.W) == by0.force);
        SwitchPreference switchPreference = this.k0;
        if (switchPreference.x) {
            return;
        }
        switchPreference.J(false);
    }
}
