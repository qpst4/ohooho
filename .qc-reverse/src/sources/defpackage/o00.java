package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o00 extends sp1 {
    public final /* synthetic */ gk f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o00(gk gkVar) {
        super(1);
        this.f = gkVar;
    }

    @Override // defpackage.sp1
    public final n0 u(int i) {
        return new n0(AccessibilityNodeInfo.obtain(this.f.n(i).a));
    }

    @Override // defpackage.sp1
    public final n0 v(int i) {
        gk gkVar = this.f;
        int i2 = i == 2 ? gkVar.k : gkVar.l;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return u(i2);
    }

    @Override // defpackage.sp1
    public final boolean y(int i, int i2, Bundle bundle) {
        int i3;
        gk gkVar = this.f;
        Chip chip = gkVar.i;
        if (i == -1) {
            WeakHashMap weakHashMap = uf1.a;
            return chip.performAccessibilityAction(i2, bundle);
        }
        if (i2 == 1) {
            return gkVar.o(i);
        }
        if (i2 == 2) {
            return gkVar.j(i);
        }
        boolean z = false;
        if (i2 == 64) {
            AccessibilityManager accessibilityManager = gkVar.h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = gkVar.k) == i) {
                return false;
            }
            if (i3 != Integer.MIN_VALUE) {
                gkVar.k = Integer.MIN_VALUE;
                chip.invalidate();
                gkVar.p(i3, 65536);
            }
            gkVar.k = i;
            chip.invalidate();
            gkVar.p(i, 32768);
            return true;
        }
        if (i2 == 128) {
            if (gkVar.k != i) {
                return false;
            }
            gkVar.k = Integer.MIN_VALUE;
            chip.invalidate();
            gkVar.p(i, 65536);
            return true;
        }
        Chip chip2 = gkVar.n;
        if (i2 == 16) {
            if (i == 0) {
                return chip2.performClick();
            }
            if (i == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.i;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z = true;
                }
                if (chip2.t) {
                    chip2.s.p(1, 1);
                }
            }
        }
        return z;
    }
}
