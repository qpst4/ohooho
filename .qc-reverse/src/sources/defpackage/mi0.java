package defpackage;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mi0 extends BroadcastReceiver {
    public final KeyguardManager a;
    public final CursorAccessibilityService b;
    public final IntentFilter c;

    public mi0(KeyguardManager keyguardManager, CursorAccessibilityService cursorAccessibilityService) {
        this.a = keyguardManager;
        this.b = cursorAccessibilityService;
        IntentFilter intentFilter = new IntentFilter();
        this.c = intentFilter;
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean zEquals = "android.intent.action.USER_PRESENT".equals(intent.getAction());
        CursorAccessibilityService cursorAccessibilityService = this.b;
        if (zEquals || ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && !this.a.isKeyguardLocked())) {
            if (cursorAccessibilityService.n != 1) {
                cursorAccessibilityService.p();
            }
            cursorAccessibilityService.l();
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            cursorAccessibilityService.getClass();
            if (!oq0.a((SharedPreferences) pn0.t().d, oq0.X0)) {
                cursorAccessibilityService.n(6);
            }
            if (zx0.d != null) {
                zx0.a(-1);
            }
            si0.a("clearTimedDisableTimerHandler");
            cursorAccessibilityService.p.d();
        }
    }
}
