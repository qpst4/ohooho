package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ko0 extends g1 {
    public static final l3 k = new l3(ko0.class, R.string.action_category_quick_cursor, R.string.action_value_open_quick_settings, R.string.action_title_open_quick_settings, R.string.action_detail_open_quick_settings, R.drawable.icon_action_open_quick_settings, 511, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        js0 js0Var = CursorAccessibilityService.q.m;
        if (js0Var == null || !js0Var.isAttachedToWindow()) {
            CursorAccessibilityService cursorAccessibilityService = CursorAccessibilityService.q;
            CursorAccessibilityService cursorAccessibilityService2 = CursorAccessibilityService.q;
            cursorAccessibilityService.m = new js0(cursorAccessibilityService2, cursorAccessibilityService2, 0);
        }
    }
}
