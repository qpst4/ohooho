package defpackage;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fr extends iz {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fr(hz hzVar, int i) {
        super(hzVar);
        this.e = i;
    }

    @Override // defpackage.iz
    public void q() {
        switch (this.e) {
            case 0:
                hz hzVar = this.b;
                hzVar.p = null;
                CheckableImageButton checkableImageButton = hzVar.h;
                checkableImageButton.setOnLongClickListener(null);
                xy0.F(checkableImageButton, null);
                break;
        }
    }
}
