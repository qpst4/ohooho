package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kx0 extends BroadcastReceiver {
    public static final /* synthetic */ int d = 0;
    public final CursorAccessibilityService a;
    public final IntentFilter b;
    public boolean c = true;

    public kx0(CursorAccessibilityService cursorAccessibilityService) {
        this.a = cursorAccessibilityService;
        IntentFilter intentFilter = new IntentFilter();
        this.b = intentFilter;
        intentFilter.addAction("com.samsung.pen.INSERT");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.c = intent.getBooleanExtra("penInsert", true);
        si0.a("S Pen attached: " + this.c);
        boolean z = this.c;
        CursorAccessibilityService cursorAccessibilityService = this.a;
        cursorAccessibilityService.getClass();
        if (oq0.a((SharedPreferences) pn0.t().d, oq0.a1)) {
            if (!z) {
                cursorAccessibilityService.n(8);
            } else if (cursorAccessibilityService.n != 1) {
                cursorAccessibilityService.p();
            }
        }
    }
}
