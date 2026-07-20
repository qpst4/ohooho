package defpackage;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u2 implements Function {
    public final /* synthetic */ int a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ((p2) obj).a;
            case 1:
                return ((c01) obj).b;
            case 2:
                return ((h91) obj).b();
            default:
                return ((oq0) obj).name();
        }
    }
}
