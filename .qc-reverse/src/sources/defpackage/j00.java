package defpackage;

import android.accessibilityservice.AccessibilityService;
import com.quickcursor.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class j00 extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("expandToggle", dn.V1);
        k = waVar;
        Boolean bool = Boolean.TRUE;
        zy zyVar = new zy(1);
        wa waVar2 = new wa();
        waVar2.put("GLOBAL_ACTION", 4);
        l = new l3(j00.class, R.string.action_category_general, R.string.action_value_expand_notifications, R.string.action_title_expand_notifications, R.string.action_detail_expand_notifications, R.drawable.icon_action_expand_notifications, 511, 1024, bool, zyVar, waVar2);
    }

    public static void m(m3 m3Var, n3 n3Var, Boolean bool, Map map) {
        if (bool.booleanValue() || map != null) {
            c3.k0(m3Var.l(), new k00(R.xml.preferences_action_expand_notifications_extra, map, 0), new eh(m3Var, n3Var, 2), null);
        } else {
            m3Var.q(new i(n3Var, k));
        }
    }

    public static void n(AccessibilityService accessibilityService, HashMap map, int i) {
        boolean zBooleanValue = dn.V1.booleanValue();
        if (map != null && map.containsKey("expandToggle")) {
            zBooleanValue = ((Boolean) map.get("expandToggle")).booleanValue();
        }
        if (!zBooleanValue) {
            accessibilityService.performGlobalAction(i);
        } else {
            if (accessibilityService.performGlobalAction(15)) {
                return;
            }
            accessibilityService.performGlobalAction(i);
        }
    }

    @Override // defpackage.g1
    public final void g() {
        n(this.f, this.g, 4);
    }
}
