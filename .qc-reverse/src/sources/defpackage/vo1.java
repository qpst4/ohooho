package defpackage;

import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vo1 extends mk1 {
    public final /* synthetic */ a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo1(a aVar, int i) {
        super(aVar, i, null);
        this.g = aVar;
    }

    @Override // defpackage.mk1
    public final void a(xm xmVar) {
        this.g.i.g(xmVar);
        System.currentTimeMillis();
    }

    @Override // defpackage.mk1
    public final boolean b() {
        this.g.i.g(xm.f);
        return true;
    }
}
