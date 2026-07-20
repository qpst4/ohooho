package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ AccessibilityStoppedActivity c;

    public /* synthetic */ r0(AccessibilityStoppedActivity accessibilityStoppedActivity, int i) {
        this.b = i;
        this.c = accessibilityStoppedActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        AccessibilityStoppedActivity accessibilityStoppedActivity = this.c;
        switch (i) {
            case 0:
                int i2 = AccessibilityStoppedActivity.t0;
                if (CursorAccessibilityService.g() && !CursorAccessibilityService.f()) {
                    u01 u01Var = new u01();
                    u01Var.b = R.string.slide_force_stop_title;
                    u01Var.c = R.string.slide_force_stop_description;
                    u01Var.d = R.drawable.quick_cursor_logo_circle;
                    u01Var.a = R.color.colorPrimaryDark;
                    u01Var.h = R.string.slide_force_stop_button;
                    u01Var.i = new q0(accessibilityStoppedActivity, 2);
                    u01Var.e = R.layout.mi_fragment_simple_slide;
                    u01Var.f = false;
                    u01Var.g = false;
                    try {
                        accessibilityStoppedActivity.Q(u01Var.a());
                    } catch (Exception unused) {
                        yb0.y(R.string.general_error_contact, 0);
                    }
                    accessibilityStoppedActivity.s0 = accessibilityStoppedActivity.a0.g.size() - 1;
                    b61.b(new r0(accessibilityStoppedActivity, 1), 150L);
                    break;
                }
                break;
            case 1:
                accessibilityStoppedActivity.J(accessibilityStoppedActivity.s0);
                break;
            default:
                accessibilityStoppedActivity.J(accessibilityStoppedActivity.r0);
                break;
        }
    }
}
