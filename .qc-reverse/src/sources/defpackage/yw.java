package defpackage;

import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.TriggerActionsListActivity;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yw implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ yw(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                int i2 = EdgeActionsSettings.S;
                ((j1) obj).u(((bx) obj2).i());
                break;
            case 1:
                int i3 = TrackerActionsSettings.I;
                ((j1) obj).u(((TrackerActionsSettings) obj2).getString(R.string.tracker_actions_settings_title));
                break;
            default:
                j1 j1Var = (j1) obj;
                bk bkVar = TriggerActionsListActivity.G;
                j1Var.u((String) obj2);
                j1Var.o(true);
                break;
        }
    }
}
