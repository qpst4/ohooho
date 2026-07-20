package defpackage;

import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class fa1 extends g1 {
    public static final l3 k = new l3(fa1.class, R.string.action_category_quick_cursor, R.string.action_value_trigger_long_tap, R.string.action_title_trigger_long_tap, R.string.action_detail_trigger_long_tap, R.drawable.icon_action_trigger_long_tap, 64, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        hj0 hj0Var = (hj0) CursorAccessibilityService.q.o;
        Point point = this.c;
        l60.f(hj0Var.b, 32, point.x, point.y);
    }
}
