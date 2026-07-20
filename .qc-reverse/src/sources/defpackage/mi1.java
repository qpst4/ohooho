package defpackage;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class mi1 extends li1 {
    public mi1(wi1 wi1Var, WindowInsets windowInsets) {
        super(wi1Var, windowInsets);
    }

    @Override // defpackage.ri1
    public wi1 a() {
        return wi1.h(null, this.c.consumeDisplayCutout());
    }

    @Override // defpackage.ri1
    public ku e() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new ku(displayCutout);
    }

    @Override // defpackage.ki1, defpackage.ri1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mi1)) {
            return false;
        }
        mi1 mi1Var = (mi1) obj;
        return Objects.equals(this.c, mi1Var.c) && Objects.equals(this.g, mi1Var.g) && ki1.y(this.h, mi1Var.h);
    }

    @Override // defpackage.ri1
    public int hashCode() {
        return this.c.hashCode();
    }
}
