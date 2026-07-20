package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pk implements View.OnFocusChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ iz b;

    public /* synthetic */ pk(iz izVar, int i) {
        this.a = i;
        this.b = izVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        int i = this.a;
        iz izVar = this.b;
        switch (i) {
            case 0:
                sk skVar = (sk) izVar;
                skVar.s(skVar.t());
                break;
            default:
                ev evVar = (ev) izVar;
                evVar.l = z;
                evVar.p();
                if (!z) {
                    evVar.s(false);
                    evVar.m = false;
                }
                break;
        }
    }
}
