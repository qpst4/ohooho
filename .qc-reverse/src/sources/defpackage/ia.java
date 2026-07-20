package defpackage;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ia extends ha {
    public final /* synthetic */ AppCompatTextView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia(AppCompatTextView appCompatTextView) {
        super(appCompatTextView);
        this.g = appCompatTextView;
    }

    @Override // defpackage.sp1, defpackage.ga
    public final void r(int i, float f) {
        super/*android.widget.TextView*/.setLineHeight(i, f);
    }
}
