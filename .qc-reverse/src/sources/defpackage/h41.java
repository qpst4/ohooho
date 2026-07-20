package defpackage;

import android.os.Build;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class h41 extends g1 {
    public static final l3 k;

    static {
        Boolean bool = Boolean.FALSE;
        wi0 wi0Var = new wi0();
        wi0Var.put("GLOBAL_ACTION", 9);
        k = new l3(h41.class, R.string.action_category_general, R.string.action_value_take_screenshot, R.string.action_title_take_screenshot, R.string.action_detail_take_screenshot, R.drawable.icon_action_take_screenshot, 511, 1040, bool, null, wi0Var);
    }

    @Override // defpackage.g1
    public final void g() {
        if (Build.VERSION.SDK_INT >= 28) {
            b61.b(new g41(this, 0), 1L);
        }
    }
}
