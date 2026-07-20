package defpackage;

import android.os.Build;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class li0 extends g1 {
    public static final l3 k;

    static {
        Boolean bool = Boolean.FALSE;
        wa waVar = new wa();
        waVar.put("GLOBAL_ACTION", 8);
        k = new l3(li0.class, R.string.action_category_general, R.string.action_value_lock_screen, R.string.action_title_lock_screen, R.string.action_detail_lock_screen, R.drawable.icon_action_lock_screen, 511, 1040, bool, null, waVar);
    }

    @Override // defpackage.g1
    public final void g() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f.performGlobalAction(8);
        }
    }
}
