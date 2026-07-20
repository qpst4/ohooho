package defpackage;

import android.content.DialogInterface;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fm0 implements DialogInterface.OnMultiChoiceClickListener {
    public final /* synthetic */ gm0 a;

    public fm0(gm0 gm0Var) {
        this.a = gm0Var;
    }

    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
    public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
        gm0 gm0Var = this.a;
        HashSet hashSet = gm0Var.w0;
        boolean z2 = gm0Var.x0;
        if (z) {
            gm0Var.x0 = hashSet.add(gm0Var.z0[i].toString()) | z2;
        } else {
            gm0Var.x0 = hashSet.remove(gm0Var.z0[i].toString()) | z2;
        }
    }
}
