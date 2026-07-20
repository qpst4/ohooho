package defpackage;

import android.media.AudioManager;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class nk0 extends g1 {
    public static final wi0 k;
    public static final l3 l;

    static {
        wi0 wi0Var = new wi0();
        Boolean bool = Boolean.TRUE;
        wi0Var.put("showUI", bool);
        k = wi0Var;
        l = new l3(nk0.class, R.string.action_category_media, R.string.action_value_media_mute_toggle, R.string.action_title_media_mute_toggle, R.string.action_detail_media_mute_toggle, R.drawable.icon_action_media_mute_toggle, 511, 0, bool, new zy(19), null);
    }

    @Override // defpackage.g1
    public final void g() {
        ((AudioManager) App.c.getSystemService("audio")).adjustStreamVolume(3, 101, ((Boolean) this.g.get("showUI")).booleanValue() ? 1 : 0);
    }
}
