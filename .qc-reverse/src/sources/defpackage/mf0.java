package defpackage;

import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class mf0 extends g1 {
    public static final wa k;
    public static final l3 l;

    static {
        wa waVar = new wa();
        waVar.put("hideCursor", dn.W1);
        k = waVar;
        l = new l3(mf0.class, R.string.action_category_launch, R.string.action_value_launch_assistant, R.string.action_title_launch_assistant, R.string.action_detail_launch_assistant, R.drawable.icon_action_launch_assistant, 511, 0, Boolean.TRUE, new zy(15), null);
    }

    @Override // defpackage.g1
    public final void g() {
        if (((Boolean) this.g.getOrDefault("hideCursor", dn.W1)).booleanValue()) {
            b61.b(new c(29, this), 1L);
            return;
        }
        Intent intent = new Intent("android.intent.action.VOICE_COMMAND");
        intent.setFlags(268435456);
        App.c.startActivity(intent);
    }
}
