package defpackage;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ActionBarOverlayLayout c;

    public /* synthetic */ n1(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.b = i;
        this.c = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        switch (i) {
            case 0:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY(0.0f).setListener(actionBarOverlayLayout.y);
                break;
            default:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY(-actionBarOverlayLayout.e.getHeight()).setListener(actionBarOverlayLayout.y);
                break;
        }
    }
}
