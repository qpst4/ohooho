package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kj0 {
    public final HashMap a;

    public kj0(int i) {
        switch (i) {
            case 1:
                this.a = new HashMap(3);
                break;
            default:
                this.a = new HashMap();
                break;
        }
    }

    public void a(Class cls, jj0 jj0Var) {
        this.a.put(cls, jj0Var);
    }
}
