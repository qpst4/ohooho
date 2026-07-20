package defpackage;

import android.text.InputFilter;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zx implements InputFilter {
    public final TextView a;
    public yx b;

    public zx(TextView textView) {
        this.a = textView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r1 != 3) goto L27;
     */
    @Override // android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence filter(java.lang.CharSequence r4, int r5, int r6, android.text.Spanned r7, int r8, int r9) {
        /*
            r3 = this;
            android.widget.TextView r0 = r3.a
            boolean r1 = r0.isInEditMode()
            if (r1 == 0) goto L9
            goto L48
        L9:
            sx r1 = defpackage.sx.a()
            int r1 = r1.b()
            if (r1 == 0) goto L49
            r2 = 1
            if (r1 == r2) goto L1a
            r5 = 3
            if (r1 == r5) goto L49
            goto L48
        L1a:
            if (r9 != 0) goto L2b
            if (r8 != 0) goto L2b
            int r3 = r7.length()
            if (r3 != 0) goto L2b
            java.lang.CharSequence r3 = r0.getText()
            if (r4 != r3) goto L2b
            goto L48
        L2b:
            if (r4 == 0) goto L48
            if (r5 != 0) goto L36
            int r3 = r4.length()
            if (r6 != r3) goto L36
            goto L3a
        L36:
            java.lang.CharSequence r4 = r4.subSequence(r5, r6)
        L3a:
            sx r3 = defpackage.sx.a()
            int r5 = r4.length()
            r6 = 0
            java.lang.CharSequence r3 = r3.e(r4, r6, r5)
            return r3
        L48:
            return r4
        L49:
            sx r5 = defpackage.sx.a()
            yx r6 = r3.b
            if (r6 != 0) goto L58
            yx r6 = new yx
            r6.<init>(r0, r3)
            r3.b = r6
        L58:
            yx r3 = r3.b
            r5.f(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zx.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }
}
