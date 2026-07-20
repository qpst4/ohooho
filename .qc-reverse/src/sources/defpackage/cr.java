package defpackage;

import android.view.MotionEvent;
import android.view.View;
import com.quickcursor.android.activities.settings.TrackerActionsSettings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cr implements View.OnTouchListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cr(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((er) obj).a(Math.min(1.0f, Math.max(0.0f, motionEvent.getX() / r4.e)), Math.min(1.0f, Math.max(0.0f, motionEvent.getY() / r4.f)));
                return false;
            case 1:
                ev evVar = (ev) obj;
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - evVar.o;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        evVar.m = false;
                    }
                    evVar.t();
                    evVar.m = true;
                    evVar.o = System.currentTimeMillis();
                }
                return false;
            default:
                TrackerActionsSettings trackerActionsSettings = (TrackerActionsSettings) obj;
                int i2 = TrackerActionsSettings.I;
                if (motionEvent.getAction() == 0) {
                    int iK = trackerActionsSettings.E.k(motionEvent.getX(), motionEvent.getY());
                    if (iK == trackerActionsSettings.G) {
                        trackerActionsSettings.onBackPressed();
                    } else if (iK < trackerActionsSettings.H.size()) {
                        trackerActionsSettings.H((j71) trackerActionsSettings.H.get(iK));
                    } else {
                        trackerActionsSettings.I();
                    }
                }
                return true;
        }
    }
}
