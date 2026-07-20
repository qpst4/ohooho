package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class td0 extends pd0 {
    public final zg0 b;

    public td0() {
        ik ikVar = zg0.j;
        this.b = new zg0(false);
    }

    public final pd0 d(String str) {
        return (pd0) this.b.get(str);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof td0) && ((td0) obj).b.equals(this.b);
        }
        return true;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
