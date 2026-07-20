package defpackage;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class xi0 extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("longTapDuration", Integer.valueOf(dn.m2));
        waVar.put("multiTouch", 1);
        k = waVar;
        l = new l3(xi0.class, R.string.action_category_gestures, R.string.action_value_long_tap, R.string.action_title_long_tap, R.string.action_detail_long_tap, R.drawable.icon_action_long_tap, 31, 0, Boolean.TRUE, new zy(17), null);
    }

    public xi0() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    @Override // defpackage.g1
    public final void g() {
        HashMap map = this.g;
        int i = en.a;
        try {
            int iIntValue = xy0.q(i, map.get("longTapDuration")).intValue();
            if (iIntValue != 0) {
                i = iIntValue;
            }
        } catch (Exception unused) {
        }
        int iM = hm0.m(this.g);
        Point point = this.a;
        ArrayList arrayListN = hm0.n(point.x, point.y, iM, true);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        int size = arrayListN.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayListN.get(i2);
            i2++;
            Point point2 = (Point) obj;
            Path path = new Path();
            path.moveTo(point2.x, point2.y);
            path.lineTo(point2.x, point2.y);
            builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, i));
            if (pn0.t().D()) {
                if (iM == 1) {
                    int iX = pn0.t().x();
                    Point point3 = this.a;
                    r60.h(iX, point3.x, point3.y);
                } else {
                    int i3 = point2.x;
                    int i4 = point2.y;
                    r60.f(i3, i4, i3, i4, i);
                }
            }
        }
        CursorAccessibilityService.q.o.z();
        l60.i(this.f, builder.build(), null);
    }
}
