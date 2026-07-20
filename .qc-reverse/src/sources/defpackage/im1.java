package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class im1 extends dl1 implements Serializable {
    public static final im1 c;
    public static final im1 d;
    public final transient em1 b;

    static {
        bm1 bm1Var = em1.c;
        c = new im1(tm1.f);
        Object[] objArr = {sm1.d};
        for (int i = 0; i < 1; i++) {
            if (objArr[i] == null) {
                zy.r(qq0.i("at index ", i));
                return;
            }
        }
        d = new im1(em1.j(1, objArr));
    }

    public im1(em1 em1Var) {
        this.b = em1Var;
    }

    @Override // defpackage.dl1
    public final /* bridge */ /* synthetic */ lm1 a() {
        em1 em1Var = this.b;
        return em1Var.isEmpty() ? zm1.j : new an1(em1Var, qm1.d);
    }
}
