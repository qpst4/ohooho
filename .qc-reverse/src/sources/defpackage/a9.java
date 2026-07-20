package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.quickcursor.R;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a9 {
    public Object a;
    public Object b;
    public Object c;
    public Serializable d;
    public Object e;
    public Serializable f;

    public a9(Set set, String str, String str2) {
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.a = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.c = str;
        this.d = str2;
        this.e = r01.a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        this.b = Collections.unmodifiableSet(hashSet);
    }

    public static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList d(Context context, int i) {
        int iC = n51.c(context, R.attr.colorControlHighlight);
        int iB = n51.b(context, R.attr.colorButtonNormal);
        int[] iArr = n51.b;
        int[] iArr2 = n51.d;
        int iD = wl.d(iC, i);
        return new ColorStateList(new int[][]{iArr, iArr2, n51.c, n51.f}, new int[]{iB, iD, wl.d(iC, i), i});
    }

    public static LayerDrawable e(bw0 bw0Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableC = bw0Var.c(context, R.drawable.abc_star_black_48dp);
        Drawable drawableC2 = bw0Var.c(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableC instanceof BitmapDrawable) && drawableC.getIntrinsicWidth() == dimensionPixelSize && drawableC.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableC;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableC2 instanceof BitmapDrawable) && drawableC2.getIntrinsicWidth() == dimensionPixelSize && drawableC2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableC2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableC2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void g(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = b9.b;
        }
        drawableMutate.setColorFilter(b9.c(i, mode));
    }

    public void a(String str, String str2) {
        HashMap map = (HashMap) this.f;
        if (map != null) {
            map.put(str, str2);
        } else {
            s1.f("Property \"autoMetadata\" has not been set");
        }
    }

    public yc c() {
        String strConcat = ((String) this.a) == null ? " transportName" : "";
        if (((ry) this.c) == null) {
            strConcat = strConcat.concat(" encodedPayload");
        }
        if (((Long) this.d) == null) {
            strConcat = strConcat.concat(" eventMillis");
        }
        if (((Long) this.e) == null) {
            strConcat = strConcat.concat(" uptimeMillis");
        }
        if (((HashMap) this.f) == null) {
            strConcat = strConcat.concat(" autoMetadata");
        }
        if (strConcat.isEmpty()) {
            return new yc((String) this.a, (Integer) this.b, (ry) this.c, ((Long) this.d).longValue(), ((Long) this.e).longValue(), (HashMap) this.f);
        }
        s1.f("Missing required properties:".concat(strConcat));
        return null;
    }

    public ColorStateList f(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return xy0.p(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return xy0.p(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return d(context, n51.c(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return d(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return d(context, n51.c(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return xy0.p(context, R.color.abc_tint_spinner);
            }
            if (b((int[]) this.b, i)) {
                return n51.d(context, R.attr.colorControlNormal);
            }
            if (b((int[]) this.e, i)) {
                return xy0.p(context, R.color.abc_tint_default);
            }
            if (b((int[]) this.f, i)) {
                return xy0.p(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return xy0.p(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = n51.d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = n51.b;
            iArr2[0] = n51.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = n51.e;
            iArr2[1] = n51.c(context, R.attr.colorControlActivated);
            iArr[2] = n51.f;
            iArr2[2] = n51.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = n51.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = n51.e;
            iArr2[1] = n51.c(context, R.attr.colorControlActivated);
            iArr[2] = n51.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }
}
