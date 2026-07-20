package defpackage;

import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q00 implements u00 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ExtendedFloatingActionButton c;

    public /* synthetic */ q00(ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        this.b = i;
        this.c = extendedFloatingActionButton;
    }

    @Override // defpackage.u00
    public final int b() {
        int i = this.b;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.c;
        switch (i) {
            case 0:
                return extendedFloatingActionButton.getCollapsedSize();
            default:
                return extendedFloatingActionButton.getMeasuredHeight();
        }
    }

    @Override // defpackage.u00
    public final int c() {
        int i = this.b;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.c;
        switch (i) {
            case 0:
                return extendedFloatingActionButton.getCollapsedPadding();
            default:
                return extendedFloatingActionButton.B;
        }
    }

    @Override // defpackage.u00
    public final int d() {
        int i = this.b;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.c;
        switch (i) {
            case 0:
                return extendedFloatingActionButton.getCollapsedPadding();
            default:
                return extendedFloatingActionButton.A;
        }
    }

    @Override // defpackage.u00
    public final int i() {
        int i = this.b;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.c;
        switch (i) {
            case 0:
                return extendedFloatingActionButton.getCollapsedSize();
            default:
                return (extendedFloatingActionButton.getMeasuredWidth() - (extendedFloatingActionButton.getCollapsedPadding() * 2)) + extendedFloatingActionButton.A + extendedFloatingActionButton.B;
        }
    }

    @Override // defpackage.u00
    public final ViewGroup.LayoutParams j() {
        switch (this.b) {
            case 0:
                ExtendedFloatingActionButton extendedFloatingActionButton = this.c;
                return new ViewGroup.LayoutParams(extendedFloatingActionButton.getCollapsedSize(), extendedFloatingActionButton.getCollapsedSize());
            default:
                return new ViewGroup.LayoutParams(-2, -2);
        }
    }
}
