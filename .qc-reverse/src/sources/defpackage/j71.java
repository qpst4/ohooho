package defpackage;

import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j71 extends j {
    public static final Type LIST_HASH_TYPE = new i71().b();
    private boolean hideTrackerAfter;
    private int size;

    public j71(n3 n3Var, HashMap map) {
        super(n3Var, map);
        this.size = 1;
        this.hideTrackerAfter = false;
    }

    public final int i() {
        return this.size;
    }

    public final boolean j() {
        return this.hideTrackerAfter;
    }

    public final void k(boolean z) {
        this.hideTrackerAfter = z;
    }

    public final void l(int i) {
        this.size = i;
    }

    public j71(i iVar) {
        super(iVar);
        this.size = 1;
        this.hideTrackerAfter = false;
    }
}
