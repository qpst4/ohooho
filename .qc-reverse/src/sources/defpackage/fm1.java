package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fm1 {
    public final Object a;
    public final Object b;
    public final Object c;

    public fm1(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj) + "=" + String.valueOf(this.b) + " and " + String.valueOf(obj) + "=" + String.valueOf(this.c));
    }
}
