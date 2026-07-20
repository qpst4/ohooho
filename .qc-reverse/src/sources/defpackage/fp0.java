package defpackage;

import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class fp0 extends j30 implements hp0 {
    public final ArrayList Y = new ArrayList();

    @Override // defpackage.j30
    public final void V(View view, Bundle bundle) {
        this.Y.addAll(lc1.u(view));
    }

    @Override // defpackage.hp0
    public final void d(float f) {
        lc1.i0(this.Y, f);
    }
}
