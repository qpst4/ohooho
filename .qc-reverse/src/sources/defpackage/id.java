package defpackage;

import android.content.Context;
import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class id extends g1 {
    public static final l3 k = new l3(id.class, R.string.action_category_advanced, R.string.action_value_automate_shortcut, R.string.action_title_automate_shortcut, R.string.action_detail_automate_shortcut, R.drawable.icon_action_automate_shortcut, 255, 0, Boolean.FALSE, new s1(1), null);

    @Override // defpackage.g1
    public final void g() {
        Context context = App.c;
        try {
            Intent uri = Intent.parseUri((String) this.g.get("intent"), 0);
            uri.addFlags(268435456);
            context.startActivity(uri);
        } catch (Exception e) {
            si0.b("AutomateShortcutAction onDispatch error: " + e.getMessage());
            yb0.B(f01.P(R.string.app_shortcut_action_couldnt_trigger, "app", "Automate"));
        }
    }
}
