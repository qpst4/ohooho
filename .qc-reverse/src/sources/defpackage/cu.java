package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class cu extends gt {
    public int m;

    public cu(oh1 oh1Var) {
        super(oh1Var);
        if (oh1Var instanceof q80) {
            this.e = 2;
        } else {
            this.e = 3;
        }
    }

    @Override // defpackage.gt
    public final void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            et etVar = (et) obj;
            etVar.a(etVar);
        }
    }
}
