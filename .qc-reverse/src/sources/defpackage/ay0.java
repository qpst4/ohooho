package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import com.quickcursor.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ay0 implements k3, d51 {
    public static final ay0 c = new ay0(9);
    public static final ay0 d = new ay0(10);
    public static final ay0 e = new ay0(11);
    public static final ay0 f = new ay0(12);
    public static final ay0 g = new ay0(13);
    public final /* synthetic */ int b;

    public /* synthetic */ ay0(int i) {
        this.b = i;
    }

    public static /* synthetic */ void a(Object obj, Object obj2) throws TimeoutException {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append((Object) " for ");
        sb.append(obj2);
        throw new TimeoutException(sb.toString());
    }

    public static /* synthetic */ void b(String str) throws np1 {
        throw new np1(str);
    }

    public static /* synthetic */ void d(String str, int i) {
        throw new IllegalArgumentException(str + i);
    }

    public static /* synthetic */ void e(String str, int i, Object obj, Object obj2) {
        throw new wd0(str + i + obj + obj2);
    }

    @Override // defpackage.k3
    public void c(m3 m3Var, n3 n3Var, boolean z, HashMap map) {
        pq0 pq0VarJ;
        int i = 7;
        int i2 = 8;
        int i3 = 0;
        int i4 = 1;
        String str = null;
        switch (this.b) {
            case 0:
                wi0 wi0Var = cy0.k;
                if (z || map != null) {
                    y30 y30VarL = m3Var.l();
                    dy0 dy0Var = new dy0(R.xml.preferences_action_screen_rotate, map);
                    Map map2 = dy0Var.i0;
                    if (map2 != null && map2.containsKey("rotations")) {
                        List listAsList = Arrays.asList(((String) map2.getOrDefault("rotations", "0,1")).split(","));
                        for (int i5 = -1; i5 <= 3; i5++) {
                            map2.put(qq0.i("rotation", i5), Boolean.valueOf(listAsList.contains(String.valueOf(i5))));
                        }
                    }
                    c3.k0(y30VarL, dy0Var, new to(m3Var, i), null);
                } else {
                    m3Var.q(new i(n3Var, cy0.k));
                }
                break;
            case 1:
                String str2 = jy0.k;
                if (z || map != null) {
                    c3.k0(m3Var.l(), new ly0(R.xml.preferences_action_screenshot_clipboard, map), new to(m3Var, i2), null);
                } else {
                    m3Var.q(new i(n3.screenshotClipboard, jy0.l));
                }
                break;
            case 2:
                m01.o(m3Var, n3Var, Boolean.valueOf(z));
                break;
            case 3:
                l3 l3Var = o41.k;
                if (f01.C("net.dinglisch.android.taskerm")) {
                    str = "net.dinglisch.android.taskerm";
                } else if (f01.C("net.dinglisch.android.tasker")) {
                    str = "net.dinglisch.android.tasker";
                }
                if (str == null) {
                    f01.I("net.dinglisch.android.taskerm");
                } else {
                    ComponentName componentName = new ComponentName(str, "net.dinglisch.android.taskerm.TaskerAppWidgetConfigureShortcut");
                    Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setComponent(componentName);
                    m3Var.n(intent, new qs(m3Var, n3Var, intent, 6));
                }
                break;
            case 6:
                wi0 wi0Var2 = x51.k;
                if (z || map != null) {
                    c3.k0(m3Var.l(), new lf0(R.xml.preferences_action_timed_disable_extra, map, i4), new eh(m3Var, n3Var, i), null);
                } else {
                    m3Var.q(new i(n3Var, x51.k));
                }
                break;
            case 7:
                l3 l3Var2 = i61.k;
                if (z || map != null || (pq0VarJ = pn0.t().j()) == pq0.b) {
                    new ih0(lc1.K(R.string.action_toggle_auto_tap_dialog_title), jh0.a(Integer.valueOf(R.array.action_toggle_auto_tap_mode_titles), Integer.valueOf(R.array.action_toggle_auto_tap_mode_descriptions), Integer.valueOf(R.array.action_toggle_auto_tap_mode_values), null), new to(m3Var, 9)).j0(m3Var.l(), "ListPickerDialogFragment");
                } else {
                    n3 n3Var2 = n3.toggleAutoTapMode;
                    wi0 wi0Var3 = new wi0();
                    wi0Var3.put("autoTapMode", pq0VarJ);
                    m3Var.q(new i(n3Var2, wi0Var3));
                }
                break;
            case 8:
                wi0 wi0Var4 = o61.k;
                if (z || map != null) {
                    y30 y30VarL2 = m3Var.l();
                    k00 k00Var = new k00(R.xml.preferences_action_toggle_sound_profile, map, i4);
                    Map map3 = k00Var.i0;
                    if (map3 != null && map3.containsKey("profiles")) {
                        List listAsList2 = Arrays.asList(((String) map3.getOrDefault("profiles", "0,1,2")).split(","));
                        while (i3 <= 2) {
                            map3.put(qq0.i("profile", i3), Boolean.valueOf(listAsList2.contains(String.valueOf(i3))));
                            i3++;
                        }
                    }
                    c3.k0(y30VarL2, k00Var, new eh(m3Var, n3Var, i2), null);
                } else {
                    m3Var.q(new i(n3Var, o61.k));
                }
                break;
            case 16:
                r71 r71Var = lh1.L;
                if (z || map != null) {
                    c3.k0(m3Var.l(), new t1(R.xml.preferences_action_volume_bar, map, i3), new to(m3Var, 10), null);
                } else {
                    m3Var.q(new i(n3.volumeBar, lh1.L));
                }
                break;
            default:
                r71 r71Var2 = mh1.N;
                if (z || map != null) {
                    c3.k0(m3Var.l(), new t1(R.xml.preferences_action_volume_bar_swipe, map, i4), new to(m3Var, 11), null);
                } else {
                    m3Var.q(new i(n3.volumeSwipe, mh1.N));
                }
                break;
        }
    }
}
