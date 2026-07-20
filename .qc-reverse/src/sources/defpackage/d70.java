package defpackage;

import android.graphics.Point;
import android.view.WindowManager;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class d70 extends g1 {
    public static final l3 l = new l3(d70.class, R.string.action_category_quick_cursor, R.string.action_value_grab_cursor, R.string.action_title_grab_cursor, R.string.action_detail_grab_cursor, R.drawable.icon_action_grab_cursor, 224, 0, Boolean.FALSE, null, null);
    public final hj0 k;

    public d70() {
        super(i3.empty, e1.continuous);
        this.k = (hj0) CursorAccessibilityService.q.o;
    }

    @Override // defpackage.g1
    public final void e() {
        Point point = this.c;
        int i = point.x;
        int i2 = point.y;
        hj0 hj0Var = this.k;
        m81 m81Var = hj0Var.e;
        int i3 = m81Var.p;
        WindowManager.LayoutParams layoutParams = m81Var.d;
        layoutParams.x = i - i3;
        layoutParams.y = i2 - i3;
        try {
            m81Var.b.updateViewLayout(m81Var, layoutParams);
        } catch (Exception unused) {
        }
        hj0Var.E(i, i2, hj0Var.v.f(), hj0Var.v.c());
        r60.l(i, i2);
    }

    @Override // defpackage.g1
    public final void g() {
        i3 i3Var = this.d;
        i3 i3Var2 = i3.onRelease;
        Point point = this.c;
        hj0 hj0Var = this.k;
        if (i3Var != i3Var2) {
            hj0Var.I(point.x, point.y);
            return;
        }
        hj0Var.I(point.x, point.y);
        Point point2 = this.c;
        int i = point2.x;
        int i2 = point2.y;
        m81 m81Var = hj0Var.e;
        int i3 = m81Var.p;
        WindowManager.LayoutParams layoutParams = m81Var.d;
        layoutParams.x = i - i3;
        layoutParams.y = i2 - i3;
        try {
            m81Var.b.updateViewLayout(m81Var, layoutParams);
        } catch (Exception unused) {
        }
        hj0Var.E(i, i2, hj0Var.v.f(), hj0Var.v.c());
        r60.l(i, i2);
    }

    @Override // defpackage.g1
    public final void h() {
        Point point = this.c;
        int i = point.x;
        int i2 = point.y;
        hj0 hj0Var = this.k;
        pq0 pq0Var = hj0Var.k;
        hj0Var.v(hj0Var.w, pq0Var == pq0.c || pq0Var == pq0.d);
    }
}
