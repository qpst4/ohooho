package defpackage;

import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.actions.ToggleFlashlightActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class l61 extends g1 {
    public static final l3 k = new l3(l61.class, R.string.action_category_general, R.string.action_value_toggle_flashlight, R.string.action_title_toggle_flashlight, R.string.action_detail_toggle_flashlight, R.drawable.icon_action_toggle_flashlight, 511, 96, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        Intent intent = new Intent(App.c, (Class<?>) ToggleFlashlightActivity.class);
        intent.setFlags(268435456);
        App.c.startActivity(intent);
    }
}
