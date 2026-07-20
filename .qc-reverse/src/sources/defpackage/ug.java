package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ug implements View.OnLayoutChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ug(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this.a;
        Object obj = this.b;
        switch (i9) {
            case 0:
                throw null;
            case 1:
                ((hc0) obj).O();
                view.removeOnLayoutChangeListener(this);
                return;
            default:
                ((es0) obj).d0();
                view.removeOnLayoutChangeListener(this);
                return;
        }
    }
}
