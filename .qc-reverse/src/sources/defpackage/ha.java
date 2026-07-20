package defpackage;

import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ha extends sp1 {
    public final /* synthetic */ AppCompatTextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha(AppCompatTextView appCompatTextView) {
        super(6, appCompatTextView);
        this.f = appCompatTextView;
    }

    @Override // defpackage.sp1, defpackage.ga
    public final void d(int i) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i);
    }

    @Override // defpackage.sp1, defpackage.ga
    public final void o(int i) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i);
    }
}
