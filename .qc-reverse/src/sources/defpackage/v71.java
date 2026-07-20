package defpackage;

import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v71 implements ToIntFunction {
    public final /* synthetic */ int a;

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.a) {
            case 0:
                return ((j71) obj).i();
            default:
                return ((h91) obj).i();
        }
    }
}
