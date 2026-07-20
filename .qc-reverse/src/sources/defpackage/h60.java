package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class h60 extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("pinchDistance", dn.n2);
        waVar.put("pinchDuration", dn.o2);
        k = waVar;
        l = new l3(h60.class, R.string.action_category_gestures, R.string.action_value_gesture_pinch_out, R.string.action_title_gesture_pinch_out, R.string.action_detail_gesture_pinch_out, R.drawable.icon_action_gesture_pinch_in, 31, 0, Boolean.TRUE, new zy(2), null);
    }

    public h60() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    public static void m(m3 m3Var, n3 n3Var, Boolean bool, Map map) {
        if (bool.booleanValue() || map != null) {
            c3.k0(m3Var.l(), new d3(R.xml.preferences_action_gesture_pinch, map), new eh(m3Var, n3Var, 3), null);
        } else {
            m3Var.q(new i(n3Var, k));
        }
    }

    public static void n(AccessibilityService accessibilityService, boolean z, int i, int i2, g60 g60Var, f60 f60Var) {
        int iA = ey0.a(f60Var == f60.SHORT ? 50 : f60Var == f60.MEDIUM ? 100 : 150);
        int i3 = iA / (z ? 8 : 5);
        int i4 = g60Var == g60.SHORT ? 300 : g60Var == g60.MEDIUM ? 500 : 1000;
        GestureDescription.Builder builder = new GestureDescription.Builder();
        int iMin = Math.min(ey0.c(), Math.max(0, i - i3));
        int iMin2 = Math.min(ey0.b(), Math.max(0, i2 - i3));
        int iMin3 = Math.min(ey0.c(), Math.max(0, i - iA));
        int iMin4 = Math.min(ey0.b(), Math.max(0, i2 - iA));
        int iMin5 = Math.min(ey0.c(), Math.max(0, i + i3));
        int iMin6 = Math.min(ey0.b(), Math.max(0, i2 + i3));
        int iMin7 = Math.min(ey0.c(), Math.max(0, i + iA));
        int iMin8 = Math.min(ey0.b(), Math.max(0, i2 + iA));
        Path path = new Path();
        Path path2 = new Path();
        if (z) {
            path.moveTo(iMin, iMin2);
            path.lineTo(iMin3, iMin4);
            path2.moveTo(iMin5, iMin6);
            path2.lineTo(iMin7, iMin8);
            if (pn0.t().D()) {
                r60.f(iMin, iMin2, iMin3, iMin4, i4);
                r60.f(iMin5, iMin6, iMin7, iMin8, i4);
            }
        } else {
            path.moveTo(iMin3, iMin4);
            path.lineTo(iMin, iMin2);
            path2.moveTo(iMin7, iMin8);
            path2.lineTo(iMin5, iMin6);
            if (pn0.t().D()) {
                r60.f(iMin3, iMin4, iMin, iMin2, i4);
                r60.f(iMin7, iMin8, iMin5, iMin6, i4);
            }
        }
        long j = i4;
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, j));
        builder.addStroke(new GestureDescription.StrokeDescription(path2, 0L, j));
        CursorAccessibilityService.q.o.z();
        l60.i(accessibilityService, builder.build(), null);
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
        n(cursorAccessibilityService, true, point2.x, point2.y, g60VarValueOf, f60VarValueOf);
    }
}
