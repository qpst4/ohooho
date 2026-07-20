package defpackage;

import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class no0 extends g1 {
    public static final l3 k = new l3(no0.class, R.string.action_category_settings, R.string.action_value_open_volume_control, R.string.action_title_open_volume_control, R.string.action_detail_open_volume_control, R.drawable.icon_action_open_volume_control, 511, 256, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        Intent intent = new Intent("android.settings.panel.action.VOLUME");
        intent.setFlags(268435456);
        App.c.startActivity(intent);
    }
}
