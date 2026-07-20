package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class q21 extends g1 {
    public static final l3 k = new l3(q21.class, R.string.action_category_quick_cursor, R.string.action_value_stop_gesture_recorder, R.string.action_title_stop_gesture_recorder, R.string.action_detail_stop_gesture_recorder, R.drawable.icon_action_stop_gesture_recorder, 31, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        try {
            CursorAccessibilityService.q.o.n();
        } catch (Exception unused) {
        }
    }
}
