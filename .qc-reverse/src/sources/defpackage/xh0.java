package defpackage;

import androidx.lifecycle.b;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xh0 {
    public final sp1 b;
    public boolean c;
    public int d = -1;
    public final /* synthetic */ b e;

    public xh0(b bVar, sp1 sp1Var) {
        this.e = bVar;
        this.b = sp1Var;
    }

    public final void b(boolean z) {
        if (z == this.c) {
            return;
        }
        this.c = z;
        int i = z ? 1 : -1;
        b bVar = this.e;
        int i2 = bVar.c;
        bVar.c = i + i2;
        if (!bVar.d) {
            bVar.d = true;
            while (true) {
                try {
                    int i3 = bVar.c;
                    if (i2 == i3) {
                        break;
                    } else {
                        i2 = i3;
                    }
                } finally {
                    bVar.d = false;
                }
            }
        }
        if (this.c) {
            bVar.c(this);
        }
    }

    public abstract boolean e();

    public void d() {
    }
}
