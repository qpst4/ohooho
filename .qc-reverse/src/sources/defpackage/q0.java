package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import com.quickcursor.R;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q0 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ AccessibilityStoppedActivity c;

    public /* synthetic */ q0(AccessibilityStoppedActivity accessibilityStoppedActivity, int i) {
        this.b = i;
        this.c = accessibilityStoppedActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        AccessibilityStoppedActivity accessibilityStoppedActivity = this.c;
        switch (i) {
            case 0:
                accessibilityStoppedActivity.onLeftButtonClicked(view);
                break;
            case 1:
                int i2 = AccessibilityStoppedActivity.t0;
                int currentItem = accessibilityStoppedActivity.U.getCurrentItem();
                if (currentItem != accessibilityStoppedActivity.q0) {
                    if (currentItem == accessibilityStoppedActivity.r0) {
                        ((SharedPreferences) pn0.t().d).edit().putBoolean(oq0.j.name(), true).apply();
                        accessibilityStoppedActivity.g0();
                    } else if (currentItem != accessibilityStoppedActivity.s0) {
                        accessibilityStoppedActivity.W();
                    } else {
                        lc1.m0(accessibilityStoppedActivity);
                    }
                } else if (!CursorAccessibilityService.f()) {
                    if (!CursorAccessibilityService.f()) {
                        accessibilityStoppedActivity.o0 = true;
                        lc1.b0(accessibilityStoppedActivity);
                    } else {
                        yb0.y(R.string.accessibility_service_already_enabled, 1);
                        accessibilityStoppedActivity.W();
                    }
                } else if (currentItem != accessibilityStoppedActivity.a0.g.size() - 1) {
                    accessibilityStoppedActivity.W();
                } else {
                    accessibilityStoppedActivity.g0();
                }
                break;
            default:
                AccessibilityStoppedActivity.f0(accessibilityStoppedActivity);
                break;
        }
    }
}
