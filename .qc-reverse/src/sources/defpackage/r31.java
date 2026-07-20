package defpackage;

import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class r31 extends g1 {
    public static final l3 k;

    static {
        Boolean bool = Boolean.FALSE;
        wi0 wi0Var = new wi0();
        wi0Var.put("GLOBAL_ACTION", 3);
        k = new l3(r31.class, R.string.action_category_general, R.string.action_value_switch_to_prev_app, R.string.action_title_switch_to_prev_app, R.string.action_detail_switch_to_prev_app, R.drawable.icon_action_switch_to_prev_app, 511, 1024, bool, null, wi0Var);
    }

    @Override // defpackage.g1
    public final void g() {
        this.f.performGlobalAction(3);
        b61.b(new lk0(10, this), 300L);
    }
}
