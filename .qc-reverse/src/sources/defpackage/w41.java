package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w41 extends fp1 {
    public final /* synthetic */ Context f;
    public final /* synthetic */ TextPaint g;
    public final /* synthetic */ fp1 h;
    public final /* synthetic */ x41 i;

    public w41(x41 x41Var, Context context, TextPaint textPaint, fp1 fp1Var) {
        this.i = x41Var;
        this.f = context;
        this.g = textPaint;
        this.h = fp1Var;
    }

    @Override // defpackage.fp1
    public final void v(int i) {
        this.h.v(i);
    }

    @Override // defpackage.fp1
    public final void w(Typeface typeface, boolean z) {
        this.i.g(this.f, this.g, typeface);
        this.h.w(typeface, z);
    }
}
