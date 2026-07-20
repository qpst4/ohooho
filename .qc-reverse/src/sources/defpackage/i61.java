package defpackage;

import android.content.SharedPreferences;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class i61 extends g1 {
    public static final l3 k = new l3(i61.class, R.string.action_category_quick_cursor, R.string.action_value_toggle_auto_tap_mode, R.string.action_title_toggle_auto_tap_mode, R.string.action_detail_toggle_auto_tap_mode, R.drawable.icon_action_toggle_auto_tap_mode, 511, 0, Boolean.FALSE, new ay0(7), null);

    @Override // defpackage.g1
    public final void g() {
        ar arVar;
        try {
            pq0 pq0VarValueOf = pq0.valueOf((String) this.g.get("autoTapMode"));
            pq0 pq0VarJ = pn0.t().j();
            pn0 pn0VarT = pn0.t();
            if (pq0VarJ == pq0VarValueOf) {
                pq0VarValueOf = pq0.b;
            }
            ((SharedPreferences) pn0VarT.d).edit().putString(oq0.l.name(), pq0VarValueOf.name()).apply();
            CursorAccessibilityService cursorAccessibilityService = CursorAccessibilityService.q;
            if (cursorAccessibilityService == null || (arVar = cursorAccessibilityService.o) == null) {
                return;
            }
            arVar.k = pn0.t().j();
            m81 m81Var = arVar.e;
            if (m81Var != null) {
                m81Var.B = (pn0.t().j() == pq0.d) || pn0.t().s().b() == n3.nothing;
            }
        } catch (Exception unused) {
        }
    }
}
