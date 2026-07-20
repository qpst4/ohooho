package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class h01 extends g1 {
    public static final l3 k = new l3(h01.class, R.string.action_category_shortcut, R.string.action_value_shortcut_stop_app, R.string.action_title_shortcut_stop_app, R.string.action_detail_shortcut_stop_app, R.drawable.icon_stop, 256, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        CursorAccessibilityService cursorAccessibilityService = CursorAccessibilityService.q;
        if (cursorAccessibilityService != null) {
            si0.a("turnOff(): ".concat(l11.p(2)));
            r60.k();
            ar arVar = cursorAccessibilityService.o;
            if (arVar != null) {
                try {
                    arVar.m();
                } catch (Exception unused) {
                }
                cursorAccessibilityService.o = null;
            }
            cursorAccessibilityService.n = 2;
        }
    }
}
