package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wb implements rr0 {
    public final int a;

    public wb(int i) {
        this.a = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return rr0.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rr0)) {
            return false;
        }
        rr0 rr0Var = (rr0) obj;
        return this.a == rr0Var.tag() && qr0.b.equals(rr0Var.intEncoding());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.a ^ 14552422) + (qr0.b.hashCode() ^ 2041407134);
    }

    @Override // defpackage.rr0
    public final qr0 intEncoding() {
        return qr0.b;
    }

    @Override // defpackage.rr0
    public final int tag() {
        return this.a;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.a + "intEncoding=" + qr0.b + ')';
    }
}
