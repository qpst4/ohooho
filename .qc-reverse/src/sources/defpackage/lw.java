package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lw extends j {
    private Integer color;
    private int size;

    public lw(n3 n3Var, HashMap map) {
        super(n3Var, map);
        this.size = 1;
        this.color = null;
    }

    public final Integer i() {
        return this.color;
    }

    public final int j() {
        return this.size;
    }

    public final void k(Integer num) {
        this.color = num;
    }

    public final void l(int i) {
        this.size = i;
    }
}
