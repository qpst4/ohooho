package defpackage;

import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class h91 extends j {
    public static final Type LIST_HASH_TYPE = new g91().b();
    private int size;

    public h91(int i, n3 n3Var, HashMap map, i3 i3Var) {
        super(n3Var, map);
        this.size = i;
        f(i3Var);
    }

    public final int i() {
        return this.size;
    }

    public final void j(int i) {
        this.size = i;
    }

    public h91(i iVar) {
        super(iVar);
        this.size = 1;
    }
}
