package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vm extends BroadcastReceiver {
    public final /* synthetic */ int a = 0;
    public Context b;
    public final Object c;

    public vm(CursorAccessibilityService cursorAccessibilityService) {
        this.b = cursorAccessibilityService;
        IntentFilter intentFilter = new IntentFilter();
        this.c = intentFilter;
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                CursorAccessibilityService cursorAccessibilityService = (CursorAccessibilityService) this.b;
                yx0 yx0Var = cursorAccessibilityService.h;
                int i = 0;
                if (yx0Var != null) {
                    yx0Var.b.a(new xx0(yx0Var, i));
                }
                i9 i9Var = cursorAccessibilityService.i;
                if (i9Var != null) {
                    ((rr) i9Var.c).a(new lk0(i, i9Var));
                    return;
                }
                return;
            default:
                Uri data = intent.getData();
                if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
                    Object obj = ((pn0) this.c).d;
                    throw null;
                }
                return;
        }
    }

    public vm(pn0 pn0Var) {
        this.c = pn0Var;
    }
}
