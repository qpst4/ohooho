package defpackage;

import android.content.ContentResolver;
import android.provider.Settings;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class h61 extends g1 {
    public static final l3 k = new l3(h61.class, R.string.action_category_settings, R.string.action_value_toggle_auto_rotate, R.string.action_title_toggle_auto_rotate, R.string.action_detail_toggle_auto_rotate, R.drawable.icon_action_toggle_auto_rotate, 511, 4, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        if (!Settings.System.canWrite(App.c)) {
            yb0.y(R.string.action_require_write_settings_permission, 0);
            return;
        }
        ContentResolver contentResolver = this.f.getContentResolver();
        int i = Settings.System.getInt(contentResolver, "accelerometer_rotation", 0);
        if (zx0.getCurrentRotation() != -1) {
            i = 0;
        }
        int i2 = i == 0 ? 1 : 0;
        if (i2 == 1 && zx0.d != null) {
            zx0.a(-1);
        }
        Settings.System.putInt(contentResolver, "accelerometer_rotation", i2);
    }
}
