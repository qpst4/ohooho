package defpackage;

import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.AdvancedTriggerActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p4 implements y31 {
    public final /* synthetic */ int b;
    public final Object c;

    public /* synthetic */ p4(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // defpackage.x31
    public final void n(b41 b41Var) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                int i2 = b41Var.e;
                int i3 = AdvancedTriggerActivity.H;
                ((AdvancedTriggerActivity) obj).G(i2);
                break;
            case 1:
                ((mg1) obj).setCurrentItem(b41Var.e);
                break;
            default:
                ((ma1) obj).h0(b41Var.e);
                break;
        }
    }
}
