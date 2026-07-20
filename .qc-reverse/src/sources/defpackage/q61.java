package defpackage;

import android.net.wifi.WifiManager;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class q61 extends g1 {
    public static final l3 k = new l3(q61.class, R.string.action_category_settings, R.string.action_value_toggle_wifi, R.string.action_title_toggle_wifi, R.string.action_detail_toggle_wifi, R.drawable.icon_action_toggle_wifi, 511, 128, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        ((WifiManager) App.c.getSystemService("wifi")).setWifiEnabled(!r1.isWifiEnabled());
    }
}
