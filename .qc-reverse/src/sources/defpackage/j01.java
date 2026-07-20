package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class j01 extends g1 {
    public static final l3 k = new l3(j01.class, R.string.action_category_shortcut, R.string.action_value_shortcut_toggle_cursor, R.string.action_title_shortcut_toggle_cursor, R.string.action_detail_shortcut_toggle_cursor, R.drawable.icon_action_toggle_cursor, 256, 0, Boolean.TRUE, new ay0(2), null);

    @Override // defpackage.g1
    public final void g() {
        f91 f91VarM = m01.m(this.g);
        boolean zN = m01.n(this.g);
        if (f91VarM != null) {
            if (!CursorAccessibilityService.e()) {
                yb0.y(R.string.shortcut_error_app_off, 0);
                return;
            }
            ar arVar = CursorAccessibilityService.q.o;
            if (arVar.e.getVisibility() == 8) {
                arVar.A(f91VarM, zN);
            } else {
                arVar.o();
            }
        }
    }
}
