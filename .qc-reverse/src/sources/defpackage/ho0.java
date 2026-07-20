package defpackage;

import android.os.Build;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ho0 extends g1 {
    public static final l3 k;

    static {
        Boolean bool = Boolean.FALSE;
        wi0 wi0Var = new wi0();
        wi0Var.put("GLOBAL_ACTION", 14);
        k = new l3(ho0.class, R.string.action_category_general, R.string.action_value_open_app_drawer, R.string.action_title_open_app_drawer, R.string.action_detail_open_app_drawer, R.drawable.icon_action_open_app_drawer, 511, 3072, bool, null, wi0Var);
    }

    @Override // defpackage.g1
    public final void g() {
        if (Build.VERSION.SDK_INT >= 31) {
            this.f.performGlobalAction(14);
        }
    }
}
