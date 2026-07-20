package defpackage;

import android.content.Context;
import android.content.Intent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class pf0 extends g1 {
    public static final l3 k = new l3(pf0.class, R.string.action_category_launch, R.string.action_value_launch_shortcut, R.string.action_title_launch_shortcut, R.string.action_detail_launch_shortcut, R.drawable.icon_action_launch_shortcut, 511, 0, Boolean.FALSE, new zy(16), null);

    @Override // defpackage.g1
    public final void g() {
        Context context = App.c;
        try {
            Intent uri = Intent.parseUri((String) this.g.get("intent"), 0);
            try {
                if (uri.getComponent().getPackageName().equals("com.whatsapp") && uri.getComponent().getClassName().equals("com.whatsapp.Conversation")) {
                    try {
                        si0.a("Trying WhatsApp workaround.");
                        Intent uri2 = Intent.parseUri((String) this.g.get("intent"), 0);
                        uri2.addFlags(268435456);
                        uri2.setAction("com.whatsapp.Conversation");
                        context.startActivity(uri2);
                        return;
                    } catch (Exception e) {
                        si0.b("WhatsApp workaround not working: " + e);
                        uri.addFlags(268435456);
                        context.startActivity(uri);
                    }
                }
            } catch (Exception unused) {
                si0.a("WhatsApp workaround issue.");
            }
            uri.addFlags(268435456);
            context.startActivity(uri);
        } catch (Exception e2) {
            si0.b("LaunchShortcutAction onDispatch error: " + e2.getMessage());
        }
    }
}
