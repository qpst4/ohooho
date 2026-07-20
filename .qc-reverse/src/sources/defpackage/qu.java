package defpackage;

import android.graphics.Point;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class qu extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("multiTouch", 1);
        k = waVar;
        l = new l3(qu.class, R.string.action_category_gestures, R.string.action_value_double_tap, R.string.action_title_double_tap, R.string.action_detail_double_tap, R.drawable.icon_action_double_tap, 31, 0, Boolean.TRUE, new s1(28), null);
    }

    public qu() {
        super(i3.empty, e1.onReleaseAndPositioned);
    }

    @Override // defpackage.g1
    public final void g() {
        CursorAccessibilityService cursorAccessibilityService = this.f;
        Point point = this.a;
        hm0.o(cursorAccessibilityService, point.x, point.y, this.g);
        b61.b(new c(20, this), 50L);
    }
}
