package com.quickcursor.android.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import defpackage.c0;
import defpackage.di0;
import defpackage.ey0;
import defpackage.f01;
import defpackage.g0;
import defpackage.g1;
import defpackage.i;
import defpackage.i3;
import defpackage.i70;
import defpackage.l01;
import defpackage.l11;
import defpackage.lc1;
import defpackage.mc1;
import defpackage.n3;
import defpackage.qf0;
import defpackage.r1;
import defpackage.r2;
import defpackage.si0;
import defpackage.tk0;
import defpackage.wi0;
import defpackage.yb0;
import defpackage.zz0;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ShortcutActivity extends di0 {
    public static final /* synthetic */ int E = 0;
    public final List B;
    public final List C;
    public final i70 D;

    public ShortcutActivity() {
        n3 n3Var = n3.shortcutTriggerCursor;
        n3 n3Var2 = n3.shortcutHideCursor;
        n3 n3Var3 = n3.shortcutToggleCursor;
        n3 n3Var4 = n3.shortcutStartApp;
        n3 n3Var5 = n3.shortcutStopApp;
        n3 n3Var6 = n3.shortcutToggleApp;
        this.B = Arrays.asList(n3Var, n3Var2, n3Var3, n3Var4, n3Var5, n3Var6);
        this.C = Arrays.asList(n3Var, n3Var2, n3Var3, n3Var4, n3Var5, n3Var6, n3.expandNotifications, n3.expandQuickSettings);
        this.D = new i70();
    }

    public static Bitmap F(i iVar) {
        Drawable drawableJ = tk0.j(App.c, R.drawable.launcher_icon_background);
        InsetDrawable insetDrawable = new InsetDrawable(tk0.j(App.c, iVar.c().iconId), ey0.a(40));
        insetDrawable.setTint(-1);
        AdaptiveIconDrawable adaptiveIconDrawableD = Build.VERSION.SDK_INT >= 33 ? g0.d(drawableJ, insetDrawable, insetDrawable) : c0.j(drawableJ, insetDrawable);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(adaptiveIconDrawableD.getIntrinsicWidth(), adaptiveIconDrawableD.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        adaptiveIconDrawableD.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        adaptiveIconDrawableD.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static int H(Intent intent, String str, int i) {
        int intExtra = intent.getIntExtra(str, i);
        if (intExtra == i) {
            try {
                String stringExtra = intent.getStringExtra(str);
                if (stringExtra != null) {
                    return Integer.parseInt(stringExtra);
                }
            } catch (Exception unused) {
            }
        }
        return intExtra;
    }

    public static String I(i iVar, String str) {
        String str2 = "v2_" + str.replaceAll(" ", "");
        if (iVar.d() == null) {
            return str2;
        }
        return str2 + "_" + iVar.d().hashCode();
    }

    public static String J(i iVar) {
        String str;
        switch (zz0.a[iVar.c().ordinal()]) {
            case 1:
                return lc1.K(R.string.action_title_shortcut_start_app);
            case 2:
                return lc1.K(R.string.action_title_shortcut_stop_app);
            case 3:
                return lc1.K(R.string.action_title_shortcut_toggle_app);
            case 4:
                return lc1.K(R.string.action_title_hide_cursor);
            case 5:
                str = lc1.K(R.string.shortcut_toggle) + " ";
                break;
            case 6:
                str = "";
                break;
            default:
                return lc1.K(iVar.c().titleId);
        }
        String str2 = (String) iVar.d().get("trigger");
        StringBuilder sbL = l11.l(str);
        sbL.append(str2.equals("-1") ? lc1.K(R.string.shortcut_name_floating_trigger) : f01.P(R.string.shortcut_name_trigger, "triggerId", str2));
        return sbL.toString();
    }

    public final i G(int i) {
        if (i == 0) {
            return new i(n3.shortcutStartApp);
        }
        if (i == 1) {
            return new i(n3.shortcutStopApp);
        }
        if (i == 2) {
            return new i(n3.shortcutToggleApp);
        }
        if (i != 3) {
            if (i == 4) {
                return new i(n3.shortcutHideCursor);
            }
            if (i != 5) {
                return null;
            }
        }
        n3 n3Var = i == 3 ? n3.shortcutTriggerCursor : n3.shortcutToggleCursor;
        int iH = H(getIntent(), "triggerId", H(getIntent(), "zoneId", -2));
        wi0 wi0Var = new wi0();
        wi0Var.put("trigger", String.valueOf(iH));
        wi0Var.put("timeout", l01.auto.toString());
        return new i(n3Var, wi0Var);
    }

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        i iVarG;
        super.onCreate(bundle);
        si0.a("ShortcutActivity onCreate()");
        if (CursorAccessibilityService.q == null) {
            yb0.y(R.string.shortcut_error_service_off, 1);
            return;
        }
        if ("android.intent.action.CREATE_SHORTCUT".equals(getIntent().getAction())) {
            r2.o0(w(), n3.b(256), this.B, this.C, new r1(17, this));
            return;
        }
        try {
            int iH = H(getIntent(), "action", -1);
            if (iH == -1) {
                String stringExtra = getIntent().getStringExtra("a");
                i70 i70Var = this.D;
                i70Var.getClass();
                iVarG = (i) i70Var.e(stringExtra, new mc1(i.class));
            } else {
                iVarG = G(iH);
            }
            si0.a("Stored action: " + iVarG);
            if (iVarG == null) {
                yb0.y(R.string.shortcut_error_invalid, 0);
            } else {
                CursorAccessibilityService cursorAccessibilityService = CursorAccessibilityService.q;
                qf0 qf0Var = new qf0(iVarG);
                i3 i3Var = i3.instant;
                g1.a(cursorAccessibilityService, qf0Var, 256, i3Var, i3Var).b(false, false);
            }
        } catch (Exception e) {
            si0.b("triggerActionFromIntent exception: " + e);
        }
        finish();
    }
}
