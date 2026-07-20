package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    private i3 actionTrigger = i3.empty;
    private n3 actionType;
    private HashMap<String, Object> extraData;

    public j(i iVar) {
        this.actionType = iVar.actionType;
        this.extraData = iVar.extraData;
    }

    public final i3 a() {
        return this.actionTrigger;
    }

    public final n3 b() {
        return this.actionType;
    }

    public final HashMap c() {
        return this.extraData;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable d(android.content.Context r7) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j.d(android.content.Context):android.graphics.drawable.Drawable");
    }

    public final void e(i iVar) {
        this.actionType = iVar.actionType;
        this.extraData = iVar.extraData;
    }

    public final void f(i3 i3Var) {
        this.actionTrigger = i3Var;
    }

    public final void g(n3 n3Var) {
        this.actionType = n3Var;
    }

    public final void h(HashMap map) {
        this.extraData = map;
    }

    public j(n3 n3Var, HashMap map) {
        this.actionType = n3Var;
        this.extraData = map;
    }
}
