package defpackage;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.util.Xml;
import android.view.VelocityTracker;
import android.view.View;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.Toast;
import com.quickcursor.App;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yb0 implements ty {
    public static Context a = null;
    public static Boolean b = null;
    public static final c1 e;
    public static final c1 f;
    public static final c1 g;
    public static final c1 h;
    public static final c1 i;
    public static VelocityTracker m = null;
    public static float n = 0.0f;
    public static boolean o = false;
    public static boolean p = true;
    public static Field q;
    public static boolean r;
    public static final c1 c = new c1("NO_DECISION", 4);
    public static final String[] d = {"standard", "accelerate", "decelerate", "linear"};
    public static final ky j = new ky(false);
    public static final ky k = new ky(true);
    public static final ld0 l = new ld0(2);

    static {
        int i2 = 4;
        e = new c1("COMPLETING_ALREADY", i2);
        f = new c1("COMPLETING_WAITING_CHILDREN", i2);
        g = new c1("COMPLETING_RETRY", i2);
        h = new c1("TOO_LATE_TO_CANCEL", i2);
        i = new c1("SEALED", i2);
    }

    public static void A(int i2) {
        if (pn0.t().A()) {
            si0.b(String.valueOf(App.c.getResources().getText(i2)));
            y(i2, 0);
        }
    }

    public static void B(String str) {
        if (pn0.t().A()) {
            si0.b(str);
            z(str, 0);
        }
    }

    public static final void C(Object obj) throws Throwable {
        if (obj instanceof jw0) {
            throw ((jw0) obj).b;
        }
    }

    public static int D(int i2) {
        if (i2 == 90) {
            return 91;
        }
        if (i2 == 91) {
            return 92;
        }
        if (i2 == 93) {
            return 94;
        }
        if (i2 == 94) {
            return 95;
        }
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            case 15:
                return 16;
            case 16:
                return 17;
            case 17:
                return 18;
            case 18:
                return 19;
            case 19:
                return 20;
            case 20:
                return 21;
            case 21:
                return 22;
            case 22:
                return 23;
            case 23:
                return 24;
            case 24:
                return 25;
            case 25:
                return 26;
            case 26:
                return 27;
            case 27:
                return 28;
            case 28:
                return 29;
            case 29:
                return 30;
            case 30:
                return 31;
            case 31:
                return 32;
            case 32:
                return 33;
            case 33:
                return 34;
            case 34:
                return 35;
            case 35:
                return 36;
            case 36:
                return 37;
            case 37:
                return 38;
            case 38:
                return 39;
            case 39:
                return 40;
            case 40:
                return 41;
            case 41:
                return 42;
            case 42:
                return 43;
            case 43:
                return 44;
            case 44:
                return 45;
            case 45:
                return 46;
            case 46:
                return 47;
            case 47:
                return 48;
            case 48:
                return 49;
            case 49:
                return 50;
            case 50:
                return 51;
            case 51:
                return 52;
            case 52:
                return 53;
            case 53:
                return 54;
            case 54:
                return 55;
            case 55:
                return 56;
            case 56:
                return 57;
            case 57:
                return 58;
            case 58:
                return 59;
            case 59:
                return 60;
            case 60:
                return 61;
            case 61:
                return 62;
            case 62:
                return 63;
            case 63:
                return 64;
            case 64:
                return 65;
            case 65:
                return 66;
            case 66:
                return 67;
            case 67:
                return 68;
            case 68:
                return 69;
            case 69:
                return 70;
            case 70:
                return 71;
            case 71:
                return 72;
            case 72:
                return 73;
            case 73:
                return 74;
            case 74:
                return 75;
            case 75:
                return 76;
            case 76:
                return 77;
            case 77:
                return 78;
            case 78:
                return 79;
            case 79:
                return 80;
            default:
                switch (i2) {
                    case 96:
                        return 97;
                    case 97:
                        return 98;
                    case 98:
                        return 99;
                    case 99:
                        return 100;
                    case 100:
                        return 101;
                    case 101:
                        return 102;
                    case 102:
                        return 103;
                    case 103:
                        return 104;
                    case 104:
                        return 105;
                    case 105:
                        return 106;
                    case 106:
                        return 107;
                    case 107:
                        return 108;
                    case 108:
                        return 109;
                    case 109:
                        return 110;
                    case 110:
                        return 111;
                    case 111:
                        return 112;
                    case 112:
                        return 113;
                    case 113:
                        return 114;
                    case 114:
                        return 115;
                    case 115:
                        return 116;
                    case 116:
                        return 117;
                    case 117:
                        return 118;
                    case 118:
                        return 119;
                    case 119:
                        return 120;
                    case 120:
                        return 121;
                    case 121:
                        return 122;
                    default:
                        return 0;
                }
        }
    }

    public static jl1 E(String str, Bundle bundle) {
        df dfVar = zl1.i;
        if (bundle == null) {
            pn1.g("BillingClient", str.concat(" got null owned items list"));
            return new jl1(54, dfVar);
        }
        int iA = pn1.a("BillingClient", bundle);
        String strE = pn1.e("BillingClient", bundle);
        jl1 jl1VarA = df.a();
        jl1VarA.b = iA;
        jl1VarA.c = strE;
        df dfVarB = jl1VarA.b();
        if (iA != 0) {
            pn1.g("BillingClient", str + " failed. Response code: " + iA);
            return new jl1(23, dfVarB);
        }
        if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            pn1.g("BillingClient", "Bundle returned from " + str + " doesn't contain required fields.");
            return new jl1(55, dfVar);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        if (stringArrayList == null) {
            pn1.g("BillingClient", "Bundle returned from " + str + " contains null SKUs list.");
            return new jl1(56, dfVar);
        }
        if (stringArrayList2 == null) {
            pn1.g("BillingClient", "Bundle returned from " + str + " contains null purchases list.");
            return new jl1(57, dfVar);
        }
        if (stringArrayList3 != null) {
            return new jl1(1, zl1.j);
        }
        pn1.g("BillingClient", "Bundle returned from " + str + " contains null signatures list.");
        return new jl1(58, dfVar);
    }

    public static void c(int i2, int i3, int i4) {
        if (i2 >= 0 && i3 <= i4) {
            if (i2 <= i3) {
                return;
            }
            zy.n(qq0.h(i2, i3, "fromIndex: ", " > toIndex: "));
        } else {
            throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
        }
    }

    public static int d(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, ua.d(context)) : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static ColorFilter e(int i2) {
        PorterDuff.Mode mode;
        if (Build.VERSION.SDK_INT >= 29) {
            Object objE = ua.e();
            if (objE != null) {
                return ua.b(i2, objE);
            }
        } else {
            switch (l11.r(10)) {
                case 0:
                    mode = PorterDuff.Mode.CLEAR;
                    break;
                case 1:
                    mode = PorterDuff.Mode.SRC;
                    break;
                case 2:
                    mode = PorterDuff.Mode.DST;
                    break;
                case 3:
                    mode = PorterDuff.Mode.SRC_OVER;
                    break;
                case 4:
                    mode = PorterDuff.Mode.DST_OVER;
                    break;
                case 5:
                    mode = PorterDuff.Mode.SRC_IN;
                    break;
                case 6:
                    mode = PorterDuff.Mode.DST_IN;
                    break;
                case 7:
                    mode = PorterDuff.Mode.SRC_OUT;
                    break;
                case 8:
                    mode = PorterDuff.Mode.DST_OUT;
                    break;
                case 9:
                    mode = PorterDuff.Mode.SRC_ATOP;
                    break;
                case 10:
                    mode = PorterDuff.Mode.DST_ATOP;
                    break;
                case 11:
                    mode = PorterDuff.Mode.XOR;
                    break;
                case 12:
                    mode = PorterDuff.Mode.ADD;
                    break;
                case 13:
                    mode = PorterDuff.Mode.MULTIPLY;
                    break;
                case 14:
                    mode = PorterDuff.Mode.SCREEN;
                    break;
                case 15:
                    mode = PorterDuff.Mode.OVERLAY;
                    break;
                case 16:
                    mode = PorterDuff.Mode.DARKEN;
                    break;
                case 17:
                    mode = PorterDuff.Mode.LIGHTEN;
                    break;
                default:
                    mode = null;
                    break;
            }
            if (mode != null) {
                return new PorterDuffColorFilter(i2, mode);
            }
        }
        return null;
    }

    public static float f(float f2, float f3, float f4) {
        float f5 = f2 / (f4 / 2.0f);
        float f6 = f3 / 2.0f;
        if (f5 < 1.0f) {
            return (f6 * f5 * f5 * f5) + 0.0f;
        }
        float f7 = f5 - 2.0f;
        return (((f7 * f7 * f7) + 2.0f) * f6) + 0.0f;
    }

    public static Rect g(String str) {
        try {
            String[] strArrSplit = str.split(",");
            return new Rect(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ColorStateList h(Context context, ra raVar, int i2) {
        int resourceId;
        ColorStateList colorStateListP;
        TypedArray typedArray = (TypedArray) raVar.c;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListP = xy0.p(context, resourceId)) == null) ? raVar.x(i2) : colorStateListP;
    }

    public static ColorStateList i(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList colorStateListP;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListP = xy0.p(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : colorStateListP;
    }

    public static Drawable j(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable drawableJ;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (drawableJ = tk0.j(context, resourceId)) == null) ? typedArray.getDrawable(i2) : drawableJ;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class k(lk lkVar) {
        lkVar.getClass();
        Class cls = lkVar.a;
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return cls;
    }

    public static int l(CursorAccessibilityService cursorAccessibilityService) {
        try {
            Rect rect = new Rect();
            for (AccessibilityWindowInfo accessibilityWindowInfo : cursorAccessibilityService.getWindows()) {
                if (accessibilityWindowInfo.getType() == 3) {
                    accessibilityWindowInfo.getBoundsInScreen(rect);
                    if (rect.bottom == ey0.b()) {
                        si0.a("NavigationBarService: size: " + rect.toString());
                        if (rect.height() < 500) {
                            accessibilityWindowInfo.recycle();
                            return rect.height();
                        }
                    } else {
                        continue;
                    }
                }
                accessibilityWindowInfo.recycle();
            }
            return 0;
        } catch (Exception e2) {
            si0.a("getNavigationBarHeight exception: " + e2.getMessage());
            return 0;
        }
    }

    public static le0 m(String str, String str2, String str3) {
        ke0 ke0Var = (ke0) le0.i.k();
        ke0Var.c();
        le0 le0Var = (le0) ke0Var.c;
        le0Var.getClass();
        le0Var.d = str2;
        String strConcat = "type.googleapis.com/google.crypto.tink.".concat(str3);
        ke0Var.c();
        le0 le0Var2 = (le0) ke0Var.c;
        le0Var2.getClass();
        le0Var2.e = strConcat;
        ke0Var.c();
        ((le0) ke0Var.c).f = 0;
        ke0Var.c();
        ((le0) ke0Var.c).g = true;
        ke0Var.c();
        le0 le0Var3 = (le0) ke0Var.c;
        le0Var3.getClass();
        le0Var3.h = str;
        return (le0) ke0Var.a();
    }

    public static boolean o(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static Typeface p(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, f01.o(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }

    public static pd0 s(vd0 vd0Var) {
        boolean z;
        try {
            try {
                vd0Var.I();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return (pd0) kc1.z.b(vd0Var);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return sd0.b;
                }
                throw new wd0(e);
            }
        } catch (ej0 e4) {
            throw new wd0(e4);
        } catch (IOException e5) {
            throw new rd0(e5);
        } catch (NumberFormatException e6) {
            throw new wd0(e6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void t(org.xmlpull.v1.XmlPullParser r16, defpackage.jj r17, defpackage.zr r18) throws org.xmlpull.v1.XmlPullParserException, defpackage.v7, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb0.t(org.xmlpull.v1.XmlPullParser, jj, zr):void");
    }

    public static jj u(Context context, int i2, zr zrVar) throws XmlPullParserException, v7, IOException {
        XmlPullParser xml;
        try {
            String resourceTypeName = context.getResources().getResourceTypeName(i2);
            if (resourceTypeName.equals("raw")) {
                InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i2);
                xml = Xml.newPullParser();
                xml.setInput(inputStreamOpenRawResource, null);
            } else {
                if (!resourceTypeName.equals("xml")) {
                    throw new RuntimeException("Wrong changelog resource type, provide xml or raw resource!");
                }
                xml = context.getResources().getXml(i2);
            }
            jj jjVar = new jj(0);
            t(xml, jjVar, zrVar);
            return jjVar;
        } catch (IOException e2) {
            Log.d("Changelog Library", "IOException with changelog.xml", e2);
            throw e2;
        } catch (XmlPullParserException e3) {
            Log.d("Changelog Library", "XmlPullParseException while parsing changelog file", e3);
            throw e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x037c, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:?, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:?, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:?, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:?, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:?, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:?, code lost:
    
        r5 = -1;
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v0 int, still in use, count: 2, list:
  (r5v0 int) from 0x03bd: PHI (r5v12 int) = 
  (r5v1 int)
  (r5v2 int)
  (r5v3 int)
  (r5v4 int)
  (r5v5 int)
  (r5v6 int)
  (r5v7 int)
  (r5v8 int)
  (r5v9 int)
  (r5v10 int)
  (r5v0 int)
  (r5v11 int)
  (r5v15 int)
 binds: [B:247:?, B:171:0x03bc, B:246:?, B:167:0x03b1, B:245:?, B:163:0x03a6, B:244:?, B:159:0x039b, B:243:?, B:155:0x0390, B:150:0x0384, B:242:?, B:148:0x037c] A[DONT_GENERATE, DONT_INLINE, REMOVE]
  (r5v0 int) from 0x032c: CONSTRUCTOR (r2v37 he0) = (r5v0 int) A[MD:(int):void (m), REMOVE] (LINE:813) call: o5.<init>(int):void type: CONSTRUCTOR
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:271)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.markCodeForRemoval(SwitchOverStringVisitor.java:160)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:124)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:71)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void v(defpackage.gv0 r11) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instruction units count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb0.v(gv0):void");
    }

    public static void w() {
        VelocityTracker velocityTracker;
        boolean zA = oq0.a((SharedPreferences) pn0.t().d, oq0.O);
        if (zA && m == null) {
            m = VelocityTracker.obtain();
        } else {
            if (zA || (velocityTracker = m) == null) {
                return;
            }
            velocityTracker.recycle();
            m = null;
        }
    }

    public static void y(int i2, int i3) {
        Toast.makeText(App.c, i2, i3).show();
    }

    public static void z(String str, int i2) {
        Toast.makeText(App.c, str, i2).show();
    }

    public t7 a(Context context, Looper looper, a9 a9Var, Object obj, y60 y60Var, z60 z60Var) {
        return b(context, looper, a9Var, obj, (mj1) y60Var, (mj1) z60Var);
    }

    public t7 b(Context context, Looper looper, a9 a9Var, Object obj, mj1 mj1Var, mj1 mj1Var2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public float n(View view) {
        if (p) {
            try {
                return wg1.a(view);
            } catch (NoSuchMethodError unused) {
                p = false;
            }
        }
        return view.getAlpha();
    }

    public abstract void q(Throwable th);

    public abstract void r(g7 g7Var);

    public void x(View view, float f2) {
        if (p) {
            try {
                wg1.b(view, f2);
                return;
            } catch (NoSuchMethodError unused) {
                p = false;
            }
        }
        view.setAlpha(f2);
    }
}
