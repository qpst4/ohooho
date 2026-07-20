package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.net.ProtocolException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f9 {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;

    public f9(int i) {
        this.a = i;
        switch (i) {
            case 5:
                break;
            default:
                float[] fArr = {0.0f, 0.0f, 0.0f};
                this.c = fArr;
                this.d = new ArrayList();
                Color.colorToHSV(0, fArr);
                this.b = Color.alpha(0);
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f5, code lost:
    
        if (r11 == 1) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f8, code lost:
    
        if (r11 == 2) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fa, code lost:
    
        r16 = (int[]) r0.c;
        r17 = (float[]) r0.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0208, code lost:
    
        if (r10 == 1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020a, code lost:
    
        if (r10 == 2) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x020c, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0219, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x021c, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021f, code lost:
    
        r11 = new android.graphics.LinearGradient(r21, r22, r26, r27, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0223, code lost:
    
        r11 = new android.graphics.SweepGradient(r8, r9, (int[]) r0.c, (float[]) r0.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0235, code lost:
    
        if (r25 <= 0.0f) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0237, code lost:
    
        r20 = (int[]) r0.c;
        r21 = (float[]) r0.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0246, code lost:
    
        if (r10 == 1) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0249, code lost:
    
        if (r10 == 2) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x024b, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0256, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0259, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x025c, code lost:
    
        r11 = new android.graphics.RadialGradient(r8, r9, r25, r20, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0268, code lost:
    
        return new defpackage.f9(r11, (android.content.res.ColorStateList) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0270, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01da, code lost:
    
        if (r13.size() <= 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dc, code lost:
    
        r0 = new defpackage.i9(r13, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e2, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e3, code lost:
    
        if (r0 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e7, code lost:
    
        if (r20 == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e9, code lost:
    
        r0 = new defpackage.i9(r6, r5, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ef, code lost:
    
        r0 = new defpackage.i9(r6, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.f9 b(android.content.res.Resources r30, int r31, android.content.res.Resources.Theme r32) {
        /*
            Method dump skipped, instruction units count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f9.b(android.content.res.Resources, int, android.content.res.Resources$Theme):f9");
    }

    public static f9 g(String str) throws ProtocolException {
        int i;
        String strSubstring;
        boolean zStartsWith = str.startsWith("HTTP/1.");
        vr0 vr0Var = vr0.c;
        if (zStartsWith) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                vr0Var = vr0.d;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i3 = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i + 4);
            }
            return new f9(vr0Var, i3, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public void a() {
        zm zmVar;
        ImageView imageView = (ImageView) this.c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            vu.a(drawable);
        }
        if (drawable == null || (zmVar = (zm) this.d) == null) {
            return;
        }
        b9.e(drawable, zmVar, imageView.getDrawableState());
    }

    public float c(float f) {
        float[] fArr = (float[]) this.c;
        int iHSVToColor = Color.HSVToColor(new float[]{fArr[0], fArr[1], f});
        return ((Color.blue(iHSVToColor) * 0.0722f) + ((Color.green(iHSVToColor) * 0.7152f) + (Color.red(iHSVToColor) * 0.2126f))) / 255.0f;
    }

    public boolean d() {
        ColorStateList colorStateList;
        return ((Shader) this.c) == null && (colorStateList = (ColorStateList) this.d) != null && colorStateList.isStateful();
    }

    public void e(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.c;
        Context context = imageView.getContext();
        int[] iArr = zs0.f;
        ra raVarM = ra.M(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) raVarM.c;
        uf1.m(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) raVarM.c, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = tk0.j(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                vu.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(raVarM.x(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(vu.c(typedArray.getInt(3, -1), null));
            }
            raVarM.O();
        } catch (Throwable th) {
            raVarM.O();
            throw th;
        }
    }

    public void f(ql qlVar) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ql qlVar2 = (ql) obj;
            if (qlVar2 != qlVar) {
                qlVar2.a(this);
            }
        }
    }

    public void h(int i) {
        ImageView imageView = (ImageView) this.c;
        if (i != 0) {
            Drawable drawableJ = tk0.j(imageView.getContext(), i);
            if (drawableJ != null) {
                vu.a(drawableJ);
            }
            imageView.setImageDrawable(drawableJ);
        } else {
            imageView.setImageDrawable(null);
        }
        a();
    }

    public String toString() {
        switch (this.a) {
            case 3:
                String str = (String) this.d;
                StringBuilder sb = new StringBuilder();
                sb.append(((vr0) this.c) == vr0.c ? "HTTP/1.0" : "HTTP/1.1");
                sb.append(' ');
                sb.append(this.b);
                sb.append(' ');
                sb.append(str);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public f9(int i, String str, ArrayList arrayList) {
        this.a = 4;
        this.b = i;
        this.d = str;
        this.c = arrayList;
    }

    public f9(vr0 vr0Var, int i, String str) {
        this.a = 3;
        this.c = vr0Var;
        this.b = i;
        this.d = str;
    }

    public f9(ImageView imageView) {
        this.a = 0;
        this.b = 0;
        this.c = imageView;
    }

    public f9(Shader shader, ColorStateList colorStateList, int i) {
        this.a = 1;
        this.c = shader;
        this.d = colorStateList;
        this.b = i;
    }
}
