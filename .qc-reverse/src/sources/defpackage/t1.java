package defpackage;

import android.os.Bundle;
import androidx.preference.SwitchPreference;
import com.quickcursor.R;
import com.quickcursor.android.preferences.DetailedListPreference;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class t1 extends d3 {
    public final /* synthetic */ int j0;
    public DetailedListPreference k0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t1(int i, Map map, int i2) {
        super(i, map);
        this.j0 = i2;
    }

    @Override // defpackage.d3, defpackage.gq0, defpackage.j30
    public void J(Bundle bundle) {
        int i = 1;
        switch (this.j0) {
            case 0:
                super.J(bundle);
                Map map = this.i0;
                if ((map == null || !map.containsKey("accessibilityStream")) && h0("accessibilityStream") != null) {
                    ((SwitchPreference) h0("accessibilityStream")).J(dn.i2.booleanValue());
                }
                this.k0 = (DetailedListPreference) h0("orientation");
                DetailedListPreference detailedListPreference = (DetailedListPreference) h0("mode");
                if (h0("granularity") != null) {
                    h0("granularity").F(fc0.s());
                }
                DetailedListPreference detailedListPreference2 = this.k0;
                detailedListPreference2.e0 = new c(i, this);
                int i2 = 0;
                detailedListPreference2.f = new r1(i2, this);
                detailedListPreference.f = new s1(this, i2);
                this.k0.O(ce.valueOf(detailedListPreference2.W) == ce.vertical ? Integer.valueOf(R.drawable.icon_settings) : null);
                be.valueOf(detailedListPreference.W);
                break;
            default:
                super.J(bundle);
                if (h0("granularity") != null) {
                    h0("granularity").F(fc0.s());
                }
                DetailedListPreference detailedListPreference3 = (DetailedListPreference) h0("orientation");
                this.k0 = detailedListPreference3;
                detailedListPreference3.e0 = new c(2, this);
                detailedListPreference3.f = new r1(i, this);
                this.k0.O(ce.valueOf(detailedListPreference3.W) == ce.vertical ? Integer.valueOf(R.drawable.icon_settings) : null);
                break;
        }
    }
}
