package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class o60 extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("swipeDistance", dn.k2);
        waVar.put("swipeDuration", Integer.valueOf(dn.l2));
        waVar.put("multiTouch", 1);
        k = waVar;
        l = new l3(o60.class, R.string.action_category_gestures, R.string.action_value_gesture_swipe, R.string.action_title_gesture_swipe, R.string.action_detail_gesture_swipe, R.drawable.icon_action_gesture_swipe_left, 31, 0, Boolean.TRUE, new zy(4), null);
    }

    public o60() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    public static void m(AccessibilityService accessibilityService, int i, int i2, m60 m60Var, n60 n60Var, int i3, int i4) {
        boolean z = true;
        int iA = ey0.a(35) * (n60Var == n60.SHORT ? 1 : n60Var == n60.MEDIUM ? 2 : 3);
        if (m60Var != m60.TOP && m60Var != m60.BOTTOM) {
            z = false;
        }
        ArrayList arrayListN = hm0.n(i, i2, i4, z);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        int size = arrayListN.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayListN.get(i5);
            i5++;
            Point point = (Point) obj;
            Path path = new Path();
            path.moveTo(point.x, point.y);
            int i6 = point.x;
            int i7 = point.y;
            if (m60Var == m60.LEFT) {
                i6 -= iA;
            } else if (m60Var == m60.TOP) {
                i7 -= iA;
            } else if (m60Var == m60.RIGHT) {
                i6 += iA;
            } else {
                i7 += iA;
            }
            int iMin = Math.min(ey0.c(), Math.max(0, i6));
            int iMin2 = Math.min(ey0.b(), Math.max(0, i7));
            path.lineTo(iMin, iMin2);
            if (pn0.t().D()) {
                r60.f(point.x, point.y, iMin, iMin2, i3 * 2);
            }
            builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, i3));
        }
        CursorAccessibilityService.q.o.z();
        l60.i(accessibilityService, builder.build(), null);
    }

    @Override // defpackage.g1
    public final void g() {
        CursorAccessibilityService cursorAccessibilityService = this.f;
        Point point = this.a;
        m(cursorAccessibilityService, point.x, point.y, m60.valueOf((String) this.g.get("swipeDirection")), n60.valueOf((String) this.g.get("swipeDistance")), xy0.q(dn.l2, this.g.get("swipeDuration")).intValue(), hm0.m(this.g));
    }
}
