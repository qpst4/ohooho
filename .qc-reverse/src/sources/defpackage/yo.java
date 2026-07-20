package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yo implements jj0 {
    public final /* synthetic */ zo a;

    public yo(zo zoVar) {
        this.a = zoVar;
    }

    @Override // defpackage.jj0
    public final void a(g7 g7Var, vm0 vm0Var) {
        String str = ((u41) vm0Var).f;
        ((r11) g7Var.b).b.append(str);
        ArrayList arrayList = this.a.a;
        if (arrayList.isEmpty()) {
            return;
        }
        g7Var.o();
        str.getClass();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
    }
}
