package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class mo0 extends g1 {
    public static final l3 k = new l3(mo0.class, R.string.action_category_quick_cursor, R.string.action_value_open_tracker_actions_once, R.string.action_title_open_tracker_actions_once, R.string.action_detail_open_tracker_actions_once, R.drawable.icon_action_open_tracker_actions_once, 4, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        m81 m81Var = CursorAccessibilityService.q.o.e;
        if (m81Var.z) {
            return;
        }
        m81Var.s = 4;
        Object obj = m81Var.c;
        int i = (int) m81Var.i;
        int i2 = (int) m81Var.j;
        q71 q71Var = ((ar) obj).h;
        b61 b61Var = q71Var.k;
        if (b61Var != null) {
            b61Var.d();
            q71Var.k = null;
        }
        q71Var.j = null;
        r60.c(i, i2);
        q71Var.i = r60.h.H;
        q71Var.c();
    }
}
