package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class d40 extends fp0 {
    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i = this.h.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_THEME_RES");
        return layoutInflater.cloneInContext(i != 0 ? new io(t(), i) : t()).inflate(this.h.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_LAYOUT_RES"), viewGroup, false);
    }
}
