package defpackage;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ll1 implements Consumer {
    public final /* synthetic */ int a = 1;

    public /* synthetic */ ll1() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                s1.o((df) obj);
                break;
            default:
                if (((bf) obj) == null) {
                    zy.n("ProductDetailsParams cannot be null.");
                    break;
                }
                break;
        }
    }

    public /* synthetic */ ll1(s1 s1Var) {
    }
}
