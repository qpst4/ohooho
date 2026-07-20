package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vc extends vk {
    public final sc a;

    public vc(sc scVar) {
        this.a = scVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vk)) {
            return false;
        }
        vk vkVar = (vk) obj;
        Object obj2 = uk.b;
        if (obj2.equals(obj2)) {
            return this.a.equals(((vc) vkVar).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ ((uk.b.hashCode() ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "ClientInfo{clientType=" + uk.b + ", androidClientInfo=" + this.a + "}";
    }
}
