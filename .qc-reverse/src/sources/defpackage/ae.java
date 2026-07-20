package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.quickcursor.R;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ae {
    public final zd a;
    public final zd b = new zd();
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public final int k;

    public ae(Context context) {
        AttributeSet attributeSet;
        int styleAttribute;
        int next;
        zd zdVar = new zd();
        int i = zdVar.b;
        if (i != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                attributeSet = attributeSetAsAttributeSet;
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayE = f01.E(context, attributeSet, ys0.a, R.attr.badgeStyle, styleAttribute == 0 ? R.style.Widget_MaterialComponents_Badge : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.c = typedArrayE.getDimensionPixelSize(4, -1);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.d = typedArrayE.getDimensionPixelSize(14, -1);
        this.e = typedArrayE.getDimension(12, resources.getDimension(R.dimen.m3_badge_size));
        this.g = typedArrayE.getDimension(17, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f = typedArrayE.getDimension(3, resources.getDimension(R.dimen.m3_badge_size));
        this.h = typedArrayE.getDimension(13, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.k = typedArrayE.getInt(24, 1);
        zd zdVar2 = this.b;
        int i2 = zdVar.j;
        zdVar2.j = i2 == -2 ? 255 : i2;
        int i3 = zdVar.l;
        if (i3 != -2) {
            zdVar2.l = i3;
        } else {
            boolean zHasValue = typedArrayE.hasValue(23);
            zd zdVar3 = this.b;
            if (zHasValue) {
                zdVar3.l = typedArrayE.getInt(23, 0);
            } else {
                zdVar3.l = -1;
            }
        }
        String str = zdVar.k;
        if (str != null) {
            this.b.k = str;
        } else if (typedArrayE.hasValue(7)) {
            this.b.k = typedArrayE.getString(7);
        }
        zd zdVar4 = this.b;
        zdVar4.p = zdVar.p;
        CharSequence charSequence = zdVar.q;
        zdVar4.q = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        zd zdVar5 = this.b;
        int i4 = zdVar.r;
        zdVar5.r = i4 == 0 ? R.plurals.mtrl_badge_content_description : i4;
        int i5 = zdVar.s;
        zdVar5.s = i5 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i5;
        Boolean bool = zdVar.u;
        zdVar5.u = Boolean.valueOf(bool == null || bool.booleanValue());
        zd zdVar6 = this.b;
        int i6 = zdVar.m;
        zdVar6.m = i6 == -2 ? typedArrayE.getInt(21, -2) : i6;
        zd zdVar7 = this.b;
        int i7 = zdVar.n;
        zdVar7.n = i7 == -2 ? typedArrayE.getInt(22, -2) : i7;
        zd zdVar8 = this.b;
        Integer num = zdVar.f;
        zdVar8.f = Integer.valueOf(num == null ? typedArrayE.getResourceId(5, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        zd zdVar9 = this.b;
        Integer num2 = zdVar.g;
        zdVar9.g = Integer.valueOf(num2 == null ? typedArrayE.getResourceId(6, 0) : num2.intValue());
        zd zdVar10 = this.b;
        Integer num3 = zdVar.h;
        zdVar10.h = Integer.valueOf(num3 == null ? typedArrayE.getResourceId(15, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        zd zdVar11 = this.b;
        Integer num4 = zdVar.i;
        zdVar11.i = Integer.valueOf(num4 == null ? typedArrayE.getResourceId(16, 0) : num4.intValue());
        zd zdVar12 = this.b;
        Integer num5 = zdVar.c;
        zdVar12.c = Integer.valueOf(num5 == null ? yb0.i(context, typedArrayE, 1).getDefaultColor() : num5.intValue());
        zd zdVar13 = this.b;
        Integer num6 = zdVar.e;
        zdVar13.e = Integer.valueOf(num6 == null ? typedArrayE.getResourceId(8, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = zdVar.d;
        if (num7 != null) {
            this.b.d = num7;
        } else {
            boolean zHasValue2 = typedArrayE.hasValue(9);
            zd zdVar14 = this.b;
            if (zHasValue2) {
                zdVar14.d = Integer.valueOf(yb0.i(context, typedArrayE, 9).getDefaultColor());
            } else {
                int iIntValue = zdVar14.e.intValue();
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, ys0.E);
                typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
                ColorStateList colorStateListI = yb0.i(context, typedArrayObtainStyledAttributes, 3);
                yb0.i(context, typedArrayObtainStyledAttributes, 4);
                yb0.i(context, typedArrayObtainStyledAttributes, 5);
                typedArrayObtainStyledAttributes.getInt(2, 0);
                typedArrayObtainStyledAttributes.getInt(1, 1);
                int i8 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
                typedArrayObtainStyledAttributes.getResourceId(i8, 0);
                typedArrayObtainStyledAttributes.getString(i8);
                typedArrayObtainStyledAttributes.getBoolean(14, false);
                yb0.i(context, typedArrayObtainStyledAttributes, 6);
                typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
                typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
                typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
                typedArrayObtainStyledAttributes.recycle();
                TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, ys0.u);
                typedArrayObtainStyledAttributes2.hasValue(0);
                typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
                typedArrayObtainStyledAttributes2.recycle();
                this.b.d = Integer.valueOf(colorStateListI.getDefaultColor());
            }
        }
        zd zdVar15 = this.b;
        Integer num8 = zdVar.t;
        zdVar15.t = Integer.valueOf(num8 == null ? typedArrayE.getInt(2, 8388661) : num8.intValue());
        zd zdVar16 = this.b;
        Integer num9 = zdVar.v;
        zdVar16.v = Integer.valueOf(num9 == null ? typedArrayE.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        zd zdVar17 = this.b;
        Integer num10 = zdVar.w;
        zdVar17.w = Integer.valueOf(num10 == null ? typedArrayE.getDimensionPixelSize(10, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        zd zdVar18 = this.b;
        Integer num11 = zdVar.x;
        zdVar18.x = Integer.valueOf(num11 == null ? typedArrayE.getDimensionPixelOffset(18, 0) : num11.intValue());
        zd zdVar19 = this.b;
        Integer num12 = zdVar.y;
        zdVar19.y = Integer.valueOf(num12 == null ? typedArrayE.getDimensionPixelOffset(25, 0) : num12.intValue());
        zd zdVar20 = this.b;
        Integer num13 = zdVar.z;
        zdVar20.z = Integer.valueOf(num13 == null ? typedArrayE.getDimensionPixelOffset(19, zdVar20.x.intValue()) : num13.intValue());
        zd zdVar21 = this.b;
        Integer num14 = zdVar.A;
        zdVar21.A = Integer.valueOf(num14 == null ? typedArrayE.getDimensionPixelOffset(26, zdVar21.y.intValue()) : num14.intValue());
        zd zdVar22 = this.b;
        Integer num15 = zdVar.D;
        zdVar22.D = Integer.valueOf(num15 == null ? typedArrayE.getDimensionPixelOffset(20, 0) : num15.intValue());
        zd zdVar23 = this.b;
        Integer num16 = zdVar.B;
        zdVar23.B = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        zd zdVar24 = this.b;
        Integer num17 = zdVar.C;
        zdVar24.C = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        zd zdVar25 = this.b;
        Boolean bool2 = zdVar.E;
        zdVar25.E = Boolean.valueOf(bool2 == null ? typedArrayE.getBoolean(0, false) : bool2.booleanValue());
        typedArrayE.recycle();
        Locale locale = zdVar.o;
        zd zdVar26 = this.b;
        if (locale == null) {
            zdVar26.o = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            zdVar26.o = locale;
        }
        this.a = zdVar;
    }
}
