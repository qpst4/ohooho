package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class hm0 extends g1 {
    public static final l3 k = new l3(hm0.class, R.string.action_category_gestures, R.string.action_value_multi_tap, R.string.action_title_multi_tap, R.string.action_detail_multi_tap, R.drawable.icon_action_multi_tap, 31, 0, Boolean.FALSE, new zy(21), null);

    public hm0() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    public static int m(Map map) {
        try {
            return xy0.q(1, map.get("multiTouch")).intValue();
        } catch (Exception unused) {
            return 1;
        }
    }

    public static ArrayList n(int i, int i2, int i3, boolean z) {
        ArrayList arrayList = new ArrayList(i3);
        if (i3 == 1) {
            arrayList.add(new Point(i, i2));
            return arrayList;
        }
        int iA = ey0.a(5) * i3;
        int i4 = 0;
        if (z) {
            int iC = i - iA;
            int i5 = i + iA;
            if (iC < 0) {
                iC = 0;
            } else if (i5 > ey0.c()) {
                iC -= i5 - ey0.c();
            }
            float f = (iA * 2.0f) / (i3 - 1);
            while (i4 < i3) {
                arrayList.add(new Point((int) ((i4 * f) + iC), i2));
                i4++;
            }
        } else {
            int iB = i2 - iA;
            int i6 = i2 + iA;
            if (iB < 0) {
                iB = 0;
            } else if (i6 > ey0.b()) {
                iB -= i6 - ey0.b();
            }
            float f2 = (iA * 2.0f) / (i3 - 1);
            while (i4 < i3) {
                arrayList.add(new Point(i, (int) ((i4 * f2) + iB)));
                i4++;
            }
        }
        return arrayList;
    }

    public static void o(AccessibilityService accessibilityService, int i, int i2, HashMap map) {
        int iM = m(map);
        ArrayList arrayListN = n(i, i2, iM, true);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        int size = arrayListN.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListN.get(i3);
            i3++;
            Point point = (Point) obj;
            Path path = new Path();
            path.moveTo(point.x, point.y);
            path.lineTo(point.x, point.y);
            builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, 5L));
            if (pn0.t().D()) {
                if (iM == 1) {
                    r60.h(pn0.t().x(), i, i2);
                } else {
                    int i4 = point.x;
                    int i5 = point.y;
                    r60.f(i4, i5, i4, i5, 25);
                }
            }
        }
        CursorAccessibilityService.q.o.z();
        l60.i(accessibilityService, builder.build(), null);
    }

    public static void p(m3 m3Var, n3 n3Var, Map map) {
        int iIntValue = n3Var == n3.multiTap ? 2 : 1;
        if (map != null) {
            iIntValue = xy0.q(iIntValue, map.get("multiTouch")).intValue();
        }
        new ih0(lc1.K(R.string.action_multi_tap_dialog_title), Integer.valueOf(iIntValue), new eh(m3Var, n3Var, 6)).j0(m3Var.l(), "NumberPickerDialogFragment");
    }

    @Override // defpackage.g1
    public final void g() {
        CursorAccessibilityService cursorAccessibilityService = this.f;
        Point point = this.a;
        o(cursorAccessibilityService, point.x, point.y, this.g);
    }
}
