package defpackage;

import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class oo0 extends g1 {
    public static final l3 k = new l3(oo0.class, R.string.action_category_settings, R.string.action_value_open_wifi_panel, R.string.action_title_open_wifi_panel, R.string.action_detail_open_wifi_panel, R.drawable.icon_action_open_wifi_panel, 511, 256, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        Intent intent = new Intent("android.settings.panel.action.WIFI");
        intent.setFlags(268435456);
        App.c.startActivity(intent);
    }
}
