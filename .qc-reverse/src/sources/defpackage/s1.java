package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.BuyProActivity;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s1 implements zp0, k3, zr0, jn0 {
    public final /* synthetic */ int b;

    public /* synthetic */ s1(int i) {
        this.b = i;
    }

    public static /* synthetic */ void d() {
        throw new ClassCastException();
    }

    public static /* synthetic */ void e(Object obj, Object obj2, String str) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void f(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void g(String str, int i, Object obj) {
        throw new IllegalArgumentException(str + i + obj);
    }

    public static /* synthetic */ void i(String str, long j) {
        throw new IllegalArgumentException(str + j);
    }

    public static /* synthetic */ void j(String str, Object obj) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void k(String str, Object obj, Throwable th) {
        throw new SecurityException(str + obj, th);
    }

    public static /* synthetic */ void l(String str) throws GeneralSecurityException {
        throw new GeneralSecurityException(str);
    }

    public static /* synthetic */ void m(String str, int i, Object obj) {
        throw new IllegalArgumentException((str + i + obj).toString());
    }

    public static /* synthetic */ void n(String str, Object obj) {
        throw new rd0(str + ((Object) obj.toString()));
    }

    public static void o(df dfVar) {
        si0.b("acknowledgePurchase billingResult.getResponseCode() = " + dfVar.a);
    }

    @Override // defpackage.zp0
    public boolean a(Preference preference, Object obj) {
        switch (this.b) {
            case 0:
                be.valueOf((String) obj);
                break;
            default:
                b61.b(new s4(6), 100L);
                break;
        }
        return true;
    }

    @Override // defpackage.zr0
    public void b(df dfVar, List list) {
        int i = BuyProActivity.H;
    }

    @Override // defpackage.k3
    public void c(m3 m3Var, n3 n3Var, boolean z, HashMap map) {
        int i = 0;
        switch (this.b) {
            case 1:
                l3 l3Var = id.k;
                if (!f01.C("com.llamalab.automate")) {
                    f01.I("com.llamalab.automate");
                } else {
                    ComponentName componentName = new ComponentName("com.llamalab.automate", "com.llamalab.automate.FlowShortcutCreateActivity");
                    Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setComponent(componentName);
                    l3 l3Var2 = o41.k;
                    m3Var.n(intent, new qs(m3Var, n3Var, intent, 6));
                }
                break;
            case 4:
                int i2 = gh.I;
                if (!z && map == null) {
                    m3Var.q(new i(n3.brightnessBar, gh.J));
                } else {
                    c3.k0(m3Var.l(), new hh(R.xml.preferences_action_brightness_bar, map, i), new eh(m3Var, n3Var, i), null);
                }
                break;
            case 5:
                wa waVar = lh.L;
                if (!z && map == null) {
                    m3Var.q(new i(n3.brightnessSwipe, lh.L));
                } else {
                    int i3 = 1;
                    c3.k0(m3Var.l(), new ih(R.xml.preferences_action_brightness_bar_swipe, map, i3), new eh(m3Var, n3Var, i3), null);
                }
                break;
            case 23:
                wa waVar2 = vo.k;
                if (!z && map == null) {
                    m3Var.q(new i(n3.copy, vo.k));
                } else {
                    new ih0(lc1.K(R.string.action_copy_dialog_mode_title), jh0.a(Integer.valueOf(R.array.action_copy_mode_titles), Integer.valueOf(R.array.action_copy_mode_descriptions), Integer.valueOf(R.array.action_copy_mode_values), null), new to(m3Var, i)).j0(m3Var.l(), "ListPickerDialogFragment");
                }
                break;
            default:
                wa waVar3 = qu.k;
                if (!z && map == null) {
                    m3Var.q(new i(n3Var, qu.k));
                } else {
                    hm0.p(m3Var, n3Var, map);
                }
                break;
        }
    }

    @Override // defpackage.jn0
    public Object h() {
        switch (this.b) {
            case 14:
                return new zg0(true);
            case 15:
                return new LinkedHashMap();
            case 16:
                return new TreeMap();
            case 17:
                return new ConcurrentHashMap();
            case 18:
                return new ConcurrentSkipListMap();
            case 19:
                return new ArrayList();
            case 20:
                return new LinkedHashSet();
            case 21:
                return new TreeSet();
            default:
                return new ArrayDeque();
        }
    }

    public /* synthetic */ s1(ir irVar, int i) {
        this.b = i;
    }
}
