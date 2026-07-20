package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fa {
    public final TextView a;
    public zm b;
    public zm c;
    public zm d;
    public zm e;
    public zm f;
    public zm g;
    public zm h;
    public final na i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public fa(TextView textView) {
        this.a = textView;
        this.i = new na(textView);
    }

    public static zm c(Context context, b9 b9Var, int i) {
        ColorStateList colorStateListF;
        synchronized (b9Var) {
            colorStateListF = b9Var.a.f(context, i);
        }
        if (colorStateListF == null) {
            return null;
        }
        zm zmVar = new zm();
        zmVar.b = true;
        zmVar.c = colorStateListF;
        return zmVar;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            i0.f(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            i0.f(editorInfo, text);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = text.length();
        if (i4 < 0 || i2 > length) {
            tk0.D(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            tk0.D(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            tk0.D(editorInfo, text, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(text.length() - i2, i8 - Math.min(i4, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i4, i8 - iMin);
        int i9 = i4 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i2 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        tk0.D(editorInfo, i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + iMin2), text.subSequence(i2, iMin + i2)) : text.subSequence(i9, i10 + iMin + i9), iMin2, i10);
    }

    public final void a(Drawable drawable, zm zmVar) {
        if (drawable == null || zmVar == null) {
            return;
        }
        b9.e(drawable, zmVar, this.a.getDrawableState());
    }

    public final void b() {
        zm zmVar = this.b;
        TextView textView = this.a;
        if (zmVar != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public final ColorStateList d() {
        zm zmVar = this.h;
        if (zmVar != null) {
            return (ColorStateList) zmVar.c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        zm zmVar = this.h;
        if (zmVar != null) {
            return (PorterDuff.Mode) zmVar.d;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instruction units count: 980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fa.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, zs0.w);
        ra raVar = new ra(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, raVar);
        if (Build.VERSION.SDK_INT >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            da.d(textView, string);
        }
        raVar.O();
        Typeface typeface = this.l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.j);
        }
    }

    public final void i(int i, int i2, int i3, int i4) {
        na naVar = this.i;
        if (naVar.j()) {
            DisplayMetrics displayMetrics = naVar.j.getResources().getDisplayMetrics();
            naVar.k(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (naVar.h()) {
                naVar.a();
            }
        }
    }

    public final void j(int[] iArr, int i) {
        na naVar = this.i;
        if (naVar.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = naVar.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                naVar.f = na.b(iArrCopyOf);
                if (!naVar.i()) {
                    s1.j("None of the preset sizes is valid: ", Arrays.toString(iArr));
                    return;
                }
            } else {
                naVar.g = false;
            }
            if (naVar.h()) {
                naVar.a();
            }
        }
    }

    public final void k(int i) {
        na naVar = this.i;
        if (naVar.j()) {
            if (i == 0) {
                naVar.a = 0;
                naVar.d = -1.0f;
                naVar.e = -1.0f;
                naVar.c = -1.0f;
                naVar.f = new int[0];
                naVar.b = false;
                return;
            }
            if (i != 1) {
                zy.n(qq0.i("Unknown auto-size text type: ", i));
                return;
            }
            DisplayMetrics displayMetrics = naVar.j.getResources().getDisplayMetrics();
            naVar.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (naVar.h()) {
                naVar.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new zm();
        }
        zm zmVar = this.h;
        zmVar.c = colorStateList;
        zmVar.b = colorStateList != null;
        this.b = zmVar;
        this.c = zmVar;
        this.d = zmVar;
        this.e = zmVar;
        this.f = zmVar;
        this.g = zmVar;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new zm();
        }
        zm zmVar = this.h;
        zmVar.d = mode;
        zmVar.a = mode != null;
        this.b = zmVar;
        this.c = zmVar;
        this.d = zmVar;
        this.e = zmVar;
        this.f = zmVar;
        this.g = zmVar;
    }

    public final void n(Context context, ra raVar) {
        String string;
        int i = this.j;
        TypedArray typedArray = (TypedArray) raVar.c;
        this.j = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.m = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.k;
        int i7 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceA = raVar.A(i5, this.j, new aa(this, i6, i7, new WeakReference(this.a)));
                if (typefaceA != null) {
                    if (i2 < 28 || this.k == -1) {
                        this.l = typefaceA;
                    } else {
                        this.l = ea.a(Typeface.create(typefaceA, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(string, this.j);
        } else {
            this.l = ea.a(Typeface.create(string, 0), this.k, (this.j & 2) != 0);
        }
    }
}
