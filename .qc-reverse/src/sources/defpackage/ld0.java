package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ld0 implements kn0 {
    public final /* synthetic */ int a;

    @Override // defpackage.sy
    public final void a(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                throw new vy("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                ln0 ln0Var = (ln0) obj2;
                ln0Var.a(tr0.g, entry.getKey());
                ln0Var.a(tr0.h, entry.getValue());
                return;
            default:
                throw new vy("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
