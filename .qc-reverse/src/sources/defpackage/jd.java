package defpackage;

import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class jd extends g1 {
    public static final l3 k;

    static {
        Boolean bool = Boolean.FALSE;
        wa waVar = new wa();
        waVar.put("GLOBAL_ACTION", 1);
        k = new l3(jd.class, R.string.action_category_general, R.string.action_value_back_button, R.string.action_title_back_button, R.string.action_detail_back_button, R.drawable.icon_action_back_button, 511, 1024, bool, null, waVar);
    }

    @Override // defpackage.g1
    public final void g() {
        this.f.performGlobalAction(1);
    }
}
