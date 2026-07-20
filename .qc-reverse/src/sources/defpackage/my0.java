package defpackage;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class my0 implements ny0 {
    public final ScrollFeedbackProvider b;

    public my0(NestedScrollView nestedScrollView) {
        this.b = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // defpackage.ny0
    public final void onScrollLimit(int i, int i2, int i3, boolean z) {
        this.b.onScrollLimit(i, i2, i3, z);
    }

    @Override // defpackage.ny0
    public final void onScrollProgress(int i, int i2, int i3, int i4) {
        this.b.onScrollProgress(i, i2, i3, i4);
    }
}
