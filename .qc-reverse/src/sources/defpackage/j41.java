package defpackage;

import com.quickcursor.android.activities.settings.TapBehaviourSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j41 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ TapBehaviourSettings.a c;

    public /* synthetic */ j41(TapBehaviourSettings.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        TapBehaviourSettings.a aVar = this.c;
        switch (i) {
            case 0:
                aVar.l0.J();
                break;
            case 1:
                aVar.h0(oq0.L.name()).w();
                break;
            case 2:
                aVar.h0("hideTimeoutThreshold").w();
                break;
            case 3:
                aVar.h0(oq0.O0.name()).w();
                break;
            default:
                aVar.h0(oq0.Q0.name()).w();
                break;
        }
    }
}
