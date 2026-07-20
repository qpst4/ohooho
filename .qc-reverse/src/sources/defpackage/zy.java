package defpackage;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import com.quickcursor.R;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zy implements k3, l81 {
    public final /* synthetic */ int b;

    public /* synthetic */ zy(int i) {
        this.b = i;
    }

    public static /* synthetic */ void a() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void b(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append((Object) " is a reserved key for the encryption keyset.");
        throw new SecurityException(sb.toString());
    }

    public static /* synthetic */ void d(Object obj, Object obj2, Object obj3, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        throw new IllegalStateException(sb.toString(), th);
    }

    public static /* synthetic */ void e(Object obj, Object obj2, String str) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void f(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void g(String str, int i) {
        throw new IllegalStateException(str + i);
    }

    public static /* synthetic */ void h(String str, Object obj) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void k(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalStateException(str + obj + obj2 + obj3 + obj4);
    }

    public static /* synthetic */ void l(String str, Throwable th) {
        throw new RuntimeException(str, th);
    }

    public static /* synthetic */ void m(Throwable th) {
        throw new RuntimeException(th);
    }

    public static /* synthetic */ void n(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void o(String str, Object obj) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void p(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void q(String str, Object obj) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void r(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void s(String str, Object obj) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void t(String str, Object obj) {
        throw new IllegalStateException(str + obj);
    }

    @Override // defpackage.k3
    public void c(final m3 m3Var, final n3 n3Var, boolean z, HashMap map) {
        int i = 4;
        int i2 = 6;
        final int i3 = 1;
        final int i4 = 0;
        switch (this.b) {
            case 1:
                j00.m(m3Var, n3Var, Boolean.valueOf(z), map);
                break;
            case 2:
                h60.m(m3Var, n3Var, Boolean.valueOf(z), map);
                break;
            case 4:
                wa waVar = o60.k;
                if (!z && map == null) {
                    new ih0(lc1.K(R.string.action_gesture_swipe_dialog_direction_title), jh0.a(Integer.valueOf(R.array.action_gesture_swipe_direction_titles), Integer.valueOf(R.array.action_gesture_swipe_direction_descriptions), Integer.valueOf(R.array.action_gesture_swipe_direction_values), Integer.valueOf(R.array.action_gesture_swipe_direction_icons)), new to(m3Var, i3)).j0(m3Var.l(), "ListPickerDialogFragment");
                } else {
                    c3.k0(m3Var.l(), new d3(R.xml.preferences_action_gesture_swipe, map), new to(m3Var, 2), null);
                }
                break;
            case 14:
                l3 l3Var = kf0.k;
                if (!z && map == null) {
                    Boolean bool = Boolean.FALSE;
                    new ya(new to(m3Var, 3), 1, bool, bool, null).j0(m3Var.l(), "AppPickerDialogFragment");
                } else {
                    lf0 lf0Var = new lf0(R.xml.preferences_action_launch_app, map, i4);
                    c3.k0(m3Var.l(), lf0Var, new to(m3Var, i), new c(28, lf0Var));
                }
                break;
            case 15:
                wa waVar2 = mf0.k;
                if (!z && map == null) {
                    m3Var.q(new i(n3Var, mf0.k));
                } else {
                    c3.k0(m3Var.l(), new d3(R.xml.preferences_action_launch_assistant, map), new eh(m3Var, n3Var, i), null);
                }
                break;
            case 16:
                l3 l3Var2 = pf0.k;
                Boolean bool2 = Boolean.FALSE;
                new ya(new to(m3Var, 5), 3, bool2, bool2, null).j0(m3Var.l(), "AppPickerDialogFragment");
                break;
            case 17:
                wa waVar3 = xi0.k;
                if (!z && map == null) {
                    m3Var.q(new i(n3Var, xi0.k));
                } else {
                    c3.k0(m3Var.l(), new d3(R.xml.preferences_action_long_tap, map), new to(m3Var, i2), null);
                }
                break;
            case 18:
                l3 l3Var3 = aj0.k;
                if (!f01.C("com.arlosoft.macrodroid")) {
                    f01.I("com.arlosoft.macrodroid");
                } else {
                    ComponentName componentName = new ComponentName("com.arlosoft.macrodroid", "com.arlosoft.macrodroid.ShortcutActivity");
                    Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setComponent(componentName);
                    l3 l3Var4 = o41.k;
                    m3Var.n(intent, new qs(m3Var, n3Var, intent, i2));
                }
                break;
            case 19:
                wi0 wi0Var = nk0.k;
                if (!z && map == null) {
                    m3Var.q(new i(n3Var, nk0.k));
                } else {
                    jl1 jl1Var = new jl1(m3Var.o());
                    jl1Var.m(R.string.action_volume_bar_show_ui_title);
                    jl1Var.g(R.string.action_volume_bar_dialog_panel_message);
                    jl1Var.k(R.string.dialog_button_yes, new DialogInterface.OnClickListener() { // from class: mk0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i5) {
                            int i6 = i4;
                            n3 n3Var2 = n3Var;
                            m3 m3Var2 = m3Var;
                            switch (i6) {
                                case 0:
                                    wi0 wi0Var2 = nk0.k;
                                    wi0 wi0Var3 = new wi0();
                                    wi0Var3.put("showUI", Boolean.TRUE);
                                    m3Var2.q(new i(n3Var2, wi0Var3));
                                    break;
                                default:
                                    wi0 wi0Var4 = nk0.k;
                                    wi0 wi0Var5 = new wi0();
                                    wi0Var5.put("showUI", Boolean.FALSE);
                                    m3Var2.q(new i(n3Var2, wi0Var5));
                                    break;
                            }
                        }
                    });
                    jl1Var.h(R.string.dialog_button_no, new DialogInterface.OnClickListener() { // from class: mk0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i5) {
                            int i6 = i3;
                            n3 n3Var2 = n3Var;
                            m3 m3Var2 = m3Var;
                            switch (i6) {
                                case 0:
                                    wi0 wi0Var2 = nk0.k;
                                    wi0 wi0Var3 = new wi0();
                                    wi0Var3.put("showUI", Boolean.TRUE);
                                    m3Var2.q(new i(n3Var2, wi0Var3));
                                    break;
                                default:
                                    wi0 wi0Var4 = nk0.k;
                                    wi0 wi0Var5 = new wi0();
                                    wi0Var5.put("showUI", Boolean.FALSE);
                                    m3Var2.q(new i(n3Var2, wi0Var5));
                                    break;
                            }
                        }
                    });
                    jl1Var.n();
                }
                break;
            case 20:
                vk0.n(m3Var, n3Var, Boolean.valueOf(z), map);
                break;
            default:
                hm0.p(m3Var, n3Var, map);
                break;
        }
    }

    @Override // defpackage.l81
    public void j(j81 j81Var) {
        l60.b(j81Var.b, j81Var.c, j81Var.d + 1);
    }
}
