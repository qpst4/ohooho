package defpackage;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fk extends ViewOutlineProvider {
    public final /* synthetic */ Chip a;

    public fk(Chip chip) {
        this.a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        hk hkVar = this.a.f;
        if (hkVar != null) {
            hkVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
