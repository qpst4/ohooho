package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a71 extends qg1 {
    public final /* synthetic */ int a;
    public boolean b;
    public int c;
    public final /* synthetic */ Object d;

    public a71(og1 og1Var) {
        this.a = 1;
        this.d = og1Var;
        this.b = false;
        this.c = 0;
    }

    @Override // defpackage.pg1
    public final void a() {
        int i = this.a;
        Object obj = this.d;
        switch (i) {
            case 0:
                if (!this.b) {
                    ((b71) obj).a.setVisibility(this.c);
                }
                break;
            default:
                int i2 = this.c + 1;
                this.c = i2;
                og1 og1Var = (og1) obj;
                if (i2 == og1Var.a.size()) {
                    pg1 pg1Var = og1Var.d;
                    if (pg1Var != null) {
                        pg1Var.a();
                    }
                    this.c = 0;
                    this.b = false;
                    og1Var.e = false;
                }
                break;
        }
    }

    @Override // defpackage.qg1, defpackage.pg1
    public void b() {
        switch (this.a) {
            case 0:
                this.b = true;
                break;
        }
    }

    @Override // defpackage.qg1, defpackage.pg1
    public final void c() {
        int i = this.a;
        Object obj = this.d;
        switch (i) {
            case 0:
                ((b71) obj).a.setVisibility(0);
                break;
            default:
                if (!this.b) {
                    this.b = true;
                    pg1 pg1Var = ((og1) obj).d;
                    if (pg1Var != null) {
                        pg1Var.c();
                    }
                    break;
                }
                break;
        }
    }

    public a71(b71 b71Var, int i) {
        this.a = 0;
        this.d = b71Var;
        this.c = i;
        this.b = false;
    }
}
