package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends ClickableSpan {
    public final int b;
    public final n0 c;
    public final int d;

    public w(int i, n0 n0Var, int i2) {
        this.b = i;
        this.c = n0Var;
        this.d = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.b);
        this.c.a.performAction(this.d, bundle);
    }
}
