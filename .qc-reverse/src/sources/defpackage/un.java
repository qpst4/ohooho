package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class un {
    public static final int[] d = {0, 4, 8};
    public static final SparseIntArray e;
    public static final SparseIntArray f;
    public final HashMap a = new HashMap();
    public final boolean b = true;
    public final HashMap c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] c(ee eeVar, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = eeVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = ks0.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && eeVar.isInEditMode() && (eeVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) eeVar.getParent();
                if (strTrim != null) {
                    HashMap map = constraintLayout.n;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.n.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public static pn d(Context context, AttributeSet attributeSet, boolean z) {
        int i;
        int i2;
        pn pnVar = new pn();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? rs0.c : rs0.a);
        String[] strArr = yb0.d;
        sn snVar = pnVar.b;
        tn tnVar = pnVar.e;
        rn rnVar = pnVar.c;
        qn qnVar = pnVar.d;
        int[] iArr = d;
        SparseIntArray sparseIntArray = e;
        if (z) {
            on onVar = new on();
            onVar.a = new int[10];
            onVar.b = new int[10];
            onVar.c = 0;
            onVar.d = new int[10];
            onVar.e = new float[10];
            onVar.f = 0;
            onVar.g = new int[5];
            onVar.h = new String[5];
            onVar.i = 0;
            onVar.j = new int[4];
            onVar.k = new boolean[4];
            onVar.l = 0;
            rnVar.getClass();
            qnVar.getClass();
            tnVar.getClass();
            int i3 = 0;
            for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i3 < indexCount; indexCount = i2) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = i3;
                switch (f.get(index)) {
                    case 2:
                        i2 = indexCount;
                        onVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.I));
                        continue;
                        i3 = i4 + 1;
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder("Unknown attribute 0x");
                        i2 = indexCount;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case 5:
                        i2 = indexCount;
                        onVar.d(typedArrayObtainStyledAttributes.getString(index), 5);
                        continue;
                        i3 = i4 + 1;
                        break;
                    case 6:
                        i2 = indexCount;
                        onVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qnVar.C));
                        break;
                    case 7:
                        i2 = indexCount;
                        onVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qnVar.D));
                        break;
                    case 8:
                        i2 = indexCount;
                        onVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.J));
                        break;
                    case 11:
                        i2 = indexCount;
                        onVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.P));
                        break;
                    case 12:
                        i2 = indexCount;
                        onVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.Q));
                        break;
                    case 13:
                        i2 = indexCount;
                        onVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.M));
                        break;
                    case 14:
                        i2 = indexCount;
                        onVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.O));
                        break;
                    case 15:
                        i2 = indexCount;
                        onVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.R));
                        break;
                    case 16:
                        i2 = indexCount;
                        onVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.N));
                        break;
                    case 17:
                        i2 = indexCount;
                        onVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qnVar.d));
                        break;
                    case 18:
                        i2 = indexCount;
                        onVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, qnVar.e));
                        break;
                    case 19:
                        i2 = indexCount;
                        onVar.a(19, typedArrayObtainStyledAttributes.getFloat(index, qnVar.f));
                        break;
                    case 20:
                        i2 = indexCount;
                        onVar.a(20, typedArrayObtainStyledAttributes.getFloat(index, qnVar.w));
                        break;
                    case 21:
                        i2 = indexCount;
                        onVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, qnVar.c));
                        break;
                    case 22:
                        i2 = indexCount;
                        onVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, snVar.a)]);
                        break;
                    case 23:
                        i2 = indexCount;
                        onVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, qnVar.b));
                        break;
                    case 24:
                        i2 = indexCount;
                        onVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.F));
                        break;
                    case 27:
                        i2 = indexCount;
                        onVar.b(27, typedArrayObtainStyledAttributes.getInt(index, qnVar.E));
                        break;
                    case 28:
                        i2 = indexCount;
                        onVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.G));
                        break;
                    case 31:
                        i2 = indexCount;
                        onVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.K));
                        break;
                    case 34:
                        i2 = indexCount;
                        onVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.H));
                        break;
                    case 37:
                        i2 = indexCount;
                        onVar.a(37, typedArrayObtainStyledAttributes.getFloat(index, qnVar.x));
                        break;
                    case 38:
                        i2 = indexCount;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, pnVar.a);
                        pnVar.a = resourceId;
                        onVar.b(38, resourceId);
                        break;
                    case 39:
                        i2 = indexCount;
                        onVar.a(39, typedArrayObtainStyledAttributes.getFloat(index, qnVar.U));
                        break;
                    case 40:
                        i2 = indexCount;
                        onVar.a(40, typedArrayObtainStyledAttributes.getFloat(index, qnVar.T));
                        break;
                    case 41:
                        i2 = indexCount;
                        onVar.b(41, typedArrayObtainStyledAttributes.getInt(index, qnVar.V));
                        break;
                    case 42:
                        i2 = indexCount;
                        onVar.b(42, typedArrayObtainStyledAttributes.getInt(index, qnVar.W));
                        break;
                    case 43:
                        i2 = indexCount;
                        onVar.a(43, typedArrayObtainStyledAttributes.getFloat(index, snVar.c));
                        break;
                    case 44:
                        i2 = indexCount;
                        onVar.c(44, true);
                        onVar.a(44, typedArrayObtainStyledAttributes.getDimension(index, tnVar.m));
                        break;
                    case 45:
                        i2 = indexCount;
                        onVar.a(45, typedArrayObtainStyledAttributes.getFloat(index, tnVar.b));
                        break;
                    case 46:
                        i2 = indexCount;
                        onVar.a(46, typedArrayObtainStyledAttributes.getFloat(index, tnVar.c));
                        break;
                    case 47:
                        i2 = indexCount;
                        onVar.a(47, typedArrayObtainStyledAttributes.getFloat(index, tnVar.d));
                        break;
                    case 48:
                        i2 = indexCount;
                        onVar.a(48, typedArrayObtainStyledAttributes.getFloat(index, tnVar.e));
                        break;
                    case 49:
                        i2 = indexCount;
                        onVar.a(49, typedArrayObtainStyledAttributes.getDimension(index, tnVar.f));
                        break;
                    case 50:
                        i2 = indexCount;
                        onVar.a(50, typedArrayObtainStyledAttributes.getDimension(index, tnVar.g));
                        break;
                    case 51:
                        i2 = indexCount;
                        onVar.a(51, typedArrayObtainStyledAttributes.getDimension(index, tnVar.i));
                        break;
                    case 52:
                        i2 = indexCount;
                        onVar.a(52, typedArrayObtainStyledAttributes.getDimension(index, tnVar.j));
                        break;
                    case 53:
                        i2 = indexCount;
                        onVar.a(53, typedArrayObtainStyledAttributes.getDimension(index, tnVar.k));
                        break;
                    case 54:
                        i2 = indexCount;
                        onVar.b(54, typedArrayObtainStyledAttributes.getInt(index, qnVar.X));
                        break;
                    case 55:
                        i2 = indexCount;
                        onVar.b(55, typedArrayObtainStyledAttributes.getInt(index, qnVar.Y));
                        break;
                    case 56:
                        i2 = indexCount;
                        onVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.Z));
                        break;
                    case 57:
                        i2 = indexCount;
                        onVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.a0));
                        break;
                    case 58:
                        i2 = indexCount;
                        onVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.b0));
                        break;
                    case 59:
                        i2 = indexCount;
                        onVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.c0));
                        break;
                    case 60:
                        i2 = indexCount;
                        onVar.a(60, typedArrayObtainStyledAttributes.getFloat(index, tnVar.a));
                        break;
                    case 62:
                        i2 = indexCount;
                        onVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.A));
                        break;
                    case 63:
                        i2 = indexCount;
                        onVar.a(63, typedArrayObtainStyledAttributes.getFloat(index, qnVar.B));
                        break;
                    case 64:
                        i2 = indexCount;
                        onVar.b(64, f(typedArrayObtainStyledAttributes, index, rnVar.a));
                        break;
                    case 65:
                        i2 = indexCount;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            onVar.d(typedArrayObtainStyledAttributes.getString(index), 65);
                        } else {
                            onVar.d(strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)], 65);
                        }
                        break;
                    case 66:
                        i2 = indexCount;
                        onVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i2 = indexCount;
                        onVar.a(67, typedArrayObtainStyledAttributes.getFloat(index, rnVar.e));
                        break;
                    case 68:
                        i2 = indexCount;
                        onVar.a(68, typedArrayObtainStyledAttributes.getFloat(index, snVar.d));
                        break;
                    case 69:
                        i2 = indexCount;
                        onVar.a(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i2 = indexCount;
                        onVar.a(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i2 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i2 = indexCount;
                        onVar.b(72, typedArrayObtainStyledAttributes.getInt(index, qnVar.f0));
                        break;
                    case 73:
                        i2 = indexCount;
                        onVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.g0));
                        break;
                    case 74:
                        i2 = indexCount;
                        onVar.d(typedArrayObtainStyledAttributes.getString(index), 74);
                        break;
                    case 75:
                        i2 = indexCount;
                        onVar.c(75, typedArrayObtainStyledAttributes.getBoolean(index, qnVar.n0));
                        break;
                    case 76:
                        i2 = indexCount;
                        onVar.b(76, typedArrayObtainStyledAttributes.getInt(index, rnVar.c));
                        break;
                    case 77:
                        i2 = indexCount;
                        onVar.d(typedArrayObtainStyledAttributes.getString(index), 77);
                        break;
                    case 78:
                        i2 = indexCount;
                        onVar.b(78, typedArrayObtainStyledAttributes.getInt(index, snVar.b));
                        break;
                    case 79:
                        i2 = indexCount;
                        onVar.a(79, typedArrayObtainStyledAttributes.getFloat(index, rnVar.d));
                        break;
                    case 80:
                        i2 = indexCount;
                        onVar.c(80, typedArrayObtainStyledAttributes.getBoolean(index, qnVar.l0));
                        break;
                    case 81:
                        i2 = indexCount;
                        onVar.c(81, typedArrayObtainStyledAttributes.getBoolean(index, qnVar.m0));
                        break;
                    case 82:
                        i2 = indexCount;
                        onVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, rnVar.b));
                        break;
                    case 83:
                        i2 = indexCount;
                        onVar.b(83, f(typedArrayObtainStyledAttributes, index, tnVar.h));
                        break;
                    case 84:
                        i2 = indexCount;
                        onVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, rnVar.g));
                        break;
                    case 85:
                        i2 = indexCount;
                        onVar.a(85, typedArrayObtainStyledAttributes.getFloat(index, rnVar.f));
                        break;
                    case 86:
                        i2 = indexCount;
                        int i5 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i5 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            rnVar.i = resourceId2;
                            onVar.b(89, resourceId2);
                            if (rnVar.i != -1) {
                                onVar.b(88, -2);
                            }
                        } else if (i5 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            rnVar.h = string;
                            onVar.d(string, 90);
                            if (rnVar.h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                rnVar.i = resourceId3;
                                onVar.b(89, resourceId3);
                                onVar.b(88, -2);
                            } else {
                                onVar.b(88, -1);
                            }
                        } else {
                            onVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, rnVar.i));
                        }
                        break;
                    case 87:
                        i2 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i2 = indexCount;
                        onVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.L));
                        break;
                    case 94:
                        i2 = indexCount;
                        onVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qnVar.S));
                        break;
                    case 95:
                        i2 = indexCount;
                        g(onVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i2 = indexCount;
                        g(onVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i2 = indexCount;
                        onVar.b(97, typedArrayObtainStyledAttributes.getInt(index, qnVar.o0));
                        break;
                    case 98:
                        i2 = indexCount;
                        int i6 = am0.r;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            pnVar.a = typedArrayObtainStyledAttributes.getResourceId(index, pnVar.a);
                        }
                        break;
                    case 99:
                        i2 = indexCount;
                        onVar.c(99, typedArrayObtainStyledAttributes.getBoolean(index, qnVar.g));
                        break;
                }
                i3 = i4 + 1;
            }
        } else {
            int i7 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i7 < indexCount2; indexCount2 = i) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        rnVar.getClass();
                        qnVar.getClass();
                        tnVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        qnVar.p = f(typedArrayObtainStyledAttributes, index2, qnVar.p);
                        continue;
                        i7++;
                        break;
                    case 2:
                        i = indexCount2;
                        qnVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.I);
                        continue;
                        i7++;
                        break;
                    case 3:
                        i = indexCount2;
                        qnVar.o = f(typedArrayObtainStyledAttributes, index2, qnVar.o);
                        continue;
                        i7++;
                        break;
                    case 4:
                        i = indexCount2;
                        qnVar.n = f(typedArrayObtainStyledAttributes, index2, qnVar.n);
                        continue;
                        i7++;
                        break;
                    case 5:
                        i = indexCount2;
                        qnVar.y = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i7++;
                        break;
                    case 6:
                        i = indexCount2;
                        qnVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, qnVar.C);
                        continue;
                        i7++;
                        break;
                    case 7:
                        i = indexCount2;
                        qnVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, qnVar.D);
                        continue;
                        i7++;
                        break;
                    case 8:
                        i = indexCount2;
                        qnVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.J);
                        continue;
                        i7++;
                        break;
                    case 9:
                        i = indexCount2;
                        qnVar.v = f(typedArrayObtainStyledAttributes, index2, qnVar.v);
                        continue;
                        i7++;
                        break;
                    case 10:
                        i = indexCount2;
                        qnVar.u = f(typedArrayObtainStyledAttributes, index2, qnVar.u);
                        continue;
                        i7++;
                        break;
                    case 11:
                        i = indexCount2;
                        qnVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.P);
                        continue;
                        i7++;
                        break;
                    case 12:
                        i = indexCount2;
                        qnVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.Q);
                        continue;
                        i7++;
                        break;
                    case 13:
                        i = indexCount2;
                        qnVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.M);
                        continue;
                        i7++;
                        break;
                    case 14:
                        i = indexCount2;
                        qnVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.O);
                        continue;
                        i7++;
                        break;
                    case 15:
                        i = indexCount2;
                        qnVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.R);
                        continue;
                        i7++;
                        break;
                    case 16:
                        i = indexCount2;
                        qnVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.N);
                        continue;
                        i7++;
                        break;
                    case 17:
                        i = indexCount2;
                        qnVar.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, qnVar.d);
                        continue;
                        i7++;
                        break;
                    case 18:
                        i = indexCount2;
                        qnVar.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, qnVar.e);
                        continue;
                        i7++;
                        break;
                    case 19:
                        i = indexCount2;
                        qnVar.f = typedArrayObtainStyledAttributes.getFloat(index2, qnVar.f);
                        continue;
                        i7++;
                        break;
                    case 20:
                        i = indexCount2;
                        qnVar.w = typedArrayObtainStyledAttributes.getFloat(index2, qnVar.w);
                        continue;
                        i7++;
                        break;
                    case 21:
                        i = indexCount2;
                        qnVar.c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, qnVar.c);
                        continue;
                        i7++;
                        break;
                    case 22:
                        i = indexCount2;
                        int i8 = typedArrayObtainStyledAttributes.getInt(index2, snVar.a);
                        snVar.a = i8;
                        snVar.a = iArr[i8];
                        continue;
                        i7++;
                        break;
                    case 23:
                        i = indexCount2;
                        qnVar.b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, qnVar.b);
                        continue;
                        i7++;
                        break;
                    case 24:
                        i = indexCount2;
                        qnVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.F);
                        continue;
                        i7++;
                        break;
                    case 25:
                        i = indexCount2;
                        qnVar.h = f(typedArrayObtainStyledAttributes, index2, qnVar.h);
                        continue;
                        i7++;
                        break;
                    case 26:
                        i = indexCount2;
                        qnVar.i = f(typedArrayObtainStyledAttributes, index2, qnVar.i);
                        continue;
                        i7++;
                        break;
                    case 27:
                        i = indexCount2;
                        qnVar.E = typedArrayObtainStyledAttributes.getInt(index2, qnVar.E);
                        continue;
                        i7++;
                        break;
                    case 28:
                        i = indexCount2;
                        qnVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.G);
                        continue;
                        i7++;
                        break;
                    case 29:
                        i = indexCount2;
                        qnVar.j = f(typedArrayObtainStyledAttributes, index2, qnVar.j);
                        continue;
                        i7++;
                        break;
                    case 30:
                        i = indexCount2;
                        qnVar.k = f(typedArrayObtainStyledAttributes, index2, qnVar.k);
                        continue;
                        i7++;
                        break;
                    case 31:
                        i = indexCount2;
                        qnVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.K);
                        continue;
                        i7++;
                        break;
                    case 32:
                        i = indexCount2;
                        qnVar.s = f(typedArrayObtainStyledAttributes, index2, qnVar.s);
                        continue;
                        i7++;
                        break;
                    case 33:
                        i = indexCount2;
                        qnVar.t = f(typedArrayObtainStyledAttributes, index2, qnVar.t);
                        continue;
                        i7++;
                        break;
                    case 34:
                        i = indexCount2;
                        qnVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.H);
                        continue;
                        i7++;
                        break;
                    case 35:
                        i = indexCount2;
                        qnVar.m = f(typedArrayObtainStyledAttributes, index2, qnVar.m);
                        continue;
                        i7++;
                        break;
                    case 36:
                        i = indexCount2;
                        qnVar.l = f(typedArrayObtainStyledAttributes, index2, qnVar.l);
                        continue;
                        i7++;
                        break;
                    case 37:
                        i = indexCount2;
                        qnVar.x = typedArrayObtainStyledAttributes.getFloat(index2, qnVar.x);
                        continue;
                        i7++;
                        break;
                    case 38:
                        i = indexCount2;
                        pnVar.a = typedArrayObtainStyledAttributes.getResourceId(index2, pnVar.a);
                        continue;
                        i7++;
                        break;
                    case 39:
                        i = indexCount2;
                        qnVar.U = typedArrayObtainStyledAttributes.getFloat(index2, qnVar.U);
                        continue;
                        i7++;
                        break;
                    case 40:
                        i = indexCount2;
                        qnVar.T = typedArrayObtainStyledAttributes.getFloat(index2, qnVar.T);
                        continue;
                        i7++;
                        break;
                    case 41:
                        i = indexCount2;
                        qnVar.V = typedArrayObtainStyledAttributes.getInt(index2, qnVar.V);
                        continue;
                        i7++;
                        break;
                    case 42:
                        i = indexCount2;
                        qnVar.W = typedArrayObtainStyledAttributes.getInt(index2, qnVar.W);
                        continue;
                        i7++;
                        break;
                    case 43:
                        i = indexCount2;
                        snVar.c = typedArrayObtainStyledAttributes.getFloat(index2, snVar.c);
                        continue;
                        i7++;
                        break;
                    case 44:
                        i = indexCount2;
                        tnVar.l = true;
                        tnVar.m = typedArrayObtainStyledAttributes.getDimension(index2, tnVar.m);
                        continue;
                        i7++;
                        break;
                    case 45:
                        i = indexCount2;
                        tnVar.b = typedArrayObtainStyledAttributes.getFloat(index2, tnVar.b);
                        continue;
                        i7++;
                        break;
                    case 46:
                        i = indexCount2;
                        tnVar.c = typedArrayObtainStyledAttributes.getFloat(index2, tnVar.c);
                        continue;
                        i7++;
                        break;
                    case 47:
                        i = indexCount2;
                        tnVar.d = typedArrayObtainStyledAttributes.getFloat(index2, tnVar.d);
                        continue;
                        i7++;
                        break;
                    case 48:
                        i = indexCount2;
                        tnVar.e = typedArrayObtainStyledAttributes.getFloat(index2, tnVar.e);
                        continue;
                        i7++;
                        break;
                    case 49:
                        i = indexCount2;
                        tnVar.f = typedArrayObtainStyledAttributes.getDimension(index2, tnVar.f);
                        continue;
                        i7++;
                        break;
                    case 50:
                        i = indexCount2;
                        tnVar.g = typedArrayObtainStyledAttributes.getDimension(index2, tnVar.g);
                        continue;
                        i7++;
                        break;
                    case 51:
                        i = indexCount2;
                        tnVar.i = typedArrayObtainStyledAttributes.getDimension(index2, tnVar.i);
                        continue;
                        i7++;
                        break;
                    case 52:
                        i = indexCount2;
                        tnVar.j = typedArrayObtainStyledAttributes.getDimension(index2, tnVar.j);
                        continue;
                        i7++;
                        break;
                    case 53:
                        i = indexCount2;
                        tnVar.k = typedArrayObtainStyledAttributes.getDimension(index2, tnVar.k);
                        continue;
                        i7++;
                        break;
                    case 54:
                        i = indexCount2;
                        qnVar.X = typedArrayObtainStyledAttributes.getInt(index2, qnVar.X);
                        continue;
                        i7++;
                        break;
                    case 55:
                        i = indexCount2;
                        qnVar.Y = typedArrayObtainStyledAttributes.getInt(index2, qnVar.Y);
                        continue;
                        i7++;
                        break;
                    case 56:
                        i = indexCount2;
                        qnVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.Z);
                        continue;
                        i7++;
                        break;
                    case 57:
                        i = indexCount2;
                        qnVar.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.a0);
                        continue;
                        i7++;
                        break;
                    case 58:
                        i = indexCount2;
                        qnVar.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.b0);
                        continue;
                        i7++;
                        break;
                    case 59:
                        i = indexCount2;
                        qnVar.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.c0);
                        continue;
                        i7++;
                        break;
                    case 60:
                        i = indexCount2;
                        tnVar.a = typedArrayObtainStyledAttributes.getFloat(index2, tnVar.a);
                        continue;
                        i7++;
                        break;
                    case 61:
                        i = indexCount2;
                        qnVar.z = f(typedArrayObtainStyledAttributes, index2, qnVar.z);
                        continue;
                        i7++;
                        break;
                    case 62:
                        i = indexCount2;
                        qnVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.A);
                        continue;
                        i7++;
                        break;
                    case 63:
                        i = indexCount2;
                        qnVar.B = typedArrayObtainStyledAttributes.getFloat(index2, qnVar.B);
                        continue;
                        i7++;
                        break;
                    case 64:
                        i = indexCount2;
                        rnVar.a = f(typedArrayObtainStyledAttributes, index2, rnVar.a);
                        continue;
                        i7++;
                        break;
                    case 65:
                        i = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            rnVar.getClass();
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            rnVar.getClass();
                            i7++;
                        }
                        break;
                    case 66:
                        i = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        rnVar.getClass();
                        continue;
                        i7++;
                        break;
                    case 67:
                        i = indexCount2;
                        rnVar.e = typedArrayObtainStyledAttributes.getFloat(index2, rnVar.e);
                        break;
                    case 68:
                        i = indexCount2;
                        snVar.d = typedArrayObtainStyledAttributes.getFloat(index2, snVar.d);
                        break;
                    case 69:
                        i = indexCount2;
                        qnVar.d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        qnVar.e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        qnVar.f0 = typedArrayObtainStyledAttributes.getInt(index2, qnVar.f0);
                        break;
                    case 73:
                        i = indexCount2;
                        qnVar.g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.g0);
                        break;
                    case 74:
                        i = indexCount2;
                        qnVar.j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        qnVar.n0 = typedArrayObtainStyledAttributes.getBoolean(index2, qnVar.n0);
                        break;
                    case 76:
                        i = indexCount2;
                        rnVar.c = typedArrayObtainStyledAttributes.getInt(index2, rnVar.c);
                        break;
                    case 77:
                        i = indexCount2;
                        qnVar.k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        snVar.b = typedArrayObtainStyledAttributes.getInt(index2, snVar.b);
                        break;
                    case 79:
                        i = indexCount2;
                        rnVar.d = typedArrayObtainStyledAttributes.getFloat(index2, rnVar.d);
                        break;
                    case 80:
                        i = indexCount2;
                        qnVar.l0 = typedArrayObtainStyledAttributes.getBoolean(index2, qnVar.l0);
                        break;
                    case 81:
                        i = indexCount2;
                        qnVar.m0 = typedArrayObtainStyledAttributes.getBoolean(index2, qnVar.m0);
                        break;
                    case 82:
                        i = indexCount2;
                        rnVar.b = typedArrayObtainStyledAttributes.getInteger(index2, rnVar.b);
                        break;
                    case 83:
                        i = indexCount2;
                        tnVar.h = f(typedArrayObtainStyledAttributes, index2, tnVar.h);
                        break;
                    case 84:
                        i = indexCount2;
                        rnVar.g = typedArrayObtainStyledAttributes.getInteger(index2, rnVar.g);
                        break;
                    case 85:
                        i = indexCount2;
                        rnVar.f = typedArrayObtainStyledAttributes.getFloat(index2, rnVar.f);
                        break;
                    case 86:
                        i = indexCount2;
                        int i9 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i9 == 1) {
                            rnVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i9 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            rnVar.h = string2;
                            if (string2.indexOf("/") > 0) {
                                rnVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, rnVar.i);
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        qnVar.q = f(typedArrayObtainStyledAttributes, index2, qnVar.q);
                        break;
                    case 92:
                        i = indexCount2;
                        qnVar.r = f(typedArrayObtainStyledAttributes, index2, qnVar.r);
                        break;
                    case 93:
                        i = indexCount2;
                        qnVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.L);
                        break;
                    case 94:
                        i = indexCount2;
                        qnVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, qnVar.S);
                        break;
                    case 95:
                        i = indexCount2;
                        g(qnVar, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i7++;
                        break;
                    case 96:
                        i = indexCount2;
                        g(qnVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        qnVar.o0 = typedArrayObtainStyledAttributes.getInt(index2, qnVar.o0);
                        break;
                }
                i7++;
            }
            if (qnVar.j0 != null) {
                qnVar.i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return pnVar;
    }

    public static int f(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.un.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(kn knVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f2 = Float.parseFloat(strSubstring3);
                        float f3 = Float.parseFloat(strSubstring4);
                        if (f2 > 0.0f && f3 > 0.0f) {
                            if (i == 1) {
                                Math.abs(f3 / f2);
                            } else {
                                Math.abs(f2 / f3);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        knVar.G = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(ConstraintLayout constraintLayout) {
        HashSet hashSet;
        int i;
        int i2;
        String str;
        HashMap map;
        String resourceEntryName;
        un unVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = unVar.c;
        HashSet<Integer> hashSet2 = new HashSet(map2.keySet());
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (unVar.b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map2.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        pn pnVar = (pn) map2.get(Integer.valueOf(id));
                        if (pnVar != null) {
                            sn snVar = pnVar.b;
                            qn qnVar = pnVar.d;
                            tn tnVar = pnVar.e;
                            if (childAt instanceof ee) {
                                qnVar.h0 = 1;
                                ee eeVar = (ee) childAt;
                                eeVar.setId(id);
                                eeVar.setType(qnVar.f0);
                                eeVar.setMargin(qnVar.g0);
                                eeVar.setAllowsGoneWidget(qnVar.n0);
                                int[] iArr = qnVar.i0;
                                if (iArr != null) {
                                    eeVar.setReferencedIds(iArr);
                                } else {
                                    String str2 = qnVar.j0;
                                    if (str2 != null) {
                                        int[] iArrC = c(eeVar, str2);
                                        qnVar.i0 = iArrC;
                                        eeVar.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            kn knVar = (kn) childAt.getLayoutParams();
                            knVar.a();
                            pnVar.a(knVar);
                            HashMap map3 = pnVar.f;
                            Class<?> cls = childAt.getClass();
                            for (String str3 : map3.keySet()) {
                                hn hnVar = (hn) map3.get(str3);
                                HashSet hashSet3 = hashSet2;
                                if (hnVar.a) {
                                    i2 = i3;
                                    str = str3;
                                } else {
                                    i2 = i3;
                                    str = "set" + str3;
                                }
                                try {
                                    int iR = l11.r(hnVar.b);
                                    Class cls2 = Float.TYPE;
                                    Class cls3 = Integer.TYPE;
                                    switch (iR) {
                                        case 0:
                                            map = map3;
                                            cls.getMethod(str, cls3).invoke(childAt, Integer.valueOf(hnVar.c));
                                            break;
                                        case 1:
                                            map = map3;
                                            cls.getMethod(str, cls2).invoke(childAt, Float.valueOf(hnVar.d));
                                            break;
                                        case 2:
                                            map = map3;
                                            cls.getMethod(str, cls3).invoke(childAt, Integer.valueOf(hnVar.g));
                                            break;
                                        case 3:
                                            Method method = cls.getMethod(str, Drawable.class);
                                            map = map3;
                                            try {
                                                ColorDrawable colorDrawable = new ColorDrawable();
                                                colorDrawable.setColor(hnVar.g);
                                                method.invoke(childAt, colorDrawable);
                                            } catch (IllegalAccessException e2) {
                                                e = e2;
                                                StringBuilder sbM = l11.m(" Custom Attribute \"", str3, "\" not found on ");
                                                sbM.append(cls.getName());
                                                Log.e("TransitionLayout", sbM.toString(), e);
                                            } catch (NoSuchMethodException e3) {
                                                e = e3;
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e);
                                            } catch (InvocationTargetException e4) {
                                                e = e4;
                                                StringBuilder sbM2 = l11.m(" Custom Attribute \"", str3, "\" not found on ");
                                                sbM2.append(cls.getName());
                                                Log.e("TransitionLayout", sbM2.toString(), e);
                                            }
                                            break;
                                        case 4:
                                            cls.getMethod(str, CharSequence.class).invoke(childAt, hnVar.e);
                                            map = map3;
                                            break;
                                        case 5:
                                            cls.getMethod(str, Boolean.TYPE).invoke(childAt, Boolean.valueOf(hnVar.f));
                                            map = map3;
                                            break;
                                        case 6:
                                            cls.getMethod(str, cls2).invoke(childAt, Float.valueOf(hnVar.d));
                                            map = map3;
                                            break;
                                        case 7:
                                            cls.getMethod(str, cls3).invoke(childAt, Integer.valueOf(hnVar.c));
                                            map = map3;
                                            break;
                                        default:
                                            map = map3;
                                            break;
                                    }
                                } catch (IllegalAccessException e5) {
                                    e = e5;
                                    map = map3;
                                } catch (NoSuchMethodException e6) {
                                    e = e6;
                                    map = map3;
                                } catch (InvocationTargetException e7) {
                                    e = e7;
                                    map = map3;
                                }
                                hashSet2 = hashSet3;
                                i3 = i2;
                                map3 = map;
                            }
                            hashSet = hashSet2;
                            i = i3;
                            childAt.setLayoutParams(knVar);
                            if (snVar.b == 0) {
                                childAt.setVisibility(snVar.a);
                            }
                            childAt.setAlpha(snVar.c);
                            childAt.setRotation(tnVar.a);
                            childAt.setRotationX(tnVar.b);
                            childAt.setRotationY(tnVar.c);
                            childAt.setScaleX(tnVar.d);
                            childAt.setScaleY(tnVar.e);
                            if (tnVar.h != -1) {
                                if (((View) childAt.getParent()).findViewById(tnVar.h) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(tnVar.f)) {
                                    childAt.setPivotX(tnVar.f);
                                }
                                if (!Float.isNaN(tnVar.g)) {
                                    childAt.setPivotY(tnVar.g);
                                }
                            }
                            childAt.setTranslationX(tnVar.i);
                            childAt.setTranslationY(tnVar.j);
                            childAt.setTranslationZ(tnVar.k);
                            if (tnVar.l) {
                                childAt.setElevation(tnVar.m);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i = i3;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i3 = i + 1;
                unVar = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i = i3;
            i3 = i + 1;
            unVar = this;
            hashSet2 = hashSet;
        }
        for (Integer num : hashSet2) {
            pn pnVar2 = (pn) map2.get(num);
            if (pnVar2 != null) {
                qn qnVar2 = pnVar2.d;
                if (qnVar2.h0 == 1) {
                    Context context = constraintLayout.getContext();
                    ee eeVar2 = new ee(context);
                    eeVar2.b = new int[32];
                    eeVar2.h = new HashMap();
                    eeVar2.d = context;
                    fe feVar = new fe();
                    feVar.s0 = 0;
                    feVar.t0 = true;
                    feVar.u0 = 0;
                    feVar.v0 = false;
                    eeVar2.k = feVar;
                    eeVar2.e = feVar;
                    eeVar2.i();
                    eeVar2.setVisibility(8);
                    eeVar2.setId(num.intValue());
                    int[] iArr2 = qnVar2.i0;
                    if (iArr2 != null) {
                        eeVar2.setReferencedIds(iArr2);
                    } else {
                        String str4 = qnVar2.j0;
                        if (str4 != null) {
                            int[] iArrC2 = c(eeVar2, str4);
                            qnVar2.i0 = iArrC2;
                            eeVar2.setReferencedIds(iArrC2);
                        }
                    }
                    eeVar2.setType(qnVar2.f0);
                    eeVar2.setMargin(qnVar2.g0);
                    kn knVarG = ConstraintLayout.g();
                    eeVar2.i();
                    pnVar2.a(knVarG);
                    constraintLayout.addView(eeVar2, knVarG);
                }
                if (qnVar2.a) {
                    View m70Var = new m70(constraintLayout.getContext());
                    m70Var.setId(num.intValue());
                    kn knVarG2 = ConstraintLayout.g();
                    pnVar2.a(knVarG2);
                    constraintLayout.addView(m70Var, knVarG2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof in) {
                ((in) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i;
        HashMap map;
        int i2;
        un unVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = unVar.c;
        map2.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            kn knVar = (kn) childAt.getLayoutParams();
            int id = childAt.getId();
            if (unVar.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map2.containsKey(Integer.valueOf(id))) {
                map2.put(Integer.valueOf(id), new pn());
            }
            pn pnVar = (pn) map2.get(Integer.valueOf(id));
            if (pnVar == null) {
                i = childCount;
                map = map2;
                i2 = i3;
            } else {
                sn snVar = pnVar.b;
                qn qnVar = pnVar.d;
                tn tnVar = pnVar.e;
                i = childCount;
                HashMap map3 = new HashMap();
                map = map2;
                Class<?> cls = childAt.getClass();
                i2 = i3;
                HashMap map4 = unVar.a;
                for (String str : map4.keySet()) {
                    hn hnVar = (hn) map4.get(str);
                    HashMap map5 = map4;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new hn(hnVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            map3.put(str, new hn(hnVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e2) {
                        StringBuilder sbM = l11.m(" Custom Attribute \"", str, "\" not found on ");
                        sbM.append(cls.getName());
                        Log.e("TransitionLayout", sbM.toString(), e2);
                    } catch (NoSuchMethodException e3) {
                        Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e3);
                    } catch (InvocationTargetException e4) {
                        StringBuilder sbM2 = l11.m(" Custom Attribute \"", str, "\" not found on ");
                        sbM2.append(cls.getName());
                        Log.e("TransitionLayout", sbM2.toString(), e4);
                    }
                    map4 = map5;
                }
                pnVar.f = map3;
                pnVar.a = id;
                qnVar.h = knVar.e;
                qnVar.i = knVar.f;
                qnVar.j = knVar.g;
                qnVar.k = knVar.h;
                qnVar.l = knVar.i;
                qnVar.m = knVar.j;
                qnVar.n = knVar.k;
                qnVar.o = knVar.l;
                qnVar.p = knVar.m;
                qnVar.q = knVar.n;
                qnVar.r = knVar.o;
                qnVar.s = knVar.s;
                qnVar.t = knVar.t;
                qnVar.u = knVar.u;
                qnVar.v = knVar.v;
                qnVar.w = knVar.E;
                qnVar.x = knVar.F;
                qnVar.y = knVar.G;
                qnVar.z = knVar.p;
                qnVar.A = knVar.q;
                qnVar.B = knVar.r;
                qnVar.C = knVar.T;
                qnVar.D = knVar.U;
                qnVar.E = knVar.V;
                qnVar.f = knVar.c;
                qnVar.d = knVar.a;
                qnVar.e = knVar.b;
                qnVar.b = ((ViewGroup.MarginLayoutParams) knVar).width;
                qnVar.c = ((ViewGroup.MarginLayoutParams) knVar).height;
                qnVar.F = ((ViewGroup.MarginLayoutParams) knVar).leftMargin;
                qnVar.G = ((ViewGroup.MarginLayoutParams) knVar).rightMargin;
                qnVar.H = ((ViewGroup.MarginLayoutParams) knVar).topMargin;
                qnVar.I = ((ViewGroup.MarginLayoutParams) knVar).bottomMargin;
                qnVar.L = knVar.D;
                qnVar.T = knVar.I;
                qnVar.U = knVar.H;
                qnVar.W = knVar.K;
                qnVar.V = knVar.J;
                qnVar.l0 = knVar.W;
                qnVar.m0 = knVar.X;
                qnVar.X = knVar.L;
                qnVar.Y = knVar.M;
                qnVar.Z = knVar.P;
                qnVar.a0 = knVar.Q;
                qnVar.b0 = knVar.N;
                qnVar.c0 = knVar.O;
                qnVar.d0 = knVar.R;
                qnVar.e0 = knVar.S;
                qnVar.k0 = knVar.Y;
                qnVar.N = knVar.x;
                qnVar.P = knVar.z;
                qnVar.M = knVar.w;
                qnVar.O = knVar.y;
                qnVar.R = knVar.A;
                qnVar.Q = knVar.B;
                qnVar.S = knVar.C;
                qnVar.o0 = knVar.Z;
                qnVar.J = knVar.getMarginEnd();
                qnVar.K = knVar.getMarginStart();
                snVar.a = childAt.getVisibility();
                snVar.c = childAt.getAlpha();
                tnVar.a = childAt.getRotation();
                tnVar.b = childAt.getRotationX();
                tnVar.c = childAt.getRotationY();
                tnVar.d = childAt.getScaleX();
                tnVar.e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    tnVar.f = pivotX;
                    tnVar.g = pivotY;
                }
                tnVar.i = childAt.getTranslationX();
                tnVar.j = childAt.getTranslationY();
                tnVar.k = childAt.getTranslationZ();
                if (tnVar.l) {
                    tnVar.m = childAt.getElevation();
                }
                if (childAt instanceof ee) {
                    ee eeVar = (ee) childAt;
                    qnVar.n0 = eeVar.getAllowsGoneWidget();
                    qnVar.i0 = eeVar.getReferencedIds();
                    qnVar.f0 = eeVar.getType();
                    qnVar.g0 = eeVar.getMargin();
                }
            }
            i3 = i2 + 1;
            unVar = this;
            childCount = i;
            map2 = map;
        }
    }

    public final void e(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    pn pnVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        pnVarD.d.a = true;
                    }
                    this.c.put(Integer.valueOf(pnVarD.a), pnVarD);
                }
            }
        } catch (IOException e2) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e2);
        } catch (XmlPullParserException e3) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e3);
        }
    }
}
