package defpackage;

import android.app.NotificationManager;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class k61 extends g1 {
    public static final l3 k = new l3(k61.class, R.string.action_category_settings, R.string.action_value_toggle_do_not_disturb, R.string.action_title_toggle_do_not_disturb, R.string.action_detail_toggle_do_not_disturb, R.drawable.icon_action_toggle_do_not_disturb, 511, 8, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        if (!((NotificationManager) App.c.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            yb0.y(R.string.action_require_do_not_disturb_permission, 0);
        } else {
            NotificationManager notificationManager = (NotificationManager) App.c.getSystemService("notification");
            notificationManager.setInterruptionFilter(notificationManager.getCurrentInterruptionFilter() == 1 ? 4 : 1);
        }
    }
}
