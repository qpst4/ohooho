package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class x51 extends g1 {
    public static final wi0 k;
    public static final l3 l;

    static {
        wi0 wi0Var = new wi0();
        wi0Var.put("seconds", dn.h2);
        k = wi0Var;
        l = new l3(x51.class, R.string.action_category_quick_cursor, R.string.action_value_timed_disable, R.string.action_title_timed_disable, R.string.action_detail_timed_disable, R.drawable.icon_action_timed_disable, 511, 0, Boolean.TRUE, new ay0(6), null);
    }

    @Override // defpackage.g1
    public final void g() {
        int iIntValue = xy0.q(dn.h2.intValue(), this.g.get("seconds")).intValue();
        if (iIntValue != -1) {
            b61.b(new w51(this, iIntValue, 0), 1L);
            return;
        }
        CursorAccessibilityService cursorAccessibilityService = this.f;
        cursorAccessibilityService.getClass();
        new js0(cursorAccessibilityService, cursorAccessibilityService, 1);
    }
}
