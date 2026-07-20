package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mq0 extends ru0 {
    public final RecyclerView f;
    public final qu0 g;
    public final xj h;

    public mq0(RecyclerView recyclerView) {
        super(recyclerView);
        this.g = this.e;
        this.h = new xj(4, this);
        this.f = recyclerView;
    }

    @Override // defpackage.ru0
    public final y j() {
        return this.h;
    }
}
