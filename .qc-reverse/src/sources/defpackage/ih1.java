package defpackage;

import android.widget.ImageButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ih1 extends ImageButton {
    public int b;

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        a(i, true);
    }
}
