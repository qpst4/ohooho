package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n41 extends k41 {
    public final Runnable d;

    public n41(Runnable runnable, long j, vy0 vy0Var) {
        super(j, vy0Var);
        this.d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.d.run();
        } finally {
            this.c.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.d;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(xr.p(runnable));
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(']');
        return sb.toString();
    }
}
