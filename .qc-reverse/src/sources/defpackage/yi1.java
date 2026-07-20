package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yi1 extends xi1 {
    @Override // defpackage.xy0
    public final void D(boolean z) {
        if (!z) {
            P(16);
            return;
        }
        Window window = this.l;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
    }
}
