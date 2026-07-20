package defpackage;

import com.quickcursor.android.activities.settings.TrackerActionsSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u71 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ w71 c;

    public /* synthetic */ u71(w71 w71Var, int i) {
        this.b = i;
        this.c = w71Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        w71 w71Var = this.c;
        switch (i) {
            case 0:
                w71Var.h0("trackerActionsTriggerDelay").w();
                break;
            default:
                ((TrackerActionsSettings) w71Var.Z()).K();
                break;
        }
    }
}
