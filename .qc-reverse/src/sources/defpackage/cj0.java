package defpackage;

import com.quickcursor.android.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cj0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ MainActivity.a c;

    public /* synthetic */ cj0(MainActivity.a aVar, int i) {
        this.b = i;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        MainActivity.a aVar = this.c;
        switch (i) {
            case 0:
                aVar.o0();
                break;
            default:
                aVar.i0.c(new bj0(aVar, 3));
                sf sfVar = aVar.i0;
                bj0 bj0Var = new bj0(aVar, 4);
                sfVar.getClass();
                c1 c1Var = new c1(2);
                c1Var.c = "subs";
                sfVar.c.f(c1Var.b(), new ff(sfVar, 2, bj0Var));
                break;
        }
    }
}
