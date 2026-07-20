package defpackage;

import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class pa1 extends g1 {
    public static final l3 k = new l3(pa1.class, R.string.action_category_quick_cursor, R.string.action_value_trigger_tap, R.string.action_title_trigger_tap, R.string.action_detail_trigger_tap, R.drawable.icon_action_trigger_tap, 32, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        hj0 hj0Var = (hj0) CursorAccessibilityService.q.o;
        Point point = this.c;
        int i = point.x;
        int i2 = point.y;
        hj0Var.z();
        l60.a(hj0Var.b, i, i2, false);
    }
}
