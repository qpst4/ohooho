package defpackage;

import android.content.SharedPreferences;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class p61 extends g1 {
    public static final l3 k = new l3(p61.class, R.string.action_category_quick_cursor, R.string.action_value_toggle_tracker_actions_always_visible, R.string.action_title_toggle_tracker_actions_always_visible, R.string.action_detail_toggle_tracker_actions_always_visible, R.drawable.icon_action_toggle_tracker_actions_always_visible, 511, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        ar arVar = CursorAccessibilityService.q.o;
        arVar.getClass();
        SharedPreferences sharedPreferences = (SharedPreferences) pn0.t().d;
        oq0 oq0Var = oq0.L0;
        boolean z = !oq0.a(sharedPreferences, oq0Var);
        ((SharedPreferences) pn0.t().d).edit().putBoolean(oq0Var.name(), z).apply();
        arVar.e.setActionsAlwaysVisible(z);
        arVar.e.a(z);
    }
}
