package defpackage;

import android.app.NotificationManager;
import android.media.AudioManager;
import com.quickcursor.App;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class o61 extends g1 {
    public static final wi0 k;
    public static final l3 l;

    static {
        wi0 wi0Var = new wi0();
        wi0Var.put("profiles", "0,1,2");
        k = wi0Var;
        l = new l3(o61.class, R.string.action_category_settings, R.string.action_value_toggle_sound_profile, R.string.action_title_toggle_sound_profile, R.string.action_detail_toggle_sound_profile, R.drawable.icon_action_toggle_sound_profile, 511, 8, Boolean.TRUE, new ay0(8), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    @Override // defpackage.g1
    public final void g() {
        ?? AsList;
        if (!((NotificationManager) App.c.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
            yb0.y(R.string.action_require_do_not_disturb_permission, 0);
            return;
        }
        AudioManager audioManager = (AudioManager) App.c.getSystemService("audio");
        try {
            String[] strArrSplit = ((String) this.g.get("profiles")).split(",");
            AsList = new ArrayList();
            for (String str : strArrSplit) {
                if (!str.isEmpty()) {
                    AsList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
        } catch (Exception unused) {
            AsList = Arrays.asList(0, 1, 2);
        }
        if (AsList.isEmpty()) {
            AsList.add(2);
        }
        if (AsList.size() == 1) {
            audioManager.setRingerMode(((Integer) AsList.get(0)).intValue());
            return;
        }
        int ringerMode = audioManager.getRingerMode();
        for (int i = 1; i <= 3; i++) {
            int i2 = (ringerMode + i) % 3;
            if (AsList.contains(Integer.valueOf(i2))) {
                audioManager.setRingerMode(i2);
                return;
            }
        }
    }
}
