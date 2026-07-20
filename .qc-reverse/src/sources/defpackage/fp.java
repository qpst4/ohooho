package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fp extends hf0 implements v40 {
    public static final fp d = new fp(1, 0);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fp(int i, int i2) {
        super(i);
        this.c = i2;
    }

    @Override // defpackage.v40
    public final Object g(Object obj) {
        switch (this.c) {
            case 0:
                cp cpVar = (cp) obj;
                if (cpVar instanceof hp) {
                    return (hp) cpVar;
                }
                return null;
            default:
                obj.getClass();
                n nVar = ct0.b;
                return Integer.valueOf(ct0.b.a().nextInt(2147418112) + 65536);
        }
    }
}
