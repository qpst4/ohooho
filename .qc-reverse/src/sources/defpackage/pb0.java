package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pb0 extends InputConnectionWrapper {
    public final /* synthetic */ r1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb0(InputConnection inputConnection, r1 r1Var) {
        super(inputConnection, false);
        this.a = r1Var;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        tb0 tb0Var = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            tb0Var = new tb0(0, new rb0(inputContentInfo));
        }
        if (this.a.k(tb0Var, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
