package defpackage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class m01 extends g1 {
    public static final l3 k = new l3(m01.class, R.string.action_category_shortcut, R.string.action_value_shortcut_trigger_cursor, R.string.action_title_shortcut_trigger_cursor, R.string.action_detail_shortcut_trigger_cursor, R.drawable.icon_action_trigger_cursor, 256, 0, Boolean.TRUE, new ay0(2), null);

    public static f91 m(HashMap map) {
        String strValueOf = String.valueOf(map.get("trigger"));
        if (strValueOf.isEmpty() || strValueOf.equals("null")) {
            strValueOf = String.valueOf(map.get("zone"));
        }
        int i = Integer.parseInt(strValueOf);
        Integer numValueOf = Integer.valueOf(i);
        if (i == -2) {
            yb0.y(R.string.shortcut_error_invalid, 0);
            return null;
        }
        uv0 uv0VarA = xv0.d.a();
        if (i == -1 && !uv0VarA.p()) {
            yb0.y(R.string.shortcut_error_trigger_doesnt_exist, 0);
            return null;
        }
        if (uv0VarA.p()) {
            return uv0VarA.e().d();
        }
        f91 f91VarJ = uv0VarA.j(numValueOf);
        if (f91VarJ == null) {
            yb0.y(R.string.shortcut_error_trigger_doesnt_exist, 0);
        }
        return f91VarJ;
    }

    public static boolean n(HashMap map) {
        try {
            l01 l01VarValueOf = l01.valueOf((String) map.get("timeout"));
            if (l01VarValueOf == l01.auto) {
                if (oq0.c((SharedPreferences) pn0.t().d, oq0.Q) <= 1000) {
                    return false;
                }
            } else if (l01VarValueOf != l01.enabled) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static void o(m3 m3Var, n3 n3Var, Boolean bool) {
        xv0 xv0Var = xv0.d;
        if (xv0Var.a().p()) {
            p(m3Var, n3Var, bool, "-1");
            return;
        }
        List listK = xv0Var.a().k();
        ArrayList arrayList = new ArrayList();
        Iterator it = listK.iterator();
        int i = 0;
        while (it.hasNext()) {
            arrayList.add(new jh0(((f91) it.next()).g(), "", i + "", null));
            i++;
        }
        new ih0(lc1.K(R.string.shortcut_choose_trigger_title), arrayList, new qs(m3Var, n3Var, bool, 5)).j0(m3Var.l(), "ListPickerDialogFragment");
    }

    public static void p(final m3 m3Var, final n3 n3Var, Boolean bool, final String str) {
        if (!bool.booleanValue()) {
            wi0 wi0Var = new wi0();
            wi0Var.put("trigger", str);
            wi0Var.put("timeout", l01.auto.toString());
            m3Var.q(new i(n3Var, wi0Var));
            return;
        }
        jl1 jl1Var = new jl1(m3Var.o());
        jl1Var.m(R.string.action_shortcut_trigger_cursor_timeout_dialog_title);
        jl1Var.g(R.string.action_shortcut_trigger_cursor_timeout_dialog_message);
        final int i = 0;
        jl1Var.k(R.string.dialog_button_yes, new DialogInterface.OnClickListener() { // from class: k01
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                int i3 = i;
                String str2 = str;
                n3 n3Var2 = n3Var;
                m3 m3Var2 = m3Var;
                switch (i3) {
                    case 0:
                        l3 l3Var = m01.k;
                        wi0 wi0Var2 = new wi0();
                        wi0Var2.put("trigger", str2);
                        wi0Var2.put("timeout", l01.enabled.toString());
                        m3Var2.q(new i(n3Var2, wi0Var2));
                        break;
                    default:
                        l3 l3Var2 = m01.k;
                        wi0 wi0Var3 = new wi0();
                        wi0Var3.put("trigger", str2);
                        wi0Var3.put("timeout", l01.disabled.toString());
                        m3Var2.q(new i(n3Var2, wi0Var3));
                        break;
                }
            }
        });
        final int i2 = 1;
        jl1Var.h(R.string.dialog_button_no, new DialogInterface.OnClickListener() { // from class: k01
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                int i3 = i2;
                String str2 = str;
                n3 n3Var2 = n3Var;
                m3 m3Var2 = m3Var;
                switch (i3) {
                    case 0:
                        l3 l3Var = m01.k;
                        wi0 wi0Var2 = new wi0();
                        wi0Var2.put("trigger", str2);
                        wi0Var2.put("timeout", l01.enabled.toString());
                        m3Var2.q(new i(n3Var2, wi0Var2));
                        break;
                    default:
                        l3 l3Var2 = m01.k;
                        wi0 wi0Var3 = new wi0();
                        wi0Var3.put("trigger", str2);
                        wi0Var3.put("timeout", l01.disabled.toString());
                        m3Var2.q(new i(n3Var2, wi0Var3));
                        break;
                }
            }
        });
        jl1Var.n();
    }

    @Override // defpackage.g1
    public final void g() {
        f91 f91VarM = m(this.g);
        boolean zN = n(this.g);
        if (f91VarM != null) {
            if (CursorAccessibilityService.e()) {
                CursorAccessibilityService.q.o.A(f91VarM, zN);
            } else {
                yb0.y(R.string.shortcut_error_app_off, 0);
            }
        }
    }
}
