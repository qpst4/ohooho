package defpackage;

import android.media.AudioManager;
import com.quickcursor.App;
import com.quickcursor.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class vk0 extends g1 {
    public static final wi0 k;
    public static final l3 l;

    static {
        wi0 wi0Var = new wi0();
        wi0Var.put("showUI", dn.U1);
        wi0Var.put("steps", dn.q2);
        k = wi0Var;
        l = new l3(vk0.class, R.string.action_category_media, R.string.action_value_media_volume_increase, R.string.action_title_media_volume_increase, R.string.action_detail_media_volume_increase, R.drawable.icon_action_media_volume_increase, 511, 0, Boolean.TRUE, new zy(20), null);
    }

    public static void m(HashMap map, int i) {
        AudioManager audioManager = (AudioManager) App.c.getSystemService("audio");
        boolean zBooleanValue = ((Boolean) map.get("showUI")).booleanValue();
        int iIntValue = xy0.q(1, map.get("steps")).intValue();
        for (int i2 = 0; i2 < iIntValue; i2++) {
            audioManager.adjustStreamVolume(3, i, zBooleanValue ? 1 : 0);
        }
    }

    public static void n(m3 m3Var, n3 n3Var, Boolean bool, Map map) {
        if (bool.booleanValue() || map != null) {
            c3.k0(m3Var.l(), new d3(R.xml.preferences_action_media_volume, map), new eh(m3Var, n3Var, 5), null);
        } else {
            m3Var.q(new i(n3Var, k));
        }
    }

    @Override // defpackage.g1
    public final void g() {
        m(this.g, 1);
    }
}
