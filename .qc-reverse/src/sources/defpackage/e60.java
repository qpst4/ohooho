package defpackage;

import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class e60 extends g1 {
    public static final l3 k = new l3(e60.class, R.string.action_category_gestures, R.string.action_value_gesture_pinch_in, R.string.action_title_gesture_pinch_in, R.string.action_detail_gesture_pinch_in, R.drawable.icon_action_gesture_pinch_out, 31, 0, Boolean.TRUE, new zy(2), null);

    public e60() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    @Override // defpackage.g1
    public final void g() {
        g60 g60VarValueOf = g60.valueOf((String) this.g.get("pinchDuration"));
        f60 f60VarValueOf = f60.valueOf((String) this.g.get("pinchDistance"));
        if (pn0.t().D()) {
            int iX = pn0.t().x();
            Point point = this.a;
            r60.h(iX, point.x, point.y);
        }
        CursorAccessibilityService cursorAccessibilityService = this.f;
        Point point2 = this.a;
        h60.n(cursorAccessibilityService, false, point2.x, point2.y, g60VarValueOf, f60VarValueOf);
    }
}
