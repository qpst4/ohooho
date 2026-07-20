package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.a;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.quickcursor.android.activities.MainActivity;
import com.quickcursor.android.activities.ThanksProActivity;
import com.quickcursor.android.activities.actions.ToggleFlashlightActivity;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.activities.settings.TrackerSettings;
import com.quickcursor.android.activities.settings.VibrationsAndVisualSettings;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lk0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ lk0(VibrationsAndVisualSettings.a aVar, Object obj) {
        this.b = 24;
        this.c = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = 1;
        boolean zPerformAction = false;
        Object[] objArr = 0;
        int i3 = 2;
        Object obj = this.c;
        switch (i) {
            case 0:
                i9 i9Var = (i9) obj;
                if (oq0.a((SharedPreferences) pn0.t().d, oq0.S0)) {
                    i9.f((CursorAccessibilityService) i9Var.d, false);
                }
                break;
            case 1:
                kp0 kp0Var = (kp0) obj;
                l3 l3Var = kp0.k;
                try {
                    AccessibilityNodeInfo accessibilityNodeInfoM = zy0.m(kp0Var.f.getRootInActiveWindow(), AccessibilityNodeInfo.AccessibilityAction.ACTION_PASTE);
                    if (accessibilityNodeInfoM != null) {
                        zPerformAction = accessibilityNodeInfoM.performAction(32768);
                        accessibilityNodeInfoM.recycle();
                    }
                    if (!zPerformAction && pn0.t().A()) {
                        new Handler(Looper.getMainLooper()).post(new s4(11));
                        break;
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            case 2:
                sf sfVar = (sf) obj;
                af afVar = sfVar.c;
                if (afVar.c()) {
                    c1 c1Var = new c1(i3);
                    c1Var.c = "inapp";
                    afVar.f(c1Var.b(), new ef(sfVar, i2));
                    c1 c1Var2 = new c1(i3);
                    c1Var2.c = "subs";
                    afVar.f(c1Var2.b(), new ef(sfVar, objArr == true ? 1 : 0));
                }
                break;
            case 3:
                wj wjVar = (wj) obj;
                wjVar.startActivity(new Intent(wjVar, (Class<?>) MainActivity.class));
                wjVar.finish();
                break;
            case 4:
                dr0 dr0Var = (dr0) obj;
                a aVar = dr0Var.g;
                if (dr0Var.c == 0) {
                    dr0Var.d = true;
                    aVar.d(yf0.ON_PAUSE);
                }
                if (dr0Var.b == 0 && dr0Var.d) {
                    aVar.d(yf0.ON_STOP);
                    dr0Var.e = true;
                    break;
                }
                break;
            case 5:
                ((at0) obj).m();
                break;
            case 6:
                ((mt0) obj).h();
                break;
            case 7:
                zy0 zy0Var = (zy0) obj;
                l3 l3Var2 = zy0.k;
                try {
                    if (!zy0.o(zy0.m(zy0Var.f.getRootInActiveWindow(), AccessibilityNodeInfo.AccessibilityAction.ACTION_CUT)) && pn0.t().A()) {
                        new Handler(Looper.getMainLooper()).post(new s4(14));
                        break;
                    }
                } catch (Exception unused2) {
                    return;
                }
                break;
            case 8:
                ah ahVar = (ah) obj;
                ahVar.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) ahVar.e;
                wf1 wf1Var = sideSheetBehavior.i;
                if (wf1Var != null && wf1Var.f()) {
                    ahVar.a(ahVar.b);
                } else if (sideSheetBehavior.h == 2) {
                    sideSheetBehavior.r(ahVar.b);
                }
                break;
            case 9:
                o21 o21Var = (o21) obj;
                l3 l3Var3 = o21.l;
                try {
                    b61 b61Var = CursorAccessibilityService.q.o.f;
                    if (b61Var != null) {
                        b61Var.a();
                    }
                    o21Var.m();
                } catch (Exception unused3) {
                    return;
                }
                break;
            case 10:
                l3 l3Var4 = r31.k;
                ((r31) obj).f.performGlobalAction(3);
                break;
            case 11:
                ((TextInputLayout) obj).e.requestLayout();
                break;
            case 12:
                ThanksProActivity thanksProActivity = (ThanksProActivity) obj;
                int i4 = ThanksProActivity.D;
                sf sfVar2 = thanksProActivity.B;
                if (sfVar2 != null) {
                    j51 j51Var = new j51(thanksProActivity, i2);
                    c1 c1Var3 = new c1(i3);
                    c1Var3.c = "subs";
                    sfVar2.c.f(c1Var3.b(), new ff(sfVar2, i3, j51Var));
                    break;
                }
                break;
            case 13:
                ToggleFlashlightActivity toggleFlashlightActivity = (ToggleFlashlightActivity) obj;
                toggleFlashlightActivity.B.unregisterTorchCallback(toggleFlashlightActivity.C);
                toggleFlashlightActivity.finish();
                break;
            case 14:
                ((q71) obj).a(i3.delayed, false);
                break;
            case 15:
                ((TrackerActionsSettings) ((z71) obj).Z()).K();
                break;
            case 16:
                ((TrackerSettings.a) obj).h0("hideTimeoutThreshold").w();
                break;
            case 17:
                int i5 = TrackerSettings.D;
                ((TrackerSettings) obj).G();
                break;
            case 18:
                ((r91) obj).h0("animationDuration").w();
                break;
            case 19:
                ((w91) obj).a(i3.delayed, false);
                break;
            case 20:
                ((la1) obj).r0();
                break;
            case 21:
                ra1 ra1Var = (ra1) obj;
                try {
                    if (ra1Var.d.b().h().b() != n3.nothing) {
                        ra1Var.h = 2;
                        ra1Var.c.i((int) ra1Var.k, (int) ra1Var.l);
                    }
                } catch (Exception unused4) {
                    return;
                }
                break;
            case 22:
                ((wa1) obj).h0("rectanglePreset").w();
                break;
            case 23:
                ((xa1) obj).f();
                break;
            case 24:
                r60.h(((Integer) obj).intValue(), ey0.c() / 2, ey0.b() / 2);
                break;
            case 25:
                View view = (View) obj;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                break;
            default:
                g7 g7Var = (g7) obj;
                ((dx0) g7Var.e).q(new r1(25, g7Var));
                break;
        }
    }

    public /* synthetic */ lk0(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }
}
