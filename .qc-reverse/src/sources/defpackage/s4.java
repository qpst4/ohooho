package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s4 implements Runnable {
    public final /* synthetic */ int b;

    public /* synthetic */ s4(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = -1;
        switch (this.b) {
            case 0:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 1:
                int i2 = AlarmManagerSchedulerBroadcastReceiver.a;
                break;
            case 2:
                break;
            case 3:
                l60.b(0, 0, 2);
                break;
            case 4:
                l3 l3Var = jr.k;
                yb0.y(R.string.action_couldnt_find_input, 0);
                break;
            case 5:
                AsyncTask.execute(new s4(29));
                break;
            case 6:
                CursorAccessibilityService.k(true);
                break;
            case 7:
                xv0.d.c();
                break;
            case 8:
                r60.o = null;
                break;
            case 9:
                CursorAccessibilityService.b();
                break;
            case 10:
                wa waVar = mf0.k;
                Intent intent = new Intent("android.intent.action.VOICE_COMMAND");
                intent.setFlags(268435456);
                App.c.startActivity(intent);
                break;
            case 11:
                l3 l3Var2 = kp0.k;
                yb0.y(R.string.action_couldnt_find_input, 0);
                break;
            case 12:
                String str = jy0.k;
                r60.j(false);
                break;
            case 13:
                String str2 = jy0.k;
                r60.j(false);
                break;
            case 14:
                l3 l3Var3 = zy0.k;
                yb0.y(R.string.action_couldnt_find_input, 0);
                break;
            case 15:
                CursorAccessibilityService.j();
                break;
            case 16:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 17:
                l3 l3Var4 = h41.k;
                r60.j(false);
                break;
            case 18:
                int i3 = TrackerActionsSettings.I;
                s71.e.c();
                CursorAccessibilityService.j();
                break;
            case 19:
                int i4 = TrackerActionsSettings.I;
                s71.e.c();
                CursorAccessibilityService.j();
                break;
            case 20:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 21:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 22:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 23:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 24:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 25:
                xv0.d.c();
                CursorAccessibilityService.j();
                break;
            case 26:
                lv.b();
                break;
            case 27:
                CursorAccessibilityService.j();
                r60.h(-1, ey0.c() / 2, ey0.b() / 2);
                break;
            case 28:
                CursorAccessibilityService.j();
                r60.h(-1, ey0.c() / 2, ey0.b() / 2);
                break;
            default:
                int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.R);
                if (iC > 0) {
                    try {
                        if (f01.l == null) {
                            f01.l = (Vibrator) App.c.getSystemService("vibrator");
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            f01.l.vibrate(iC);
                        } else {
                            int iC2 = oq0.c((SharedPreferences) pn0.t().d, oq0.Y0);
                            Vibrator vibrator = f01.l;
                            long j = iC;
                            if (iC2 != 0) {
                                i = iC2;
                            }
                            vibrator.vibrate(VibrationEffect.createOneShot(j, i));
                        }
                    } catch (Exception e) {
                        si0.b("Vibration failed: " + e);
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ s4(int i, Object obj) {
        this.b = i;
    }

    private final void a() {
    }
}
