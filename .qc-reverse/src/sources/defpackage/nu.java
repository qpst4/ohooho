package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nu extends k {
    public final /* synthetic */ int a;
    public final kg b;

    public nu(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new m51();
                break;
            default:
                this.b = new x80(1);
                break;
        }
    }

    @Override // defpackage.k
    public void a(CharSequence charSequence) {
        int i = this.a;
    }

    @Override // defpackage.k
    public boolean b(kg kgVar) {
        switch (this.a) {
            case 0:
                return true;
            default:
                return super.b(kgVar);
        }
    }

    @Override // defpackage.k
    public final kg d() {
        int i = this.a;
        kg kgVar = this.b;
        switch (i) {
            case 0:
                return (x80) kgVar;
            default:
                return (m51) kgVar;
        }
    }

    @Override // defpackage.k
    public boolean e() {
        switch (this.a) {
            case 0:
                return true;
            default:
                return super.e();
        }
    }

    @Override // defpackage.k
    public final lg g(ou ouVar) {
        switch (this.a) {
            case 0:
                return lg.a(ouVar.b);
            default:
                return null;
        }
    }

    private final void h(CharSequence charSequence) {
    }
}
