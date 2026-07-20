package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class xi1 extends xy0 {
    public final Window l;

    public xi1(Window window, c70 c70Var) {
        this.l = window;
    }

    @Override // defpackage.xy0
    public final void E(boolean z) {
        if (!z) {
            P(8192);
            return;
        }
        Window window = this.l;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
    }

    public final void P(int i) {
        View decorView = this.l.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
