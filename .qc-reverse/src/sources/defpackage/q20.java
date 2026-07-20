package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q20 implements ao {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ q20(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.ao
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                r20 r20Var = (r20) obj;
                if (r20Var == null) {
                    r20Var = new r20(-3);
                }
                ((i9) this.b).F(r20Var);
                return;
            default:
                r20 r20Var2 = (r20) obj;
                synchronized (s20.c) {
                    try {
                        t01 t01Var = s20.d;
                        ArrayList arrayList = (ArrayList) t01Var.get((String) this.b);
                        if (arrayList == null) {
                            return;
                        }
                        t01Var.remove((String) this.b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((ao) arrayList.get(i)).accept(r20Var2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
