package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oi {
    public boolean a;
    public ni b;
    public boolean c;

    public final void a(ni niVar) {
        synchronized (this) {
            while (this.c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.b == niVar) {
                return;
            }
            this.b = niVar;
            if (this.a) {
                niVar.onCancel();
            }
        }
    }
}
