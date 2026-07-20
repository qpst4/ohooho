package defpackage;

import androidx.activity.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wn0 extends hf0 implements k40 {
    public final /* synthetic */ int c;
    public final /* synthetic */ a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wn0(a aVar, int i) {
        super(0);
        this.c = i;
        this.d = aVar;
    }

    @Override // defpackage.k40
    public final Object a() {
        int i = this.c;
        a aVar = this.d;
        switch (i) {
            case 0:
                aVar.d();
                break;
            case 1:
                aVar.c();
                break;
            default:
                aVar.d();
                break;
        }
        return ow0.h;
    }
}
