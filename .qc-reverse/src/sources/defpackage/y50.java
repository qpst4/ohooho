package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y50 implements bz0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ y50(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.bz0
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new x50(this);
            default:
                return (Iterator) this.b;
        }
    }
}
