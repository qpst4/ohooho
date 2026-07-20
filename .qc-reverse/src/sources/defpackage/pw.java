package defpackage;

import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ qw c;

    public /* synthetic */ pw(qw qwVar, int i) {
        this.b = i;
        this.c = qwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        qw qwVar = this.c;
        switch (i) {
            case 0:
                ((EdgeActionsSettings) qwVar.Z()).L(qwVar.i0.getEdgeBar());
                break;
            default:
                EdgeActionsSettings edgeActionsSettings = (EdgeActionsSettings) qwVar.u();
                EdgeBarConstraintLayout edgeBarConstraintLayout = qwVar.i0;
                edgeActionsSettings.getClass();
                edgeBarConstraintLayout.m(null);
                edgeActionsSettings.M(edgeBarConstraintLayout);
                break;
        }
    }
}
