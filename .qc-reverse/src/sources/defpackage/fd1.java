package defpackage;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fd1 implements Spannable {
    public boolean b = false;
    public Spannable c;

    public fd1(Spannable spannable) {
        this.c = spannable;
    }

    public final void a() {
        Spannable spannable = this.c;
        if (!this.b) {
            if ((Build.VERSION.SDK_INT < 28 ? new ix(28) : new ed1(28)).i(spannable)) {
                this.c = new SpannableString(spannable);
            }
        }
        this.b = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.c.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.c.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.c.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i2, Class cls) {
        return this.c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.c.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.c.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        a();
        this.c.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.c.toString();
    }
}
