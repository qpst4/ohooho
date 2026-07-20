package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w4 {
    private List<f91> triggers;

    public w4(ArrayList arrayList) {
        this.triggers = arrayList;
    }

    public static w4 a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lc1.G(i, i2).n("Left"));
        arrayList.add(lc1.G(i, i2).n("Right"));
        return new w4(arrayList);
    }

    public final f91 b(int i) {
        try {
            return this.triggers.get(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public final List c() {
        return this.triggers;
    }

    public final void d(ArrayList arrayList) {
        this.triggers = arrayList;
    }
}
