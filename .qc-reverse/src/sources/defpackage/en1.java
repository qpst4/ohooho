package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class en1 extends Throwable {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ en1(String str, int i) {
        super(str);
        this.b = i;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        switch (this.b) {
            case 0:
                synchronized (this) {
                    break;
                }
                break;
            case 1:
                synchronized (this) {
                    break;
                }
                break;
            default:
                synchronized (this) {
                    break;
                }
                break;
        }
        return this;
    }
}
