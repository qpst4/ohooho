package defpackage;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ek extends fp1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ Object g;

    public /* synthetic */ ek(int i, Object obj) {
        this.f = i;
        this.g = obj;
    }

    @Override // defpackage.fp1
    public final void v(int i) {
        switch (this.f) {
            case 0:
                break;
            default:
                a51 a51Var = (a51) this.g;
                a51Var.e = true;
                z41 z41Var = (z41) a51Var.f.get();
                if (z41Var != null) {
                    z41Var.a();
                }
                break;
        }
    }

    @Override // defpackage.fp1
    public final void w(Typeface typeface, boolean z) {
        int i = this.f;
        Object obj = this.g;
        switch (i) {
            case 0:
                Chip chip = (Chip) obj;
                hk hkVar = chip.f;
                chip.setText(hkVar.D0 ? hkVar.F : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    a51 a51Var = (a51) obj;
                    a51Var.e = true;
                    z41 z41Var = (z41) a51Var.f.get();
                    if (z41Var != null) {
                        z41Var.a();
                    }
                    break;
                }
                break;
        }
    }

    private final void L(int i) {
    }
}
