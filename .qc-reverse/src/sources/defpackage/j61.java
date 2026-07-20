package defpackage;

import android.content.ContentResolver;
import android.provider.Settings;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class j61 extends g1 {
    public static final l3 k = new l3(j61.class, R.string.action_category_settings, R.string.action_value_toggle_brightness, R.string.action_title_toggle_brightness, R.string.action_detail_toggle_brightness, R.drawable.icon_action_toggle_brightness, 511, 4, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        if (!Settings.System.canWrite(App.c)) {
            yb0.y(R.string.action_require_write_settings_permission, 0);
        } else {
            ContentResolver contentResolver = this.f.getContentResolver();
            Settings.System.putInt(contentResolver, "screen_brightness_mode", Settings.System.getInt(contentResolver, "screen_brightness_mode", 0) == 0 ? 1 : 0);
        }
    }
}
