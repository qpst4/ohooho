package defpackage;

import com.quickcursor.android.activities.settings.EdgeActionsSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ EdgeActionsSettings c;

    public /* synthetic */ zw(EdgeActionsSettings edgeActionsSettings, int i) {
        this.b = i;
        this.c = edgeActionsSettings;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        EdgeActionsSettings edgeActionsSettings = this.c;
        switch (i) {
            case 0:
                int i2 = EdgeActionsSettings.S;
                edgeActionsSettings.H();
                break;
            default:
                int i3 = EdgeActionsSettings.S;
                edgeActionsSettings.K();
                break;
        }
    }
}
