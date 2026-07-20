package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    private final n3 actionType;
    private final HashMap<String, Object> extraData;

    public i(n3 n3Var) {
        this.actionType = n3Var;
        this.extraData = null;
    }

    public final n3 c() {
        return this.actionType;
    }

    public final HashMap d() {
        return this.extraData;
    }

    public final String toString() {
        return "StoredAction{actionType=" + this.actionType + ", extraData=" + this.extraData + '}';
    }

    public i(n3 n3Var, HashMap map) {
        this.actionType = n3Var;
        this.extraData = map;
    }
}
